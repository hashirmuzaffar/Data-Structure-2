/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4.Question1;

/**
 *
 * @author BABAR
 */
class node<T> {

    T data;
    node<T> left;
    node<T> right;

    node(T d) {
        data = d;
    }
}

public class BinarySearchTree<T extends Comparable<T>> {

    /**
     * @param args the command line arguments
     */
    node<T> root;

    public void insert(T key) { // required non-recursive implementation

        node newnode = new node(key);
        if (root == null) {
            root = newnode;
        } else {
            node<T> temp = root;
            node<T> temp2 = root;
            while (temp != null) {
                if (key.compareTo(temp.data) > 0) {
                    temp2 = temp;
                    temp = temp.right;
                } else {
                    temp2 = temp;
                    temp = temp.left;
                }
            }
            if (temp2 == null) {
                temp2 = newnode;
            } else if (key.compareTo(temp2.data) > 0) {
                temp2.right = newnode;
            } else {
                temp2.left = newnode;
            }
        }
    }

    public void LNR(node n) {
        if (n == null) {
            return;
        } else {
            LNR(n.left);
            System.out.println(n.data);
            LNR(n.right);

        }
    }

    public void PrintRange(node<T> n, T k1, T k2) {
        if (n == null) {
            return;
        } else {
            PrintRange(n.left, k1, k2);
            if (n.data.compareTo(k1) >= 0 && n.data.compareTo(k2) <= 0) {
                System.out.println(n.data);
            }
            PrintRange(n.right, k1, k2);

        }
    }

    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert(40);

        bst.insert(49);

        bst.insert(42);

        bst.insert(48);

        bst.insert(47);

        bst.insert(34);

        bst.insert(64);

        bst.insert(54);

        bst.insert(54);

        bst.insert(44);

        bst.insert(88);

        bst.LNR(bst.root);

        System.out.println("\n");

        bst.PrintRange(bst.root, 42, 54);
    }

}
