class Solution {

    public String fractionToDecimal(int n, int d) {
        if (n == 0) return "0";

        StringBuilder fraction = new StringBuilder();

        //xor because we need 10 , 01 case, not 11 case
        if (n < 0 ^ d < 0) fraction.append("-");

        //avoid overflows in case of Integer.MIN_VALUE becoming positive if both n and d are -ve
        long nl = Math.abs(Long.valueOf(n));
        long dl = Math.abs(Long.valueOf(d));

        fraction.append(String.valueOf(nl / dl));

        Long rem = nl % dl;

        if (rem == 0) return fraction.toString(); //whole integer

        fraction.append(".");

        Map<Long, Integer> map = new HashMap();

        while (rem != 0) {
            if (map.containsKey(rem)) {
                fraction.insert(map.get(rem), "(");
                fraction.append(")");
                break;
            }

            map.put(rem, fraction.length());

            rem *= 10;
            fraction.append(String.valueOf(rem / dl));

            rem = rem % dl;
        }

        return fraction.toString();
    }
}
