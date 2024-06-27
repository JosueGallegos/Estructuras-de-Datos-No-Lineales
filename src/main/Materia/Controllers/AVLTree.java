package main.Materia.Controllers;
import main.Materia.Models.Node;

public class AVLTree {
    private Node root;

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            System.out.println("Nodo a insertar: " + value);
            return new Node(value);
        }
        if (value > node.getValue()) {
            node.setRight(insert(node.getRight(), value));
        } else if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        } else {
            System.out.println("El nodo " + value + " ya está presente en el árbol.");
            return node;
        }

        // Actualizar la altura del predecesor o ancestro
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));

        // Calcular el balance
        int balance = getBalance(node);

        // Casos de desequilibrio y rotaciones
        // Caso Izquierda - Izquierda
        if (balance > 1 && value < node.getLeft().getValue()) {
            System.out.println("Inserted node: " + node.getValue() + ", Balance: " + balance);
            return rightRotate(node);
        }

        // Caso Derecha - Derecha
        if (balance < -1 && value > node.getRight().getValue()) {
            System.out.println("Inserted node: " + node.getValue() + ", Balance: " + balance);
            return leftRotate(node);
        }

        // Caso Izquierda - Derecha
        if (balance > 1 && value > node.getLeft().getValue()) {
            System.out.println("Inserted node: " + node.getValue() + ", Balance: " + balance);
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        // Caso Derecha - Izquierda
        if (balance < -1 && value < node.getRight().getValue()) {
            System.out.println("Inserted node: " + node.getValue() + ", Balance: " + balance);
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        System.out.println("Inserted Node: "+ node.getValue()+ "Balance"+ balance);
        return node;
    }

    private Node rightRotate(Node nodeR) {
        System.out.println("Left Rotato on :" + nodeR.getValue()+ "Balance"+getBalance(nodeR));
        Node x = nodeR.getLeft();
        System.out.println("New root after left rotate : " + x.getValue());
        Node temp = x.getRight();

        // Realizar la rotacion
        x.setRight(nodeR);
        nodeR.setLeft(temp);

        // Actualizar las alturas
        nodeR.setHeight(Math.max(height(nodeR.getLeft()), height(nodeR.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        // Informar sobre la rotación
        System.out.println("Right rotate on node: " + nodeR.getValue() + ", Balance: " + getBalance(nodeR));

        // Devolver nueva raiz
        return x;
    }

    private Node leftRotate(Node nodeR) {
        Node y = nodeR.getRight();
        System.out.println("Left Rotato on :" + nodeR.getValue()+ "Balance"+getBalance(nodeR));
        Node temp = y.getLeft();
        System.out.println("New root after left rotate : " + y.getValue());

        // Realizar la rotacion
        y.setLeft(nodeR);
        nodeR.setRight(temp);

        // Actualizar las alturas
        nodeR.setHeight(Math.max(height(nodeR.getLeft()), height(nodeR.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        // Informar sobre la rotación
        System.out.println("Left rotate on node: " + nodeR.getValue() + ", Balance: " + getBalance(nodeR));

        // Devolver nueva raiz
        return y;
    }

    public void insert(int value) {
        System.out.println("Nodo a insertar: " + value);
        root = insert(root, value);
        printTree();
        System.out.println("\n-------\n");
    }

    public void printTree() {
        printTreeNode(root, "", true);
    }

    private void printTreeNode(Node root, String prefix, boolean isLeft) {
        if (root != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.getValue());
            if (root.getLeft() != null || root.getRight() != null) {
                if (root.getLeft() != null) {
                    printTreeNode(root.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
                } else {
                    System.out.println(prefix + (isLeft ? "│   " : "    ") + "├── null");
                }
                if (root.getRight() != null) {
                    printTreeNode(root.getRight(), prefix + (isLeft ? "│   " : "    "), false);
                } else {
                    System.out.println(prefix + (isLeft ? "│   " : "    ") + "└── null");
                }
            }
        }
    }
}

    


