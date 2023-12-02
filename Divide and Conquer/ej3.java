// Potencia. 
// Calcular a^n cuando n es una potencia de 2.

public class ej3 {
  public static void main (String[] args) {
    System.out.println(potencia(5));
  }

  public static int potencia(int n) {
    if (n == 1) return 2;

    return potencia(n / 2) * potencia(Math.ceilDiv(n, 2));
  }
}
