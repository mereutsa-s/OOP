package src.main.java.org.example.ListNode;

class ListNodeTwo {
    int val;
    ListNodeTwo next;

    ListNodeTwo(int val) {
        this.val = val;
    }
}

public class MergeSortedLists {
    public static ListNodeTwo mergeTwoLists(ListNodeTwo l1, ListNodeTwo l2) {
        // Создаем "виртуальный" узел для упрощения слияния
        ListNodeTwo dummy = new ListNodeTwo(0);
        ListNodeTwo current = dummy;

        // Сравниваем элементы двух списков и добавляем меньший в результирующий список
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1; // Присоединяем узел l1 к результирующему списку
                l1 = l1.next;      // Переход к следующему элементу l1
            } else {
                current.next = l2; // Присоединяем узел l2 к результирующему списку
                l2 = l2.next;      // Переход к следующему элементу l2
            }
            current = current.next; // Переход к следующему узлу в результирующем списке
        }

        // Присоединяем оставшиеся узлы (если такие есть)
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        // Возвращаем следующий узел виртуального узла (это будет голова нового списка)
        return dummy.next;
    }

    public static void printList(ListNodeTwo head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNodeTwo l1 = new ListNodeTwo(1);
        l1.next = new ListNodeTwo(3);
        l1.next.next = new ListNodeTwo(5);

        ListNodeTwo l2 = new ListNodeTwo(2);
        l2.next = new ListNodeTwo(4);
        l2.next.next = new ListNodeTwo(6);

        ListNodeTwo mergedList = mergeTwoLists(l1, l2);
        System.out.println("Merged List:");
        printList(mergedList);
    }
}