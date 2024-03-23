class Solution {
  public:
    vector<int> Series(int n) {
        int mod=1e9+7;
        vector<int>v(n+1,0);
        v[0]=0;
        v[1]=1;
        for(int i=2;i<=n;i++)
        {
           v[i]=(v[i-1]+v[i-2])%mod; 
        }
        return v;
    }
};
