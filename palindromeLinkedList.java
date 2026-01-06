/*

Problem link - https://www.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1

Palindrome Linked List
Difficulty: Medium

You are given the head of a singly linked list of positive integers. You have to check if the given linked list is palindrome or not.

Examples:
Given linked list: 1 -> 2 -> 1 -> 1 -> 2 -> 1
Output: true

Examples:
Given linked list : 10 -> 20 -> 30 -> 40 -> 50
Output: false

*/

/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/


// Solution 1 (done by me)
class Solution {
    public boolean isPalindrome(Node head) {
        int left = 0;
        
        Node temp = head;
        
        while(temp != null)
        {
            left *= 10;
            left += temp.data;
            temp = temp.next;
        }
        
        temp = reverse(head);
        
        int right = 0;
        
        while(temp != null)
        {
            right *= 10;
            right += temp.data;
            temp = temp.next;
        }
        
        return (right == left);
        
    }
    
    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}

//Solution 2 (done by me)
class Solution {
    public boolean isPalindrome(Node head) {
        int left = 0;
        int right = 0;
        int x10 = 1;
        
        Node temp = head;
        
        while(temp != null)
        {
            left *= 10;
            left += temp.data;
            
            if(right != 0) {
                x10 *= 10;
                right = (temp.data * x10) + right;
            }
            else 
                right = temp.data;
                
            temp = temp.next;
        }
        
        return (right == left);
        
    }
}

//Solution 3 (done by me)
class Solution {
    public boolean isPalindrome(Node head) {
        
        Node temp = reverseAndClone(head);
        
        while((head != null) && (temp != null))
        {
            if(head.data != temp.data)
                return false;
            
            head = head.next;
            temp = temp.next;
        }
        
        return true;
        
    }
    
    public Node reverseAndClone(Node head) {
        Node newHead = null;
        Node curr = head;
        
        while(curr != null) {
            Node newNode = new Node(curr.data);
            newNode.next = newHead;
            newHead = newNode;
            curr = curr.next;
        }
        
        return newHead;
    }
}

//Solution 4 
class Solution {
    public boolean isPalindrome(Node head) {
        Stack<Integer> s = new Stack<>();
        Node curr = head;
        
        while(curr != null)
        {
            s.push(curr.data);
            curr = curr.next;
        }
        
        while(head != null) {
            if(head.data != s.pop())
                return false;
            head = head.next;
        }
        
        return true;
    }
}

//Solution 5 
class Solution {
    public boolean isPalindrome(Node head) {
        Node[] start = new Node[]{head};
        return train(head, start);
    }
    
    public boolean train(Node end, Node[] start) {
        
        if(end == null) return true;
        
        boolean deep = train(end.next, start);
        boolean ans = deep && (start[0].data == end.data);
        
        start[0] = start[0].next;
        
        return ans;
    }
}