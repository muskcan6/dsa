class Solution {

    //brute force = buy and try to sell on all subsequent days and keep max - o(n^2)
    //1d dp == keeping track of min seen so far and maximixing the diff - o(n)

    //space is o(1) in both

    public int maxProfit(int[] p) {
        int minSoFar = p[0], res = 0, n = p.length;

        for (int i = 0; i < n; i++) {
            int curr = p[i];
            int profit = curr - minSoFar;
            res = Math.max(res, profit);
            minSoFar = Math.min(minSoFar, curr);
        }

        return res;
    }
}
