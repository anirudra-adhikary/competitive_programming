/*
Problem link - https://www.geeksforgeeks.org/problems/find-unique-number/1

Unique Number I
Difficulty: Easy

Given a unsorted array arr[] of positive integers having all the numbers occurring exactly twice, except for one number which will occur only once. Find the number occurring only once.

Examples :

Input: arr[] = [1, 2, 1, 5, 5]
Output: 2
Explanation: Since 2 occurs once, while other numbers occur twice, 2 is the answer.

Input: arr[] = [2, 30, 2, 15, 20, 30, 15]
Output: 20
Explanation: Since 20 occurs once, while other numbers occur twice, 20 is the answer.

Constraints
1 ≤  arr.size()  ≤ 10^6
0 ≤ arr[i] ≤ 10^9

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(1)
*/

//Solution 1 (done by me)
class Solution {
    public int findUnique(int[] arr) {
        // code here
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for(int item : arr)
            freq.put(item, freq.getOrDefault(item, 0) + 1);
            
        for(Map.Entry<Integer, Integer> entry : freq.entrySet())
            if(entry.getValue()==1)
                return entry.getKey();
                
        return -1;
        
    }
    
}

// Solution 2
class Solution {
    public int findUnique(int[] arr) {
        // code here
        int res = 0;
        for(int item : arr) res ^= item;
        return res;
        
    }
    
}