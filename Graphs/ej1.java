// Dado un grafo G dirigido, cuyos nodos representan las escuelas y gimnasios de un barrio en forma numérica, 
// y sus aristas la distancia en cuadras para llegar entre los diferentes lugares representados en el grafo. 
// Determinar cuántas son las cuadras mínimas para llegar de la escuela X al
// gimnasio Y (ambos puntos están representados en el grafo).

public class ej1 {
  public static void main(String[] args) {
    int tamaño = 7;

    Grafo g = new Grafo(tamaño);

    g.setPeso(1, 2, 2);
    g.setPeso(1, 4, 15);
    g.setPeso(1, 5, 4);
    g.setPeso(2, 3, 3);
    g.setPeso(2, 5, 2);
    g.setPeso(3, 4, 6);
    g.setPeso(5, 4, 1);
    g.setPeso(5, 6, 3);
    g.setPeso(6, 4, 1);

    int origen = 1;
    int destino = 4;

    int distanciaOrigenDestino = dijkstra(g, origen, destino);
    System.out.println(distanciaOrigenDestino);
  }

  public static void printSolution(int dist[]) {
    System.out.println(
        "Vertex \t\t Distance from Source");
    for (int i = 0; i < dist.length; i++)
      System.out.println(i + " \t\t " + dist[i]);
  }

  public static int minDistance(int[] dist, Boolean[] visitados) {
    int min = Integer.MAX_VALUE;
    int index = -1;

    for (int v = 0; v < dist.length; v++) {
      if (visitados[v] == false && dist[v] <= min) {
        min = dist[v];
        index = v;
      }
    }

    return index;
  }

  public static int dijkstra(Grafo grafo, int inicio, int destino) {
    int[] distancias = new int[grafo.vertices];
    Boolean[] visitados = new Boolean[grafo.vertices];

    for (int i = 0; i < distancias.length; i++) {
      distancias[i] = Integer.MAX_VALUE;
      visitados[i] = false;
    }

    distancias[inicio] = 0;

    for (int i = 0; i < distancias.length; i++) {
      int u = minDistance(distancias, visitados);
      visitados[u] = true;

      for (int j = 0; j < distancias.length; j++) {
        if (!grafo.existeArista(u, j)) continue;

        int peso = grafo.getPeso(u, j);

        if (distancias[j] > distancias[u] + peso) {
          distancias[j] = distancias[u] + peso;
        }
      }
    }

    return distancias[destino];
  }
}