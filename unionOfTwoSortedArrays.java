/*
Problem link - https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1

Union of 2 Sorted Arrays
Difficulty: Medium

Given two sorted arrays a[] and b[], where each array may contain duplicate elements , the task is to return the elements in the union of the two arrays in sorted order.
Union of two arrays can be defined as the set containing distinct common elements that are present in either of the arrays.



Examples:

Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3, 6, 7]
Output: [1, 2, 3, 4, 5, 6, 7]
Explanation: Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
Input: a[] = [2, 2, 3, 4, 5], b[] = [1, 1, 2, 3, 4]
Output: [1, 2, 3, 4, 5]
Explanation: Distinct elements including both the arrays are: 1 2 3 4 5.


Input: a[] = [1, 1, 1, 1, 1], b[] = [2, 2, 2, 2, 2]
Output: [1, 2]
Explanation: Distinct elements including both the arrays are: 1 2.
Constraints:
1  ≤  a.size(), b.size()  ≤  10^5
-10^9 ≤ a[i], b[i] ≤10^9

Expected Complexities
Time Complexity: O(n + m)
Auxiliary Space: O(1)

*/


//Solution 1:
class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
        Set<Integer> st = new TreeSet<>();
        
        for(int item : a)
            st.add(item);
        
        for(int item: b)
            st.add(item);
            
        ArrayList<Integer> res = new ArrayList<>(st);
        
        return res;
    }
}


//Solution 2:
class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        int lPointer = 0;
        int rPointer = 0;
        
        while(lPointer < a.length && rPointer < b.length) {
            
            if(a[lPointer] < b[rPointer]) {
                if(res.size() == 0 || a[lPointer] > res.get(res.size() - 1))
                    res.add(a[lPointer]);
                
                lPointer++;
            }
            else if(b[rPointer] < a[lPointer]) {
                if(res.size() == 0 || b[rPointer] > res.get(res.size() - 1))
                    res.add(b[rPointer]);
                    
                rPointer++;
            }
            else {
                if(res.size() == 0 || a[lPointer] > res.get(res.size() - 1))
                    res.add(a[lPointer]);
                    
                lPointer++;
                rPointer++;
            }
        }
        
        while(lPointer < a.length) {
            if(res.size() == 0 || a[lPointer] > res.get(res.size() - 1))
                    res.add(a[lPointer]);
            lPointer++;
        }
            
        while(rPointer < b.length) {
            if(res.size() == 0 || b[rPointer] > res.get(res.size() - 1))
                    res.add(b[rPointer]);
                    
            rPointer++;
        }
            
        return res;
        
    }
}

