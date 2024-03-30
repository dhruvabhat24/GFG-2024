class Solution {
    int minValue(Node root) {
        if(root == null)
            return -1;
        
        while(root.left != null)
            root = root.left;
            
        return root.data;
    }
}
