package DataStructures.QuickSort;

public class QuickSort{
    private int[] arr;

    public QuickSort() {
    }

    public void sort(int[] arr) {
        this.arr = arr;
        System.out.print("Arr[] = ");
        traverse(arr);
        sort(0, this.arr.length - 1);
        traverse(this.arr);
    }

    private void sort(int indexLeft, int indexRight) {
        if (indexRight - indexLeft < 2) return;
        int pivotIndex = partition(indexLeft, indexRight);
        sort(indexLeft, pivotIndex-1);
        sort(pivotIndex+1, indexRight);
    }

    private int partition(int indexLeft, int indexRight) {
        int pivot = this.arr[indexRight];
        System.out.println("Left index = " + indexLeft + ", Right index = " + indexRight + ", Pivot index = " + indexRight + ", Pivot = " + pivot);
        int minIndex = (indexLeft - 1);
        System.out.println("Initialize index_of_smaller_element = " + minIndex);
        System.out.println("Traverse elements from left [" + indexLeft + "] to right [" + indexRight + "]");
        for (int i = indexLeft; i <= indexRight; i++) {
            if (this.arr[i] < pivot) {
                System.out.println("[i] = " + i + ":");
                System.out.println("arr[" + i + "] < pivot, do index_of_smaller_element++");
                minIndex++;
                if (minIndex == i){
                    System.out.println("No change as index_of_smaller_element and [i] are same");
                } else {
                    swap(minIndex, i);
                    System.out.println("and swap(arr[" + minIndex + "], arr[" + i + "])");
                }
                continue;
            }
            System.out.println("i = " + i + ": arr[" + i + "] >= pivot, do nothing");
        }
        swap(minIndex+1, indexRight);
        System.out.println("Come out of loop because index_of_smaller_element is now equal to right."
        + "\nPlace pivot at correct position by swapping arr[" + minIndex + "+1] and arr["+ indexRight +"]");
        System.out.print("arr[] = ");
        traverse(this.arr);
        return (minIndex+1);
    }

    private void swap(int indexLeft, int indexRight) {
        int temp;
        temp = this.arr[indexLeft];
        this.arr[indexLeft] = this.arr[indexRight];
        this.arr[indexRight] = temp;
    }

    public void traverse(int[] arr){
        for (int element : arr) System.out.print(element + " ");
        System.out.println(" ");
    }

    public int[] getArr() {
        return this.arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

}