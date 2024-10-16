package src.main.java.org.example.Node;

enum Color {
    RED, BLACK;
}

class Node {
    int value;
    Node left, right, parent;
    Color color;

    public Node(int value) {
        this.value = value;
        this.color = Color.RED; // Новый узел всегда красный
    }
}