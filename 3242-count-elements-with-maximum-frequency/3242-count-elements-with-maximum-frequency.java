class Solution {

    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap();

        int max = 0;

        for (int i : nums) {
            int curr = map.getOrDefault(i, 0) + 1;
            map.put(i, curr);
            max = Math.max(curr, max);
        }

        int cnt = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == max) {
                cnt += 1;
            }
        }

        return cnt * max;
    }
}
