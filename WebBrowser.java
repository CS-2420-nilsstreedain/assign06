package assign06;

import java.net.URL;
import java.util.NoSuchElementException;

public class WebBrowser {
	
	private ArrayStack<URL> backHistory;
	private ArrayStack<URL> forwardHistory;
	private URL currentURL;

	/**
	 * This constructor creates a new web browser with no previously-visited
	 * webpages and no webpages to visit next.
	 */
	public WebBrowser() {
		backHistory = new ArrayStack<>();
		forwardHistory = new ArrayStack<>();
		currentURL = null;
	}

	/**
	 * This constructor creates a new web browser with a preloaded history of
	 * visited webpages, given as a list of URL (Links to an external site.)
	 * objects. The first webpage in the list is the "current" page visited, and the
	 * remaining webpages are ordered from most recently visited to least recently
	 * visited.
	 * 
	 * @param history - an already existing history of pages, with the most recent
	 *                one being the current page
	 */
	public WebBrowser(SinglyLinkedList<URL> history) {
		backHistory = new ArrayStack<>();
		forwardHistory = new ArrayStack<>();
		for(URL temp : history)
			forwardHistory.push(temp);
		while(forwardHistory.size() != 0)
			backHistory.push(forwardHistory.pop());
		currentURL = backHistory.pop();
	}

	/**
	 * This method simulates visiting a webpage, given as a URL. Note that calling
	 * this method should clear the forward stack, since there is no URL to visit
	 * next.
	 * 
	 * @param webpage - the url of the webpage to 'visit'
	 */
	public void visit(URL webpage) {
		if (currentURL != null) 
			backHistory.push(currentURL);
		currentURL = webpage;
		forwardHistory.clear();
	}

	/**
	 * This method simulates using the back button, returning the URL visited.
	 * NoSuchElementException (Links to an external site.) is thrown if there is no
	 * previously-visited URL.
	 * 
	 * @return the URL that it goes back to
	 * @throws NoSuchElementException if there is no previously-visited URL
	 */
	public URL back() throws NoSuchElementException {
		URL prevURL = backHistory.pop();
		forwardHistory.push(currentURL);
		currentURL = prevURL;
		
		return currentURL;

	}

	/**
	 * This method simulates using the forward button, returning the URL visited.
	 * NoSuchElementException is thrown if there is no URL to visit next.
	 * 
	 * @return the URL that it goes forward to
	 * @throws NoSuchElementException
	 */
	public URL forward() throws NoSuchElementException {
		URL forwardURL = forwardHistory.pop();
		backHistory.push(currentURL);
		currentURL = forwardURL;
		
		return currentURL;
	}

	/**
	 * This method generates a history of URLs visited, as a list of URL objects
	 * ordered from most recently visited to least recently visited (including the
	 * "current" page visited), without altering subsequent behavior of this web
	 * browser. "Forward" links are not included. The behavior of the method must be
	 * O(N), where N is the number of URLs.
	 * 
	 * @return a history of URLs visited, as a list of URL objects
	 * ordered from most recently visited to least recently visited (including the
	 * "current" page visited)
	 */
	public SinglyLinkedList<URL> history() {
		SinglyLinkedList<URL> tempListHistory = new SinglyLinkedList<>();
		SinglyLinkedList<URL> returnListHistory = new SinglyLinkedList<>();
		
		//pops whole backHistory, reversing order
		while(backHistory.size() != 0) 
			tempListHistory.insertFirst(backHistory.pop());
		
		//pops whole tempListHistory, restoring order to rebuild history
		//and return correct order history
		for(URL tempURL : tempListHistory) {
			backHistory.push(tempURL);
			returnListHistory.insertFirst(tempURL);
		}
		
		if (currentURL != null)
			returnListHistory.insertFirst(currentURL);
		
		return returnListHistory;

	}
}
