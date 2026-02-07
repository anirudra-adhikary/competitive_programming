/*
Problem link - https://www.geeksforgeeks.org/problems/max-sum-in-the-configuration/1

Max sum in the configuration
Difficulty: Medium

Given an integer array arr[]. Find the maximum value of the sum of i*arr[i] for all 0 ≤ i ≤ arr.size()-1. The only operation allowed is to rotate(clockwise or counterclockwise) the array any number of times.

Examples :

Input: arr[] = [3, 1, 2, 8]
Output: 29
Explanation: Out of all the possible configurations by rotating the elements: arr[] = [3, 1, 2, 8] here (3*0) + (1*1) + (2*2) + (8*3) = 29 is maximum.


Input: arr[] = [1, 2, 3]
Output: 8
Explanation: Out of all the possible configurations by rotating the elements: arr[] = [1, 2, 3] here (1*0) + (2*1) + (3*2) = 8 is maximum.

Input: arr[] = [4, 13]
Output: 13


Constraints:
1 ≤ arr.size() ≤ 10^4
1 ≤ arr[i] ≤ 20

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(1)

*/

//Solution 1
class Solution {
    int maxSum(int[] arr) {
        
        int currSum = 0;
        int currVal = 0;
        
        for(int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            currVal += i * arr[i];
        }
        
        int res = currVal;
        for(int i = 1; i < arr.length; i++) {
            currVal = currVal - (currSum - arr[i-1]) + arr[i - 1] * (arr.length - 1);
            
            res = Math.max(res, currVal);
        }
        
        return res;
    }
} 

