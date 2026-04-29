package com.farid.ahadli.T6LinkedLIst;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Q143ReorderList {
    class ListNode {
        int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public void reorderList(ListNode head) {
        Deque<ListNode> nodeQueue = new ArrayDeque<>();
        Deque<ListNode> nodeStack = new ArrayDeque<>();
        int listLength = 0;
        ListNode node = head;
        while (node!=null){
            node=node.next;
            listLength++;
        }
        int mid = (int) Math.ceil((listLength+0f)/2);
        int counter = 0;
        node = head;
        while(counter < mid){
            nodeQueue.add(node);
            node = node.next;
            counter++;
        }
        while(node!=null){
            nodeStack.push(node);
            node=node.next;
        }
        counter = 0;
        ListNode last = nodeStack.peek();
        while(counter<mid){
            ListNode first = nodeQueue.remove();
            ListNode second = nodeStack.pollFirst();
            first.next = second;
            if(counter!=0){
                last.next = first;
            }
            last = second;
            counter++;
        }
        if(last!=null){
            last.next = null;
        }

    }
}
