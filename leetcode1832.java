/*
Problem link - https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/  

Check if the Sentence Is Pangram (Easy)

A pangram is a sentence where every letter of the English alphabet appears at least once.
Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

 

Example 1:
Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.


Example 2:
Input: sentence = "leetcode"
Output: false
 

Constraints:

1 <= sentence.length <= 1000
sentence consists of lowercase English letters


*/


// Solution 1 (done by me)
class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] freq = new int[26];

        for(char c: sentence.toCharArray())
            freq[c-'a']++;

        for(int item : freq)
            if(item == 0)
                return false;
        
        return true;
    }
}

// Solution 2 (bit-masking)
class Solution {
    public boolean checkIfPangram(String sentence) {
        int mask = 0;
        for(int i=0;i<sentence.length();i++)
            mask |= 1 << (sentence.charAt(i) - 'a');
        return mask == (1<<26) - 1;
    }
}
