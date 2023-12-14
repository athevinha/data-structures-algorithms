package DataStructures.BinanySearch;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 2, 7, 1, 0, 3, 9, 5, 11, 8 };
        BinarySearch bSearch = new BinarySearch();
        QuickSort qSort = new QuickSort();
        qSort.sort(arr);
        System.out.println("Quick sort arr:");
        qSort.traverse(arr);
        System.out.println(bSearch.search(qSort.getArr(), 8));
        System.out.println(bSearch.searchRecursive(qSort.getArr(), 8));

        // Output:
        // Quick sort arr:
        // 0 1 2 3 5 7 8 11 9
        
        // Midle point: arr[4] = 5
        // 5 < 8: Element is larger than mid, then it can only be present in right subarray
        // Midle point: arr[7] = 11
        // 11 < 8: Element is smaller than mid, then it can only be present in left subarray
        // Midle point: arr[6] = 8
        // The element is present at the middle itself
        // true

        // Midle point: arr[4] = 5
        // 5 < 8: Element is larger than mid, then it can only be present in right subarray
        // Midle point: arr[7] = 11
        // 11 < 8: Element is smaller than mid, then it can only be present in left subarray
        // Midle point: arr[6] = 8
        // The element is present at the middle itself
        // true
    }
}
