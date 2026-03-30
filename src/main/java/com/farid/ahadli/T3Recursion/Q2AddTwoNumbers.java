package com.farid.ahadli.T3Recursion;

import java.nio.file.Paths;

public class Q2AddTwoNumbers {


       class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    class Solution {

           public ListNode addNum( ListNode l1, ListNode l2, int remaining){
               if(l2 == null && l1 == null){
                   if(remaining>0){
                       return new ListNode(remaining%10, addNum( null, null,remaining/10 ) );
                   } else {
                       return null;
                   }
               }
               if(l1 == null){
                   int[] res = addNum((l2.val),remaining);
                  return new ListNode(res[0], addNum( null, l2.next, res[1]) );
               }
               if(l2 == null){
                   int[] res = addNum((l1.val),remaining);
                   return new ListNode(res[0] , addNum(l1.next, null,res[1])) ;
               }
               int[] res =  addNum(l1.val,l2.val+remaining);
               return new ListNode(res[0] , addNum( l1.next, l2.next,res[1]));

           }

           private int[] addNum(int i, int j ){
               int sum = i+j;
               return new int[]{sum%10, sum/10};
           }

           public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
               return addNum( l1, l2,0);
           }

           // better solution
        // collapses all branches to single one
/*           class Solution {
               private int[] addDigits(int i, int j) {
                   int sum = i + j;
                   return new int[]{sum % 10, sum / 10};
               }

               private ListNode addNum(ListNode l1, ListNode l2, int carry) {
                   if (l1 == null && l2 == null) {
                       return carry > 0 ? new ListNode(carry) : null;
                   }

                   int v1 = (l1 != null) ? l1.val : 0;
                   int v2 = (l2 != null) ? l2.val : 0;
                   ListNode next1 = (l1 != null) ? l1.next : null;
                   ListNode next2 = (l2 != null) ? l2.next : null;

                   int[] res = addDigits(v1, v2 + carry);
                   return new ListNode(res[0], addNum(next1, next2, res[1]));
               }

               public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                   return addNum(l1, l2, 0);
               }
           }*/
    }
}