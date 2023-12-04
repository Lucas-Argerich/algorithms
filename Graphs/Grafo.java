public class Grafo {
    int vertices;
    private int[][] datos;

    public Grafo(int vertices) {
      this.vertices = vertices;
      datos = new int[vertices][vertices];
    }

    public void setPeso(int n, int m, int peso) {
      datos[n][m] = peso;
    }

    public int getPeso(int n, int m) {
      return datos[n][m];
    }

    public boolean existeArista(int n, int m) {
      return datos[n][m] != 0;
    }

    public void print() {
      for (int[] linea : datos) {
        System.out.print("[ ");
        for (int valor : linea) {
          System.out.print(valor + " ");
        }
        System.out.println("]");
      }
    }
  }