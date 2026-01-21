/*

Sum of subarray ranges
Difficulty: Medium

Given an integer array arr[], the range of a subarray is defined as the difference between the largest and smallest elements within that subarray. Your task is to return the sum of the ranges of all possible subarrays in the array.
Note: It is guaranteed that the result will fit within a 32-bit integer.

Examples:

Input: arr[] = [1, 2, 3]
Output: 4
Explanation: The 6 subarray of arr are the following :
[1], range = largest - smallest = 1 - 1 = 0
[2], range = largest - smallest = 2 - 2 = 0
[3], range = largest - smallest = 3 - 3 = 0
[1, 2], range = largest - smallest = 2 - 1 = 1
[2, 3], range = largest - smallest = 3 - 2 = 1
[1, 2, 3], range = largest - smallest = 3 - 1 = 2
Sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4


Input: arr[] = [-32, 0, -2, 72]
Output: 318
Explanation: 
[-32], range = largest - smallest = -32 - (-32) = 0
[-32, 0], range = largest - smallest = 0 - (-32) = 32
[-32, 0, -2], range = largest - smallest = 0 - (-32) = 32
[-32, 0, -2, 72], range= largest - smallest = 72 - (-32) = 104
[0], range = largest - smallest = 0 - 0 = 0
[0, -2], range = largest - smallest = 0 - (-2) = 2
[0, -2, 72], range = largest - smallest = 72 - (-2) = 74
[-2], range = largest - smallest = -2 - (-2) = 0
[-2, 72], range = largest - smallest = 72 - (-2) = 74
[72], range = largest - smallest = 72 - 72 = 0
Sum of all ranges is 0 + 32 + 32 + 104 + 0 + 2 + 74 + 0 + 74 + 0 = 318


Constraints:
1 ≤ arr.size() ≤ 10^6
10-9 ≤ arr[i]  ≤ 10^9

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(n)

*/


//Solution 1
class Solution {
    public int subarrayRanges(int[] arr) {
        // code here
        int n = arr.length;
        
        Deque<Integer> minStack = new ArrayDeque<>();
        Deque<Integer> maxStack = new ArrayDeque<>();
        
        int minSum = 0;
        int maxSum = 0;
        
        for(int i=0;i<=n;i++) {
            
            while(!minStack.isEmpty() && (i == n || arr[i] < arr[minStack.peek()])) {
                int mid = minStack.pop();
                int prevSmall = -1;
                if(!minStack.isEmpty())
                    prevSmall = minStack.peek();
                int count = (mid - prevSmall) * (i - mid);
                minSum += arr[mid] * count;
            }
            minStack.push(i);
                
                
            while(!maxStack.isEmpty() && (i == n || arr[i] > arr[maxStack.peek()])) {
                int mid = maxStack.pop();
                int prevBig = -1;
                if(!maxStack.isEmpty())
                    prevBig = maxStack.peek();
                int count = (mid - prevBig) * (i - mid);
                maxSum += arr[mid] * count;
            }
            maxStack.push(i);
                
        }
        
        return maxSum - minSum;
    }
}
