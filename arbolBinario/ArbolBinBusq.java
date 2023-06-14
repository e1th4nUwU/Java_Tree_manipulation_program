package arbolBinario;
import java.util.HashSet;

public class ArbolBinBusq extends ArbolBin {
    HashSet<Integer> storedValues = new HashSet<>();

    @Override
    public void add(Nodo padre, Nodo hijo, int lado) throws IllegalArgumentException {
        throw new IllegalArgumentException("No se puede agregar a un arbol de busqueda con esos argumentos  ");
    }
    public void add(int n){
        add(new Nodo(n));
    }
    public void add(Nodo n) {
        if(!storedValues.contains(n.getValue())){

            if (root == null)
                root = n;
            else
                addInPlace(root, n);
            
            storedValues.add(n.getValue());

        }
    }
    private void addInPlace(Nodo nodo, Nodo add){
        if(nodo.getValue() > add.getValue()){
            if(nodo.left == null)
                nodo.left = add;
            else   
                addInPlace(nodo.left, add);
        }
        else{
            if(nodo.right == null)
                nodo.right = add;
            else
                addInPlace(nodo.right, add);

        }
    }
    public Integer remove(Integer n){
        if(!storedValues.contains(n))
            return null;
        
        Nodo nodo = root;
        
        if(root.getValue() == n)
            removeRoot();
        else{
            while(nodo.right.getValue() != n || nodo.left.getValue() != n){
                if(nodo.getValue() > n){
                    nodo = nodo.left;
                }
                else
                    nodo = nodo.right;
            }
            if(nodo.right.getValue() == n)
                removeRightChild(nodo);
            else
                removeLeftChild(nodo);

        }

        storedValues.remove(n);
        return n;
    }
}