package src.main.java.org.example.ListNode;

import java.util.HashSet;

class ListNode {
    int val;
    ListNodeOne next;

    ListNode(int val) {
        this.val = val;
    }
}

public class RemoveDuplicates {

    public static void removeDuplicates(ListNodeOne head) {
        if (head == null) return;

        HashSet<Integer> seen = new HashSet<>();
        ListNodeOne current = head;
        seen.add(current.val);

        while (current.next != null) {
            if (seen.contains(current.next.val)) {
                // Если значение уже встречалось, удаляем следующий элемент
                current.next = current.next.next;
            } else {
                // Если значение новое, добавляем его в множество и переходим к следующему элементу
                seen.add(current.next.val);
                current = current.next;
            }
        }
    }

    public static void printList(ListNodeOne head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNodeOne head = new ListNodeOne(1);
        head.next = new ListNodeOne(2);
        head.next.next = new ListNodeOne(3);
        head.next.next.next = new ListNodeOne(2);
        head.next.next.next.next = new ListNodeOne(4);
        head.next.next.next.next.next = new ListNodeOne(1);

        System.out.println("Before removing duplicates:");
        printList(head);
        removeDuplicates(head);
        System.out.println("After removing duplicates:");
        printList(head);
    }
}