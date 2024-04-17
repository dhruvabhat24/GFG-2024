class Solution {
  public:
    //Function to find two repeated elements.
    vector<int> twoRepeated (int arr[], int n) {
        int x=arr[n+1],a=0,b=0;
        for(int i=0;i<=n;i++) x^=arr[i]^i;
        for(int i=0;i<=n+1;i++) {
            if(arr[i]&(x&-x))a^=arr[i];
            else b^=arr[i];
            if(i<=n) {
                if(i&(x&-x))a^=i;
                else b^=i;
            }
        }
        for(int i=n+1;i>=0;i--) {
            if(a==arr[i]) {
                return {b,a};
            } else if(b==arr[i]) return {a,b};
        }
        return {};
    }
};
