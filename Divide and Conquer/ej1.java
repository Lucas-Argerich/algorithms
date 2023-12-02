// Secuencia ordenada alfabéticamente. 
// Determinar si una secuencia de n caracteres está ordenada alfabéticamente.

public class ej1 {
  public static void main(String[] args) {
   String palabra = "abcdña";

   System.out.println(ordenadoAlfabeticamente(palabra, 0, palabra.length() - 1));
  }

  public static boolean ordenadoAlfabeticamente(String str, int i, int j) {
    if (j - i <= 1) {
      return str.charAt(i) < str.charAt(j);
    } 
    int mid = i + (j - i) / 2;
    return ordenadoAlfabeticamente(str, i, mid) && ordenadoAlfabeticamente(str, mid, j);
  }
}
