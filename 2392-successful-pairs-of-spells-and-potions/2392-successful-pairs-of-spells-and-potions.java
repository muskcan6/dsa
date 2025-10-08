class Solution {

    public int[] successfulPairs(int[] s, int[] p, long su) {
        int res[] = new int[s.length];
        int ind = 0;

        Arrays.sort(p);

        for (int i : s) {
            int temp = 0;
            int k = findMid(p, su, i);
            res[ind++] = k == -1 ? 0 : p.length - k;
        }

        return res;
    }

    public int findMid(int[] p, long su, int curr) {
        int i = 0, j = p.length - 1, res = -1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            long val = (long) p[mid] * curr;
            if (val >= su) {
                res = mid;
                j = mid - 1;
            } else i = mid + 1;
        }

        return res;
    }
}
