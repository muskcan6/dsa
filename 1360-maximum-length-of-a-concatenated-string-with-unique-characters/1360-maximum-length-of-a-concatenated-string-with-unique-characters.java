class Solution {
    Map<String, Integer> dp = new HashMap();

    public int maxLength(List<String> arr) {
        return solve(arr, 0, "");
    }

    public int solve(List<String> arr, int i, String curr) {
        if (i >= arr.size()) return curr.length();

        if (dp.containsKey(curr)) return dp.get(curr);

        int take = 0;
        if (canTake(arr.get(i), curr)) {
            take = solve(arr, i + 1, curr + arr.get(i));
        }

        int skip = solve(arr, i + 1, curr);

        int res = Math.max(take, skip);
        dp.put(curr, res);

        return res;
    }

    public boolean canTake(String st, String curr) {
        Set<Character> set = new HashSet();
        for (char c : st.toCharArray()) {
            if (set.contains(c)) return false;
            set.add(c);
        }

        for (char c : curr.toCharArray()) {
            if (set.contains(c)) return false;
        }
        return true;
    }
}
