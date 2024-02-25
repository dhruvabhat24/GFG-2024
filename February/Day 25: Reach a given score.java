class Geeks {
    public long count(int n) {
        // Add your code here.
        long[] dp = new long[n + 1];
        dp[0] = 1;
        int[] moves = {3, 5, 10};
        for (int move : moves) {
            for (int i = move; i <= n; i++) {
                dp[i] += dp[i - move];
            }
        }
        return dp[n];
    }
}
