class Solution
{
    public:
    //Function to return the level order traversal of a tree.
    void push(Node* root, queue<Node*>& q, vector<int>& v){
        if(!root) return;
        q.push(root);
        while(!q.empty()){
            Node* temp = q.front();
            q.pop();
            v.push_back(temp->data);
            if(temp->left) q.push(temp->left);
            if(temp->right) q.push(temp->right);
        }
    }
    vector<int> levelOrder(Node* root){
        vector<int> v;
        queue<Node*> q;
        push(root, q, v);
        return v;
    }
};
