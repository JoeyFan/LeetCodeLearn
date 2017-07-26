package com.fqh.learn.AddTwoNum;

/**
 * Definition for singly-linked list.
 * 研究题目以后第一个想法就是递归实现
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        int l1Val = 0;
        int l2Val = 0;
        boolean l1Flag = false;
        boolean l2Flag = false;
        if (l1 != null) {
            l1Val = l1.val;
            l1Flag = true;
        }
        if (l2 != null) {
            l2Val = l2.val;
            l2Flag = true;
        }

        ListNode l1Next = null, l2Next = null;
        int sum = l1Val + l2Val;
        if (sum >= 10) {
            sum = sum % 10;
            if (l1 != null && l1.next != null) {
                l1.next.val += 1;
            } else if (l2 != null && l2.next != null) {
                l2.next.val += 1;
            } else {
                if (l1Flag) {
                    l1.next = new ListNode(1);
                } else if (l2Flag) {
                    l2.next = new ListNode(1);
                }
            }
        }
        if (l1 != null && l1.next != null) {
            l1Next = l1.next;
        }
        if (l2 != null && l2.next != null) {
            l2Next = l2.next;
        }
        ListNode result = new ListNode(sum);
        result.next = addTwoNumbers(l1Next, l2Next);//递归
        return result;
    }


    public static void main(String[] argus) {
       /* ListNode l1 = new ListNode(2);
        ListNode l1_1 = new ListNode(9);
        l1.next = l1_1;
        ListNode l1_2 = new ListNode(3);
        l1_1.next = l1_2;
        System.out.println(l1);
        ListNode l2 = new ListNode(5);
        ListNode l2_1 = new ListNode(6);
        l2.next = l2_1;
        ListNode l2_2 = new ListNode(3);
        l2_1.next = l2_2;
        ListNode l2_3 = new ListNode(3);
        l2_2.next = l2_3;
        System.out.println(l2);*/
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        ListNode l2_1 = new ListNode(9);
        l2.next = l2_1;

        ListNode result = new Solution().addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}

