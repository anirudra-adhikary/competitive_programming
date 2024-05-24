/*
Problem link: https://www.geeksforgeeks.org/problems/remove-vowels-from-string1446/1

Given a string, remove the vowels from the string.

Example 1:
Input: S = "welcome to geeksforgeeks"
Output: wlcm t gksfrgks

Example 2:
Input: S = "what is your name ?"
Output: wht s yr nm ?


Your task is to complete the function removeVowels() which takes a single string as input and returns the modified string. You need not take any input or print anything.

Expected Time Complexity: O(|s|)
Expected Auxiliary Space: O(1)

Constraints:
1 <= |S| <= 10^5
Alphabets are lower cases only

Company Tags: GE
Topic Tags: Strings, Data Structures
 */


 class Solution {
    String removeVowels(String s) {
        return s.replaceAll("[aeiou]", "");
    }
}