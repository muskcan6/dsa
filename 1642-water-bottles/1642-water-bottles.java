class Solution {

    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0, rem = 0;

        while (numBottles > 0) {
            res += numBottles;
            int temp = (numBottles + rem) / numExchange;
            rem = (numBottles + rem) % numExchange;
            numBottles = temp;
        }

        return res;
    }
}
