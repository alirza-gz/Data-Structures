package uni.ds.ir;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    //Swaps two elements in the array.
    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    //Sorts an array of numbers using bubble sort.
    public static void bubbleSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[500000];
        for (int i = 0; i < array.length ; i++) {
            array[i] = random.nextInt();
        }
        //int[] array2 = array.clone();
        bubbleSort(array);
        //Arrays.sort(array2);
        System.out.println(Arrays.toString(array));
        //System.out.println(Arrays.toString(array2));
        //System.out.println(Arrays.equals(array,array2));

    }
}
