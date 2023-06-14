package utilidades;
import java.util.HashSet;
import arbolBinario.ArbolBinBusq;

class BinarySearchTreeMenu{
    ArbolBinBusq tree = new ArbolBinBusq();
    HashSet<Integer> nodes = new HashSet<>();

    void run(){
        int option;
        do {
            System.out.print("\033[H\033[2J");
            option = askOption();
            evaluateOption(option);
        } while (option != 0);
    }
    private int askOption(){
        System.out.println("\n---------------------");
        System.out.println("  ARBOL DE BUSQUEDA  ");
        System.out.println("---------------------");
        System.out.println("\t0. Salir");
        System.out.println("\t1. Reiniciar arbol");
        System.out.println("\t2. Agregar dato");
        System.out.println("\t3. Eliminar Nodo");
        System.out.println("\t4. Buscar");
        System.out.println("\t5. Imprimir arbol (BFS)");

        return AskUser.tryToAskInt(": ", 0, 5);
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
                else{
                    this.delete();
                }
                break;
            case 4:
                if (tree.isEmpty())
                    System.out.println("El arbol esta vacio");
                else
                    search();
                System.out.println("Presione enter para continuar");
                AskUser.askString("");
                break;
            case 5:
                if(tree.isEmpty())
                    System.out.println("El arbol esta vacio");
                else
                    tree.breadthFirst();
                System.out.println("Presione enter para continuar");
                AskUser.askString("");                    
                break;
        }
    }
    private void createNewTree(){
        tree = new ArbolBinBusq();
        nodes.clear();
    }
    private void add(){
        int n;
        n = AskUser.tryToAskInt("Ingresa el numero a agregar: ");

        if(tree.isEmpty())
            tree = new ArbolBinBusq();

        tree.add(n);
        nodes.add(n);
    }
    private void delete(){
        int rm;
        showNodes();
        System.out.println();
        rm = AskUser.tryToAskInt("Ingresa el numero a eliminar: ");
        
        if(!nodes.contains(rm)){
            System.out.println("El numero no existe en el arbol");
            System.out.println("Presione enter para continuar");
            AskUser.askString("");
        }
            
        else{
            tree.remove(rm);
            nodes.remove(rm);
        }
    }
    private void search(){
        int n;
        n = AskUser.tryToAskInt("Ingresa el numero a buscar: ");
        if(tree.search(n))
            System.out.println("\n\tEl numero existe en el arbol\n");
        else
            System.out.println("\n\tEl numero no existe en el arbol\n");
    }
    private void showNodes(){
        tree.breadthFirst();
    }
}