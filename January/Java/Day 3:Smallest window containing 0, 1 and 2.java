//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) { 
        int zero=0,one=0,two=0,unq=0; 
        int left=0;
        int max=(int)1e6,last=max;
        for(int i=0;i<S.length();i++){
            int c= S.charAt(i)-'0';
            if(c==0){
                if(zero==0)unq++;
                zero++;
            }else if(c==1){
                if(one==0)unq++;
                one++;
            }
            else {
                if(two==0)unq++;
                two++;
            } 
            if(unq==3){
                while(left<S.length() && unq==3){
                    max=Math.min(max,i-left+1);
                    int pr=S.charAt(left)-'0';
                    left++;
                    if(pr==0){
                        if(zero==1)unq--;
                        zero--;
                    }
                    else if(pr==1){
                        if(one==1)unq--;
                        one--;
                    }
                    else {
                        if(two==1)unq--;
                        two--;
                    }
                    
                }
            }
        }return max==last?-1:max;
    }
};
