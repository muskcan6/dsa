class Solution {

    //tc = o(m+n) sc = o(m+n)

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet();

        for (int i : nums1) set.add(i);

        Set<Integer> res = new HashSet();
        for (int i : nums2) if (set.contains(i)) res.add(i);

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
