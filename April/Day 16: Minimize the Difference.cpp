class Solution {
  public:
    int minimizeDifference(int n, int k, vector<int> &arr) {
        // code here
        int mini = INT_MAX, maxi = INT_MIN, ans = INT_MAX;
        vector<int> rightmax(n,0), rightmin(n,0);
        rightmin[n-1] = arr[n-1];
        rightmax[n-1] = arr[n-1];
        
        for(int i = n-2; i>=0; i--){
            rightmin[i] = min(rightmin[i+1], arr[i]);
            rightmax[i] = max(rightmax[i+1], arr[i]);
        }
        int i = 0, j = k-1;
        while(j<n){
            if(i!=0){
                mini = min(mini, arr[i-1]);
                maxi = max(maxi, arr[i-1]);
            }
            int temp1 = mini, temp2 = maxi;
            
            if(j!=n-1){
                temp1 = min(temp1, rightmin[j+1]);
                temp2  =max(temp2, rightmax[j+1]);
            }
            ans = min(ans, abs(temp2-temp1));
            i++;
            j++;
        }
        return ans;
        
    }
};
