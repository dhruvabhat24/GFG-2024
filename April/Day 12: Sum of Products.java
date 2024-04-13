class Solution {
    static long pairAndSum(int n, long arr[]) {
        long sum=0; int k=1;
        for(int i=0; i<32; i++){
            long c=0;        
            for(int j=0; j<n; j++){
                if((arr[j]&1)!=0){
                    c++;
                }
                arr[j]>>=1;
            }
            long num = (c*(c-1))/2; 
            sum+= num*k;    
            k<<=1;
        }
        return sum;
    }
}
