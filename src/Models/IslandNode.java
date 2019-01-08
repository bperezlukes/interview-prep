package Models;

public class IslandNode {
    public int row;
    public int column;
    public int depth;
    public String direction;

    public IslandNode(int row, int column, int depth, String direction) {
        this.row = row;
        this.column = column;
        this.depth = depth;
        this.direction = direction;
    }
}
