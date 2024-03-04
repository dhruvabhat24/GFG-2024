class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
      static int maxIndexDiff(int a[], int n) { 
        
        // Your code here
        int maxCount = Integer.MIN_VALUE;
            
            int left = 0;
            int right = n-1;
            while( left <= right){
                if( a[left] <= a[right] ){
                    int count = right - left;
                    maxCount = Math.max( maxCount , count);
                    left++;
                    right = n-1;
                }else right--;
                
            }
        
        return maxCount;
        
    }
}
