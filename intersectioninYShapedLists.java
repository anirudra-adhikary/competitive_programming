/*
Problem link - https://www.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1

Intersection in Y Shaped Lists
Difficulty: Medium

You are given the heads of two non-empty singly linked lists, head1 and head2, that intersect at a certain point. Return that Node where these two linked lists intersect.
Note: It is guaranteed that the intersected node always exists.

Examples:

Input: head1: 10 -> 15 -> 30, head2: 3 -> 6 -> 9 -> 15 -> 30
Output: 15
Explanation: From the above image, it is clearly seen that the common part is 15 -> 30, whose starting point is 15.
    
Input: head1: 4 -> 1 -> 8 -> 5, head2: 5 -> 6 -> 1 -> 8 -> 5
Output: 1
Explanation: From the above image, it is clearly seen that the common part is 1 -> 8 -> 5, whose starting point is 1.
    
Constraints:
2 ≤ total number of nodes ≤ 2*10^5
-10^4 ≤ node->data ≤ 10^4
*/

//Solution 1
class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        
        HashSet<Node> visited = new HashSet<>();
        
        while(head1 != null)
        {
            visited.add(head1);
            head1 = head1.next;
        }
        
        while(head2 != null)
        {
            if(visited.contains(head2))
                return head2;
            head2 = head2.next;
        }
        
        return null;
    }
}