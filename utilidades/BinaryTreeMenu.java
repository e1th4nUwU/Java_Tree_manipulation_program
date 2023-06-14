package utilidades;
import java.util.LinkedList;
import arbolBinario.ArbolBin;
import arbolBinario.Nodo;

class BinaryTreeMenu{
    ArbolBin tree = new ArbolBin();
    LinkedList<Nodo> nodes = new LinkedList<>();

    void run(){
        int option;
        do {
            System.out.print("\033[H\033[2J");
            option = askOption();
            evaluateOption(option);
        } while (option != 0);
    }
    private int askOption(){
        System.out.println("\n-----------------");
        System.out.println("  ARBOL BINARIO  ");
        System.out.println("-----------------");
        System.out.println("\t0. Salir");
        System.out.println("\t1. Reiniciar arbol");
        System.out.println("\t2. Agregar dato");
        System.out.println("\t3. Eliminar Nodo");
        System.out.println("\t4. Imprimir arbol (BFS)");
        System.out.println("\t5. Notacion Prefija (preorden)");
        System.out.println("\t6. Notacion Infija (inorden)");
        System.out.println("\t7. Notacion Postfija (postorden)");
        System.out.println("\t8. Ver nodos con hijos");

        return AskUser.tryToAskInt(": ", 0, 8);
    }
    private void evaluateOption(int option){
        switch(option){
            case 1:
                createNewTree();
                break;
            case 2:
                add();
                break;
            case 3:
                if(tree.isEmpty()){
                    System.out.println("El arbol esta vacio");
                    System.out.println("Presione enter para continuar");
                    AskUser.askString("");
                }
                else 
                    delete();
                
                
                break;
            case 4:
                if(tree.isEmpty())
                    System.out.println("El arbol esta vacio");
                    
                else
                    tree.breadthFirst();
                
                System.out.println("Presione enter para continuar");
                AskUser.askString("");                  
                break;
            case 5:
                if(tree.isEmpty())
                    System.out.println("El arbol esta vacio");
                else
                    tree.preOrder();
                
                System.out.println("Presione enter para continuar");
                AskUser.askString("");                
                break;
            case 6:
                if(tree.isEmpty())
                    System.out.println("El arbol esta vacio");
                else
                    tree.inOrder();
                
                System.out.println("Presione enter para continuar");
                AskUser.askString("");
                break;
            case 7:
                if(tree.isEmpty())
                    System.out.println("El arbol esta vacio");
                else
                    tree.postOrder();

                System.out.println("Presione enter para continuar");
                AskUser.askString("");
                break;
            case 8:
                if(tree.isEmpty())
                    System.out.println("El arbol esta vacio");
                else
                    printNodosWithChildren();

                System.out.println("Presione enter para continuar");
                AskUser.askString("");
                break;
        }


    }
    private void createNewTree(){
        tree = new ArbolBin();
        nodes.clear();
    }
    private void add(){
        int n, pos, lado;
        Nodo nodoAgregar;
        n = AskUser.tryToAskInt("Ingresa el numero a agregar: ");
        nodoAgregar = new Nodo(n);
        if(tree.isEmpty()){
            tree = new ArbolBin(nodoAgregar);
            nodes.add(nodoAgregar);
        }
        else{
            printNodosWithChildren();
            System.out.println();
            pos = AskUser.tryToAskInt("Ingresa quien sera el nodo padre (solo nodos con posiciones libres): ", 0, nodes.size()-1);
            Nodo padre = nodes.get(pos);
            lado = AskUser.tryToAskInt("Ingresa el lado (0=izq, otro=der): ");
            if(lado == 0){
                if(padre.leftValue() == null){
                    tree.add(padre, nodoAgregar, lado);
                    nodes.add(nodoAgregar);
                }
                else
                    System.out.println("\n\tEl nodo ya tiene un hijo izquierdo");
                    System.out.println("\tNo se agrego el nodo\n");
            }
            else{
                if(padre.rightValue() == null){
                    tree.add(padre, nodoAgregar, lado);
                    nodes.add(nodoAgregar);
                }
                else
                    System.out.println("\n\tEl nodo ya tiene un hijo derecho");
                    System.out.println("\tNo se agrego el nodo\n");
            }
            
        }
    }
    private void delete(){          
        int pos;
        System.out.println("Nodos del arbol:");
        showNodes();
        System.out.println();
        pos = AskUser.tryToAskInt("Ingresa el nodo a eliminar: ", 0, nodes.size()-1);
        tree.remove(nodes.get(pos));
        nodes.remove(pos);
    }
    private void showNodes(){
        System.out.println("Nodos del arbol:");
        for(int i = 0; i < nodes.size(); i++){
            System.out.println("\t" + i + ". " + nodes.get(i).getValue());
        }
        
        
    }
    private void printNodosWithChildren(){
        System.out.println("Nodos del arbol:");
        for(int i=0; i<nodes.size(); i++){
            System.out.println("\t"+i+". "+nodes.get(i).getValue());
            System.out.println("\t\tIzq: "+ nodes.get(i).leftValue() + "\tDer: "+ nodes.get(i).rightValue());
        }
    }
}