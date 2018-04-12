package rs.edu.devcenter.maze;

public class Body {

    private static int[][] a = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
            {2, 1, 1, 0, 1, 0, 0, 1, 1, 1},
            {0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
            {0, 1, 1, 1, 1, 0, 1, 1, 1, 0},
            {0, 1, 0, 0, 1, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 1, 1, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 3},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    private final int MAXROW = a.length, MAXCOL = a[0].length;
    private int startI, startJ, finishI, finishJ;

    /**
     * A method that looks for the starting and end position of the maze
     * startI - row value of starting position
     * startJ - column value of starting position
     * finishI - row value of end position
     * finishJ - column value of end position
     */
    public void startAndFinish() {

        int temp;

        for(int i=0; i<MAXROW; i++) {
            for (int j = 0; j < MAXCOL; j++) {
                temp = a[i][j];
                if (temp == 2) {
                    startI = i;
                    startJ = j;
                }
                if (temp == 3) {
                    finishI = i;
                    finishJ = j;
                }

            }
        }

    }

    /**
     * A recursive method that gives value 4 to the paths that lead to nowhere and gives value 5 to the true path
     * @param i - current row of the matrix maze
     * @param j - current column of the matrix maze
     * @return - (last return) returns false value (if it even gets to it) only if the maze can't be solved, but if
     * the maze is solvable then it won't even get to it
     */
    public boolean execute(int i, int j) {

        if(i < 0 || j < 0 || i >= MAXROW || j >= MAXCOL)
            return false;
        if(i == finishI && j == finishJ) {
            a[i][j] = 5;
            return true;
        }
        if(a[i][j] != 1 && a[i][j] != 2)
            return false;
        a[i][j] = 4;

        if(execute(i-1,j)) {
            a[i][j] = 5;
            return true;
        }
        if(execute(i+1,j)) {
            a[i][j] = 5;
            return true;
        }
        if(execute(i,j-1)) {
            a[i][j] = 5;
            return true;
        }
        if(execute(i,j+1)) {
            a[i][j] = 5;
            return true;
        }

        return false;

    }

    /**
     * Prints the whole maze
     */
    public void print() {

        for(int i=0; i < MAXROW; i++) {
            System.out.print("|");
            for(int j=0; j < MAXCOL; j++)
                System.out.print(a[i][j] + "|");
            System.out.println();
        }
        System.out.println();

    }

    /**
     * Prints the rows and columns from the start to the end of the matrix maze
     */
    public void printPath() {

        for(int i=0; i < MAXROW; i++)
            for(int j=0; j < MAXCOL; j++)
                if(a[i][j] == 5)
                    System.out.printf("(%d,%d)", i, j);

    }

    public int getStartI() {
        return startI;
    }

    public int getStartJ() {
        return startJ;
    }

}

