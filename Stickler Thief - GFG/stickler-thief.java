//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int hval[], int n)
    {
     if (n == 0)
        return 0;
    if (n == 1)
        return hval[0];

    // Create an array to store the maximum loot at each house
    int[] dp = new int[n];

    // Initialize the first two values in the dp array
    dp[0] = hval[0];
    dp[1] = Math.max(hval[0], hval[1]); // Use Math.max instead of Math.Max

    // Calculate the maximum loot for each house
    for (int i = 2; i < n; i++)
    {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + hval[i]); // Use Math.max instead of Math.Max
    }

    // The last value in dp will contain the maximum loot
    return dp[n - 1];
    
    }
}