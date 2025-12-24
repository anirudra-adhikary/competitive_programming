/*
Problem link - https://www.geeksforgeeks.org/problems/count-elements-less-than-or-equal-to-k-in-a-sorted-rotated-array/1

Count elements less than or equal to k in a sorted rotated array

Given a sorted array arr[] containing distinct positive integers that has been rotated at some unknown pivot, and a value x. Your task is to count the number of elements in the array that are less than or equal to x.

Examples:
Input: arr[] = [4, 5, 8, 1, 3], x = 6
Output: 4
Explanation: 1, 3, 4 and 5 are less than 6, so the count of all elements less than 6 is 4.

Input: arr[] = [6, 10, 12, 15, 2, 4, 5], x = 14
Output: 6
Explanation: All elements except 15 are less than 14, so the count of all elements less than 14 is 6.

Constraints:
1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i], x ≤ 10^9

Expected Complexities
Time Complexity: O(log n)
Auxiliary Space: O(1)
*/


// Solution 1
class Solution {
    public int countLessEqual(int[] arr, int x) {
        // code here
        int ans = 0;
        for(int i=0;i<arr.length;i++)
        {
            if (arr[i] <= x)
                ans += 1;
        }
        return ans;
    }
}

//Solution 2
class Solution {
    public int countLessEqual(int[] arr, int x) {
        int n = arr.length;
        int pivot = pivotFind(arr);
        int beforePivot = countMembers(arr, 0, pivot-1, x);
        int afterPivot = countMembers(arr, pivot, n-1, x);
        return beforePivot + afterPivot;
    }
    
    public int pivotFind(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        
        while(low < high) {
            int mid = low + (high - low) / 2;
            
            if(arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }
        
        return low;
    }
    
    public int countMembers(int[] arr, int left, int right, int key) {
        int low = left;
        int high = right;
        int res = left - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= key)
            {
                res = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return res - left + 1;
    }
    
}
