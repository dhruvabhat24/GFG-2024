class Solution {
    public static int findMaxForN(Node node, int val)
    {
       if(node==null){
           return -1;
       }
       if(node.key==val){
           return val;
       }
        int ans;
        if(node.key> val){
            ans = findMaxForN(node.left,val);
        }
        else{
            ans = findMaxForN(node.right,val);
        }
        return (node.key <= val ? 		Math.max(ans,node.key) : ans);
    }
}
