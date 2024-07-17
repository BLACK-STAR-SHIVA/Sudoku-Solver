
public class Sudoku {
    public static void main(String[] args) {
        
        int sudoku[][] = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (sudoSolve(sudoku, 0, 0)) {
            System.out.println("Solved");
        } else {
            System.out.println("Not Solved");
        }
    }

    public static boolean sudoSolve(int sudo[][], int row, int col) {
        if (row == 9) {
            return true;
        }
        if (col == 9) {
            return sudoSolve(sudo, row + 1, 0);
        }
        if (sudo[row][col] != 0) {
            return sudoSolve(sudo, row, col + 1);
        }
        for (int num = 1; num <= 9; num++) {
            if (isSafe(sudo, num, row, col)) {
                sudo[row][col] = num;
                if (sudoSolve(sudo, row, col + 1)) {
                    return true;
                }
                sudo[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int sudo[][], int num, int row, int col) {
        for (int j = 0; j < 9; j++) {
            if (sudo[row][j] == num) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            if (sudo[j][col] == num) {
                return false;
            }
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int iRow = startRow; iRow < startRow + 3; iRow++) {
            for (int iCol = startCol; iCol < startCol + 3; iCol++) {
                if (sudo[iRow][iCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
