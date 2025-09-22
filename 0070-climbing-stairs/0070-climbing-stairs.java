class Solution {
    Integer dp[];

    public int climbStairs(int n) {
        dp = new Integer[n + 1];
        return solve(n);
    }

    public int solve(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (dp[n] != null) return dp[n];

        return dp[n] = solve(n - 2) + solve(n - 1);
    }
}
