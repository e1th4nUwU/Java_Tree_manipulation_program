package arbolBinario;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
import arbolB.BTree;
public class Pruebas {
    
    public static void main(String args[]){
        ArbolBin arbol;
        
        Nodo n7 = new Nodo(7);
        Nodo n9 = new Nodo(9);
        Nodo n1 = new Nodo(1,n7,n9);
        Nodo n15 = new Nodo(15);
        Nodo n8 = new Nodo(8);
        Nodo n4 = new Nodo(4);
        Nodo n2 = new Nodo(2);
        Nodo n16 = new Nodo(16);
        Nodo n3 = new Nodo(3);
        
        arbol = new ArbolBin(n1);
        arbol.add(n7,n15,0);
        arbol.add(n7,n8,-1);
        arbol.add(n9,n4,0);
        arbol.add(n9,n2,1);
        arbol.add(n15,n16,1);
        arbol.add(n8,n3,0);
        arbol.breadthFirst();

        arbol.remove(1);
        arbol.remove(9);

        System.out.println();
        
        arbol.breadthFirst();
    
        System.out.println();

        System.out.println("Esta el numero 16?:" +  arbol.search(16));
        System.out.println("Cuantas veces aparece el numero 304?: " + arbol.searchCount(304));
        System.out.println("Hay algun numero similar al 14?: " + arbol.searchSimilar(14));

        System.out.println();
        
        n1 = new Nodo(1);
        n2 = new Nodo(2);
        n3 = new Nodo(3);
        n4 = new Nodo(4);
        Nodo n5 = new Nodo(5); 
        Nodo n6 = new Nodo(6);
        n7 = new Nodo(7);
        n8 = new Nodo(8);
        n9 = new Nodo(9);

        arbol = new ArbolBin(n1);
        arbol.add(n1,n2,0);
        arbol.add(n1,n3,1);
        arbol.add(n2,n4,0);
        arbol.add(n2,n5,1);
        arbol.add(n3,n6,1);
        arbol.add(n4,n7,0);
        arbol.add(n5,n8,0);
        arbol.add(n5,n9,1);
        arbol.breadthFirst();

        System.out.println("\nPreorden:");
        arbol.preOrder();

        System.out.println("Inorden:");
        arbol.inOrder();

        System.out.println("Postorden:");
        arbol.postOrder();

        
        System.out.println("\nARBOL DE BUSQUEDA\n");
        ArbolBinBusq  arbolBinBusq= new ArbolBinBusq();
        arbolBinBusq.add(5);
        arbolBinBusq.add(3);
        arbolBinBusq.add(4);
        arbolBinBusq.add(2);
        arbolBinBusq.add(7);
        arbolBinBusq.add(8);
        arbolBinBusq.add(9);
        arbolBinBusq.add(10);
        arbolBinBusq.add(1);
        arbolBinBusq.add(6);

        arbolBinBusq.breadthFirst();
        
        arbolBinBusq.remove(5);
        arbolBinBusq.remove(6);
        arbolBinBusq.remove(7);
        arbolBinBusq.remove(8);

        System.out.println();
        arbolBinBusq.breadthFirst();

        System.out.println("\nARBOL B\n");
        BTree arbolB = new BTree(3);
        arbolB.mostrarArbol();
        for(int i = 0; i < 10; i++){
            arbolB.add(i);
        }
        arbolB.mostrarArbol();


    }

    
}
