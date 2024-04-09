class Solution{
		
	public:
	int maxDotProduct(int n, int m, int a[], int b[]) {
	int res[m+1] = {};
	for(int i=0;i<n;i++) {
	    for(int j=min(m,i+1);j>0;j--)
	        res[j] = max(res[j],a[i]*b[j-1]+res[j-1]);
	}
	return res[m];
}
};
