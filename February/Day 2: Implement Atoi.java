//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	// Your code here
	int result = 0;
	    int start = 0;
	    if(str.charAt(0) == '-')
            start = 1;
	    for(int i=start;i<str.length();i++){
	        if(!Character.isDigit(str.charAt(i))) return -1;
	        result = (result * 10) + (str.charAt(i) - '0');
	    }
	    return start == 1 ? -result : result; 
    }
}
