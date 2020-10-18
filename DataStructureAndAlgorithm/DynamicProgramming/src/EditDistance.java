package src;
/**
 * @author Kevin Mai
 * This program search for the least expensive process to convert a word to another. 
 * By searching through all possibility to find the smallest cost solution. 
 */

import java.util.Arrays;
import java.util.Collections;

/** 
 * Observation:
 * -There are 3 types of operations:
 *  + Deletion: Delete a single character from P to match with T.
 *  + Subtitution: Replace a single character from P to match with T.
 *  + Insertion: Insert a single character into pattern P to match P with T.
 * - After each operation, there will be new possiblity. 
 */

enum Operations { 
    DELETEION(0),
    INSERTION(1),
    SUBTITUTION(2);

    public int index;

    private Operations (int index) {
        this.index = index;
    }

    public static Operations valueOfIndex(int index) {
        switch(index) {
            case 0:
                return Operations.DELETEION;
            case 1:
                return Operations.INSERTION;
            case 2:
                return Operations.SUBTITUTION;
            default:
                return null;
        }
    }
}

public class EditDistance {
    
    public static final int MATCH_COST = 0;
    public static final int DELETE_COST = 1;
    public static final int INSERT_COST = 1;
    public static final int SUBTITUTION_COST = 1;

    class cell {
        public int cost;
        public Operations parent;
    }

    private cell[][] cells;

    public EditDistance () {

    }

    public int compareStrings (String p, String t) {

        initTable(p, t);
        int[] opt = new int[3];

        for (int pIndex = 1; pIndex < p.length(); pIndex ++) {
            for (int tIndex = 1; tIndex < t.length(); tIndex ++) {
                opt[Operations.INSERTION.index] = cells[pIndex-1][tIndex-1].cost + match(p, t, pIndex, tIndex);
                opt[Operations.DELETEION.index] = cells[pIndex-1][tIndex].cost + indel(p, pIndex);
                opt[Operations.SUBTITUTION.index] = cells[pIndex][tIndex-1].cost + indel(t, tIndex);

                cells[pIndex][tIndex].cost = opt[Operations.SUBTITUTION.index];
                cells[pIndex][tIndex].parent = Operations.SUBTITUTION;

                for(int i = Operations.DELETEION.index; i < Operations.SUBTITUTION.index; i ++) {
                    if (opt[i] < cells[pIndex][tIndex].cost) {
                        cells[pIndex][tIndex].cost = opt[i];
                        cells[pIndex][tIndex].parent = Operations.valueOfIndex(i);
                    }
                }
            }
        }

        goalCells(p, t);

        return cells[p.length()-1][t.length()-1].cost;
    }

    private void initTable (String p, String t) {
        int rowsNum = p.length();
        int colsNum = t.length();

        cells = new cell[rowsNum][colsNum];
        for (int row = 0; row < rowsNum; row ++) {
            for (int col = 0; col < colsNum; col ++) {
                cells[row][col] = new cell();
            }
        }
         
        for (int i = 0; i < rowsNum; i ++) {
            initCol(i);
        }
        for (int i = 0; i < colsNum; i ++) {
            initRow(i);
        }
    }

    private void initRow (int col) {
        cells[0][col].cost = col;
        if (col > 0) {
            cells[0][col].parent = Operations.INSERTION;
        } else {
            cells[0][col].parent = null;
        }
    }

    private void initCol (int row) {
        cells[row][0].cost = row;
        if (row > 0) {
            cells[row][0].parent = Operations.DELETEION;
        } else {
            cells[row][0].parent = null;
        }
    }

    private void goalCells (String p, String t) {
    }

    public int compareStrings (String p, String t, int pIndex, int tIndex) {
        if (pIndex == -1 && tIndex == -1) {
            return 0;
        }
        if (pIndex == -1) {
            return compareStrings (p, t, pIndex, tIndex - 1) + indel(t, tIndex);
        };
         if (tIndex == -1) {
            return compareStrings (p, t, pIndex-1, tIndex) + indel(p, pIndex);
        };
        
        Integer[] opt = new Integer[3];
        int lowsetCost = Integer.MAX_VALUE;
        
        opt[Operations.DELETEION.index] = compareStrings (p, t, pIndex-1, tIndex) + indel(p, pIndex);
        opt[Operations.INSERTION.index] = compareStrings (p, t, pIndex, tIndex-1) + indel(t, tIndex);
        opt[Operations.SUBTITUTION.index] = compareStrings (p,t, pIndex-1, tIndex-1) + match(p, t, pIndex, tIndex);

        for (int i = 0; i < 3; i ++) {
            if (opt[i] < lowsetCost) {
                lowsetCost = opt[i];
            }
        }

        return lowsetCost;
    }


    private int match (String p, String t, int pIndex, int tIndex) {
        if (p.charAt(pIndex) == t.charAt(tIndex)) {
            return MATCH_COST;
        } else {
            return SUBTITUTION_COST;
        }
    }

    private int indel (String p, int pIndex) {
        return DELETE_COST;
    }

}
