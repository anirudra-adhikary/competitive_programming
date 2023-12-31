/*

Problem link: https://www.geeksforgeeks.org/problems/print-pattern3549/1


Print a sequence of numbers starting with N, without using loop, where replace N with N - 5, until N > 0. After that replace N with N + 5 until N regains its initial value.

Example 1:

Input: 
N = 16
Output: 
16 11 6 1 -4 1 6 11 16
Explaination: 
The value decreases until it is greater than 0. After that it increases and stops when it becomes 16 again.


Example 2:

Input: 
N = 10
Output: 
10 5 0 5 10
Explaination: It follows the same logic as per the above example.
Your Task:
You do not need to read input or print anything. Your task is to complete the function pattern() which takes N as input parameters and returns a list containing the pattern.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints: -10^5 ≤ N ≤ 10^5

Company Tags: Microsoft
Topic Tags: pattern-printing, Recursion, Algorithms

*/

Solution 1: 

class Solution{
public:

    vector<int> pattern(int N){
        
        vector<int> vect;
        
        if(N <= 0)
            vect.push_back(N);
        else
        {
            int n = decrease(vect, N);
            increase(vect, n+5, N);
        }
        
        return vect;
        
    }
    
    int decrease(vector<int> &vect, int N)
    {
        vect.push_back(N);
        
        if(N<=0)
            return N;
            
        int n = decrease(vect, N-5);
        
        return n;    
    }
    
    void increase(vector<int> &vect, int n, int N)
    {
        vect.push_back(n);
        
        if(n==N)
            return;
        
        increase(vect, n+5, N);
    }
};

Solution: 


class Solution{
public:

    vector<int> pattern(int N){
        
        vector<int> vect;
        
        if(N<=0)
            vect.push_back(N);
        
        else
        {
            vect.push_back(N);
            int flag = 0;
            solution(vect, N-5, N, flag);
        }
        
        return vect;
        
    }
    
    void solution(vector<int> &vect, int n, int N, int flag)
    {
        vect.push_back(n);
        
        if(n==N)
            return;
            
            
        if(n>0 && !flag)
            solution(vect, n-5, N, flag);
        else if(n<=0 && !flag)
        {
            flag = 1;
            solution(vect, n+5, N, flag);
        }
        else
            solution(vect, n+5, N, flag);
            
    }
 


