package ua.nure.zhazhkyi.Practice6.part5;


public class Tree<E extends Comparable<E>> {

    private static final String INDENT = "   ";
    private static StringBuilder sb = new StringBuilder();
    private static int level = -1;

    public Node<E> root = null;
    private Node<E> current = null;
//    private Node<E> parent = null;

    public boolean remove(E element) {
        return remove(element, root);
    }

    private boolean remove(E element, Node<E> current) {
        if (current == null) {
            System.out.println("No such element in the tree!");
            return false;
        }

        if (element.compareTo(current.data) == 0) {
            if (current.right != null && current.left != null) {
                Node<E> temp = findMinFromRight(current.right);
                E tempValue = temp.getData();
                remove(tempValue, current.right);
                current.setData(tempValue);
                return true;
            } else if (current.right != null) {
                current.parent.right = current.right;
                return true;
            } else if (current.left != null) {
                current.parent.left = current.left;
                return true;
            } else {
                if(current.parent==null){
                    root = null;
                }
                else if (current == current.parent.left) {
                    current.parent.left = null;
                } else if (current == current.parent.right) {
                    current.parent.right = null;
                }
                return true;
            }
        } else if (element.compareTo(current.getData()) > 0) {
            current.parent = current;
            return remove(element, current.right);
        } else if (element.compareTo(current.getData()) < 0) {
            current.parent = current;
            return remove(element, current.left);
        }
        return false;
    }

    private Node findMinFromRight(Node<E> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void add(E[] elements) {
        for (int i = 0; i < elements.length; i++) {
            add(elements[i]);
        }
    }

    public boolean add(E e) {
        if (root == null) {
            root = new Node<>(e);
            current = root;
            return true;
        }
        if (e.compareTo(current.getData()) > 0) {
            if (current.right == null) {
                current.right = new Node<>(e);
                current.right.parent = current;
                current = root;
                return true;
            } else {
                current = current.right;
                add(e);
            }
        } else if (e.compareTo(current.getData()) < 0) {
            if (current.left == null) {
                current.left = new Node<>(e);
                current.left.parent = current;
                current = root;
                return true;
            } else {
                current = current.left;
                add(e);
            }
        }
        return false;
    }

    public void print() {
        print(root);
        System.out.println(sb);
        sb.append(System.lineSeparator());
        level = -1;
    }

    public void print(Node node) {
        if (node != null) {
            level += 1;
            print(node.right);
            for (int i = 0; i < level; i++) {
                sb.append(INDENT);
            }
            sb.append(node.getData()).append(System.lineSeparator());
            print(node.left);
            level -= 1;
        }
    }

    private static class Node<E extends Comparable> implements Comparable<Node<E>> {
        private E data;
        private Node<E> right;
        private Node<E> left;
        private Node<E> parent;

        Node(E value) {
            data = value;
            right = null;
            left = null;
        }

        E getData() {
            return data;
        }

        void setData(E data) {
            this.data = data;
        }

        @Override
        public int compareTo(Node<E> node) {
            return data.compareTo(node.getData());
        }
    }

}
