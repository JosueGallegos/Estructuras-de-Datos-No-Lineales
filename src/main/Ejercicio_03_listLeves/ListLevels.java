package main.Ejercicio_03_listLeves;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.Materia.Models.Node;

public class ListLevels {

    public List<List<Node>> listLevels(Node root) {
        List<List<Node>> result = new ArrayList<>();
        
        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Node> levelList = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                levelList.add(node);

                if (node.getLeft() != null)
                    queue.offer(node.getLeft());
                if (node.getRight() != null)
                    queue.offer(node.getRight());
            }

            result.add(levelList);
        }

        return result;
    }

}
