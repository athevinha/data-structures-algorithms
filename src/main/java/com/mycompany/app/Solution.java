import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> queue = new LinkedList<>();
        int NC = 1, N = scanner.nextInt(), B = scanner.nextInt();

        for (int i = 0; i < B; i++) {
            int event = scanner.nextInt();
            switch (event) {
                case 1:
                    queue.add(NC);
                    NC++;
                    break;
                case 2:
                    printFirstElement(queue);
                    break;
                case 3:
                    printLastElement(queue);
                    break;
                case 4:
                    System.out.println(queueSize(queue));
                    break;
                case 5:
                    int u = scanner.nextInt();
                    printElementByIndex(queue, u);
                    break;
            }
        }
    }

    private static void printFirstElement(Deque<Integer> queue) {
        if (!queue.isEmpty()) {
            System.out.println(queue.pollFirst());
        } else {
            System.out.println(0);
        }
    }

    private static void printLastElement(Deque<Integer> queue) {
        if (!queue.isEmpty()) {
            System.out.println(queue.pollLast());
        } else {
            System.out.println(0);
        }
    }

    private static int queueSize(Deque<Integer> queue) {
        return queue.size();
    }

    private static void printElementByIndex(Deque<Integer> queue, int u) {
        if (u > 0 && u <= queue.size()) {
            int element = 1;
            for (Integer customer : queue) {
                if (element == u) {
                    System.out.println(customer);
                    break;
                }
                element++;
            }
        } else {
            System.out.println(0);
        }
    }
}
