package main.Materia.Models;

import java.util.LinkedList;
import java.util.List;

public class NodeGraph {
    private int value;
    private List<NodeGraph> neighbors;

    public NodeGraph(int value){
        this.value = value;
        this.neighbors = new LinkedList<>();
    }
    public int getValue(){
        return value;
    }
    public void  setValue(int value){
        this.value= value;
    }
    public List<NodeGraph> getNeighbor(){
        return neighbors;
    }
    public void addNeighbor(NodeGraph neighbors){
        this.neighbors.add(neighbors);
    }
    public void setNeighbor(List<NodeGraph>neighbors){
        this.neighbors = neighbors;
    }

}
