package Utils;

import Models.IslandNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class IslandCounter {
    public static int getDistinctIslandCountRecursive(int[][] islandMatrix) {
        Set<String> islandSet = new HashSet<>();

        for (int row=0; row<islandMatrix.length; row++) {
            for (int col=0; col<islandMatrix[0].length; col++){
                if (islandMatrix[row][col] == 1) {
                    //recurse
                    String path = "0X";
                    path = getIslandPathRecursive(islandMatrix, row, col, 1, path);
                    System.out.println(path);
                    islandSet.add(path);
                }
            }
        }

        return islandSet.size();
    }

    public static int getDistinctIslandCountIterative(int[][] islandMatrix) {
        Set<String> islandSet = new HashSet<>();

        for (int row=0; row<islandMatrix.length; row++) {
            for (int col=0; col<islandMatrix[0].length; col++){
                if (islandMatrix[row][col] == 1) {
                    String path = getIslandPathIterative(islandMatrix, row, col);
                    System.out.println(path);
                    islandSet.add(path);
                }
            }
        }

        return islandSet.size();
    }

    /**
     * recurses through possible island paths, depth first search, records path as it goes - E for east, S for south, W for west, N for north
     */
    private static String getIslandPathRecursive(int[][] islandMatrix, int row, int col, int depth, String path) {
        islandMatrix[row][col] = -1;
        //search east
        if (col+1 < islandMatrix[row].length && islandMatrix[row][col+1] == 1) {
            path = getIslandPathRecursive(islandMatrix, row, col+1, depth+1, path+depth+"E");
        }
        //search south
        if (row+1 < islandMatrix.length && islandMatrix[row+1][col] == 1) {
            path = getIslandPathRecursive(islandMatrix, row+1, col, depth+1,path+depth+"S");
        }
        //search west
        if (col-1 >= 0 && islandMatrix[row][col-1] == 1) {
            path = getIslandPathRecursive(islandMatrix, row, col-1, depth+1,path+depth+"W");
        }
        //searth north
        if (row-1 >= 0 && islandMatrix[row-1][col] == 1) {
            path = getIslandPathRecursive(islandMatrix, row-1, col, depth+1,path+depth+"N");
        }

        return path;
    }

    /**
     * iterates through possible island paths by pushing island nodes to stack
     */
    private static String getIslandPathIterative(int[][] islandMatrix, int row, int col) {
        Deque<IslandNode> stack = new ArrayDeque<>();
        String path = "";
        IslandNode startNode = new IslandNode(row, col, 0, "X");

        //for each node visited, add right, down, left, up nodes if they extend the island
        stack.add(startNode);

        while (stack.size() != 0) {
            IslandNode currentNode = stack.pop();
            int depth = currentNode.depth;
            int i = currentNode.row;
            int j = currentNode.column;
            islandMatrix[i][j] = -1;
            path = path+depth+currentNode.direction;

            if (i -1 >= 0 && islandMatrix[i -1][j] == 1) {
                stack.push(new IslandNode(i-1, j+1, depth + 1, "N"));
            }
            if (j-1 >= 0 && islandMatrix[i][j-1] == 1) {
                stack.push(new IslandNode(i, j-1, depth + 1, "W"));
            }
            if (i+1 < islandMatrix.length && islandMatrix[i+1][j] ==1) {
                stack.push(new IslandNode(i+1, j, depth + 1, "S"));
            }
            if (j+1 < islandMatrix[0].length && islandMatrix[i][j+1] == 1) {
                stack.push(new IslandNode(i, j+1, depth + 1, "E"));
            }
        }

        return path;
    }
}
