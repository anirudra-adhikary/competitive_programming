/*
Problem link - 

Max Xor Subarray of size K
Difficulty: Medium

Given an array of integers arr[]  and a number k. Return the maximum xor of a subarray of size k.
Note: A subarray is a contiguous part of any given array.


Examples:

Input: arr[] = [2, 5, 8, 1, 1, 3], k = 3
Output: 15
Explanation: arr[0] ^ arr[1] ^ arr[2] = 15, which is maximum.

Input: arr[] = [1, 2, 4, 5, 6] , k = 2
Output: 6
Explanation: arr[1] ^ arr[2] = 6, which is maximum.

Constraints:
1 ≤ arr.size() ≤ 10^6
0 ≤ arr[i] ≤ 10^6
1 ≤ k ≤ arr.size()

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(1)

*/

//Solution 1 (done by me)
class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int maxXor = 0;
        
        for(int i=0;i<k;i++)
            maxXor ^= arr[i];
        
        int sumXor = maxXor;
        int left = 0;
        int right = k;
        while(right<arr.length)
        {
            sumXor ^= arr[left++];
            sumXor ^= arr[right++];
            
            if(sumXor > maxXor)
                maxXor = sumXor;
        }
        
        return maxXor;
        
    }
}




