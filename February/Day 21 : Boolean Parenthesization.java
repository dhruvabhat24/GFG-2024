  //{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Pair {
    int t, f;
    int modulo = 1003;
    
    Pair (int t, int f) {
        this.t = t;
        this.f = f;
    }
    
    public void applyModulo() {
        this.t %= modulo;
        this.f %= modulo;
    }
}


class Solution{
    
    static Pair rec(String s, HashMap<String, Pair> mem) {
        
        if(s.length()==0) {
            return new Pair(0, 0);
        }
        
        if(s.length()==1) {
            return s.charAt(0) == 'T' ? new Pair(1, 0) : new Pair(0, 1);
        }
        
        if(mem.containsKey(s)) {
            return mem.get(s);
        }
        
        Pair ans = new Pair(0, 0);
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '&') {
                Pair leftWays = rec(s.substring(0, i), mem);
                Pair rightWays = rec(s.substring(i+1), mem);
                
                ans.t += leftWays.t * rightWays.t;
                ans.f += leftWays.f*rightWays.f + leftWays.t*rightWays.f + leftWays.f*rightWays.t;
            } else if(s.charAt(i) == '|') {
                Pair leftWays = rec(s.substring(0, i), mem);
                Pair rightWays = rec(s.substring(i+1), mem);
                
                ans.t += leftWays.t*rightWays.t + leftWays.t*rightWays.f + leftWays.f*rightWays.t;
                ans.f += leftWays.f*rightWays.f;
            } else if(s.charAt(i) == '^') {
                Pair leftWays = rec(s.substring(0, i), mem);
                Pair rightWays = rec(s.substring(i+1), mem);
                
                ans.t += leftWays.f*rightWays.t + leftWays.t*rightWays.f;
                ans.f += leftWays.t*rightWays.t + leftWays.f*rightWays.f;
            }
            ans.applyModulo();
        }
        
        mem.put(s, ans);
        
        return ans;
        
    }
    
    
    static int countWays(int n, String s){
        
        HashMap<String, Pair> mem = new HashMap<>();
        
        return rec(s, mem).t;
    }
}
