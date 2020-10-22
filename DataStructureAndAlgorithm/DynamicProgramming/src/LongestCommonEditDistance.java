public class LongestCommonEditDistance implements LongestCommonString {
    public static final int DELETE = 0;
    public static final int MATCH = 1;
    
    public static final int OPT_MATCH = 0;
    public static final int OPT_DELETE_X = 1;
    public static final int OPT_DELETE_Y = 2;

    private String x;
    private String y;

    private Cell[] table;
    
    private String longestSubstring;

    @Override
    public String searchLongestCommonString (String x, String y) {
        this.x = x;
        this.y = y;
        initTable();

        processStringsEarly ();

        buildUpTable ();
    }

    private void buildUpTable () {
        int rowNum = x.length();
        int colNum = y.length();

        int[] opt = new int[3];

        for (int row = 1; row < rowNum; row ++) {
            for (int col = 1; col < colNum; col ++) {
                opt[OPT_MATCH] = table[row-1][col-1].cost + match(x, y, row, col);
                opt[OPT_DELETE_X] = table[row-1][col].cost + del(x, row);
                opt[OPT_DELETE_Y] = table[row][col-1].cost + del(y, col);

                int lowestCost = opt[OPT_MATCH];
                int operation = OPT_MATCH;

                for (int i = OPT_MATCH; i < OPT_DELETE_Y; i ++) {
                    if (opt[i] < lowestCost) {
                        lowestCost = opt[i];
                        operation = i;
                    }
                }

                table[row][col].cost = lowestCost;
                table[row][col].parent = lowestCost;
            }
        }

    }

    private int match (String x, String y, int xIndex, int yIndex) {
        if (x.charAt(xIndex) == y.charAt(yIndex)) {
            return 0;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    private int buildLowestCostTable (String x, String y, int xIndex, int yIndex) {
        
    }

    public void processStringsEarly () {
        StringBuilder xBuilder = new StringBuilder();
        StringBuilder yBuilder = new StringBuilder();

        if (x.charAt(0) != ' ') {
            xBuilder.append(" ");
            xBuilder.append(x);
            x = xBuilder.toString();
        }

        if (y.charAt(0) != ' ') {
            yBuilder.append(" ");
            yBuilder.append(y);
            y = xBuilder.toString();
        }
    }

    private void initTable () {
        int rowNum = x.length();
        int colNum = y.length();

        table = new Cell[rowNum][colNum];
        for (int row = 0; row < rowNum; row ++) {
            for (int col = 0; col < colNum; col ++) {
                table[row][col] = new Cell();
            }
        }

        for (int row = 0; row < rowNum; row ++) {
            table[row][0].cost = row;
            table[row][0].parent = DELETE;
        }

        for (int col = 0; col < colNum; col ++) {
            table[0][col].cost = col;
            table[0][col].parent = DELETE;
        }
        
    }


    private void traceBack () {

    }

}

class Cell {
    public int cost;
    public int parent;
}
