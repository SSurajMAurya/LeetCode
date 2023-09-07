//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        if (start == end) {
            return 0; // No multiplications needed if start and end are the same.
        }

        int mod = 100000;
        int[] dp = new int[mod];
        Arrays.fill(dp, -1);
        dp[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int num : arr) {
                int next = (current * num) % mod;

                if (dp[next] == -1) {
                    dp[next] = dp[current] + 1;

                    if (next == end) {
                        return dp[next];
                    }

                    queue.offer(next);
                }
            }
        }

        return -1;
    }
}
