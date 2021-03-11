package assign06;

/**
 * This class collects running times for methods of ArrayListSorter.
 * 
 * @author Erin Parker, Paul Nuffer, Nils Streedain
 * @version February 9, 2021
 */
public class StackComparisonTimer {
	
	public static void main(String[] args) {
		System.out.println("\nN\t\tnanoTime");
		
		int incr = 20000;
		for(int probSize = 2000000; probSize <= 20000000; probSize += incr) {
			
			int timesToLoop = 100000;

			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.

			long stopTime, midpointTime, startTime = System.nanoTime();

			while(System.nanoTime() - startTime < Integer.MAX_VALUE) {}
			
			//ListStack Push Setup
		//	LinkedListStack<Integer> listStack = new LinkedListStack<>();
		//	for (int i = 0; i < probSize; i++) 
		//		listStack.push(0);
			
			//ArrayStack Push Setup
			ArrayStack<Integer> arrayStack = new ArrayStack<>();
			for (int i = 0; i < probSize; i++) 
				arrayStack.push(0);
			
			//ListStack Pop Setup
		//	LinkedListStack<Integer> listStack = new LinkedListStack<>();
		//	for (int i = 0; i < probSize; i++) 
		//		listStack.push(0);
			
			//ArrayStack Pop Setup
		//	ArrayStack<Integer> arrayStack = new ArrayStack<>();
		//	for (int i = 0; i < probSize; i++) 
		//		arrayStack.push(0);
			
			//ListStack Peek Setup
		//	LinkedListStack<Integer> listStack = new LinkedListStack<>();
		//	for (int i = 0; i < probSize; i++) 
		//		listStack.push(0);
			
			//ArrayStack Peek Setup
		//	ArrayStack<Integer> arrayStack = new ArrayStack<>();
		//	for (int i = 0; i < probSize; i++) 
		//		arrayStack.push(0);
			
			// Collect running times.
			startTime = System.nanoTime();
			for(int i = 0; i < timesToLoop; i++) {
		//		listStack.push(0);
				
				arrayStack.push(0);
				
		//		listStack.pop();
				
		//		arrayStack.pop();	
						 
		//		listStack.peek();
				
		//		ArrayStack<Integer> arrayStack = new ArrayStack<>();
		//		arrayStack.push(i);
		//		for (int j = 0; j < 10000000; j++) 
		//			arrayStack.peek();
			}

			midpointTime = System.nanoTime();

			// Capture the cost of running the loop and any other operations done
			// above that are not the essential method call being timed.
			for(int i = 0; i < timesToLoop; i++) {
		//		ListStack Push no subtract
				
		//		ArrayStack Push no subtract

		//		ListStack Pop no subtract
				
		//		ArrayStack Pop no subtract			
				
		//		ListStack Peek no subtract
				
		//		ArrayStack Peek no subtract		
						
			}

			stopTime = System.nanoTime();
			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and searching.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - 
						(stopTime - midpointTime)) / (double) timesToLoop;
			System.out.println(probSize + "\t" + averageTime);
		}
	}
}
