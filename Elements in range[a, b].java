/*
Problem link - https://www.geeksforgeeks.org/problems/find-number-of-elements-in-range-a-b-for-each-query/1
    
Given an unsorted array arr[] and a 2D array queries[][] of size q, where each query is in the form of [a, b]. For each query, count how many elements in arr[] lie within the range [a, b], i.e., elements satisfying a ≤ x ≤ b.
Return the results for all queries as a list of integers, where each integer corresponds to the count of elements in the respective query range.

Examples:

Input: arr[] = [1, 4, 2, 8, 5], queries[][] = [[1, 4], [3, 6], [0, 10]]
Output: [3, 2, 5]
Explanation: Query [1, 4]: Elements in range → [1, 4, 2] → Count = 3
Query [3, 6]: Elements in range → [4, 5] → Count = 2
Query [0, 10]: All elements → [1, 4, 2, 8, 5] → Count = 5

Input: arr[] = [10, 20, 30, 40, 50], queries[][] = [[5, 15], [25, 45], [10, 50]]
Output: [1, 2, 5]
Explanation: Query [5, 15]: Elements in range → [10] → Count = 1
Query [25, 45]: Elements in range → [30, 40] → Count = 2
Query [10, 50]: Elements in range → [10, 20, 30, 40, 50] → Count = 5

Expected Complexities
Time Complexity: O(n log n + q log n)
Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size(), q ≤ 10^5
0 ≤ arr[i] ≤ 10^6
0 ≤ queries[i][0] ≤ queries[i][1] ≤ 10^6

*/

import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        
        Arrays.sort(arr);
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int query[] : queries) {
            int first = query[0];
            int second = query[1];
            int left = lowerBound(arr, first);
            int right = upperBound(arr, second);
            ans.add(right - left);
        }
        
        return ans;
    }
    
    public int lowerBound(int arr[], int key) {
        int low = 0;
        int high = arr.length;
        while(low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
    
    public int upperBound(int arr[], int key) {
        int low = 0;
        int high = arr.length;
        while(low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= key)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
