/*

Problem link - https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

Max Sum Subarray of size K 
Difficulty: Easy

Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.

Note: A subarray is a contiguous part of any given array.


Examples:

Input: arr[] = [100, 200, 300, 400], k = 2
Output: 700
Explanation: arr2 + arr3 = 700, which is maximum.

Input: arr[] = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
Output: 39
Explanation: arr1 + arr2 + arr3 + arr4 = 39, which is maximum.

Input: arr[] = [100, 200, 300, 400], k = 1
Output: 400
Explanation: arr3 = 400, which is maximum.

Constraints:
1 ≤ arr.size() ≤ 10^6
1 ≤ arr[i] ≤ 10^6
1 ≤ k ≤ arr.size()

Time Complexity: O(n)
Auxiliary Space: O(1)

*/

// Solution 1 (done by me)
class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        
        int sum = 0;
        
        for(int i=0;i<k;i++)
            sum += arr[i];
            
        int maxSum = sum;
        
        int right = k;
        int left = 0;
        
        while(right < arr.length)
        {
            sum -= arr[left++];
            sum += arr[right++];
            
            if(sum > maxSum)
                maxSum = sum;
            
        }
        
        return maxSum;
    }
}

//Solution 2
class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        
        Queue<Integer> q = new LinkedList<>();
        int maxSum = 0;
        int sum = 0;
        
        for(int item: arr)
        {
            sum += item;
            q.add(item);
            if(q.size()>k)
                sum -= q.poll();
            if(q.size()==k)
                if(sum > maxSum)
                    maxSum = sum;
        }
        
        return maxSum;
    }
}

//Solution 3
class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        int[] prefix = new int[n+1];
        
        for(int i=0;i<n;i++)
            prefix[i+1] = prefix[i] + arr[i];
            
        int maxSum = 0;
        for(int i=0;i<=n-k;i++)
        {
            int j = i + k - 1;
            int sum = prefix[j+1] - prefix[i];
            if(sum > maxSum)
                maxSum = sum;
        }
        
        return maxSum;
    }
}