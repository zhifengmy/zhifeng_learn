package com.ludas.linkedlist;

/**
* @Description:单向链表反转
* @author KyLin
* @date 2018/10/10 19:59
*/
public class LinkedListReverse {


    /**
     * 1->2->3->4->5->NULL
     * 1->2->3->4->5->NULL
     */

    public static void main(String[] args) {

        Node node = new Node();
        node.setValue(1);
        Node node2 = new Node();
        node2.setValue(2);
        node.setNextNode(node2);
        Node node3 = new Node();
        node3.setValue(3);
        node2.setNextNode(node3);
        Node node4 = new Node();
        node4.setValue(4);
        node3.setNextNode(node4);
        Node node5 = new Node();
        node5.setValue(5);
        node4.setNextNode(node5);

        reverse(node);

       while (true){
           System.out.println(node.getValue()+"");
           if(node.getNextNode()==null){
               break;
           }
           node=node.getNextNode();
       }


    }


    public static void reverse(Node node){


    }

}
