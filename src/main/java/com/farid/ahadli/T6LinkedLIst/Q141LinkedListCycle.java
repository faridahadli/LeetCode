package com.farid.ahadli.T6LinkedLIst;

import java.util.HashMap;
import java.util.HashSet;

public class Q141LinkedListCycle {
/*    *//**//**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */

    class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
    }

        public boolean hasCycle(ListNode head) {
            HashSet<ListNode> nodeSet = new HashSet<>();
            ListNode node = head;
            while(node!=null){
                if(nodeSet.contains(node)){
                    return true;
                }
                nodeSet.add(node);
                node = node.next;
            }
            return false;
        }

        /*

        solution with O1 space complexity!

        public boolean hasCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;         // moves 1 step
                fast = fast.next.next;    // moves 2 steps

                if (slow == fast) {       // pointers met → cycle exists
                    return true;
                }
            }
            return false;
        }



         */

   /* To find the exact point where the circle starts, we need to:
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        // Phase 1: detect meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return null; // no cycle

        // Phase 2: find cycle start
        // reset one pointer to head, keep other at meeting point
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next; // fast now moves 1 step too
        }

        return slow; // cycle start
    }
    */

}
