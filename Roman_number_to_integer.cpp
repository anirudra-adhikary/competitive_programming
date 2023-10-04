/*
This is a problem from "Problem of the day" of GeeksForGeeks. Date - Oct 4, 2023

Problem link - https://practice.geeksforgeeks.org/problems/roman-number-to-integer3201/1

Given a string in roman no format (s)  your task is to convert it to an integer . Various symbols and their values are given below.
I 1
V 5
X 10
L 50
C 100
D 500
M 1000



Example 1:

Input:
s = V
Output: 5



Example 2:

Input:
 s = III 
Output: 3


Your Task:
Complete the function romanToDecimal() which takes a string as input parameter and returns the equivalent decimal number. 

Expected Time Complexity: O(|S|), |S| = length of string S.
Expected Auxiliary Space: O(1)

Constraints:
1<=roman no range<=3999

Company Tags : Zoho, Amazon, Microsoft, Facebook, Twitter
Topic Tags : Strings, Data Structures

*/

//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function template for C++

class Solution {
  public:
    int romanToDecimal(string &str) {
        int val = 0;
        
        for(int i=0;str[i]!='\0';i++)
        {
            if(str[i] == 'M')
                val += 1000;
            else if(str[i] == 'D')
                val += 500;
            else if(str[i] == 'C')
            {
                if(str[i+1] == 'D' || str[i+1] == 'M')
                    val -= 100;
                else
                    val += 100;
            }
            else if(str[i] == 'L')
                val += 50;
            else if(str[i] == 'X')
            {
                if(str[i+1]=='L' || str[i+1]=='C')
                    val -= 10;
                else
                    val += 10;
            }
            else if(str[i] == 'V')
                val += 5;
            else
            {
                if(str[i+1] == 'V' || str[i+1] == 'X')
                    val--;
                else
                    val++;
            }
            
        }
        
        return val;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        Solution ob;
        cout << ob.romanToDecimal(s) << endl;
    }
}
// } Driver Code Ends