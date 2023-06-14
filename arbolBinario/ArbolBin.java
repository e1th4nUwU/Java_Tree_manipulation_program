package arbolBinario;

import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license hearight, choose License Hearights in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
public class ArbolBin {
    protected Nodo root;
    
    public ArbolBin(){
        root=null;
    }
    
    public ArbolBin(int val){
        root=new Nodo(val);
    }
    
    public ArbolBin(Nodo root){
        this.root=root;
    }

    public boolean isEmpty(){
        return root==null;
    }
    
    public void add(Nodo padre, Nodo hijo, int lado){
	if(lado==0)
            padre.setLeft(hijo);
	else
            padre.setRight(hijo);
    }
    
    protected void visit(Nodo n){
        System.out.println(n.value+" ");
    }	
    
    public void breadthFirst() {
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList<>();
        if (r != null) {
            queue.add(r);
            while (!queue.isEmpty()) {
                r = (Nodo) queue.poll();
                visit(r);
                if (r.left != null)
                    queue.add(r.left);
                if (r.right != null)
                    queue.add(r.right);
            }
        }
    }

    
    public Integer remove(Nodo n){
        return remove(n.getValue());    
    }

    public Integer remove(int rm){
       if(root == null)
            return null;
        if(root.getValue() == rm){
            removeRoot();
            return rm;
        }

        Queue<Nodo> queue = new LinkedList<>();
        Nodo n;
        queue.add(root);
        while(!queue.isEmpty()){
            n = queue.poll();
	        if(n.left!=null){
                if(n.left.getValue() == rm){
                    removeLeftChild(n);
                    return rm;
                }
                queue.add(n.left);
            }
            if(n.right!=null){
                if(n.right.getValue() == rm){
                    removeRightChild(n);
                    return rm;
                }
                queue.add(n.right);
            }

        }

        return null;
    }
    protected Integer removeRoot(){
        Nodo aux;
        int rootValue = root.getValue();
        if (root == null)
            return null;
        if(root.left != null){
            aux = root.left;
            if(aux.right == null){
                aux.right = root.right;
                root = aux;
            }
            else{
                while(aux.right.right != null)
                    aux = aux.right;
                Nodo aux1 = aux.right;
                aux1.right = root.right;
                aux.right = aux1.left;
                aux1.left = root.left;
                root = aux1;
            }
        }
        else if(root.right != null){
            aux = root.right;
            if(aux.left == null){
                aux.left = root.left;
                root = aux;
            }
            else{
                while(aux.left.left != null)
                    aux = aux.left;
                Nodo aux1 = aux.left;
                aux1.left =  root.left;
                aux.left = aux1.right;
                aux1.right = root.right;
                root = aux;
            }
        }
        else{
            root = null;
            return null;
        }
        return rootValue;
    }
    protected void removeLeftChild(Nodo origin){
        Nodo n = origin.left, rm = origin.left, end;
        if(n.right == null && n.left == null){
            origin.left = null;
        }
        else if(n.right == null){
            origin.left = n.left;
        }
        else{
            while(n.right.right != null){
                n = n.right;
            }
            end = n.right;
            n.right = end.left;
            end.left = rm.left;
            end.right = rm.right;
            origin.left = end;
        }
    }
    protected void removeRightChild(Nodo origin){
        Nodo n = origin.right, rm = origin.right, end;
        if(n.left == null && n.right == null){
            origin.right = null;
        }
        else if(n.left == null){
            origin.right = n.right;
        }
        else{
            while(n.left.left != null){
                n = n.left;
            }
            end = n.left;
            n.left = end.right;
            end.right = rm.right;
            end.left = rm.left;
            origin.right = end;
        }
    }

    public boolean search(int searchValue){
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList<>();
        if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
                if(r.getValue() == searchValue){
                    return true;
                }
                if(r.left!=null)
                    queue.add(r.left);
                if(r.right!=null)
                    queue.add(r.right);
            }
        }
        return false;
    }
    public int searchCount(int searchValue){
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList<>();
        int count = 0;
        if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
                if(r.getValue() == searchValue){
                    count++;
                }
                if(r.left!=null)
                    queue.add(r.left);
                if(r.right!=null)
                    queue.add(r.right);
            }
        }
        return count;
    }
    public Integer searchSimilar(int searchValue, int errorMargin){
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList<>();
        if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
                if(r.getValue() <= searchValue + errorMargin && r.getValue() >= searchValue - errorMargin)
                    return r.getValue();
                if(r.left!=null)
                    queue.add(r.left);
                if(r.right!=null)
                    queue.add(r.right);
            }
        }
        return null;
    }
    public Integer searchSimilar(int searchValue){
        return searchSimilar(searchValue, 1);
    }

    public void preOrder(Nodo n) {
        if (n != null) {
            visit(n);
            preOrder(n.left);
            preOrder(n.right);
        }
    }
    public void preOrder() {
        preOrder(root);
    }
    public void inOrder(Nodo n) {
        if (n != null) {
            inOrder(n.left);
            visit(n);
            inOrder(n.right);
        }
    }
    public void inOrder() {
        inOrder(root);
    }
    public void postOrder(Nodo n) {
        if (n != null) {
            postOrder(n.left);
            postOrder(n.right);
            visit(n);
        }
    }
    public void postOrder() {
        postOrder(root);
    }
}
