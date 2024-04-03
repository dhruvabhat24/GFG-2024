class Solution {
   
    public static long sumSubstrings(String s) {
        long sum = 0;
        long multiplier = 1;
        long mod = 1000000007; 
        for (int i = s.length() - 1; i >= 0; i--) {
            sum = (sum + (s.charAt(i) - '0') * multiplier * (i + 1)) % mod;
            multiplier = (multiplier * 10 + 1) % mod;
        }
        return sum;
    }
}
