
class Solution {
    int[] dp;

    int fun(int i, int[][] nums) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int id = nums.length;

        int l = i + 1;
        int h = nums.length - 1;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (nums[mid][0] > nums[i][1]) {
                id = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        int a = 1 + fun(id, nums);
        int b = fun(i + 1, nums);

        return dp[i] = Math.max(a, b);
    }

    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;

        dp = new int[n];
        Arrays.fill(dp, -1);

        Arrays.sort(pairs, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        return fun(0, pairs);
    }
}