class Solution
{
    public:
    vector<int> v;
vector<int> f(Node *n, int i) {
        if(n) {
            if(v.size() == i) v.emplace_back(n->data);
            else v[i] += n->data;
            f(n->right, i), f(n->left, i + 1);
        }
        
        return v;
}
vector<int> diagonalSum(Node *r) {
        return f(r, 0);
}
};
