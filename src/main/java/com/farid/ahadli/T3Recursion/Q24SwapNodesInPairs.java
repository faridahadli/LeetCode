package com.farid.ahadli.T3Recursion;

// https://leetcode.com/problems/swap-nodes-in-pairs/description/?envType=problem-list-v2&envId=recursion
public class Q24SwapNodesInPairs {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {

          public ListNode swapNode( ListNode node){
              if(node == null){
                  return null;
              }
              if(node.next == null){
                  return node;
              }
              ListNode second = node.next;
              ListNode third = second.next;
              second.next = node;
              node.next =  swapNode(third);
              return second;
          }

          public ListNode swapPairs(ListNode head) {
            return swapNode(head);
          }

     /*
     cleanest solution.
     public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode second = head.next;
            ListNode third = second.next;
            second.next = head;
            head.next = swapPairs(third);
            return second;
        }
        */
    }
}
