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
        ln2.setNext(ln4);
        ln4.setNext(ln3);

        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(6);
        ListNode ln8 = new ListNode(8);
        ln5.setNext(ln6);
        ln6.setNext(ln8);



        ListNode cal = cal(ln2, ln5);





    }

    public static ListNode cal(ListNode ln1, ListNode ln2) {

        while (ln1.getNext()!=null){


        }

        return null;
    }

}

class ListNode {

    private int value;

    private ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
