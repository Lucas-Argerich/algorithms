// El problema del par más cercano consiste en encontrar dos puntos 
// dentro de un conjunto de puntos cuya distancia sea menor que la que existe 
// entre cualquier otro par de puntos del conjunto. 
// Suponiendo que los puntos vienen ordenados por sus coordenadas (x; y), 
// y que han sido clasificados en orden ascendente de la coordenada x, resolver el problema.

public class ej8 {
  public static void main(String[] args) {
    int[][] coords = {{-1, 4}, {0, 2}, {1, 5}, {3, -1}, {3, 0}, {5, 2}};
    
    // for (int i = 0; i < coords.length; i++) {
    //   for(int j = i + 1; j < coords.length; j++) {
    //     double dist = distancia(coords[i], coords[j]);
    //     System.out.printf("(" + i + "," + j + "). Dist:  %.2f \n", dist);
    //   }
    // }

    int[] res = masCercanas(coords, 0, coords.length - 1);
    System.out.println("BEST (recursive): (" + res[0] + "," + res[1] + ")");
  }

  public static int[] masCercanas(int[][] pares, int i, int j) {
    if (j == i) return null;
    if (j - i < 2) {
      int[] iPares = {i, j};
      return iPares;
    }

    int mid = i + (j - i) / 2;
    
    int[] izquierda = masCercanas(pares, i, mid);
    int[] derecha = masCercanas(pares, mid + 1, j);
 

    double distanciaIzquierda = distancia(pares[izquierda[0]], pares[izquierda[1]]);
    System.out.printf("L (" + izquierda[0] + "," + izquierda[1] + "). Dist:  %.2f \n", distanciaIzquierda);
    double distanciaMedio = distancia(pares[izquierda[1]], pares[derecha[0]]);
    System.out.printf("M (" + izquierda[1] + "," + derecha[0] + "). Dist:  %.2f \n", distanciaMedio);
    double distanciaDerecha = distancia(pares[derecha[0]], pares[derecha[1]]);
    System.out.printf("R (" + derecha[0] + "," + derecha[1] + "). Dist:  %.2f \n", distanciaDerecha);
    System.out.println();
    if (distanciaIzquierda < distanciaMedio && distanciaIzquierda < distanciaDerecha) {
      int[] iPares = {izquierda[0], izquierda[1]};
      return iPares;
    } if (distanciaIzquierda >= distanciaMedio && distanciaMedio < distanciaDerecha) {
      int[] iPares = {izquierda[1], derecha[0]};
      return iPares;
    } else {
      int[] iPares = {derecha[0], derecha[1]};
      return iPares;
    }
  }

  public static double distancia(int[] parUno, int[] parDos) {
    int x = parDos[0] - parUno[0];
    int y = parDos[1] - parUno[1];
    return Math.sqrt(x*x+y*y);
  }
}
