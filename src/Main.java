import Utils.IslandCounter;

public class Main {
    public static void main(String[] args) {
        /**
         * given matrix of 0s and 1s where 0s represent water and adjacent 1s represent islands, return count of distinct islands
         * ex:
         * 0 0 1 0 0 0 1
         * 1 1 1 1 0 0 1
         * 0 0 0 1 1 0 0
         * 1 0 0 1 0 0 0
         * 1 0 0 0 0 1 0
         *
         * returns: 3
         */

        //destructive operations?
        //size requirement of islands?
        //adjacent = diagonal or NSEW only?
        //space/time complexity requirement?

        int[][] islandMatrix1r = {{0,0,1,0,0,0,1},{1,1,1,1,0,0,1},{0,0,0,1,1,0,0},{1,0,0,1,0,0,0},{1,0,0,0,0,1,0}};
        int[][] islandMatrix2r = {{1,1},{1,1},{0,1}};
        int[][] islandMatrix3r = {{1,1},{0,1},{0,1},{0,1}};
        int[][] islandMatrix4r = {{}};

        System.out.println("recursive");
        System.out.println(IslandCounter.getDistinctIslandCountRecursive(islandMatrix1r));
        System.out.println(IslandCounter.getDistinctIslandCountRecursive(islandMatrix2r));
        System.out.println(IslandCounter.getDistinctIslandCountRecursive(islandMatrix3r));
        System.out.println(IslandCounter.getDistinctIslandCountRecursive(islandMatrix4r));

        //resetting due to destructive operations
        int[][] islandMatrix1i = {{0,0,1,0,0,0,1},{1,1,1,1,0,0,1},{0,0,0,1,1,0,0},{1,0,0,1,0,0,0},{1,0,0,0,0,1,0}};
        int[][] islandMatrix2i = {{1,1},{1,1},{0,1}};
        int[][] islandMatrix3i = {{1,1},{0,1},{0,1},{0,1}};
        int[][] islandMatrix4i = {{}};

        System.out.println("\niterative");
        System.out.println(IslandCounter.getDistinctIslandCountIterative(islandMatrix1i));
        System.out.println(IslandCounter.getDistinctIslandCountIterative(islandMatrix2i));
        System.out.println(IslandCounter.getDistinctIslandCountIterative(islandMatrix3i));
        System.out.println(IslandCounter.getDistinctIslandCountIterative(islandMatrix4i));
    }
}