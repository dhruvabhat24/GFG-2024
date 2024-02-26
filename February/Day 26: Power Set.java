class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        List<String> ans = new ArrayList<>();
        GenerateSub(s,0,"",ans);
        Collections.sort(ans);
        return ans;
    }
    public void GenerateSub(String s,int i,String curr,List<String> ans){
        if(i==s.length()){
            if(curr.length()>=1){
                ans.add(curr);
            }
            return ;
        }
        // not take
        GenerateSub(s,i+1,curr,ans);
         //  take
        GenerateSub(s,i+1,curr+s.charAt(i),ans);
    }
}
