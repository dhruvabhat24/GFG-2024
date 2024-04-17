class Solution{
    public:
    int countPairs(int arr[] , int n ) 
    {
        /*// Brute Force Approach: Time: O(N^2), Time Limit Exceeded after Test case - 1030*
        int result = 0;
        for(int i=0; i<n; i++){
            int eleI =  arr[i] * i;
            for(int j=i+1; j<n; j++){
                int eleJ = arr[j]*j;
                if(eleI > eleJ)
                    result++;
            }
        }
        return result;
        **/
        
        //> Optimal Approach: Time: O(NlogN)
        vector<int> b,s;
        for(int i=0;i<n;i++){
            b.push_back((i * arr[i]));
            s.push_back(b[i]);
        }
        sort(s.begin(), s.end());
        int ans = 0;
        for(int i=0; i<n; i++){
            int i1 = lower_bound(s.begin(), s.end(), b[i]) - s.begin();
            ans += i1;
            s.erase((s.begin() + i1));
        }
        return ans;
    }
};
