package April_05_Assognment;

import java.util.Scanner;

public class Q2_InterleavingString {
    public int isInterleave(String A, String B, String C) {
        int m = A.length();
        int n = B.length();

        if (m + n != C.length())
            return 0;

        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (i == 0)
                    dp[i][j] = (dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1));
                else if (j == 0)
                    dp[i][j] = (dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1));
                else
                    dp[i][j] = (dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1)) ||
                            (dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1));
            }
        }

        return dp[m][n] ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q2_InterleavingString solution = new Q2_InterleavingString();

        System.out.println("Enter string A:");
        String A = scanner.nextLine();

        System.out.println("Enter string B:");
        String B = scanner.nextLine();

        System.out.println("Enter string C:");
        String C = scanner.nextLine();

        int result = solution.isInterleave(A, B, C);
        System.out.println("Output: " + result);

        scanner.close();
    }
}
