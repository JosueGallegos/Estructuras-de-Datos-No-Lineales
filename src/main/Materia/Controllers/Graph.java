package main.Materia.Controllers;

import java.util.ArrayList;
import java.util.List;

import main.Materia.Models.NodeGraph;


public class Graph {
    private List<NodeGraph> nodes;

    /**
     * Constructor de la clase Graph.
     * Inicializa una lista vacía de nodos.
     */
    public Graph(){
        this.nodes = new ArrayList<>();
    }

    /**
     * Añade un nuevo nodo al grafo con el valor especificado.
     * @param value Valor del nodo a añadir.
     * @return El nodo añadido.
     */
    public NodeGraph addNode(int value){
        NodeGraph newNode = new NodeGraph(value);
        nodes.add(newNode);
        return newNode;
    }

    /**
     * Añade una arista no dirigida entre dos nodos.
     * @param src Nodo origen.
     * @param dest Nodo destino.
     */
    public void addEdge(NodeGraph src, NodeGraph dest){
        src.addNeighbor(dest);
        dest.addNeighbor(src);
    }

    /**
     * Imprime el grafo mostrando cada nodo y sus vecinos.
     */
    public void printGraph(){
        for(NodeGraph node : nodes){
            System.out.println("Vertex "+ node.getValue()+ ":");
            for(NodeGraph neighbor : node.getNeighbor()){
                System.out.println(" -> "+ neighbor.getValue());
            }
            System.out.println();
        }
    }

    /**
     * Realiza un recorrido en profundidad (DFS) comenzando desde el nodo especificado.
     * @param startNode Nodo inicial para el recorrido DFS.
     */
    public void getDFS(NodeGraph startNode){
        boolean[] visited = new boolean[nodes.size()];
        getDFSUtil(startNode, visited);
    }

    /**
     * Método auxiliar para realizar DFS recursivo.
     * @param node Nodo actual.
     * @param visited Array para registrar nodos visitados.
     */
    private void getDFSUtil(NodeGraph node, boolean[] visited){
        visited[node.getValue()] = true;
        System.out.println(node.getValue() + " ");

        for (NodeGraph neighbor : node.getNeighbor()){
            if (!visited[neighbor.getValue()]){
                getDFSUtil(neighbor, visited);
            }
        }
    }

    /**
     * Realiza un recorrido en amplitud (BFS) comenzando desde el nodo especificado.
     * @param startNode Nodo inicial para el recorrido BFS.
     */
    public void getBFS(NodeGraph startNode){
        // Implementación de BF2S utilizando una cola
        // (Pendiente de implementación)
    }

    /**
     * Obtiene la matriz de adyacencia del grafo.
     * @return Matriz de adyacencia del grafo.
     */
    public int[][] getAdjacencyMatrix(){
        int size = nodes.size();
        int[][] adjacencyMatrix = new int[size][size];

        for (NodeGraph node : nodes){
            int nodeIndex = node.getValue();

            for (NodeGraph neighbor : node.getNeighbor()){
                int neighborIndex = neighbor.getValue();
                adjacencyMatrix[nodeIndex][neighborIndex] = 1;
            }
        }
        return adjacencyMatrix;
    }

    /**
     * Imprime la matriz de adyacencia del grafo.
     */
    public void printAdjacencyMatrix(){
        int[][] adjacencyMatrix = getAdjacencyMatrix();
        int size = nodes.size();

        System.out.print("  ");
        for (int i = 0; i < size; i++){
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < size; i++){
            System.out.print(i + " ");
            for (int j = 0; j < size; j++){
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
