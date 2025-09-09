public class solution2327 {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1_000_000_007;
        long share = 0;

        // dp[i] = number of people who learn the secret on day i
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; ++i) {
            if (i - delay >= 0)
                share += dp[i - delay];
            if (i - forget >= 0)
                share -= dp[i - forget];

            share = (share + MOD) % MOD;
            dp[i] = (int) share;
        }

        int ans = 0;
        for (int i = n - forget; i < n; ++i) {
            if (i >= 0) {
                ans = (ans + dp[i]) % MOD;
            }
        }

        return ans;
    }

    // Main method for local testing
    public static void main(String[] args) {
        solution2327 sol = new solution2327();
        
        // Example test
        int n = 6, delay = 2, forget = 4;
        System.out.println(sol.peopleAwareOfSecret(n, delay, forget)); // Expected: 5
    }
}

