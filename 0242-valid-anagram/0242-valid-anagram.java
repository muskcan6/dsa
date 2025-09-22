class Solution {

    public boolean isAnagram(String s, String t) {
        //sort all chars and check nlogn for sort and n for check so nlogn

        // use int arr, and then do array check tc = sc = o(1)

        if (s.length() != t.length()) return false;

        int a1[] = new int[26]; // make this 256 for unicode chars
        int a2[] = new int[26];

        for (char c : s.toCharArray()) a1[c - 'a']++;
        for (char c : t.toCharArray()) a2[c - 'a']++;

        return Arrays.equals(a1, a2);
    }
}
