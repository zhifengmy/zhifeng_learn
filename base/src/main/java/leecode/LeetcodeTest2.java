package leecode;


/**
 * @author LuDas
 * @Description:给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @date 2018/10/11 18:53
 */
public class LeetcodeTest2 {

    public static void main(String[] args) {

        ListNode ln2 = new ListNode(2);
        ListNode ln4 = new ListNode(4);
        ListNode ln3 = new ListNode(3);
        ln2.next=ln4;
        ln4.next=ln3;
        print(ln2);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(6);
        ListNode ln8 = new ListNode(8);
        ln5.next=ln6;
        ln6.next=ln8;
        print(ln5);

        ListNode listNode = addTwoNumbers(ln2, ln5);

        print(listNode);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void print(ListNode head){
        ListNode cur=head;
        while (cur!=null){
            System.out.print(cur.val);
            cur=cur.next;
        }
        System.out.println("---------");
    }

}

class ListNode {

    int val;

    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
