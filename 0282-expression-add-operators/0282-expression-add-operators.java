class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        backtrack(num, target, 0, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String num, int target, int idx, long eval, long prev,
                           StringBuilder path, List<String> res) {
        if (idx == num.length()) {
            if (eval == target) res.add(path.toString());
            return;
        }
        for (int end = idx; end < num.length(); end++) {
            if (end > idx && num.charAt(idx) == '0') break;   // no leading zeros ("05" is invalid)

            long cur = Long.parseLong(num.substring(idx, end + 1));
            int len = path.length();

            if (idx == 0) {                                    // first number: no operator before it
                path.append(cur);
                backtrack(num, target, end + 1, cur, cur, path, res);
                path.setLength(len);                           // un-choose
            } else {
                path.append('+').append(cur);
                backtrack(num, target, end + 1, eval + cur, cur, path, res);
                path.setLength(len);

                path.append('-').append(cur);
                backtrack(num, target, end + 1, eval - cur, -cur, path, res);
                path.setLength(len);

                path.append('*').append(cur);
                backtrack(num, target, end + 1, eval - prev + prev * cur, prev * cur, path, res);
                path.setLength(len);
            }
        }
    }
}