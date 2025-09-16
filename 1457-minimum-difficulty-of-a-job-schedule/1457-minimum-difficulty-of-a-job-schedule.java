class Solution {
    // tc --  without memo -- n ^ d (har index pe i can break and ese i can take n indexes aur max depth tree ki d hai so n power d) space -- recursion stack space o(d)

    // tc with memo - d * n^2 (d*n states hai aur har state mein max khojenge jo approx again n time lega so d * n power 2) -- space -- o(n*d)

    Integer[][] dp;

    public int minDifficulty(int[] jd, int d) {
        if (jd.length < d) return -1;
        if (jd.length == d) return Arrays.stream(jd).sum();

        dp = new Integer[d + 1][jd.length + 1];

        return solve(jd, d, 0);
    }

    public int solve(int[] jd, int d, int i) {
        if (d == 1) {
            int max = jd[i];
            for (int k = i; k < jd.length; k++) {
                max = Math.max(jd[k], max);
            }

            return max;
        }

        if (dp[d][i] != null) return dp[d][i];

        int max = jd[i], res = Integer.MAX_VALUE;
        for (int k = i; k <= jd.length - d; k++) {
            max = Math.max(jd[k], max);
            int curr = max + solve(jd, d - 1, k + 1);

            res = Math.min(res, curr);
        }

        return dp[d][i] = res;
    }
}
