//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    private static final int MOD = 1000000007;

    public int TotalWays(int N)
    {
        // Code here
        if (N == 0) return 0;

        int[] withBuilding = new int[N];
        int[] withoutBuilding = new int[N];

        withBuilding[0] = 1;
        withoutBuilding[0] = 1;

        for (int i = 1; i < N; i++) {
            withBuilding[i] = withoutBuilding[i - 1];
            withoutBuilding[i] = (withBuilding[i - 1] + withoutBuilding[i - 1]) % MOD;
        }

        int totalOneSide = (withBuilding[N - 1] + withoutBuilding[N - 1]) % MOD;
        return (int)((long)totalOneSide * totalOneSide % MOD);
    }
}
