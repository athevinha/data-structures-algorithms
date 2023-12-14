
public class Main {
    public static void main(String[] args) {
        int[] arr = { 3, 8, 4, 9, 1, 2 };
        BubbleSort bSort = new BubbleSort();
        bSort.sortDescending(arr);
        System.out.println("Bubble desending sort arr:");
        bSort.traverse(arr);

        // Output:
        // Pass: 0: 
        // 8 < 3 then swap arr[0] and arr[0+1]
        // 4 < 3 then swap arr[1] and arr[1+1]
        // 9 < 3 then swap arr[2] and arr[2+1]
        // 2 < 1 then swap arr[4] and arr[4+1]
        // Else: do nothing
        // Pass: 1:
        // 9 < 4 then swap arr[1] and arr[1+1]
        // Else: do nothing
        // Pass: 2:
        // 9 < 8 then swap arr[0] and arr[0+1]
        // Else: do nothing
        // Pass: 3:
        // Else: do nothing
        // Pass: 4:
        // Else: do nothing
        
        // Bubble desending sort arr:
        // 9 8 4 3 2 1
    }
}

