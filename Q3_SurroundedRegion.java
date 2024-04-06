package April_05_Assognment;

import java.util.ArrayList;
import java.util.Scanner;

public class Q3_SurroundedRegion {
    public void solve(ArrayList<ArrayList<Character>> A) {
        if (A == null || A.size() == 0) return;

        int rows = A.size();
        int cols = A.get(0).size();

        // Mark 'O's connected to the border as '#'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && A.get(i).get(j) == 'O') {
                    dfs(A, i, j);
                }
            }
        }

        // Convert 'O's to 'X's and '#'s to 'O's
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A.get(i).get(j) == 'O') {
                    A.get(i).set(j, 'X');
                } else if (A.get(i).get(j) == '#') {
                    A.get(i).set(j, 'O');
                }
            }
        }
    }

    private void dfs(ArrayList<ArrayList<Character>> A, int i, int j) {
        if (i < 0 || i >= A.size() || j < 0 || j >= A.get(0).size() || A.get(i).get(j) != 'O') {
            return;
        }
        A.get(i).set(j, '#');
        dfs(A, i + 1, j);
        dfs(A, i - 1, j);
        dfs(A, i, j + 1);
        dfs(A, i, j - 1);
    }

    public static void main(String[] args) {
        Q3_SurroundedRegion solution = new Q3_SurroundedRegion();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows in the matrix:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of columns in the matrix:");
        int cols = scanner.nextInt();

        ArrayList<ArrayList<Character>> A = new ArrayList<>();
        System.out.println("Enter the elements of the matrix (X or O):");
        for (int i = 0; i < rows; i++) {
            ArrayList<Character> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(scanner.next().charAt(0));
            }
            A.add(row);
        }

        solution.solve(A);

        System.out.println("Updated matrix:");
        for (ArrayList<Character> row : A) {
            System.out.println(row);
        }

        scanner.close();
    }
}
