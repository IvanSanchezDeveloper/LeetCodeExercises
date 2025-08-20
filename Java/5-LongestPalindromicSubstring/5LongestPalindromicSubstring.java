class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();
        if (n < 2) return s;

        String maxPalindrome = "";
        for (int i = 0; i < s.length(); i++) {

            // Odd palindrome 
            String odd = expandFromCenter(s, i, i);

            // Even palindrome
            String even = expandFromCenter(s, i, i + 1);

            String longer = odd.length() > even.length() ? odd : even;
            if (longer.length() > maxPalindrome.length()) {
                maxPalindrome = longer;
            }
        }

        return maxPalindrome;
    }

    private String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}

