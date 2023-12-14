package DataStructures.BubbleSort;

public class BubbleSort {
    private int[] arr;

    public BubbleSort() {
    }

    public void sortAscending (int[] arr) {
        this.arr = arr;
        boolean swapped = false;
        int arrLenght = arr.length;
        for (int i = 0; i < arrLenght - 1; i++) {
            System.out.println("Pass: " + i + ": ");
            for (int j = 0; j < arrLenght - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j+1);
                    System.out.println(arr[j] + " > " + arr[j + 1] + " then swap arr[" + j + "] and arr[" + j + "+1]");
                    swapped = true;
                }
            }
            if (!swapped) {
                System.out.println("No two elements were swapped by inner loop, then break");
                break;
            }
            System.out.println("Else: do nothing");
        }
    }

    private void swap(int indexLeft, int indexRight) {
        int temp;
        temp = this.arr[indexLeft];
        this.arr[indexLeft] = this.arr[indexRight];
        this.arr[indexRight] = temp;
    }

    public void sortDescending(int[] arr) {
        this.arr = arr;
        boolean swapped = false;
        int arrLenght = arr.length;
        for (int i = 0; i < arrLenght - 1; i++) {
            System.out.println("Pass: " + i + ": ");
            for (int j = 0; j < arrLenght - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    swap(j, j+1);
                    System.out.println(arr[j] + " < " + arr[j + 1] + " then swap arr[" + j + "] and arr[" + j + "+1]");
                    swapped = true;
                }
            }
            if (!swapped) {
                System.out.println("No two elements were swapped by inner loop, then break");
                break;
            }
            System.out.println("Else: do nothing");
        }
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
