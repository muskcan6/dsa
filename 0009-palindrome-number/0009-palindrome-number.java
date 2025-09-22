class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        if (x % 10 == 0 && x != 0) return false;

        int res = 0;

        while (x > res) {
            int pop = x % 10;
            res = res * 10 + pop;
            x = x / 10;
        }

        return x == res || x == res / 10;
    }
}
