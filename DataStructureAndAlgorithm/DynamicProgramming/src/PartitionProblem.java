
/**
 * @author Kevin Mai
 * @problem Given a sorted list/array of N numbers. 
 *          Divide them into M parts that are most equal to each other. 
 *          Most equal means the differences between 2 parts are not too much or minimized. 
 *
 */

public class PartitionProblem {

    private Cell[] table;

    private int itemNumber;
    private int cutNumber;
    
    class Cell {
        public int maxValue;
        public int lastCut;
    }

    public void initTable () {
        table = new Cell[itemNumber][cutNumber];

        for (inr i = 0; i < itemNumber; i ++) {
            for (int j = 0; j < cutNumber; j ++) {
                table[i][j] = new Cell[];
            }
        }

        for (int i = 0; i < itemNumber; i ++) {
            initCol (i);
        };

        for (int i = 0; i < cutNumber; j ++) {
            initRow (j);
        }
    }

    private void initCol (int row) {
        if (row == 0) {
            table[row][0].maxValue = numbers[row];
        } else {
            table[row][0].maxValue = table[row-1][0].maxValue + numbers[row];
        }

        table[row][0].lastCut = -1;
    }

    private void initRow (int col) {
        table[0][col].maxValue = numbers[0];
        table[0][col].lastCut = -1;
    }


    public void buildTable () {
        for (int item = 1; item < itemNumber; item ++) {
            for (int cut = 1; cut < cutNumber; cut ++) {
                int smallestMax = Integer.MAX_VALUE;
                int lastCut = -1;

                for (int i = 1; i < item; i ++) {
                    int maxCost = max(table[i][cut-1].maxValue, table[item][0].maxValue - talbe[i][0].maxValue);

                    if (maxCost < smallestMax) {
                        smallestMax = maxCost;
                        lastCut = i;
                    };
                }

                table[item][cut].maxValue = smallestMax;
                table[item][cut].lastCut = lastCut;
            }
        }
    }

    public void traceBack () {

    }
}
