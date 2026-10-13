class Solution {
    int[][] dp = new int[201][201];

    int fun(int i, int j, int[][] triangle) {
        int n = triangle.length;

        if (i == n - 1)
            return triangle[i][j];

        if (dp[i][j] != -1000000000)
            return dp[i][j];

        int c1 = triangle[i][j] + fun(i + 1, j, triangle);
        int c2 = triangle[i][j] + fun(i + 1, j + 1, triangle);

        return dp[i][j] = Math.min(c1, c2);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < triangle.get(i).size(); j++)
                arr[i][j] = triangle.get(i).get(j);

        for (int i = 0; i < 201; i++)
            Arrays.fill(dp[i], -1000000000);

        return fun(0, 0, arr);
    }
}
