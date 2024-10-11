package src.main.java.org.example.ListNode;

class ListNodeOne {
    int val;
    ListNodeOne next;

    ListNodeOne(int val) {
        this.val = val;
    }
}

public class FindMiddle {
    public static ListNodeOne findMiddle(ListNodeOne head) {
        if (head == null) return null;

        ListNodeOne slow = head;
        ListNodeOne fast = head;

        // Используем два указателя: slow и fast
        while (fast != null && fast.next != null) {
            slow = slow.next;        // двигаем slow на один элемент
            fast = fast.next.next;  // двигаем fast на два элемента
        }

        // Когда fast дойдет до конца, slow будет указывать на средний элемент
        return slow;
    }

    public static void main(String[] args) {
        ListNodeOne head = new ListNodeOne(1);
        head.next = new ListNodeOne(2);
        head.next.next = new ListNodeOne(3);
        head.next.next.next = new ListNodeOne(4);
        head.next.next.next.next = new ListNodeOne(5);

        ListNodeOne middle = findMiddle(head);
        System.out.println("Middle element: " + middle.val);
    }
}