package DataStructures.BinanySearch;

public class BinarySearch {
    private int[] arr;

    public BinarySearch() {
    }

    public boolean search(int[] arr, int value) {
        this.arr = arr;
        int start = 0;
        int end = this.arr.length;
        while (start < end) {
            int midPoint = (start + end) / 2;
            System.out.println("Midle point: arr[" + midPoint + "] = " + arr[midPoint]);
            if (arr[midPoint] == value){
                System.out.println("The element is present at the middle itself");
                return true;
            } else if (this.arr[midPoint] < value) {
                System.out.println(arr[midPoint] + " < " + value + ": Element is larger than mid, then it can only be present in right subarray");
                start = midPoint + 1;
            }
            else {
                System.out.println(arr[midPoint] + " < " + value + ": Element is smaller than mid, then it can only be present in left subarray");
                end = midPoint;
            }
        }
        return false;
    }

    public boolean searchRecursive(int[] arr, int value) {
        this.arr = arr;
        return recursiveBinarySearch(this.arr, value, 0, this.arr.length);
    }

    private boolean recursiveBinarySearch(int[] arr, int value, int start, int end) {
        if (start == end) return false;
        int midPoint = (start + end) / 2;
        System.out.println("Midle point: arr[" + midPoint + "] = " + arr[midPoint]);
        if (arr[midPoint] == value){
            System.out.println("The element is present at the middle itself");
            return true;
        }
        if (arr[midPoint] < value) {
            System.out.println(arr[midPoint] + " < " + value + ": Element is larger than mid, then it can only be present in right subarray");
            return recursiveBinarySearch(arr, value, midPoint + 1, end);
        } else {
            System.out.println(arr[midPoint] + " < " + value + ": Element is smaller than mid, then it can only be present in left subarray");
            return recursiveBinarySearch(arr, value, start, midPoint);
        }
    }

    public void traverse() {
        for (int element : this.arr) System.out.println(element + " ");
        System.out.println(" ");
    }
    
    public int[] getArr() {
        return this.arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

}
