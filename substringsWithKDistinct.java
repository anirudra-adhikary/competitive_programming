/*
Problem link - https://www.geeksforgeeks.org/problems/count-number-of-substrings4528/1

Substrings with K Distinct
Difficulty: Medium

You are given a string s consisting of lowercase characters and an integer k, You have to count all possible substrings that have exactly k distinct characters.

Examples :

Input: s = "abc", k = 2
Output: 2
Explanation: Possible substrings are ["ab", "bc"]

Input: s = "aba", k = 2
Output: 3
Explanation: Possible substrings are ["ab", "ba", "aba"]

Input: s = "aa", k = 1
Output: 3
Explanation: Possible substrings are ["a", "a", "aa"]

Constraints:
1 ≤ s.size() ≤ 10^6
1 ≤ k ≤ 26

Time Complexity: O(n)
Auxiliary Space: O(1)

*/

//Solution 
class Solution {
    public int countSubstr(String s, int k) {
        return atMost(s, k) - atMost(s, k - 1);
    }
    
    int atMost(String s, int k)
    {
        int n = s.length();
        int left = 0;
        int right = 0;
        int ans = 0;
        Map<Character, Integer> freq = new HashMap<>();
        
        while(right < n)
        {
            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            
            if(freq.get(ch)==1)
                k--;
                
            while(k<0)
            {
                freq.put(s.charAt(left), freq.get(s.charAt(left))-1);
                if(freq.get(s.charAt(left))==0)
                    k++;
                left++;
            }
            
            ans += right - left + 1;
            right++;
        }
        
        return ans;
    }
}