/*
Problem link - https://www.geeksforgeeks.org/problems/remove-k-digits/1

Remove K Digits
Difficulty: Medium

Given a non-negative integer s represented as a string and an integer k, remove exactly k digits from the string so that the resulting number is the smallest possible, while maintaining the relative order of the remaining digits.
Note : The resulting number must not contain any leading zeros.
If the resulting number is an empty string after the removal, return "0".

Examples:

Input: s = "4325043", k = 3
Output: 2043
Explanation: Remove the three digits 4, 3, and 5 to form the new number "2043" which is smallest among all possible removal.

Input: s = "765028321", k = 5
Output: 221
Explanation: Remove the five digits 7, 6, 5, 8 and 3 to form the new number "0221". Since we are not supposed to keep leading 0s, we get "221".

Constraints:
1 ≤ k ≤ |s| ≤ 10^6

Expected Complexities
Time Complexity: O(n + k)
Auxiliary Space: O(n)
*/

//Solution 
class Solution {
    public String removeKdig(String s, int k) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            
            while(!st.isEmpty() && k>0 && st.peek()>c)
            {
                st.pop();
                k--;
            }
            
            if(!st.isEmpty() || c!='0')
                st.push(c);
        }
        
        while(!st.isEmpty() && k-->0)
            st.pop();
            
        if(st.isEmpty())
            return "0";
            
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty())
            res.append(st.pop());
            
        return res.reverse().toString();
    }
}
