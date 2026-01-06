/*
Problem link - https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1

K-th element of two Arrays
Difficulty: Medium

Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.

Examples :

Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
Output: 6
Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.

Input: a[] = [1, 4, 8, 10, 12], b[] = [5, 7, 11, 15, 17], k = 6
Output: 10
Explanation: Combined sorted array is [1, 4, 5, 7, 8, 10, 11, 12, 15, 17]. The 6th element of this array is 10.

Constraints:
1 ≤ a.size(), b.size() ≤ 10^6
1 ≤ k ≤ a.size() + b.size()
0 ≤ a[i], b[i] ≤ 10^8

Expected Complexities
Time Complexity: O(log(min(a, b)))
Auxiliary Space: O(1)
*/

//Solution 1 (done by me)

import java.util.*;
P
class Solution {
    public int kthElement(int a[], int b[], int k) {
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(int item : a)
            temp.add(item);
        
        for(int item : b)
            temp.add(item);
        
        Collections.sort(temp);
        
        return temp.get(k-1);
    }
}

// Solution 2 (done by me)
import java.util.*;

class Solution {
    public int kthElement(int a[], int b[], int k) {
        int pointer1 = 0;
        int pointer2 = 0;
        int i = 0;
        
        while((pointer1 < a.length) && (pointer2 < b.length))
        {
            if(a[pointer1] < b[pointer2])
            {
                if(++i==k) return a[pointer1];
                pointer1++;
            }
            else
            {
                if(++i==k) return b[pointer2];
                pointer2++;
            }
        }
        
        while(pointer1 < a.length) {
            if(++i==k) return a[pointer1];
            pointer1++;
        }
        
        while(pointer2 < b.length) {
            if(++i==k) return b[pointer2];
            pointer2++;
        }
        
        return -1;
    }
}