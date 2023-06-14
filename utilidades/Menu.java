package utilidades;

public class Menu {
    int treeOption;

    public void run(){
        BinaryTreeMenu btMenu;
        BinarySearchTreeMenu bstMenu;
        BTreeMenu bMenu;
        do{
            System.out.print("\033[H\033[2J");
            chooseTree();
            switch(treeOption){
                case 1:
                    btMenu = new BinaryTreeMenu();
                    btMenu.run();
                    break;
                case 2:
                    bstMenu = new BinarySearchTreeMenu();
                    bstMenu.run();
                    break;
                case 3:
                    bMenu = new BTreeMenu();
                    bMenu.run();
                    break;
            }
        }while(treeOption != 0);


    }
    private void chooseTree(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("       ARBOLES         ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t0. Salir");
        System.out.println("\t1. Arbol Binario");
        System.out.println("\t2. Arbol Binario de Busqueda");
        System.out.println("\t3. Arbol B");

        treeOption = AskUser.tryToAskInt(": ", 0, 3);
    }
}
