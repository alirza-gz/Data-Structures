import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    //Swaps two elements in the array.
    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    //Sorts an array of numbers using insertion sort.
    public static void insertionSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j-1] > array[j]; j--) {
                swap(array, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[500000];

        Random rnd = new Random();
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = rnd.nextInt();
        }

        insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}

