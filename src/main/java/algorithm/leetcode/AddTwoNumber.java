package algorithm.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumber {


    public static ListNode addTwoNumber(ListNode l1, ListNode l2) {
        int remain = 0;
        int sum = 0;
        int a, b;
        ListNode ans = null;
        ListNode index = null;
        while (l1 != null || l2 != null) {
            a = l1 != null ? l1.val : 0;
            b = l2 != null ? l2.val : 0;
            sum = a + b + remain;
            remain = sum / 10;
            ListNode node = new ListNode(sum % 10);
            if (ans == null) {
                ans = index = node;
            } else {
                index.next = node;
                index = index.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (remain != 0) {
            ListNode node = new ListNode(remain);
            index.next = node;
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] arr1 = {2, 4, 3};
        int[] arr2 = {5, 6, 4};
        ListNode l1 = ListNode.generate(arr1);
        ListNode l2 = ListNode.generate(arr2);
        ListNode sum = addTwoNumber(l1, l2);
        l1.print();
        l2.print();
        sum.print();
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    static ListNode generate(int[] arr) {
        ListNode list = new ListNode(arr[0]);
        ListNode tail = list;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }
        return list;
    }

    void print() {
        ListNode index = this;
        StringBuilder builder = new StringBuilder();
        while (index != null) {
            builder.append(index.val);
            if (index.next != null) {
                builder.append(" -> ");
            }
            index = index.next;
        }
        System.out.println(builder);
    }
}
