
class Solution {

    Boolean[][][] dp;

    boolean solve(char[][] grid, int i, int j, int balance) {

        int m = grid.length;
        int n = grid[0].length;

        if (i >= m || j >= n) {
            return false;
        }

        if (grid[i][j] == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0) {
            return false;
        }

        int remaining = (m - 1 - i) + (n - 1 - j);

        if (balance > remaining) {
            return false;
        }

        if (i == m - 1 && j == n - 1) {
            return balance == 0;
        }

        if (dp[i][j][balance] != null) {
            return dp[i][j][balance];
        }

        boolean down = solve(grid, i + 1, j, balance);
        boolean right = solve(grid, i, j + 1, balance);

        dp[i][j][balance] = down || right;

        return dp[i][j][balance];
    }

    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        dp = new Boolean[m][n][m + n + 1];

        return solve(grid, 0, 0, 0);
    }
}

