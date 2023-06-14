package utilidades;
import arbolB.BTree;

public class BTreeMenu {
    BTree tree;
    int order;

    void run() {
        int option;
        order = getTreeOrder();
        tree = new BTree(order);
        do {
            System.out.print("\033[H\033[2J");
            option = askOption();
            evaluateOption(option);
        } while (option != 0);
    }

    private int getTreeOrder() {
        return AskUser.tryToAskInt("Ingresa el orden del arbol: ",1);
    }

    private int askOption() {
        System.out.println("-----------");
        System.out.println("  ARBOL B  ");
        System.out.println("-----------");
        System.out.println("\t0. Salir");
        System.out.println("\t1. Reiniciar arbol");
        System.out.println("\t2. Agregar dato");
        System.out.println("\t3. Buscar dato");
        System.out.println("\t4. Imprimir arbol");

        return AskUser.tryToAskInt(": ", 0, 4);
    }

    private void evaluateOption(int option) {
        switch (option) {
            case 1:
                createNewTree();
                break;
            case 2:
                add();
                break;
            case 3:
                if (tree.isEmpty())
                    System.out.println("No hay elementos en el arbol aun");
                else
                    search();
                System.out.println("Presione enter para continuar");
                AskUser.askString("");
                break;
            case 4:
                if (tree.isEmpty())
                    System.out.println("No hay elementos en el arbol aun");
                else
                    tree.mostrarArbol();
                System.out.println("Presione enter para continuar");
                AskUser.askString("");
                break;
        }
    }

    private void createNewTree() {
        order = getTreeOrder();
        tree = new BTree(order);
    }

    private void add() {
        int n;
        n = AskUser.tryToAskInt("Ingresa el numero a agregar: ");

        tree.add(n);
    }

    private void search() {
        int n;
        n = AskUser.tryToAskInt("Ingresa el numero a buscar: ");
        if (tree.find(n))
            System.out.println("\n\tEl numero existe en el arbol\n");
        else
            System.out.println("\n\tEl numero no existe en el arbol\n");
    }
}
