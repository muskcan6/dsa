class Solution {

    public boolean isValid(String s) {
        // brute force - while string has () or {} or [] keep replacing and lastly check if string is empty if yes return true else false
        // assuming each pass will remove one pair, while will run n/2 times that is approx n, and in each iteration we check if contains anf we replace which takes n time so total o (n ^2)
        // space is constant

        // using stack
        // push opening, when encountered closing, check top and close belong to same family and stack is not empty, return stack.isEmpty at last
        // tc = o(n) sc = o(n) - in case all are opening brackets in input string

        // while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
        //     s = s.replace("()", "");
        //     s = s.replace("[]", "");
        //     s = s.replace("{}", "");
        // }

        // return s.length() == 0;

        return solve(s);
    }

    public boolean solve(String s) {
        Stack<Character> st = new Stack();
        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Set<Character> open = new HashSet(Arrays.asList('(', '[', '{'));

        for (char c : s.toCharArray()) {
            if (open.contains(c)) {
                st.push(c);
            } else {
                if (st.isEmpty()) return false;
                if (st.peek() != map.get(c)) return false; else st.pop();
            }
        }

        return st.isEmpty();
    }
}
