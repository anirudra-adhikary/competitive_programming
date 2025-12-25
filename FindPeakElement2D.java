/*

Problem link - https://www.geeksforgeeks.org/problems/find-the-peak-element-in-a-2d-matrix/1

Find the Peak Element in a 2D Matrix
Difficulty: Medium
Given a 2D matrix mat[][], identify any peak element within the matrix.
An element is considered a peak if it is greater than or equal to its four immediate neighbors: top, bottom, left, and right. For corner and edge elements, any missing neighbors are treated as having a value of negative infinity.
Note: A peak element is not necessarily the global maximum, it only needs to satisfy the condition relative to its adjacent elements. Multiple peak elements may exist, return any one of them.
Note that the driver code will print true if you return the correct position of peak element, else it will print false.

Examples:

Input: mat[][] = [[10, 20, 15],           
                [21, 30, 14],
                 [7, 16, 32]]
Output: true
Explanation: One of the peak element is 30 at index (1, 1), which is greater than or equal to all its valid neighbors: Left = 21, Right = 14, Top = 20, Bottom = 16. So, it satisfies the peak condition. Alternatively, (2, 2) with value 32 also qualifies as a peak.

Input: mat[][] = [[17, 7],
                [11, 10]]
Output: true
Explanation: 17 is the only peak element at index (0, 0). Its neighbors are: Right= 7, Bottom = 11. Since 17 is greater than or equal to both (and top/left are out of bounds), it qualifies as a peak element.

Constraint:
1 ≤ n × m ≤ 10^6
-106 ≤ mat[i][j] ≤ 10^6

Expected Complexities
Time Complexity: O(n log m)
Auxiliary Space: O(1)
*/

//Solution 1 (done by me)
class Solution {
    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        // code here
        int row = mat.length;
        int col = mat[0].length;
        int c = 0;
        int r = 0;
        // boolean[][] visited = new boolean[row][column];
        ArrayList<Integer> ans = new ArrayList<>();
        
        while (c < col) {
            // visited[r][c] == true;
                 
            int tracker = 0;
            
            //top
            if((c - 1 < 0) || (mat[r][c-1] <= mat[r][c]))
                    tracker++;
            //bottom
            if((c+1 == col) || (mat[r][c+1] <= mat[r][c]))
                    tracker++;
            //left
            if((r - 1 < 0) || (mat[r-1][c] <= mat[r][c]))
                    tracker++;
            //right
            if((r+1 == row) || (mat[r+1][c] <= mat[r][c]))
                    tracker++;
                    
            if(tracker == 4)
            {
                ans.add(r);
                ans.add(c);
                return ans;
            }
            
            if(r+1==row) {
                r = 0;
                c++;
            }
            else
                r++;
        }
        return ans;
    }
}

//solution 2 (done by me)
class Solution {
    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        // code here
        int row = mat.length;
        int col = mat[0].length;
        int c = 0;
        int r = 0;
        boolean[][] visited = new boolean[row][col];
        ArrayList<Integer> ans = new ArrayList<>();
        
        while (c < col) {
            if(!visited[r][c]) {
                ans = peakChecker(mat, visited, r, c);
                if(!ans.isEmpty())
                    return ans;
            }
            if(r+1==row) {
                r = 0;
                c++;
            }
            else
                r++;
        }
        return ans;
    }
    
    ArrayList<Integer> peakChecker(int[][] mat, boolean[][] visited, int r, int c) {
        
        visited[r][c] = true;
        
        int row = mat.length;
        int col = mat[0].length;
        
        int tracker = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        
        //top
        if((c - 1 < 0) || (mat[r][c-1] <= mat[r][c]))
                tracker++;
        else if(c - 1 >= 0)
            if(!visited[r][c-1]) {
                temp = peakChecker(mat, visited, r, c-1);
                if(!temp.isEmpty())
                    return temp;
            }
        //bottom
        if((c+1 == col) || (mat[r][c+1] <= mat[r][c]))
                tracker++;
        else if(c+1 < col)
            if(!visited[r][c+1]) {
                temp = peakChecker(mat, visited, r, c+1);
                if(!temp.isEmpty())
                    return temp;
            }
        //left
        if((r - 1 < 0) || (mat[r-1][c] <= mat[r][c]))
                tracker++;
        else if(r - 1 >= 0)
            if(!visited[r-1][c]) {
                temp = peakChecker(mat, visited, r-1, c);
                if(!temp.isEmpty())
                    return temp;
            }
        //right
        if((r+1 == row) || (mat[r+1][c] <= mat[r][c]))
                tracker++;
        else if(r + 1 < row)
            if(!visited[r+1][c]) {
                temp = peakChecker(mat, visited, r+1, c);
                if(!temp.isEmpty())
                    return temp;
            }
        if(tracker == 4)
        {
            temp.add(r);
            temp.add(c);
        }
        
        return temp;
    }
}

//solution 3
class Solution {
    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        // code here
        int row = mat.length;
        int col = mat[0].length;

        int low = 0, high = col - 1;
        int negInf = Integer.MIN_VALUE;
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            int maxRow = 0;
            for(int i=1;i<row;i++)
                if(mat[i][mid] > mat[maxRow][mid])
                    maxRow = i;
                    
            int left = (mid>0) ? mat[maxRow][mid-1] : negInf;
            int right = (mid+1 < col) ? mat[maxRow][mid+1]: negInf;
            
            int curr = mat[maxRow][mid];
            
            if(curr>=left && curr>=right)
            {
                ans.add(maxRow);
                ans.add(mid);
                return ans;
            }
            else if(right > curr)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return ans;
        
    }
}

