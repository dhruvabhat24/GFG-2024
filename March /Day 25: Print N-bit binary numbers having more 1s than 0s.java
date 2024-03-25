class Solution 
{
    void solve(String ds, int ones, int remaining, ArrayList<String> res) 
    {
        if(remaining == 0)
        {
            res.add(ds);
            return;
        }
        
        solve(ds + "1", ones + 1, remaining - 1, res);
        if(ones > 0)
            solve(ds + "0", ones - 1, remaining - 1, res);
    }

	ArrayList<String> NBitBinary(int n)
	{
	    ArrayList<String> res = new ArrayList<>();
	    String ds = "";
	    solve(ds, 0, n, res);
	    return res;
	}
}
