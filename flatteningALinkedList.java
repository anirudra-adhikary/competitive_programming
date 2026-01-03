/*
Problem link - https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1

Flattening a Linked List
Difficulty: Medium

Given a linked list containing n head nodes where every node in the linked list contains two pointers:
(i) next points to the next node in the list.
(ii) bottom points to a sub-linked list where the current node is the head.
Each of the sub-linked lists nodes and the head nodes are sorted in ascending order based on their data. Flatten the linked list such that all the nodes appear in a single level while maintaining the sorted order.

Note:
1. ↓ represents the bottom pointer and → represents the next pointer.
2. The flattened list will be printed using the bottom pointer instead of the next pointer.


Constraints:
0 ≤ n ≤ 100
1 ≤ number of nodes in sub-linked list(mi) ≤ 50
1 ≤ node->data ≤ 10^4

Time Complexity: O(n * n * m)
Auxiliary Space: O(n)
*/


//Solution 1  (done by me)

class Solution {
    public Node flatten(Node root) {
        
        if(root == null)
            return root;
        
        ArrayList<Integer> flat = new ArrayList<>();
        
        Node horizontalTemp = root;
        
        while(horizontalTemp != null)
        {
            Node verticalTemp = horizontalTemp;
            while(verticalTemp != null)
            {
                flat.add(verticalTemp.data);
                verticalTemp = verticalTemp.bottom;
            }
            horizontalTemp = horizontalTemp.next;
        }
        
        Collections.sort(flat);
        
        Node head = null;
        Node temp = null;
        for(Integer item : flat)
        {
            Node newNode = new Node(item);
            
            if(head == null)
                head = newNode;
            else
                temp.bottom = newNode;
            
            temp = newNode;
        }
        
        return head;
    }
}


// Solution 2 
class Solution {
    public Node flatten(Node root) {
        
        if(root == null || root.next == null)
            return root;
            
        root.next = flatten(root.next);
        root = merge(root, root.next);
        return root;
    }   
    
    public Node merge(Node head1, Node head2) {
        
        Node dummy = new Node(-1);
        
        Node tail = dummy;
        
        while(head1!=null && head2!=null) {
            if(head1.data<=head2.data)
            {
                tail.bottom = head1;
                head1 = head1.bottom;
            }
            else
            {
                tail.bottom = head2;
                head2 = head2.bottom;
            }
            
            tail = tail.bottom;
        }
        
        if(head1 == null)
            tail.bottom = head2;
        else
            tail.bottom = head1;
            
        return dummy.bottom;
    }
}

// Solution 3
class Solution {
    public Node flatten(Node root) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.data, b.data));
        
        while(root != null) {
            pq.add(root);
            root = root.next;
        }
        
        Node head = null;
        Node tail = null;
        
        while(!pq.isEmpty())
        {
            Node minNode = pq.poll();
            
            if(head == null)
            {
                head = minNode;
                tail = minNode;
            }
            else
            {
                tail.bottom = minNode;
                tail = tail.bottom;
            }
            
            if(minNode.bottom != null)
            {
                pq.add(minNode.bottom);
                minNode.bottom = null;
            }
        }
        
        return head;
        
    }
}

