public class Grafo {
    int vertices;
    private double[][] datos;

    public Grafo(int vertices) {
      this.vertices = vertices;
      datos = new double[vertices][vertices];
    }

    public void setPeso(int n, int m, int peso) {
      datos[n][m] = peso;
    }

    public double getPeso(int n, int m) {
      return datos[n][m];
    }

    public boolean existeArista(int n, int m) {
      return datos[n][m] != 0;
    }

    public void print() {
      for (double[] linea : datos) {
        System.out.print("[ ");
        for (double valor : linea) {
          System.out.print(valor + " ");
        }
        System.out.println("]");
      }
    }
  }