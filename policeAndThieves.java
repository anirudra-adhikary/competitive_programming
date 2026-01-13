/*
Problem link - https://www.geeksforgeeks.org/problems/police-and-thieves--141631/1

Police and Thieves
Difficulty: Medium
Given an array arr[], where each element contains either a 'P' for policeman or a 'T' for thief. Find the maximum number of thieves that can be caught by the police. 
Keep in mind the following conditions :
Each policeman can catch only one thief.
A policeman cannot catch a thief who is more than k units away from him.


Examples:

Input: arr[] = ['P', 'T', 'T', 'P', 'T'], k = 1
Output: 2
Explanation: Maximum 2 thieves can be caught. First policeman catches first thief and second police man can catch either second or third thief.


Input: arr[] = ['T', 'T', 'P', 'P', 'T', 'P'], k = 2
Output: 3
Explanation: Maximum 3 thieves can be caught.

Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ k ≤ 1000
arr[i] = 'P' or 'T'

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(1)
*/

//Solution 1
class Solution {
    public int catchThieves(char[] arr, int k) {
        ArrayList<Integer> policeList = new ArrayList<>();
        ArrayList<Integer> thiefList = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++)
            if(arr[i]=='T') thiefList.add(i);
            else policeList.add(i);
            
        int p = 0, t = 0;
        
        int count = 0;
        while(p<policeList.size() && t<thiefList.size())
        {
            int dist = Math.abs(policeList.get(p) - thiefList.get(t));
            
            if(dist<=k) {
                count++;
                p++;
                t++;
            }
            else if(policeList.get(p) < thiefList.get(t))
                p++;
            else
                t++;
        }
        
        return count;
    }
}


//Solution 2
class Solution {
    public int catchThieves(char[] arr, int k) {
        int n = arr.length;
        Queue<Integer> police = new LinkedList<>();
        Queue<Integer> thief = new LinkedList<>();
        
        for(int i=0;i<n;i++)
            if(arr[i]=='T')
                thief.add(i);
            else
                police.add(i);
                
        int count = 0;
        
        while(!police.isEmpty() && !thief.isEmpty())
        {
            int policePos = police.peek();
            int thiefPos = thief.peek();
            int dist = Math.abs(policePos - thiefPos);
            
            if(dist<=k) {
                count++;
                police.poll();
                thief.poll();
            }
            else if(policePos < thiefPos)
                police.poll();
            else
                thief.poll();
        }
        
        return count;
    }
}

//Solution 3
class Solution {
    public int catchThieves(char[] arr, int k) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        int count = 0;
        
        while(i<n && j<n)
        {
            while(i<n && arr[i]!='P') i++;
            while(j<n && arr[j]!='T') j++;
            
            if(i<n && j<n && Math.abs(i-j) <= k)
            {
                count++;
                i++;
                j++;
            }
            else if(i<n && i<j)
                i++;
            else
                j++;
        }
        
        return count;
    }
}