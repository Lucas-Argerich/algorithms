// Elemento en su posición. 
// Sea A[1..n], n >= 1, un vector de enteros diferentes y ordenados crecientemente, 
// tal que algunos de los valores pueden ser negativos. 
// Diseñar un algoritmo que devuelva un índice natural k, 1<=k<=n, tal que A[k] = k, 
// siempre que tal índice exista.

public class ej5 {
  public static void main(String[] args) {
    int[] array = {-3, -1, 1, 2, 3, 5, 7 /*...*/, 999, 999, 999};
    
    System.out.println(elementoEnSuPosicionIndex(array, 0, 1));

  }

  public static int elementoEnSuPosicionIndex(int[] arr, int i, int j) {
    if (j > arr[j]) return elementoEnSuPosicionIndex(arr, j, j*2);
  
    int mid = i + (j - i) / 2;

    if (mid == arr[mid]) return mid;
    if (mid > arr[mid]) return elementoEnSuPosicionIndex(arr, mid, j);
    else return elementoEnSuPosicionIndex(arr, i, mid);
  }
}
