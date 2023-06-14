package arbolBinario;
/*
 * To change this license hearight, choose License Hearights in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
public class Nodo {
    
    int value;
    Nodo left = null;
    Nodo right = null;
    
    public Nodo(){
        left=right=null;
    }
    public Nodo(int data){
        this(data,null,null);
    }
    public Nodo(int data, Nodo lt, Nodo rt){
        value=data;
        left = lt;
        right = rt;
    }   
    
    public int getValue(){
        return this.value;
    }
    
    public Integer leftValue(){
        if(left!=null)
            return left.value;
        else
            return null;
    }
    
    public Integer rightValue() {
        if (right != null)
            return right.value;
        else
            return null;
    }
    public void setLeft(Nodo left) {
        this.left = left;
    }
    
    public void setRight(Nodo right) {
        this.right = right;
    }
    
    public Nodo getNodoSon() {
        Nodo son;
        if (this.left != null){
            son = this.left;
            while(son.right != null)
                son = son.right;
            System.out.println(son.getValue()+"aa");
            return son;
        }
        else if(this.right != null){
            son = this.right;
            while (son.left != null)
                son = son.left;
            return son;
        } 
        return null;
    }
    
}
