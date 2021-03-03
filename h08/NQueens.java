import java.util.Scanner;
public class NQueens {
    int n; 
    int [][] table;
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of queens:");
        int n = scan.nextInt();
        NQueens nq = new NQueens(n);
        scan.close();
        System.out.println("The number of valid arrangments is " + nq.checkRow(0));
    }

    public NQueens(int n) {
        table = new int[n][n];
    }

    public int checkRow(int r) {
        int numQueens = 0;
        if (r == n) {
            numQueens++;
            return numQueens;
        }
        for (int i = 0; i < n; i++) {
            if (isOpen(r, i) == 0) {
                table[r][i] = 1;
                numQueens += checkRow(r + 1);
                table[r][i] -= 1;
            }

        }
        return numQueens;
    }

    public int isOpen(int row, int col) {
        //Right diag
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (table[i][j] == 1) {
                return 0;
            }
        }
        //Left diag
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (table[i][j] == 1) {
                return 0;
            }
        }
        //Columnar check
        for (int i = row, j = col; i >= 0; i--) {
            if (table[i][j] == 1) {
                return 0;
            }
        }
        return 1;
    }
}
