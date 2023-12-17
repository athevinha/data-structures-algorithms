
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Collections;

/**
 * VeboSolution class handles a series of queries on a set of numbers.
 */
public class VeboSolution {

    /**
     * Main method to execute the solution logic.
     *
     * @param args Command line arguments (not used in this solution).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int queries = scanner.nextInt();
        long[] numbers = new long[arraySize + 1];
        PriorityQueue<Long> lowerPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> higherPriorityQueue = new PriorityQueue<>();

        for (int i = 1; i <= arraySize; i++) {
            numbers[i] = scanner.nextInt();
            updateQueues(numbers[i], lowerPriorityQueue, higherPriorityQueue);
        }

        for (int i = 1; i <= queries; i++) {
            int queryType = scanner.nextInt();
            if (queryType == 1) {
                handleTypeOneQuery(scanner.nextLong(), lowerPriorityQueue, higherPriorityQueue);
            } else if (queryType == 2) {
                handleTypeTwoQuery(lowerPriorityQueue, higherPriorityQueue);
            } else if (queryType == 3) {
                handleTypeThreeQuery(lowerPriorityQueue, higherPriorityQueue);
            }
        }
    }

    /**
     * Updates the priority queues based on the given value.
     *
     * @param value              The value to be added to the queues.
     * @param lowerPriorityQueue The lower priority queue.
     * @param higherPriorityQueue The higher priority queue.
     */
    private static void updateQueues(long value, PriorityQueue<Long> lowerPriorityQueue,
                                     PriorityQueue<Long> higherPriorityQueue) {
        if (lowerPriorityQueue.isEmpty() || value < lowerPriorityQueue.peek()) {
            lowerPriorityQueue.offer(value);
        } else {
            higherPriorityQueue.offer(value);
        }

        balanceQueues(lowerPriorityQueue, higherPriorityQueue);
    }

    /**
     * Balances the size of the priority queues to maintain the property.
     *
     * @param lowerPriorityQueue The lower priority queue.
     * @param higherPriorityQueue The higher priority queue.
     */
    private static void balanceQueues(PriorityQueue<Long> lowerPriorityQueue,
                                      PriorityQueue<Long> higherPriorityQueue) {
        while (Math.abs(lowerPriorityQueue.size() - higherPriorityQueue.size()) >= 2) {
            if (lowerPriorityQueue.size() > higherPriorityQueue.size()) {
                higherPriorityQueue.add(lowerPriorityQueue.poll());
            } else {
                lowerPriorityQueue.add(higherPriorityQueue.poll());
            }
        }
    }

    /**
     * Handles a query of type 1.
     *
     * @param value              The value to be added to the queues.
     * @param lowerPriorityQueue The lower priority queue.
     * @param higherPriorityQueue The higher priority queue.
     */
    private static void handleTypeOneQuery(long value, PriorityQueue<Long> lowerPriorityQueue,
                                           PriorityQueue<Long> higherPriorityQueue) {
        if (higherPriorityQueue.isEmpty() && lowerPriorityQueue.isEmpty()) {
            higherPriorityQueue.offer(value);
        } else if (higherPriorityQueue.isEmpty() || value > lowerPriorityQueue.peek()) {
            higherPriorityQueue.offer(value);
        } else if (lowerPriorityQueue.isEmpty() || value > higherPriorityQueue.peek()) {
            lowerPriorityQueue.offer(value);
        } else {
            lowerPriorityQueue.offer(value);
        }

        balanceQueues(lowerPriorityQueue, higherPriorityQueue);
    }

    /**
     * Handles a query of type 2.
     *
     * @param lowerPriorityQueue The lower priority queue.
     * @param higherPriorityQueue The higher priority queue.
     */
    private static void handleTypeTwoQuery(PriorityQueue<Long> lowerPriorityQueue,
                                           PriorityQueue<Long> higherPriorityQueue) {
        if (lowerPriorityQueue.isEmpty() && higherPriorityQueue.isEmpty()) {
            // Handle the case when both queues are empty.
            return;
        }

        if (lowerPriorityQueue.size() == higherPriorityQueue.size()) {
            lowerPriorityQueue.poll();
        } else if (lowerPriorityQueue.size() < higherPriorityQueue.size()) {
            higherPriorityQueue.poll();
        } else {
            lowerPriorityQueue.poll();
        }
    }

    /**
     * Handles a query of type 3.
     *
     * @param lowerPriorityQueue The lower priority queue.
     * @param higherPriorityQueue The higher priority queue.
     */
    private static void handleTypeThreeQuery(PriorityQueue<Long> lowerPriorityQueue,
                                             PriorityQueue<Long> higherPriorityQueue) {
        if (lowerPriorityQueue.isEmpty() && higherPriorityQueue.isEmpty()) {
            System.out.println(0);
            return;
        }

        if (lowerPriorityQueue.size() == higherPriorityQueue.size()) {
            System.out.println(lowerPriorityQueue.peek());
        } else if (lowerPriorityQueue.size() < higherPriorityQueue.size()) {
            System.out.println(higherPriorityQueue.peek());
        } else {
            System.out.println(lowerPriorityQueue.peek());
        }
    }
}
