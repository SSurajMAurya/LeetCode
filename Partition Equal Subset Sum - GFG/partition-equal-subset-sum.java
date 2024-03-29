//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
      int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        // If the sum is odd, we can't partition the array into two equal-sum parts.
        if (sum % 2 != 0) {
            return 0;
        }

        int targetSum = sum / 2;

        // Create a boolean dp array to store whether a sum of j can be achieved
        // using the first i elements of the array.
        boolean[][] dp = new boolean[N + 1][targetSum + 1];

        // Initialize the dp array.
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }

        // Fill the dp array.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= targetSum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The answer is stored in dp[N][targetSum]. If it's true, we can partition
        // the array into two parts with equal sums; otherwise, we can't.
        return dp[N][targetSum] ? 1 : 0;
    }
}