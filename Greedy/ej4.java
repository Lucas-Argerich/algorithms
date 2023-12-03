// Minimizar tiempo de espera:
// Un procesador debe atender n procesos. 
// Se conoce de antemano el tiempo que necesita cada uno de ellos.
// Determinar en qué orden el procesador debe atender dichos
// procesos para minimizar la suma del tiempo
// que los procesos están en el sistema.

import java.util.Arrays;

public class ej4 {
  public static void main(String[] args) {
    int n = 3;
    int[] tiempos = {5, 10, 3};

    int[] res = minimizarTiempoEspera(n, tiempos);

    System.out.println(Arrays.toString(res));
  }

  private static int[] minimizarTiempoEspera(int n, int[] t) {
    int[] res = new int[n];
    int index = 0;

    for (int i = 0; i < n; i++) {
      int min = 0;

      for (int j = 0; j < n; j++) {
        if (t[j] < t[min]) {
          min = j;
        }
      }

      res[index++] = t[min];
      t[min] = Integer.MAX_VALUE;
    }

    return res;
  }
}
