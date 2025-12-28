/*
Problem link - https://www.geeksforgeeks.org/problems/kth-element-in-matrix/1

Kth smallest element in a Matrix
Difficulty: Medium

Given a matrix mat[][] of size n*n, where each row and column is sorted in non-decreasing order. Find the kth smallest element in the matrix.

Examples:
Input: mat[][] = [[16, 28, 60, 64], k = 3
                [22, 41, 63, 91],
                [27, 50, 87, 93],
                [36, 78, 87, 94]]
Output: 27
Explanation: 27 is the 3rd smallest element.

Input: mat[][] = [[10, 20, 30, 40], k = 7
                [15, 25, 35, 45],
                [24, 29, 37, 48],
                [32, 33, 39, 50]] 
Output: 30
Explanation: 30 is the 7th smallest element.

Constraints:
1 ≤ n ≤ 500
1 ≤ mat[i][j] ≤ 10^4
1 ≤ k ≤ n*n

Time Complexity: O(n × log(max(mat) - min(mat)))
Auxiliary Space: O(1)

*/

//Solution 1
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                arr.add(mat[i][j]);
                
        Collections.sort(arr);
        
        return arr.get(k-1);
    }
}

//Solution 2
import java.util.*;

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++) {
                pq.add(mat[i][j]);
                
                if(pq.size() > k)
                    pq.poll();
            }
            
        return pq.peek();
    }
}

//Solution 3
import java.util.*;

class Solution {
    public int count(int[][] mat, int x) {
        int n = mat.length;
        int r = 0;
        int c = n - 1;
        int count = 0;
        
        while((r<n) && (c>=0)) {
            if(mat[r][c] <= x) {
                count += (c+1);
                r++;
            }
            else
                c--;
        }
        
        return count;
    }
    
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        int low = mat[0][0];
        int high = mat[n-1][n-1];
        int ans = 0;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int count = count(mat, mid);
            
            if(count<k)
                low = mid + 1;
            else {
                ans = mid;
                high = mid - 1;
            }
        }
        
        
        return ans;
    }
}


