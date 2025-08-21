class Solution {
    public int reverse(int x) {
        long reversed = 0; // use long to detect overflow

        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;

            if (Math.abs(reversed) > Integer.MAX_VALUE) {
                return 0;
            }
        }

        return (int) reversed;
    }
}