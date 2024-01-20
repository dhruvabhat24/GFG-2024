//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(s[i]);
            Solution T = new Solution();
            out.println(T.min_sprinklers(gallery,n));
        }
		out.close();
		
	}
}





// } Driver Code Ends


//User function Template for Java

class pair implements Comparable<pair> {
    int first, second;

    pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int compareTo(pair other) {
        return Integer.compare(this.first, other.first);
    }
}

class Solution {
    int min_sprinklers(int gallery[], int n) {
        ArrayList<pair> l = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (gallery[i] != -1) {
                l.add(new pair(i - gallery[i], i + gallery[i]));
            }
        }

        Collections.sort(l);

        int count = 0;
        int i = 0;
        int target = 0;

        while (target < n) {
            int maxEnd = target - 1; 

            while (i < l.size()) {
                if (l.get(i).first > target)
                    break;
                maxEnd = Math.max(maxEnd, l.get(i).second);
                i++;
            }

            if (maxEnd < target) {
                return -1;
            }

            count++;
            target = maxEnd + 1;
        }

        return count;
    }
}
