// Búsqueda de un elemento. 
// Dado un vector de n números naturales ordenados crecientemente,
// determinar si un número x dado pertenece al vector.

public class ej2 {
  public static void main (String[] args) {
    int[] array = {1, 3, 4, 5, 7, 10, 11, 13, 21, 25};
    System.out.println(existe(array, 25, 0, array.length));
  }

  public static boolean existe(int[] arr, int n, int i, int j) {
    if (i >= j) return false;
    
    int mid = i + (j - i) / 2;

    if (arr[mid] == n) return true;
    if (arr[mid] > n) {
      return existe(arr, n, i, mid);
    } else {
      return existe(arr, n, mid + 1, j);
    }
  }
}
