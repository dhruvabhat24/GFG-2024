class Solution{
    public:
    //Function to store the zig zag order traversal of tree in a list.
    vector <int> zigZagTraversal(Node* root)
    {
     vector<int>ans;
      queue<Node*>q;
      q.push(root);
      int n = 1,flag=1;
      vector<int>temp;
      while(!q.empty()){
          auto it  = q.front();
          q.pop();
          if(n>0){
            temp.emplace_back(it->data);
          }
          if(it->left){
              q.push(it->left);
          }
          if(it->right){
              q.push(it->right);
          }
          n--;
          if(n == 0){
            n = q.size();
            if(!flag){
                reverse(temp.begin(),temp.end());
                flag=1;
            }else
                flag = 0;
            for(int num : temp)
                ans.emplace_back(num);
            temp.clear();
          }
      }
      return ans;
    }
};
