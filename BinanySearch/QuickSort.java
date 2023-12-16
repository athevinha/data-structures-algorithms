package DataStructures.BinanySearch;

public class QuickSort{
    private int[] arr;

    public QuickSort() {
    }

    public void sort(int[] arr) {
        this.arr = arr;
        sort(0, this.arr.length - 1);
    }

    private void sort(int indexLeft, int indexRight) {
        if (indexRight - indexLeft < 2) return;
        int pivotIndex = partition(indexLeft, indexRight);
        sort(indexLeft, pivotIndex-1);
        sort(pivotIndex+1, indexRight);
    }

    private int partition(int indexLeft, int indexRight) {
        int pivot = this.arr[indexRight];
        int minIndex = (indexLeft - 1);
        for (int i = indexLeft; i <= indexRight; i++) {
            if (this.arr[i] < pivot) {
                minIndex++;
                swap(minIndex, i);
            }
        }
        swap(minIndex+1, indexRight);
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