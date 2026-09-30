class Solution {
    public int balancedStringSplit(String s) {
        return solve(s, 0, 0);
    }
    
    public int solve(String s, int index, int balance) {

        if (index == s.length()) {
            return 0;
        }
        if (s.charAt(index) == 'R') {
            balance++;
        } else {
            balance--;
        }
        if (balance == 0) {
            return 1 + solve(s, index + 1, balance);
        }
        return solve(s, index + 1, balance);
    }
}