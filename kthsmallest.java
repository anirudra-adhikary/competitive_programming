/*
Problem link - https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1

Kth Smallest
Difficulty: Medium

Given an integer array arr[] and an integer k, your task is to find and return the kth smallest element in the given array.
Note: The kth smallest element is determined based on the sorted order of the array.

Examples :

Input: arr[] = [10, 5, 4, 3, 48, 6, 2, 33, 53, 10], k = 4
Output: 5
Explanation: 4th smallest element in the given array is 5.


Input: arr[] = [7, 10, 4, 3, 20, 15], k = 3
Output: 7
Explanation: 3rd smallest element in the given array is 7.


Constraints:
1 ≤ arr.size() ≤ 10^5
1 ≤ arr[i] ≤ 10^5
1 ≤ k ≤  arr.size() 

Expected Complexities
Time Complexity: O(n log k)
Auxiliary Space: O(k)

*/

//Solution 1 : sorting the array
class Solution {
    public int kthSmallest(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }
}

// Solution  2 : using the maxHeap
class Solution {
    public int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int item : arr) {
            maxHeap.offer(item);
            if(maxHeap.size() > k)
                maxHeap.poll();
        }        
    
        return maxHeap.poll();
    }
}


//Solution 3 : using quickselect
class Solution {
    public int kthSmallest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }
    
    int quickSelect(int[] arr, int left, int right, int k) {
        if(left <= right) {
            
            int pivotIndex = partition(arr, left, right);
            
            if(pivotIndex == k) return arr[pivotIndex];
            else if(pivotIndex > k) return quickSelect(arr, left, pivotIndex - 1, k);
            else return quickSelect(arr, pivotIndex + 1, right, k);
        }
        
        return -1;
    }
    
    int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        
        for(int j = left; j < right; j++) {
            if(arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        } 
        
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
        return i;
    }
}


//Solution 4 : using counting sort
class Solution {
    public int kthSmallest(int[] arr, int k) {
        
        int maxEle = Integer.MIN_VALUE;
        for(int item: arr)
            maxEle = Math.max(maxEle, item);
            
        int[] freq = new int[maxEle + 1];
        for(int item: arr)
            freq[item]++;
            
        int count = 0;
        for(int i = 0; i <= maxEle; i++)
        {
            count += freq[i];
            if(count >= k)
                return i;
        }
        
        return -1;
        
    }
}


