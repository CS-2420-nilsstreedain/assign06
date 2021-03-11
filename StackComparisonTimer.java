package assign06;

/**
 * This class collects running times for methods of LinkedListStack and ArrayStack.
 * 
 * @author Erin Parker, Paul Nuffer, Nils Streedain
 * @version February 9, 2021
 */
public class StackComparisonTimer {
	
	public static void main(String[] args) {
		System.out.println("\nN\t\tnanoTime");
		
		int incr = 100000000;
		for(int probSize = 100000000; probSize <= 2000000000; probSize += incr) {
			
			int timesToLoop = 100000000;

			long stopTime, midpointTime, startTime = System.nanoTime();

			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			while(System.nanoTime() - startTime < Integer.MAX_VALUE) {}

			// Collect running times.
			startTime = System.nanoTime();
			for(int i = 0; i < timesToLoop; i++) {
				ArrayStack<Integer> stack = new ArrayStack<>();
				stack.push(i);
			}

			midpointTime = System.nanoTime();

			// Capture the cost of running the loop and any other operations done
			// above that are not the essential method call being timed.
			for(int i = 0; i < timesToLoop; i++) {
				@SuppressWarnings("unused")
				ArrayStack<Integer> stack = new ArrayStack<>();
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and searching.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
			
			System.out.println(probSize + "\t" + averageTime);
		}
	}
}
