class Solution {

    public int searchInsert(int[] nums, int target) {
        int l = 0, h = nums.length - 1; //doesnt go out of bound
        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (target <= nums[mid]) h = mid - 1; else l = mid + 1;
        }

        return l;
    }
}
