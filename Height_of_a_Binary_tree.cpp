/*
 This is a problem from "Problem of the day" of GeeksForGeeks. Date - Oct 8, 2023

 Problem Link: https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1

Given a binary tree, find its height.

Example 1:

Input:
     1
    /  \
   2    3
   
Output: 2


Example 2:

Input:
  2
   \
    1
   /
 3

Output: 3   

Your Task:
You don't need to read input or print anything. Your task is to complete the function height() which takes root node of the tree as input parameter and returns an integer denoting the height of the tree. If the tree is empty, return 0. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= Number of nodes <= 10^5
1 <= Data of a node <= 10^9

Company Tags: VMWare, Zoho, Amazon, Microsoft, Snapdeal, D-E-Shaw, FactSet,MakeMyTrip Teradata,Synopsys,CouponDunia,Cadence India, Monotype Solutions, FreeCharge

Topic Tags: TreeData Structures
*/

class Solution{
    public:
    //Function to find the height of a binary tree.
    int height(struct Node* node){
        
        if(node==NULL)
            return 0;
            
        int l = height(node->left);
        int r = height(node->right);
        
        return 1 + max(l, r);
        
    }
};