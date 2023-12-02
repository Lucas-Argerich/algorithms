// Cambio de monedas: 
// Dado un conjunto C de N tipos de monedas con un número ilimitado de ejemplares de cada tipo, 
// se requiere formar, si se puede, una cantidad M empleando el mínimo número de ellas. 
// Por ejemplo, un cajero automático dispone de billetes de 
// distintos valores: $100, $25, $10, $5 y $1, si se tiene que pagar $289, 
// la mejor solución consiste en dar 10 billetes: 2 de $100, 3 de $25, 1 de $10 y 4 de $1.

import java.util.ArrayList;

public class ej1 {
  public static void main(String[] args) {
    int[] billetes = {100, 25, 10, 5, 1};
    int valor = 289;

    ArrayList<Integer> solucion = cajero(billetes, valor);

    System.out.print('[');
    for(int n : solucion) {
      System.out.print(n + ", ");
    }
    System.out.println(']');
  }

  public static ArrayList<Integer> cajero(int[] monedas, int valor) {
    if (valor <= 0) return new ArrayList<Integer>();
  
    int i = monedas.length - 1;
    while(i > 0 && monedas[i - 1] < valor) i--;
    
    ArrayList<Integer> res = new ArrayList<Integer>();
    res.add(monedas[i]);
    res.addAll(cajero(monedas, valor - monedas[i]));
    return res;
  }
}
