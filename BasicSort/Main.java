
public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("A05", "Tran Quang", 7);
        employees[1] = new Employee("A03", "Nguyen An", 7);
        employees[2] = new Employee("A01", "Trong Phung", 5);
        employees[3] = new Employee("A04", "Pham Thi Lam", 2);
        employees[4] = new Employee("A02", "Do Trung Ton", 5);
        System.out.println("Selection sort:");
        selectionSortByIdAscending(employees);
        traverse(employees);
        selectionSortByIdDescending(employees);
        traverse(employees);
        System.out.println("Bubble sort:");
        bubbleSortByIdAscending(employees);
        traverse(employees);
        bubbleSortByIdDescending(employees);
        traverse(employees);
        System.out.println("Quick sort:");
        quickSortByIdAscending(employees);
        traverse(employees);
        quickSortByIdDescending(employees);
        traverse(employees);
        

        // Output:
        // Selection sort:
        // { id='A01', name='Trong Phung', level='5'}
        // { id='A02', name='Do Trung Ton', level='5'}
        // { id='A03', name='Nguyen An', level='7'}
        // { id='A04', name='Pham Thi Lam', level='2'}
        // { id='A05', name='Tran Quang', level='7'}
        
        // { id='A05', name='Tran Quang', level='7'}
        // { id='A04', name='Pham Thi Lam', level='2'}
        // { id='A03', name='Nguyen An', level='7'}
        // { id='A02', name='Do Trung Ton', level='5'}
        // { id='A01', name='Trong Phung', level='5'}
        
        // Bubble sort:
        // { id='A01', name='Trong Phung', level='5'}
        // { id='A02', name='Do Trung Ton', level='5'}
        // { id='A03', name='Nguyen An', level='7'}
        // { id='A04', name='Pham Thi Lam', level='2'}
        // { id='A05', name='Tran Quang', level='7'}
        
        // { id='A05', name='Tran Quang', level='7'}
        // { id='A04', name='Pham Thi Lam', level='2'}
        // { id='A03', name='Nguyen An', level='7'}
        // { id='A02', name='Do Trung Ton', level='5'}
        // { id='A01', name='Trong Phung', level='5'}
        
        // Quick sort:
        // { id='A01', name='Trong Phung', level='5'}
        // { id='A02', name='Do Trung Ton', level='5'}
        // { id='A03', name='Nguyen An', level='7'}
        // { id='A04', name='Pham Thi Lam', level='2'}
        // { id='A05', name='Tran Quang', level='7'}
        
        // { id='A05', name='Tran Quang', level='7'}
        // { id='A04', name='Pham Thi Lam', level='2'}
        // { id='A03', name='Nguyen An', level='7'}
        // { id='A02', name='Do Trung Ton', level='5'}
        // { id='A01', name='Trong Phung', level='5'}
    }

    private static void traverse(Employee arr[]) {
        for (Employee employee : arr) System.out.println(employee);
        System.out.println(" ");
    }

    private static void selectionSortByIdAscending(Employee arr[]) {
        int arrLenght = arr.length;
        for (int i = 0; i < arrLenght - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < arrLenght; j++) {
                if ((arr[j].getId()).compareTo(arr[indexOfMin].getId()) < 0) indexOfMin = j;
            }
            if (i != indexOfMin) {
                Employee temp = arr[indexOfMin];
                arr[indexOfMin] = arr[i];
                arr[i] = temp;
            }
        }
    }    private static void selectionSortByIdDescending(Employee arr[]) {
        int arrLenght = arr.length;
        for (int i = 0; i < arrLenght - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < arrLenght; j++) {
                if ((arr[j].getId()).compareTo(arr[indexOfMin].getId()) > 0) indexOfMin = j;
            }
            if (i != indexOfMin) {
                Employee temp = arr[indexOfMin];
                arr[indexOfMin] = arr[i];
                arr[i] = temp;
            }
        }
    }

    private static void bubbleSortByIdAscending(Employee[] arr) {
        int lastIndex = arr.length - 1;
        for (int last = lastIndex; last >= 0; last--) {
            for (int i = 0; i < last; i++) {
                if (arr[i].getId().compareTo(arr[i+1].getId()) > 0) swap(arr, i, i+1);
            }
        }
    }

    private static void bubbleSortByIdDescending(Employee[] arr) {
        int lastIndex = arr.length - 1;
        for (int last = lastIndex; last >= 0; last--) {
            for (int i = 0; i < last; i++) {
                if (arr[i].getId().compareTo(arr[i+1].getId()) < 0) swap(arr, i, i+1);
            }
        }
    }

    private static void quickSortByIdAscending(Employee[] arr){
        quickSortByIdRecursive(arr, 0, arr.length-1, false);
    }

    private static void quickSortByIdDescending(Employee[] arr){
        quickSortByIdRecursive(arr, 0, arr.length-1, true);
    }

    private static void quickSortByIdRecursive(Employee[] arr, int left, int right, boolean isDescending) {
        if (left >= right) return;
        int index = isDescending? partitionDescending(arr, left, right) : partitionAscending(arr, left, right);
        if (left < index - 1) quickSortByIdRecursive(arr, left, index - 1, isDescending);
        if (index < right) quickSortByIdRecursive(arr, index, right, isDescending);
    }

    private static int partitionAscending(Employee[] arr, int indexLeft, int indexRight) {
        Employee pivot = arr[indexRight];
        int minIndex = (indexLeft - 1);
        for (int i = indexLeft; i <= indexRight; i++) {
            if (arr[i].getId().compareTo(pivot.getId()) < 0) {
                minIndex++;
                if (minIndex != i){
                    swap(arr, minIndex, i);
                }
            }
        }
        swap(arr, minIndex+1, indexRight);
        return (minIndex+1);
    }
    private static int partitionDescending(Employee[] arr, int indexLeft, int indexRight) {
        Employee pivot = arr[indexRight];
        int minIndex = (indexLeft - 1);
        for (int i = indexLeft; i <= indexRight; i++) {
            if (arr[i].getId().compareTo(pivot.getId()) > 0) {
                minIndex++;
                if (minIndex != i){
                    swap(arr, minIndex, i);
                }
            }
        }
        swap(arr, minIndex+1, indexRight);
        return (minIndex+1);
    }

    private static void swap(Employee[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        Employee temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
