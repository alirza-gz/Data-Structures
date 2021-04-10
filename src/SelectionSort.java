package uni.ds.ir;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

    //Swaps two elements in the array.
    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    //Sorts an array of numbers using selection sort.
    public static void selectionSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }

            if (minIndex != i){
                swap(array,minIndex,i);
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[100000];
        for (int i = 0; i < array.length ; i++) {
            array[i] = random.nextInt();
        }
        //int[] array2 = array.clone();
        selectionSort(array);
        //Arrays.sort(array2);
        System.out.println(Arrays.toString(array));
        //System.out.println(Arrays.toString(array2));
        //System.out.println(Arrays.equals(array,array2));
    }
}
