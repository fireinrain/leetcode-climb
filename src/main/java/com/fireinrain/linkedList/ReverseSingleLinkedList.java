package com.fireinrain.linkedList;


import java.util.concurrent.ArrayBlockingQueue;

//翻转单链表
public class ReverseSingleLinkedList {

    /**
     * 翻转一个单链表
     * @param head
     * @return
     */
    public LinkNode reverse(LinkNode head) {
        LinkNode newHead = null;
        LinkNode currentHead = head;

        if (head == null || head.next == null) {
            return head;
        }

        while (currentHead != null) {
            LinkNode next = currentHead.next;
            currentHead.next = newHead;
            newHead = currentHead;
            currentHead = next;
        }

        return newHead;


    }


    public static void main(String[] args) throws InterruptedException {

        People xiaoqian = new People("xiaoqian", 12);
        People xiaolan = new People("xiaolan", 18);
        People ganggang = new People("ganggang", 23);
        People laobai = new People("laobai", 35);


        printLinkedList(makeLinkedList(xiaoqian, ganggang, laobai, xiaolan));

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(2);
        arrayBlockingQueue.put(1);
        arrayBlockingQueue.put(2);
        arrayBlockingQueue.put(3);
        System.out.println("finish");


    }


    /**
     * 构建单链表
     *
     * @param args
     * @return
     */
    public static <T> LinkNode makeLinkedList(T... args) {
        LinkNode<String> linkNode = new LinkNode();
        LinkNode temp = linkNode;

        for (T arg : args) {
            while (true) {
                if (temp.next == null) {
                    LinkNode<T> node = new LinkNode();
                    node.setValue(arg);
                    temp.next = node;
                    temp = temp.next;
                    break;
                }
            }
        }
        return linkNode;

    }

    // 打印链表路径
    public static <T> void printLinkedList(LinkNode<T> node) {
        if (node == null) {
            System.out.println(node);
        }
        StringBuilder builder = new StringBuilder();
        LinkNode<T> temp = node;
        while (true) {
            // 到结尾了
            if (temp.next == null) {
                builder.append(temp.value);
                break;
            }
            //最开始的头结点数值为null
            // if (temp.value == null) {
            //     builder.append(temp.hashCode());
            // } else {
            //     builder.append(temp.value);
            // }
            builder.append(temp.value);
            builder.append("->");

            temp = temp.next;

        }
        System.out.println(builder.toString());
    }


}


class People {
    String name;
    int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}

class LinkNode<T> {
    T value;
    LinkNode next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkNode{" + "value=" + value.toString() + ", next=" + next + '}';
    }
}
