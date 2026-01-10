/*
Problem link - https://www.geeksforgeeks.org/problems/sandwiched-vowels5158/1

Sandwiched_Vowels
Difficulty: Basic

For a given string s comprising only lowercase English alphabets, eliminate the vowels from the string that occur between two consonants(sandwiched between two immediately adjacent consonants). Return the new string.

Examples:

Input : s = "bab"
Output : bb
Explanation: 'a' is a vowel occuring between two consonants i.e. b. Hence the updated string eliminates a.

Input : s = "ceghij"
Output : cghj
Explanation: 'e' and 'i' are sandwitched vowels.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ s.size() ≤ 106
'a' ≤ s[i] ≤ 'z'
*/


//Solution 
// User function Template for Java

class Complete {

    public static String Sandwiched_Vowel(String str) {
        
        if (str == null || str.length() <= 2) {
            return str;
        }
        
        int n = str.length();
        StringBuilder ans = new StringBuilder();
        ans.append(str.charAt(0));
        
        for(int i=1;i<n-1;i++)
        {
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);
            char next = str.charAt(i+1);
            
            if(isVowel(curr) && !isVowel(prev) && !isVowel(next)) {
                continue;
            }
            else
            {
                ans.append(curr);
            }
        }
        
        ans.append(str.charAt(n - 1));
        
        return ans.toString();
    }
    
    public static boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }
}