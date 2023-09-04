//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
       if (a == null || n <= 0 || m <= 0) {
            return null;
        }

        // Create a queue for BFS
        Queue<int[]> queue = new LinkedList<>();

        // Add 'O' cells on the border to the queue
        for (int i = 0; i < n; i++) {
            if (a[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
            }
            if (a[i][m - 1] == 'O') {
                queue.offer(new int[]{i, m - 1});
            }
        }

        for (int j = 0; j < m; j++) {
            if (a[0][j] == 'O') {
                queue.offer(new int[]{0, j});
            }
            if (a[n - 1][j] == 'O') {
                queue.offer(new int[]{n - 1, j});
            }
        }

        // Mark 'O' cells on the border as visited
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            a[row][col] = 'V'; // Mark as visited

            // Explore neighboring cells
            int[][] neighbors = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] neighbor : neighbors) {
                int newRow = row + neighbor[0];
                int newCol = col + neighbor[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                        && a[newRow][newCol] == 'O') {
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        // Replace remaining 'O' cells with 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'O') {
                    a[i][j] = 'X';
                } else if (a[i][j] == 'V') {
                    a[i][j] = 'O'; // Restore visited cells
                }
            }
        }

        return a;
    }
}