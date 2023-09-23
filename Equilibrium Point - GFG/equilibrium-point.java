//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            
            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            
            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();
            
            //calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {
 long totalSum = 0;
    long leftSum = 0;
    
    // Calculate the total sum of all elements in the array
    for (int i = 0; i < n; i++) {
        totalSum += arr[i];
    }
    
    // Iterate through the array to find the equilibrium point
    for (int i = 0; i < n; i++) {
        // Check if leftSum is equal to (totalSum - leftSum - arr[i])
        if (leftSum == (totalSum - leftSum - arr[i])) {
            return i + 1; // 1-based indexing
        }
        
        // Update leftSum for the next iteration
        leftSum += arr[i];
    }
    
    // No equilibrium point found
    return -1;
       
    }
}
