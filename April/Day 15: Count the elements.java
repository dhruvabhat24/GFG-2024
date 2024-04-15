class Solution
{
    public static int[] countElements(int a[], int b[], int n, int query[], int q){
        int[] ans = new int[q];
        Arrays.sort(b);
        for(int i=0;i<q;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(a[query[i]]>=b[j]){
                    cnt++;
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }
}
