/*
Problem link - https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1

Sort 0s, 1s and 2s
Difficulty: Medium

Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.
Note: You need to solve this problem without utilizing the built-in sort function.

Examples:

Input: arr[] = [0, 1, 2, 0, 1, 2]
Output: [0, 0, 1, 1, 2, 2]
Explanation: 0s, 1s and 2s are segregated into ascending order.

Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
Explanation: 0s, 1s and 2s are segregated into ascending order.
Follow up: Could you come up with a one-pass algorithm using only constant extra space?

Constraints:
1 ≤ arr.size() ≤ 10^6
0 ≤ arr[i] ≤ 2

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(1)
*/

//Solution 1 (done by me)

class Solution {
    public void sort012(int[] arr) {

        int zero = 0;
        int one = 0;
        
        for(int item : arr)
            if(item == 0)
                zero++;
            else if(item == 1)
                one++;
            else
        
        for(int i=0;i<zero;i++)
            arr[i] = 0;
        for(int i=zero;i<zero + one;i++)
            arr[i] = 1;
        for(int i=zero+one;i<arr.length;i++)
            arr[i] = 2;
    }
}

//Solution 2 
class Solution {
    public void sort012(int[] arr) {
        
        int zero = 0;
        int one = 0;
        
        for(int item : arr)
            if(item == 0) zero++;
            else if(item == 1) one++;
        
        int i = 0;
        
        while(zero-- > 0) arr[i++] = 0;
        while(one-- > 0) arr[i++] = 1;
        while(i < arr.length) arr[i++] = 2;
    }
}

//Solution 3
class Solution {
    public void sort012(int[] arr) {
        
        int zero = 0;
        int one = 0;
        
        for(int item : arr)
            if(item == 0) zero++;
            else if(item == 1) one++;
        
        
        Arrays.fill(arr, 0, zero, 0);
        Arrays.fill(arr, zero, zero + one, 1);
        Arrays.fill(arr, zero + one, arr.length, 2);
    }
}

// Solution 4 - Dutch National Flag Algorithm
class Solution {
    public void sort012(int[] arr) {
        
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        
        while(mid <= high)
        {
            int temp = arr[mid];
            
            if(temp == 0)
            {
                arr[mid++] = arr[low];
                arr[low++] = temp;
            }
            else if(temp == 1)
                mid++;
            else
            {
                arr[mid] = arr[high];
                arr[high--] = temp;
            }
        }
    }
}