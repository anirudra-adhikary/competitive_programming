/*
Problem link - https://www.geeksforgeeks.org/problems/kth-missing-positive-number-in-a-sorted-array/1

Kth Missing Positive Number in a Sorted Array
Difficulty: Medium

Given a sorted array of distinct positive integers arr[], You need to find the kth positive number that is missing from the arr[].

Examples:

Input: arr[] = [2, 3, 4, 7, 11], k = 5
Output: 9
Explanation: Missing are 1, 5, 6, 8, 9, 10… and 5th missing number is 9.

Input: arr[] = [1, 2, 3], k = 2
Output: 5
Explanation: Missing are 4, 5, 6… and 2nd missing number is 5.

Input: arr[] = [3, 5, 9, 10, 11, 12], k = 2
Output: 2
Explanation: Missing are 1, 2, 4, 6… and 2nd missing number is 2.

Constraints:
1 ≤ arr.size() ≤ 10^5
1 ≤ k ≤ 10^5
1 ≤ arr[i] ≤ 10^6

Expected Complexities
Time Complexity: O(log n)
Auxiliary Space: O(1)

Topic Tags
Binary Search, Arrays
*/

//Solution 1 (done by me)
class Solution {
    public int kthMissing(int[] arr, int k) {
        int num = 1, missingPos = 0;
        for(int i=0;i<arr.length;i++) {
            while(num != arr[i]) {
                missingPos++;
                if(missingPos==k) {
                    return num;
                }
                num++;
            }
            if(num == arr[i])
                num++;
        }
        
        while(missingPos!=k) {
            num++;
            missingPos++;
        }
            
        return num-1;
    }
}

//Solution 2 (done by me)
class Solution {
    public int kthMissing(int[] arr, int k) {
        int num = 1, missingPos = 0, i = 0;
        while(i<arr.length) {
            if(num < arr[i]) {
                missingPos += arr[i] - num;
                num = arr[i];
                if(missingPos >= k)
                    return num - (missingPos - k) - 1;
            }
            else {
                i++;
                num++;
            }
        }
        
        while(missingPos!=k) {
            num++;
            missingPos++;
        }
            
        return num-1;
    }
}

//Solution 3 (done by me)
class Solution {
    public int kthMissing(int[] arr, int k) {
        int num = 1, missingPos = 0, i = 0;
        while(i<arr.length) {
            if(num < arr[i]) {
                missingPos += arr[i] - num;
                num = arr[i];
                if(missingPos >= k)
                    return num - (missingPos - k) - 1;
            }
            else {
                i++;
                num++;
            }
        }
        
        if(missingPos!=k) {
            num += (k-missingPos);
        }
            
        return num-1;
    }
}

//Solution 4
import java.util.*;

class Solution {
    public int kthMissing(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num : arr)
            set.add(num);
        
        int count = 0;
        int curr = 0;
        
        while(count<k) {
            curr++;
            
            if(!set.contains(curr))
                count++;
        }
        
        return curr;
    }
}

//Solution 5
class Solution {
    public int kthMissing(int[] arr, int k) {
        int n = arr.length;
        
        for(int i=0;i<n;i++)
        {
            if(arr[i] > (k + i))
                return k + i;
        }
        
        return k + n;
    }
}

//solution 6
class Solution {
    public int kthMissing(int[] arr, int k) {
        int num = 1, missingPos = 0, i = 0;
        while(i<arr.length) {
            if(num < arr[i]) {
                missingPos += arr[i] - num;
                num = arr[i];
                if(missingPos >= k)
                    return num - (missingPos - k) - 1;
            }
            else {
                i++;
                num++;
            }
        }
            
        return k + arr.length;
    }
}


//solution 7
class Solution {
    public int kthMissing(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int result = arr.length + k;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid]>mid+k) {
                result = mid + k;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        
        return result;
    }
}
