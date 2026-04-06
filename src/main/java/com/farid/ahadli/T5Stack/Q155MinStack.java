package com.farid.ahadli.T5Stack;

import java.util.Deque;
import java.util.LinkedList;

public class Q155MinStack {



    class MinStack {
        class Node{

            int value;
            Node next;

            Node(int value){
                this.value = value;
            }

        }
        Node top;
        Deque<Node> minStack = new LinkedList<>();
        int size = 0;
        public MinStack() {

        }

        public void push(int val) {
            Node newNode = new Node(val);
            if(size == 0){
                top = newNode;
                minStack.addFirst(top);
            }else {
                newNode.next = top;
                top = newNode;
                if(top.value < minStack.getFirst().value ){
                    minStack.addFirst(top);
                }else {
                    minStack.addFirst(minStack.getFirst());
                }
            }
            size ++;
        }

        public void pop() {
            minStack.removeFirst();
            Node nodeToRemove = top;
            top = nodeToRemove.next;
            nodeToRemove.next = null;
            size -- ;
        }

        public int top() {
            return top.value;
        }

        public int getMin() {
            return minStack.getFirst().value;
        }
    }

    /*
    The two-stack approach uses O(n) extra space for the auxiliary stack. A strong candidate
    proactively mentions this and ideally knows the optimized approach
    (store (value, currentMin) pairs in one stack, or only push to the min stack when
    a new minimum is found).
     */

    /*
    3. One Stack
Intuition
This approach keeps only one stack and stores encoded values instead of the actual numbers.
The trick is to record the difference between the pushed value and the current minimum.
Whenever a new minimum is pushed, we store a negative encoded value, which signals that the minimum has changed.
Later, when popping such a value, we can decode it to restore the previous minimum.

This way, the stack internally keeps track of all minimum updates without needing a second stack — giving constant-time operations with minimal space.

Algorithm
Maintain:
stack → stores encoded values (not the actual numbers)
min → stores the current minimum in the stack
Push(val):
If the stack is empty:
Push 0 (difference) and set min = val.
Otherwise:
Push val - min.
If val is the new minimum, update min.
Pop():
Pop the encoded value.
If this value is negative, it means the popped element was the minimum.
Restore the previous minimum using the encoded difference.
Top():
If the encoded value is positive, return encoded + min.
If it's negative, the top actual value is simply min.
getMin():
Return the current min.
     */
}
