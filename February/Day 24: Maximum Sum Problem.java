class Solution
{
    public int maxSum(int n) 
    { 
        int ans = solve(n);
        return ans;
    }
    public static int solve(int n){
        
        if(n==0){
            return 0;
        }
        
        int ans = solve(n/2) + solve(n/3) + solve(n/4);
        
        return Math.max(n,ans);
    }
    
}
