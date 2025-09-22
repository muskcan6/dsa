class Node {
    private Node links[] = new Node[26];

    public boolean containsChar(char c) {
        return links[c - 'a'] != null;
    }

    public void insert(char c, Node temp) {
        links[c - 'a'] = temp;
    }

    public Node get(char c) {
        return links[c - 'a'];
    }

    public boolean singleCheck() {
        int cnt = 0;
        for (Node i : links) {
            if (i != null) {
                cnt += 1;
                if (cnt > 1) return false;
            }
        }

        return true;
    }
}

class Solution {
    private Node root = new Node();

    private void insert(String word) {
        Node temp = root;
        for (char c : word.toCharArray()) {
            if (!temp.containsChar(c)) {
                Node nn = new Node();
                temp.insert(c, nn);
            }

            temp = temp.get(c);
        }
    }

    private String longest(String word) {
        Node temp = root;
        int res = 0;
        for (char c : word.toCharArray()) {
            if (temp.singleCheck()) {
                res += 1;
                temp = temp.get(c);
            } else break;
        }

        return word.substring(0, res);
    }

    public String longestCommonPrefix(String[] strs) {
        //brute force --  find the smallest string from strs(o(n)), then iterate on characters of that string (o(k). o(n)) and check across all the strings

        //using trie
        // insertion -- n word of approx l length would be o(n.l) -- so lets consider total k characters so insertion would take o(k) time
        // finding smallest =o(n) // n word, same loop as insertion
        // finding longest = considering the size of smallest prefix is m -- o (m) time

        //max time is taken for insertion, so if total n chars are considered then tc nd sc becomes o(n)

        // use binary search -- find minlength of all strings that will be our high and low will be 1, try finding mid and substring(0, mid) -- check if all strings in list startsWith this substring, if yes increase low otherwise decreaes high
        // o(s. log m) space is constant -- s is total number of characters

        String small = strs[0];

        for (String s : strs) {
            if (s.length() < small.length()) small = s;

            insert(s);
        }

        // return longest(small);

        return bs(strs);
    }

    private String bs(String[] strs) {
        int min = strs[0].length();
        for (String s : strs) min = Math.min(min, s.length());

        int low = 1, high = min;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(strs, mid)) low = mid + 1; else high = mid - 1;
        }

        // System.out.println(low + " ** " + high);
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean check(String strs[], int k) {
        String sw = strs[0].substring(0, k);
        for (String s : strs) {
            if (!s.startsWith(sw)) return false;
        }

        return true;
    }
}
