class Solution {

    public int removeDuplicates(int[] nums) {
        // brute force -- use additional space, remove duplicates takes extra space

        // use 2 pointers, read and write pointer, tc = o(n), sc = o(1)

        // int read = 0, write = 0, n = nums.length;

        // while (read < n) {
        //     int temp = read;
        //     while (temp < n && nums[temp] == nums[read]) {
        //         temp += 1;
        //     }

        //     nums[write++] = nums[read];
        //     read = temp;
        // }

        // return write;

        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }
}
