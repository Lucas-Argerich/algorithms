// Dado un Vector A de números enteros, ordenarlo en forma creciente. 
// Utilizar el método de ordenamiento MergeSort, 
// pero dividiendo el vector en 3 subvectores y analizar el costo.

import java.util.Arrays;
import java.util.Random;

public class ej6 {
  public static void main(String[] args) {
    int[] randomArray = new Random().ints(30, -100, 200).toArray();


    for (int n : mergeSort(randomArray)) {
      System.out.print(n + " ");
    }
    System.out.println();
  }

  public static int[] mergeSort(int[] arr) {
    if (arr.length <= 2) {
      if (arr.length == 2 && arr[0] > arr[1]) {
        int aux = arr[0];
        arr[0] = arr[1];
        arr[1] = aux;
      }
      return arr;
    }
    int[] first = Arrays.copyOfRange(arr, 0, arr.length / 3);
    int[] second = Arrays.copyOfRange(arr, arr.length / 3 + 1, arr.length / 3 * 2);
    int[] third = Arrays.copyOfRange(arr, arr.length / 3 * 2 + 1, arr.length);
    return orderedJoin(orderedJoin(mergeSort(first), mergeSort(second)), mergeSort(third));
  }


  public static int[] orderedJoin(int[] arr1, int[] arr2) {
    int len1 = arr1.length, len2 = arr2.length;
    int[] res = new int[len1 + len2];
    int index = 0;
    int i = 0, j = 0;
    while(i < len1 && j < len2) {
      if(arr1[i] <= arr2[j]) res[index++] = arr1[i++];
      else res[index++] = arr2[j++];
    }
    while(i < len1) res[index++] = arr1[i++];
    while(j < len2) res[index++] = arr2[j++];
    return res;
  }
}
