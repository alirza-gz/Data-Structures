import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    //Swaps two elements in the array.
    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    //Sorts an array of numbers using quick sort.
    public static void quickSort(int arr[], int begin, int end)
    {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            // Recursively sort elements of the 2 sub-arrays
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int arr[], int begin, int end)
    {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j=begin; j<end; j++)
        {
            if (arr[j] <= pivot) {
                i++;

                swap(arr,i,j);
            }
        }

        swap(arr,i+1,end);

        return i+1;
    }

    public static void main(String[] args) {

        int[] arr = new int[500000];

        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt();
        }

        quickSort(arr,0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
}