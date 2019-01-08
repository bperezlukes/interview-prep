package Models;

public class IslandNode {
    private final int row;
    private final int column;
    private final int depth;
    private final String direction;

    public IslandNode(int row, int column, int depth, String direction) {
        this.row = row;
        this.column = column;
        this.depth = depth;
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getDepth() {
        return depth;
    }

    public String getDirection() {
        return direction;
    }
}
