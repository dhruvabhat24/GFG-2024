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
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.criticalConnections(V, adj);
            for(int i=0;i<ans.size();i++)
                System.out.println(ans.get(i).get(0) + " " + ans.get(i).get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    private void dfs(ArrayList<ArrayList<Integer>> ans,ArrayList<ArrayList<Integer>> adj,boolean vis[],int[] low,int disc[],int src,int parent,int timer){
        vis[src] = true;
        low[src] = disc[src] = timer++;
        for(int nbr:adj.get(src)){
            if(nbr==parent)
                continue;
            
            if(!vis[nbr]){
                dfs(ans,adj,vis,low,disc,nbr,src,timer);
                //check low is updated or not
                if(disc[src]<low[nbr]){
                    ArrayList<Integer> bridge = new ArrayList<>();
                    bridge.add(src);
                    bridge.add(nbr);
                    ans.add(bridge);
                }else{
                     low[src] = Math.min(low[src],low[nbr]);
                }
            }else{
                low[src] = Math.min(low[src],disc[nbr]);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean vis[] = new boolean[v];
        int low[] = new int[v];
        int disc[] = new int[v];
        int parent = -1;
        int timer = 0;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(ans,adj,vis,low,disc,i,parent,timer);
            }
        }
        for(int i=0;i<ans.size();i++)
        Collections.sort(ans.get(i));
        
        Collections.sort(ans,(a,b)->{
            for (int i = 0; i < 2; i++) {
                int compareResult = a.get(i).compareTo(b.get(i));
                if (compareResult != 0)
                    return compareResult; 
            }
            return 0;
        });
        return ans;
        
    }
}
