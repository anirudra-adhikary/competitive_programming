/*
Problem link - https://www.geeksforgeeks.org/problems/minimum-time-to-fulfil-all-orders/1

Minimum time to fulfil all orders
Difficulty: Hard

Geek is organizing a party at his house. For the party, he needs exactly n donuts for the guests. Geek decides to order the donuts from a nearby restaurant, which has m chefs and each chef has a rank r.
A chef with rank r can make 1 donut in the first r minutes, 1 more donut in the next 2r minutes, 1 more donut in the next 3r minutes, and so on.
For example, a chef with rank 2, can make one donut in 2 minutes, one more donut in the next 4 minutes, and one more in the next 6 minutes. So, it take 2 + 4 + 6 = 12 minutes to make 3 donuts. A chef can move on to making the next donut only after completing the previous one. All the chefs can work simultaneously.
Since, it's time for the party, Geek wants to know the minimum time required in completing n donuts. Return an integer denoting the minimum time.

Examples:

Input: n = 10, rank[] = [1, 2, 3, 4]
Output: 12
Explanation: 
Chef with rank 1, can make 4 donuts in time 1 + 2 + 3 + 4 = 10 mins
Chef with rank 2, can make 3 donuts in time 2 + 4 + 6 = 12 mins
Chef with rank 3, can make 2 donuts in time 3 + 6 = 9 mins
Chef with rank 4, can make 1 donuts in time = 4 minutes
Total donuts = 4 + 3 + 2 + 1 = 10 and total time = 12 minutes.

Input: n = 8, rank[] = [1, 1, 1, 1, 1, 1, 1, 1]
Output: 1
Explanation: As all chefs are ranked 1, so each chef can make 1 donuts in 1 min.
Total donuts = 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 = 8 and total time = 1 minute.

Constraints:
1 ≤ n ≤ 10^3
1 ≤ m ≤ 10^4
1 ≤ rank[i] ≤ 100

Expected Complexities
Time Complexity: O(m * log n)
Auxiliary Space: O(1)
*/

// Solution 1
class Solution {
    public int minTime(int[] ranks, int n) {
        int minRank = ranks[0];
        
        for(int rank : ranks)
            minRank = Math.min(rank, minRank);
    
        int low = 0;    
        int high = minRank * n * (n+1)/2;  
        int ans = high;
    
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(canMake(ranks, n, mid))
            {
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return ans;
    }
    
    public boolean canMake(int[] ranks, int n, int currTime) {
        int count = 0;
        int l = ranks.length;
        
        for(int i=0;i<l;i++) {
            int timeConsumed = 0;
            int cost = ranks[i];
            
            while(timeConsumed + cost <=currTime)
            {
                count++;
                timeConsumed += cost;
                cost += ranks[i];
            }
        }
        
        return count>=n;
    }
}

// Solution 2
class Solution {
    public int minTime(int[] ranks, int n) {
        int minRank = ranks[0];
        
        for(int rank : ranks)
            minRank = Math.min(rank, minRank);
    
        int low = 0;    
        int high = minRank * n * (n+1)/2;  
        int ans = high;
    
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(canMake(ranks, n, mid))
            {
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return ans;
    }
    
    public boolean canMake(int[] ranks, int n, int currTime) {
        int total = 0;
        
        for(int rank : ranks) {
            double D = 1.0 + 8.0 * currTime / (double) rank;
            int currCapacity = (int)((-1 + Math.sqrt(D))/2.0);
            total += currCapacity;
            if(total >= n)
                return true;
        }
        
        return false;
    }
}