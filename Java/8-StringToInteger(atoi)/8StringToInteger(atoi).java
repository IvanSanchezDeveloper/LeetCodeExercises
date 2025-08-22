class Solution {
    public int myAtoi(String s) {

        int idx = 0, n = s.length();

        while (idx < n && s.charAt(idx) == ' ') {
            idx++;
        }

        // Just in case the string is only spaces
        if (idx == n) {
            return 0;
        }

        boolean isNegative = false;
        if (s.charAt(idx) == '+' || s.charAt(idx) == '-') {
            isNegative = (s.charAt(idx) == '-');
            idx++;
        }

        long result = 0;
        while (idx < n && Character.isDigit(s.charAt(idx))) {
            int digit = s.charAt(idx) - '0';

            result = result * 10 + digit;

            if (!isNegative && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (isNegative && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            idx++;
        }

        return isNegative ? (int)-result : (int)result;
    }
}