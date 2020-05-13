package linkedlist;

/**
* @Description:单向链表反转
* @author KyLin
* @date 2018/10/10 19:59
*/
public class LinkedListReverse {


    /**
     * 1->2->3->4->5->NULL
     */

    public static void main(String[] args) {

        Node node = new Node();
        node.value=1;
        Node node2 = new Node();
        node2.value=2;
        node.next=node2;
        Node node3 = new Node();
        node3.value=3;
        node2.next=node3;
        Node node4 = new Node();
        node4.value=4;
        node3.next=node4;
        Node node5 = new Node();
        node5.value=5;
        node4.next=node5;

        reverse(node);

       while (true){
           System.out.println(node.value+"");
           if(node.next==null){
               break;
           }
           node=node.next;
       }


    }


    public static Node reverse(Node head){
        //申请节点，pre和 cur，pre指向null
        Node pre = null;
        Node cur = head;
        Node tmp = null;
        while(cur!=null) {
            //记录当前节点的下一个节点
            tmp = cur.next;
            //然后将当前节点指向pre
            cur.next = pre;
            //pre和cur节点都前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;

    }

}
