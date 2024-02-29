class Solution {
    long sumBitDifferences(int[] arr, int n) {
        // code here
    
        long p=0;
        for(int i=0;i<32;i++){
             long count1=0;
            for(int a:arr){
                if((a&(1<<i))!=0){
                    count1++;
                }
            }
            long count2=n-count1;
            long x=count1*count2*2;
            p+=x;
        }
        return p;
    }
}
