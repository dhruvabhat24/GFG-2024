// User function Template for C++

/*// A Tree node
struct Node
{
    int data;
    struct Node *left, *right;
};*/

class Solution {
  public:
    vector<int> arr;
    int ans=0;
    
    void inorder(Node* root) {
        if(!root) return;
        inorder(root->left);
        arr.push_back(root->data);
        inorder(root->right);
    }
    
    void mergeSort(int i,int j) {
        if(i>=j)return;
        int m=i+(j-i)/2;
        mergeSort(i,m);
        mergeSort(m+1,j);
        int k=m+1, start=i;
        while(i<k and k<=j) {
            if(arr[i]<=arr[k])i++;
            else {
                ans+=m-i+1;
                k++;
            }
        }
       sort(arr.begin() + start, arr.begin() + j + 1);
    }
    int pairsViolatingBST(int n, Node *root) {
        inorder(root);
        mergeSort(0,n-1);
        return ans;
    }
};
