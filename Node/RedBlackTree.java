package src.main.java.org.example.Node;

class RedBlackTree {
    private Node root;

    public RedBlackTree() {
        this.root = null;
    }

    // Метод вставки узла
    public void insert(int value) {
        Node newNode = new Node(value);
        root = bstInsert(root, newNode);
        fixViolations(newNode);
    }

    // Вставка узла как в бинарном дереве поиска
    private Node bstInsert(Node root, Node newNode) {
        if (root == null) {
            return newNode;
        }

        if (newNode.value < root.value) {
            root.left = bstInsert(root.left, newNode);
            root.left.parent = root;
        } else if (newNode.value > root.value) {
            root.right = bstInsert(root.right, newNode);
            root.right.parent = root;
        }

        return root;
    }

    // Балансировка
    private void fixViolations(Node newNode) {
        while (newNode != root && newNode.parent.color == Color.RED) {
            Node parent = newNode.parent;
            Node grandparent = parent.parent;

            // Случай A: Если родитель - левый ребенок
            if (parent == grandparent.left) {
                Node uncle = grandparent.right;

                // Случай 1: У дяди красный
                if (uncle != null && uncle.color == Color.RED) {
                    grandparent.color = Color.RED;
                    parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    newNode = grandparent; // Поднимаемся выше
                } else { // Случай 2: У дяди черный
                    if (newNode == parent.right) {
                        // Малый левый поворот
                        root.left = rotateLeft(parent);
                        newNode = parent;
                        parent = newNode.parent;
                    }
                    // Случай 3: У дяди черный
                    root = rotateRight(grandparent);
                    Color tempColor = parent.color;
                    parent.color = grandparent.color;
                    grandparent.color = tempColor;
                    newNode = parent; // Завершаем и выходим
                }
            } else { // Случай B: Если родитель - правый ребенок
                Node uncle = grandparent.left;

                // Случай 1: У дяди красный
                if (uncle != null && uncle.color == Color.RED) {
                    grandparent.color = Color.RED;
                    parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    newNode = grandparent; // Поднимаемся выше
                } else { // Случай 2: У дяди черный
                    if (newNode == parent.left) {
                        // Малый правый поворот
                        root.right = rotateRight(parent);
                        newNode = parent;
                        parent = newNode.parent;
                    }
                    // Случай 3: У дяди черный
                    root = rotateLeft(grandparent);
                    Color tempColor = parent.color;
                    parent.color = grandparent.color;
                    grandparent.color = tempColor;
                    newNode = parent; // Завершаем и выходим
                }
            }
        }

        root.color = Color.BLACK; // Корень всегда черный
    }

    // Левый поворот
    private Node rotateLeft(Node node) {
        Node newParent = node.right;
        node.right = newParent.left;

        if (newParent.left != null) {
            newParent.left.parent = node;
        }

        newParent.parent = node.parent;

        if (node.parent == null) {
            root = newParent;
        } else if (node == node.parent.left) {
            node.parent.left = newParent;
        } else {
            node.parent.right = newParent;
        }

        newParent.left = node;
        node.parent = newParent;

        return newParent;
    }

    // Правый поворот
    private Node rotateRight(Node node) {
        Node newParent = node.left;
        node.left = newParent.right;

        if (newParent.right != null) {
            newParent.right.parent = node;
        }

        newParent.parent = node.parent;

        if (node.parent == null) {
            root = newParent;
        } else if (node == node.parent.right) {
            node.parent.right = newParent;
        } else {
            node.parent.left = newParent;
        }

        newParent.right = node;
        node.parent = newParent;

        return newParent;
    }

    // Для тестирования
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }
}