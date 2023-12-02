// Dado un grafo G dirigido, cuyos nodos representan las escuelas y gimnasios de un barrio en forma numérica, 
// y sus aristas la distancia en cuadras para llegar entre los diferentes lugares representados en el grafo. 
// Determinar cuántas son las cuadras mínimas para llegar de la escuela X al
// gimnasio Y (ambos puntos están representados en el grafo).

import java.util.Arrays;

public class ej1 {
  public static void main(String[] args) {
    int tamaño = 9;

    Grafo g = new Grafo(tamaño);

    g.setPeso(1, 2, 2);
    g.setPeso(1, 4, 15);
    g.setPeso(1, 5, 4);
    g.setPeso(1, 6, 3);
    g.setPeso(2, 3, 3);
    g.setPeso(2, 5, 2);
    g.setPeso(3, 4, 6);
    g.setPeso(5, 4, 1);
    g.setPeso(5, 6, 3);
    g.setPeso(6, 4, 1);

    dijkstra(g, 1);
    // g.print();
  }

  public static void printSolution(double dist[]) {
    System.out.println(
        "Vertex \t\t Distance from Source");
    for (int i = 0; i < dist.length; i++)
      System.out.println(i + " \t\t " + dist[i]);
  }

  public static int minDistance(double[] dist, Boolean[] visitados) {
    double min = Double.MAX_VALUE;
    int index = -1;

    for (int v = 0; v < dist.length; v++) {
      if (visitados[v] == false && dist[v] <= min) {
        min = dist[v];
        index = v;
      }
    }
    System.out.println("MIN: " + index);
    return index;
  }

  public static void dijkstra(Grafo grafo, int inicio) {
    double[] distancias = new double[grafo.vertices];
    Boolean[] visitados = new Boolean[grafo.vertices];

    for (int i = 0; i < grafo.vertices; i++) {
      distancias[i] = Double.MAX_VALUE;
      visitados[i] = false;
    }

    distancias[inicio] = 0;

    for (int i = 0; i < grafo.vertices - 1; i++) {
      System.out.println(Arrays.toString(distancias));
      int u = minDistance(distancias, visitados); // O(n)
      visitados[u] = true;

      for (int v = 0; v < grafo.vertices; v++) {
        System.out.println("Revisando: " + u + " -> " + v + " p:" + grafo.getPeso(u, v));

        if (!grafo.existeArista(u, v))
          continue; // validar si hay arista

        double peso = grafo.getPeso(u, v);

        if (visitados[v] == false && distancias[u] + peso < distancias[v]) {
          distancias[v] = distancias[u] + peso;
        }
      }
    }
    printSolution(distancias);
  }
}