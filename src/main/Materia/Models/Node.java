package main.Materia.Models;

public class Node{
    private int value;
    public Node left;
    public Node right;
    public Integer val;
    private int height;

    public Node(int value){
        this.value = value;
    
    }
    public int getValue(){
        return value;
    }
    public int getHeight(){
        return height;
    }
    public void setValue(int value){
        this.value = value;
    }
    public Node getLeft(){
        return left;
    }
    public void setLeft(Node left){
        this.left=left;
    }
    public Node getRight(){
        return right;
    }
    public void setRight(Node right){
        this.right=right;
    }
    public void setHeight(int height){
        this.height=height;
    }

}
