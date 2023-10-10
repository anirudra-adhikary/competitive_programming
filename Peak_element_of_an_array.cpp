/*
Problem Link: https://practice.geeksforgeeks.org/problems/peak-element/1

An element is called a peak element if its value is not smaller than the value of its adjacent elements(if they exists).

Given an array arr[] of size N, Return the index of any one of its peak elements.
Note: The generated output will always be 1 if the index that you return is correct. Otherwise output will be 0. 


Example 1:

Input: 
N = 3
arr[] = {1,2,3}
Possible Answer: 2
Generated Output: 1
Explanation: index 2 is 3.
It is the peak element as it is 
greater than its neighbour 2.
If 2 is returned then the generated output will be 1 else 0.



Example 2:

Input:
N = 3
arr[] = {3,4,2}
Possible Answer: 1
Output: 1
Explanation: 4 (at index 1) is the 
peak element as it is greater than 
it's neighbor elements 3 and 2.
If 1 is returned then the generated output will be 1 else 0.
 

Your Task:
You don't have to read input or print anything. Complete the function peakElement() which takes the array arr[] and its size N as input parameters and return the index of any one of its peak elements.


Expected Time Complexity: O(log N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 10^5
1 ≤ A[] ≤ 10^6

Company Tags: Accolite, Amazon, Visa, Adobe, Google
Topic Tags: Arrays, Searching, Data Structures, Algorithms
*/



/* The function should return the index of any
   peak element present in the array */

// arr: input array
// n: size of array
class Solution
{
    public:
    int peakElement(int arr[], int n)
    {
        if(n==1)
            return 0;
        if(arr[0]>=arr[1])
            return 0;
        if(arr[n-1]>=arr[n-2])
            return n-1;
            
        for(int i=1;i<n-1;i++)
        {
            if((arr[i]>=arr[i+1]) && (arr[i] >= arr[i-1]))
                return i;
        }
    }
};
