// Problema de la Mochila: 
// Se tienen n objetos y una mochila. Para i = 1,2,..n, el objeto i tiene 
// un peso positivo pi y un valor positivo vi. 
// La mochila puede llevar un peso que no sobrepase P. 
// El objetivo es llenar la mochila de tal manera que se maximice el valor 
// de los objetos transportados, respetando la limitación de capacidad impuesta. 
// Los objetos pueden ser fraccionados, si una fracción xi (0 £ xi £ 1) del 
// objeto i es ubicada en la mochila contribuye en xi*pi al peso total de la
// mochila y en xi*vi al valor de la carga.

import java.util.ArrayList;

public class ej2 {

  static class Objeto {
    double peso;
    double valor;
    Objeto(int p, int v) {
      peso = p;
      valor = v;
    }
  }

  public static void main(String[] args) {
    // {{5, 10}, {2, 7}, {8, 15}, {1, 3}, {6, 12}};
    ArrayList<Objeto> objetos = new ArrayList<Objeto>();
    objetos.add(new Objeto(5, 10));    
    objetos.add(new Objeto(2, 7));
    objetos.add(new Objeto(8, 15));
    objetos.add(new Objeto(1, 3));
    objetos.add(new Objeto(6, 12));
    
    int mochila = 9;

    System.out.println(llenarMochila(objetos, mochila));

  }

  public static double llenarMochila(ArrayList<Objeto> objetos, double capacidad) {
    if (objetos.isEmpty() || capacidad == 0) return 0;
    
    Objeto best = objetos.get(0);
    for (Objeto obj : objetos) {
      if (obj.valor / obj.peso > best.valor / best.peso) best = obj;
    }

    double valor;
    double peso;
    if (best.peso > capacidad) {
      valor = best.valor / best.peso * capacidad;
      peso = capacidad;
    } else {
      valor = best.valor;
      peso = best.peso;
    }

    System.out.println("{ p:" + peso + ", v:" + valor + " } => " + valor / peso);

    objetos.remove(best);

    return valor + llenarMochila(objetos, capacidad - peso);
  }
}
