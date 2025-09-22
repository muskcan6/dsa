class Solution {

    public boolean isAnagram(String s, String t) {
        //sort all chars and check nlogn for sort and n for check so nlogn

        // use int arr, and then do array check tc = o(n), sc = o(256) thats constant

        if (s.length() != t.length()) return false;

        int a1[] = new int[26]; // make this 256 for unicode chars
        int a2[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            a1[s.charAt(i) - 'a']++;
            a2[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(a1, a2);
    }
}
