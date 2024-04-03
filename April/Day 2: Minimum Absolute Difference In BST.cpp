/*The Node structure is defined as
struct Node {
    int data;
    Node *left;
    Node *right;

};
*/

class Solution
{
    public:
    void inorder(Node *root, vector<int> &trav){
        if(root==NULL)
        return;
        
        inorder(root->left, trav);
        trav.push_back(root->data);
        inorder(root->right, trav);
    }
    int absolute_diff(Node *root)
    {
        //Your code here
        vector<int> trav;
        inorder(root, trav);
        
        int mini=INT_MAX, ans=INT_MAX;
        for(int i=0; i<trav.size()-1; i++){
            int diff=abs(trav[i]-trav[i+1]);
            mini=min(mini, diff);
        }
        
        return mini;
    }
};
