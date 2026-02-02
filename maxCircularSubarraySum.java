/*
Problem link - https://www.geeksforgeeks.org/problems/max-circular-subarray-sum-1587115620/1

Max Circular Subarray Sum
Difficulty: Hard

You are given a circular array arr[] of integers, find the maximum possible sum of a non-empty subarray. In a circular array, the subarray can start at the end and wrap around to the beginning. Return the maximum non-empty subarray sum, considering both non-wrapping and wrapping cases.

Examples:

Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
Output: 22
Explanation: Starting from the last element of the array, i.e, 12, and moving in a circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.
Input: arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
Output: 23
Explanation: Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].


Input: arr[] = [5, -2, 3, 4]
Output: 12
Explanation: The circular subarray [3, 4, 5] gives the maximum sum of 12.
Constraints:
1 ≤ arr.size() ≤ 10^5
-104 ≤ arr[i] ≤ 10^4

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(1)

*/


// Solution 1:
class Solution {
    public int maxCircularSum(int arr[]) {
        
        int n = arr.length;
        int suffixSum = arr[n - 1];
        
        int[] maxSuffix = new int[n + 1];
        maxSuffix[n - 1] = arr[n - 1];
        
        for(int i = n - 2; i >= 0; i--) {
            suffixSum = suffixSum + arr[i];
            maxSuffix[i] = Math.max(maxSuffix[i + 1], suffixSum);
        }
        
        int circularSum = arr[0];
        int normalSum = arr[0];
        
        int currSum = 0;
        int prefix = 0;
        
        for(int i = 0; i < n; i++) {
            
            currSum = Math.max(currSum + arr[i], arr[i]);
            normalSum = Math.max(normalSum, currSum);
            
            prefix = prefix + arr[i];
            circularSum = Math.max(circularSum, prefix + maxSuffix[i + 1]);
        }
        
        return Math.max(normalSum, circularSum);
    }
}



//Solution 2 (expected):
class Solution {
    public int maxCircularSum(int arr[]) {
        int globMax = arr[0];
        int globMin = arr[0];
        int currMax = 0;
        int currMin = 0;
        
        int total = 0;
        for ( int item : arr) {
            currMax = Math.max(currMax + item, item);
            currMin = Math.min(currMin + item, item);
            total += item;
            globMax = Math.max(globMax, currMax);
            globMin = Math.min(globMin, currMin);
        }
        
        return (globMax > 0) ? Math.max(globMax, total - globMin) : globMax;
    }
}
