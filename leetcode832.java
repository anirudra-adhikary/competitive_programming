/*
Problem link - https://leetcode.com/problems/flipping-an-image/description/

Flipping an Image
Easy

Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
To flip an image horizontally means that each row of the image is reversed.
For example, flipping [1,1,0] horizontally results in [0,1,1].
To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
For example, inverting [0,1,1] results in [1,0,0].
 

Example 1:
Input: image = [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]


Example 2:
Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 

Constraints:

n == image.length
n == image[i].length
1 <= n <= 20
images[i][j] is either 0 or 1.
*/

//Solution 1 (done by me)
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] row: image)
            reverseRow(row);
        for(int[] row: image)
            invert(row);

        return image;
    }

    public void reverseRow(int[] row)
    {
        int left = 0;
        int right = row.length - 1;
        while(left < right)
        {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;  
            left++;
            right--;
        }
    }

    public void invert(int[] row)
    {
        for(int i=0;i<row.length;i++)
            if(row[i] == 1)
                row[i] = 0;
            else
                row[i] = 1;
    }
}

//Solution 2(done by me)
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] row: image)
            reverseRow(row);
        return image;
    }

    public void reverseRow(int[] row)
    {
        int left = 0;
        int right = row.length - 1;
        while(left <= right)
        {
            if(left==right)
                row[left] = row[left] ^ 1;
            else {
                int temp = row[left]^1;
                row[left] = row[right]^1;
                row[right] = temp;
            }
            
            left++;
            right--;
        }
    }
}

//Solution 3 
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] row: image)
            reverseRow(row);
        return image;
    }

    public void reverseRow(int[] row)
    {
        int left = 0;
        int right = row.length - 1;
        while(left <= right)
        {
            if(row[left]==row[right])
            {
                row[left] ^= 1;
                row[right] = row[left];
            }
            
            left++;
            right--;
        }
    }
}