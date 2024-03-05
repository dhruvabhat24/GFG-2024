class Solution
{   
    ArrayList<Integer> search(String p, String t)
    {
        // your code here
       p= p.trim();
       t= t.trim();
        int m=p.length(), n=t.length();
        ArrayList<Integer> ans=new  ArrayList<Integer>();
        if(m==0 || n==0)return ans;
        
        for(int i=0;i<n-m+1;i++){
            int k=0, j=0;
            for(j=0;j<m && i + k < n;j++){
                if ( p.charAt(k) != t.charAt(i + k)){
                    break;
                }
                //System.out.println(i+" j=" +j);
                k++;
            }
            
            if(k==m)ans.add(i+1);
        }
        
        return ans;
    }
}
