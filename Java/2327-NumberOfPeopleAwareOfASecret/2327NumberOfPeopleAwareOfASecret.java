class Solution {

    private static final int MODULO = 1000000007;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1];
        dp[1] = 1;

        for (int i = 1; i <= n; i++) {
            if (dp[i] == 0) continue;

            for (int j = i + delay; j < i + forget && j <= n; j++) {
                dp[j] = (dp[j] + dp[i]) % MODULO;
            }
        }

        long ans = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            if (i >= 1) ans = (ans + dp[i]) % MODULO;
        }

        return (int) ans;
    }
}