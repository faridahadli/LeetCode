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
    }
}