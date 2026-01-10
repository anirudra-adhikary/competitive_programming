/*
Problem link - https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/description/

Cells with Odd Values in a Matrix
Easy

There is an m x n matrix that is initialized to all 0's. There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform some increment operations on the matrix.
For each location indices[i], do both of the following:
Increment all the cells on row ri.
Increment all the cells on column ci.
Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.


Example 1:
Input: m = 2, n = 3, indices = [[0,1],[1,1]]
Output: 6
Explanation: Initial matrix = [[0,0,0],[0,0,0]].
After applying first increment it becomes [[1,2,1],[0,1,0]].
The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.


Example 2:
Input: m = 2, n = 2, indices = [[1,1],[0,0]]
Output: 0
Explanation: Final matrix = [[2,2],[2,2]]. There are no odd numbers in the final matrix.
 

Constraints:

1 <= m, n <= 50
1 <= indices.length <= 100
0 <= ri < m
0 <= ci < n
*/

//Solution 1 (done by me)
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] mat = new int[m][n];

        for(int i=0;i<indices.length;i++) {

            int row = indices[i][0];
            int col = indices[i][1];

            for(int j=0;j<n;j++)
                mat[row][j]++;
            for(int k=0;k<m;k++)
                mat[k][col]++;
        }

        int oddCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((mat[i][j] & 1) == 1) {
                    oddCount++;
                }
            }
        }

        return oddCount;
    }
}

//Solution 2
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];

        for(int[] idx: indices) {
            int r = idx[0];
            int c = idx[1];

            row[r]++;
            col[c]++;
        }

        int oddCount = 0;

        for(int i: row)
            for(int j: col)
                oddCount += (i+j)%2;

        return oddCount;
    }
}

//Solution 3
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];

        for(int[] idx: indices) {
            int r = idx[0];
            int c = idx[1];

            row[r]++;
            col[c]++;
        }

        int cnt1 = 0, cnt2 = 0;

        for(int i: row)
            cnt1 += i%2;
        for(int j: col)
            cnt2 += j%2;

        return cnt1 * (n - cnt2) + cnt2 * (m - cnt1); 
    }
}

//Solution 4
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for(int[] idx: indices) {
            row[idx[0]] = !row[idx[0]];
            col[idx[1]] = !col[idx[1]];
        }

        int cnt1 = 0, cnt2 = 0;

        for(boolean r: row)
            if(r) cnt1++;
        for(boolean c: col)
            if(c) cnt2++;

        return cnt1 * (n - cnt2) + cnt2 * (m - cnt1); 
    }
}