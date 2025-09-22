class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //brute force -- use extra space and merge 2 arrays
        // tc = sc =  o(m + n)

        // use 2 pointers,
        //sc would be o(1), tc = o(m+n) iterate all chars

        int l1 = m - 1, l2 = n - 1, w = nums1.length - 1;

        while (l1 >= 0 && l2 >= 0) {
            if (nums2[l2] >= nums1[l1]) {
                nums1[w--] = nums2[l2--];
            } else {
                nums1[w--] = nums1[l1--];
            }
        }

        while (l2 >= 0) {
            nums1[w--] = nums2[l2--];
        }
    }
}
