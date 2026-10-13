class Solution {
    int[][] dp = new int[101][101];

    int fun(int i, int j, int[][] matrix) {
        int n = matrix.length;
        if (j < 0 || j >= n)
            return 1000000000;
        if (i == n - 1)
            return matrix[i][j];
        if (dp[i][j] != 1000000000)
            return dp[i][j];
        int down = fun(i + 1, j, matrix);
        int left = fun(i + 1, j - 1, matrix);
        int right = fun(i + 1, j + 1, matrix);

        return dp[i][j] = matrix[i][j]
                + Math.min(down, Math.min(left, right));
    }
    public int minFallingPathSum(int[][] matrix) {
        for (int i = 0; i < 101; i++)
            java.util.Arrays.fill(dp[i], 1000000000);
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < matrix.length; j++)
            ans = Math.min(ans, fun(0, j, matrix));

        return ans;
    }
}
