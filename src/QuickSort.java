
public class QuickSort {

//    pivot = Value of index to be moved
//    low = index of lower bound in split array
//    high = index of higher bound in split array
//    splitIndex = index of middle value to split array into greater and lesser around

    public void sortThis(int array[]) {
        if (array.length > 0) {
            quickSort(array, 0, array.length - 1);
        }
    }

    private void quickSort(int array[],int low, int high) {
        if (low < high) {
            int splitIndex = split(array, low, high);
            quickSort(array, low, splitIndex - 1);
            quickSort(array, splitIndex + 1, high);
        }
    }

    private int split(int array[], int low, int high){
        int pivot = array[high];
        int bottomIndex = (low - 1);

        for (int x = low; x < high; x++) {

            if (array[x] <= pivot) {
                bottomIndex++;
                int temp = array[bottomIndex];
                array[bottomIndex] = array[x];
                array[x] = temp;
            }
        }

        int temp = array[bottomIndex + 1];
        array[bottomIndex + 1] = array[high];
        array[high] = temp;

        return bottomIndex + 1;
    }
}
