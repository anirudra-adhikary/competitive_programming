/*
Problem link - https://leetcode.com/problems/remove-duplicate-letters/description/

316. Remove Duplicate Letters (Medium)

Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 10^4
s consists of lowercase English letters.
 


*/

// Solution 1:
class Solution {
    public String removeDuplicateLetters(String s) {
        
        int[] freq = new int[26];
        for(char ch: s.toCharArray())
            freq[ch - 'a']++;

        boolean[] inStack = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(inStack[c - 'a']) {
                freq[c - 'a']--;
                continue;
            }

            while(!stack.isEmpty() && stack.peek() > c 
                && freq[stack.peek() - 'a'] > 0) 
                inStack[stack.pop() - 'a'] = false;

            stack.push(c);
            inStack[c - 'a'] = true;
            freq[c - 'a']--;

        }


        StringBuilder sb = new StringBuilder();
        for(char c : stack)
            sb.append(c);
        return sb.reverse().toString();
    }
}


// Solution 2:
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        char[] chars = s.toCharArray();
        for(char c: chars) freq[c-'a']++;

        char[] stack = new char[26];
        int top = -1;

        //bitmask
        int present = 0;

        for(char c: chars) {
            
            int idx = c - 'a';
            freq[idx]--;
            
            if ((present & (1 << idx)) != 0) continue;

            while(top > -1 && stack[top] > c 
                && freq[stack[top] - 'a'] > 0) {
                    present &= ~(1 << (stack[top] - 'a'));
                top--;
            }

            stack[++top] = c;
            present |= (1 << idx);
        }

        return new String(stack, 0, top + 1);
    }
}