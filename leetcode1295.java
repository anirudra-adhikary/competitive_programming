/*
Problem link - 

Find Numbers with Even Number of Digits (Easy)

Given an array nums of integers, return how many of them contain an even number of digits.


Example 1:

Input: nums = [12,345,2,6,7896]
Output: 2
Explanation: 
12 contains 2 digits (even number of digits). 
345 contains 3 digits (odd number of digits). 
2 contains 1 digit (odd number of digits). 
6 contains 1 digit (odd number of digits). 
7896 contains 4 digits (even number of digits). 
Therefore only 12 and 7896 contain an even number of digits.


Example 2:

Input: nums = [555,901,482,1771]
Output: 1 
Explanation: 
Only 1771 contains an even number of digits.
 

Constraints:

1 <= nums.length <= 500
1 <= nums[i] <= 10^5
*/

//Solution 1:
class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for(int item : nums)
            if(noOfDigit(item))
                res++;
        return res;
    }

    public boolean noOfDigit(int num) {
        int count = 0;
        while(num > 0) {
            count++;
            num /= 10;
        }

        return (count & 1) == 0;
    }
}

//Solution 2: (using log10 to find the number of digits )
class Solution {
    public int findNumbers(int[] nums) {
        
        int res = 0;
        for(int item : nums) {
            int count = (int)Math.log10(item) + 1;
            if((count & 1) == 0)
                res++;
        }

        return res;
    }
}

//Solution 3: (using leetcode constraints to hardcode the conditions to find even digits)
class Solution {
    public int findNumbers(int[] nums) {
        
        int res = 0;
        for(int item : nums) {
            if ((item>= 10 && item<100) || 
                (item >= 1000 && item < 10000) ||
                (item == 100000))
                    res++;
        }

        return res;
    }
}

//Solution 4: (using string conversion)
class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for(int item : nums)
            if(noOfDigit(item))
                res++;
        return res;
    }

    public boolean noOfDigit(int num) {
        return (String.valueOf(num).length() & 1) == 0;
    }
}