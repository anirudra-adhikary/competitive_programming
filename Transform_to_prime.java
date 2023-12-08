/*
Problem link: https://www.geeksforgeeks.org/problems/transform-to-prime4635/1

Given an array of n integers. Find the minimum positive number to be inserted in array, so that sum of all elements of array becomes prime.

Example 1:

Input:
N=5
arr = {2, 4, 6, 8, 12}
Output:  
5
Explanation: 
The sum of the array is 32 ,we can add 5 to this to make it 37 which is a prime number.


Example 2:

Input:
N=3
arr = {1, 5, 7}
Output:  
0
Explanation: 
The sum of the array is 13 which is already prime. 


Your Task:
You don't need to read input or print anything. Your task is to complete the function minNumber() that takes array arr and integer N as input parameters and returns the minimum positive number to be inserted in the array so as to make it's sum a prime number.

Expected Time Complexity: O(N log(log N))
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 10^5
1 ≤ sum of all elements ≤ 10^6

Topic Tags : Arrays, Prime Number, sieve, Data Structures
*/

class Solution
{
    public int minNumber(int arr[], int N)
    {
        int sum = 0;
        
        for(int i=0;i<N;i++)
            sum += arr[i];
            
        return findSmallest(sum);
        
    }
    
    static int findSmallest(int n)
    {
        if(n==0)
            return 2;
            
        if(n==1)
            return 1;
        
        int num = 0;
        boolean flag = false;
        
        while(!flag)
        {
            if(isPrime(n+num))
                flag = true;
            else 
                num++;
            
        }
        
        return num;
    }
    
    static boolean isPrime(int n)
    {
        if(n<=1)
            return false;
        
        if(n<=3)
            return true;
        
        if(n%2==0 || n%3==0)
            return false;
            
        for(int i=5;i*i<=n;i+=6)
            if((n%i==0) || (n%(i+2)==0))
                return false;
        
        return true;
    }
    
}