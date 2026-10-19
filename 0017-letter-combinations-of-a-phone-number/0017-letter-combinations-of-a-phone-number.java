class Solution {
    private static final String[] MAP = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> ls=new ArrayList<>();
        func(0, 0, digits, new StringBuilder(), ls);
        return ls;    
    }
    private void func(int idx, int i, String digits, StringBuilder sb, List<String> ls){
        if(idx == digits.length()){
            ls.add(sb.toString());
            return;
        }
        
        String letters = MAP[digits.charAt(idx) - '0'];
        if (i == letters.length()) return;               // stop: no more letters for this digit

        sb.append(letters.charAt(i));
        func(idx + 1, 0, digits, sb, ls);                // next digit starts from its first letter
        sb.deleteCharAt(sb.length() - 1);

        func(idx, i + 1, digits, sb, ls); 

        // char ch=digits.charAt(idx);
        // sb.append((char)(ch + i + 51));
        // func(idx+1, i, digits, sb, ls);
        // sb.deleteCharAt(sb.length()-1);
        // func(idx, i+1, digits, sb, ls);
    }

}