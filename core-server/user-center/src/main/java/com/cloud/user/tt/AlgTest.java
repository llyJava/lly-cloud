package com.cloud.user.tt;

/**
 * @Description: TODO
 * @Author luoliyin
 * @Date 2020/7/29
 **/
public class AlgTest {
    public static void main(String[] args) {

    }

    public void  sort(){
        int[] arr = {5,2,52,14,1};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j]<arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(arr);
    }

    public static void reversetList(Node headNode)
    {
        if(headNode.next == null || headNode.next.next == null) {
            return;
        }
        Node reversetNode= new Node(0,"");//1
        Node currentNode= headNode.next;
        Node nextNode= null;
        while(currentNode != null) {
            nextNode = currentNode.next;//记录一下即将要变动的节点后的next
            currentNode.next = reversetNode.next;//2当前节点的下一节点指向链表最前端(reversetNode.next即为链表的最前端)
            reversetNode.next = currentNode;//将当前节点连接到新链表上
            currentNode = nextNode;//当前节点后移
        }
        headNode.next = reversetNode.next;//3
    }
}
class Node{
    Node next;
    int no;
    String name;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }
}
