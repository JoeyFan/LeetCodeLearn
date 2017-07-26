package com.fqh.learn.AddTwoNum;

public class ListNode {
   public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "(" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}