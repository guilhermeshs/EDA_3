package Algoritmos;

import java.util.Stack;

public class BinarySearchTree {

    static class Node {
        double data;
        Node left;
        Node right;
        Node parent;

        public Node(double data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    static Node root;
    private static int rotationCount = 0;

    public void insert(double data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
            return;
        }

        Node temp = root;

        while (temp != null) {
            if (temp.data > data) {
                if (temp.left == null) {
                    temp.left = node;
                    node.parent = temp;
                    break;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = node;
                    node.parent = temp;
                    break;
                }
                temp = temp.right;
            }
        }
    }

    public int countRotations() {
        return rotationCount;
    }

    // Método de rotação esquerda, apenas para fins de contagem
    private void leftRotate(Node node) {
        rotationCount++;
        Node parent = node.parent;
        Node left = node.left;
        node.left = parent;
        parent.right = left;
        if (left != null) {
            left.parent = parent;
        }
        Node gp = parent.parent;
        node.parent = gp;
        parent.parent = node;

        if (gp == null) {
            root = node;
        } else {
            if (gp.left == parent) {
                gp.left = node;
            } else {
                gp.right = node;
            }
        }
    }

    // Método de rotação direita, apenas para fins de contagem
    private void rightRotate(Node node) {
        rotationCount++;
        Node parent = node.parent;
        Node right = node.right;
        node.right = parent;
        parent.left = right;
        if (right != null) {
            right.parent = parent;
        }
        Node gp = parent.parent;
        node.parent = gp;
        parent.parent = node;

        if (gp == null) {
            root = node;
        } else {
            if (gp.left == parent) {
                gp.left = node;
            } else {
                gp.right = node;
            }
        }
    }

    public Node search(double data) {
        Node temp = root;
        while (temp != null) {
            if (temp.data == data) {
                return temp;
            }
            if (temp.data > data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return null;
    }

    public int getHeight() {
        return calculateHeight(root);
    }

    private int calculateHeight(Node node) {
        if (node == null) {
            return 0;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        int height = 0;
        Node prev = null;

        while (!stack.isEmpty()) {
            Node current = stack.peek();

            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                }
            } else if (current.left == prev) {
                if (current.right != null) {
                    stack.push(current.right);
                }
            } else {
                stack.pop();
            }

            prev = current;

            height = Math.max(height, stack.size());
        }

        return height;
    }
}

