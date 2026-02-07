/*
Problem link - https://www.geeksforgeeks.org/problems/happiest-triplet2921/1

Happiest Triplet
Difficulty: Medium

You are given three arrays a[], b[], c[] of the same size . Find a triplet such that (maximum-minimum) in that triplet is the minimum of all the triplets. A triplet should be selected so that it should have one number from each of the three given arrays. This triplet is the happiest among all the possible triplets. Print the triplet in decreasing order.
Note: If there are 2 or more smallest difference triplets, then the one with the smallest sum of its elements should be displayed.



Examples:

Input: a[] = [5, 2, 8] , b[] = [10, 7, 12] , c[] = [9, 14, 6]
Output: [7, 6, 5]
Explanation: The triplet [5, 7, 6]  has difference (maximum - minimum)= (7 - 5) = 2 which is minimum of all triplets.  


Input: a[] = [15, 12, 18, 9] , b[] = [10, 17, 13, 8] , c[] = [14, 16, 11, 5]
Output: [11, 10, 9]
Explanation: Multiple triplets have the same minimum difference, and among them [11, 10, 9] has the smallest sum, so it is chosen.

Constraints:
1 ≤ a.size(), b.size() ,c.size() ≤ 10^5
1 ≤ a[i], b[i], c[i] ≤ 10^5

Expected Complexities
Time Complexity: O(n log n)
Auxiliary Space: O(1)
*/

//Solution 1 (done by by)
class Solution {
    int[] smallestDiff(int arr1[], int arr2[], int arr3[]) {
        
        int n = arr1.length;
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);
        
        int i = 0;
        int j = 0;
        int k = 0;

        int[] res = new int[3];
        int minSize = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        
        while((i<n) && (j<n) && (k<n)) {
            int a = arr1[i];
            int b = arr2[j];
            int c = arr3[k];
            
            int min, mid, max;

            if (a <= b) {
                if (b <= c) {
                    min = a; mid = b; max = c;
                    i++;
                } else if (a <= c) {
                    min = a; mid = c; max = b;
                    i++;
                } else {
                    min = c; mid = a; max = b;
                    k++;
                }
            } else {
                if (a <= c) {
                    min = b; mid = a; max = c;
                    j++;
                } else if (b <= c) {
                    min = b; mid = c; max = a;
                    j++;
                } else {
                    min = c; mid = b; max = a;
                    k++; 
                }
            }
        
            
            if(max - min < minDiff || 
                ( (max - min == minDiff) && (min + mid + max < minSize)))
            {
                res[0] = max;
                res[1] = mid;
                res[2] = min;
                
                minDiff = max - min;
                minSize = min + mid + max;
            }
            
        }
        
        return res;
        
    }
}


//Solution 2 (same logic but cleaner)
class Solution {
    int[] smallestDiff(int arr1[], int arr2[], int arr3[]) {
        
        int n = arr1.length;
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);
        
        int i = 0;
        int j = 0;
        int k = 0;

        int[] res = new int[3];
        int minSize = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        
        while((i<n) && (j<n) && (k<n)) {
            int a = arr1[i];
            int b = arr2[j];
            int c = arr3[k];
            
            int min = Math.min(a, Math.min(b, c));
            int max = Math.max(a, Math.max(b, c));
            
            if(max - min < minDiff || 
                ( (max - min == minDiff) && (a + b + c < minSize)))
            {
                res[0] = max;
                res[1] = (a + b + c) - (max + min);
                res[2] = min;
                
                minDiff = max - min;
                minSize = a + b + c;
            }
            
            if(min == a) i++;
            else if(min == b) j++;
            else k++;
            
        }
        
        return res;
        
    }
}

//solution 3 - removing a redundant part
class Solution {
    int[] smallestDiff(int arr1[], int arr2[], int arr3[]) {
        
        int n = arr1.length;
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);
        
        int i = 0;
        int j = 0;
        int k = 0;

        int[] res = new int[3];
        int minSize = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        
        while((i<n) && (j<n) && (k<n)) {
            int a = arr1[i];
            int b = arr2[j];
            int c = arr3[k];
            
            int min = Math.min(a, Math.min(b, c));
            int max = Math.max(a, Math.max(b, c));
            
            if(max - min < minDiff)
            {
                res[0] = max;
                res[1] = (a + b + c) - (max + min);
                res[2] = min;
                
                minDiff = max - min;
                minSize = a + b + c;
            }
            
            if(min == a) i++;
            else if(min == b) j++;
            else k++;
            
        }
        
        return res;
        
    }
}
