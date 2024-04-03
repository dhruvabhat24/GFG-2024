//User function Template for C++

/*// A Tree node
struct Node
{
	int data;
	struct Node *left, *right;
};*/


class Solution {
public:
    int kthCommonAncestor(Node *root, int k, int x, int y) {
        // Calculating LCA(Lowest Common Ancestor)
        // Time: O(Height of the BST); Space: O(1)
        Node* LCA = root;
        while(LCA) {
            if(LCA->data > x && LCA->data > y) LCA = LCA->left;
            else if(LCA->data < x && LCA->data < y) LCA = LCA->right;
            else break;
        }
        
        // Finding Parent of Nodes from root to LCA
        // Time: O(Height of the BST); Space: O(Height of the BST)
        Node* temp = root;
        Node* prev = NULL;
        unordered_map<Node*, Node*> parent;
        while(temp != LCA) {
            parent[temp] = prev;
            prev = temp;
            
            if(LCA->data > temp->data) temp = temp->right;
            else temp = temp->left;
        }
        parent[LCA] = prev;
        
        // Calculating final result
        // // Time: O(Height of the BST); Space: O(1)
        k = k - 1;
        while(k--) {
            if(temp == root) return -1;
            temp = parent[temp];
        }
        
        return temp->data;
    }
};
