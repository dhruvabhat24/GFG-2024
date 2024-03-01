class Solution
{
	// Function to find the peak element
	// arr[]: input array
	// n: size of array a[]
  public int peakElement(int[] arr,int n)
    {
       int s = 0;
       int e = n-1;
       while(s!=e){
            int mid = (s+e)/2;
            if(arr[mid]<arr[mid+1])
                s = mid+1;
            else
                e = mid;
       }
       return s;
    }
}
