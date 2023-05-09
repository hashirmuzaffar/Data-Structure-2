/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4.Question2;

/**
 *
 * @author 22816
 */
class node {

    node left;
    node right;
    String word;
    String meaning;

    public node(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

}

public class BinarySearchTree {

    node root;

    public void insert(String word, String meaning) {
        node newnode = new node(word, meaning);
        if (root == null) {
            root = newnode;

        } else {
            node current = root;
            node prev = root;
            while (current != null) {

                if (word.compareTo(current.word) < 0) {
                    prev = current;
                    current = current.left;
                } else {
                    prev = current;
                    current = current.right;
                }
            }
            if (prev == null) {
                prev = newnode;
            }
            if (word.compareTo(prev.word) < 0) {
                prev.left = newnode;
            } else {
                prev.right = newnode;
            }
        }
    }

    public void LNR(node n) {
        if (n == null) {
            return;
        } else {
            LNR(n.left);
            System.out.println(n.word + " - " + n.meaning);
            LNR(n.right);
        }
    }

    public String find(String data) {
        String str = "Not found";

        if (data.equals(root.word)) {
           str = "The "+ root.word+" is in the dictionary and its meaning is "+ root.meaning;
            return str;
        } else {
            node current = root;
            while (current != null) {
                if (data.compareTo(current.word) < 0) {
                    if (data.compareTo(current.word)==0) {
                        str = "The "+ current.word+" is available and it's meaning is "+ current.meaning;
                        return str;
                    }
                    current = current.left;
                } else {
                    if (data.equals(current.word)) {
                        str = "The "+ current.word+" is available and it's meaning is "+ current.meaning;
                        return str;
                    }
                current = current.right;
                }
                
            }
        }
        return str;
    }

   public void delete(String word) {
        node[] arr = new node[2];
        arr = FindToDel(word);
        if (arr[0] == null && arr[1] == null) {
            System.out.println("Word not found");
            return;
        }
        if (arr[1].left == null && arr[1].right == null) {
            this.NoChildCase(arr[0], arr[1]);
        } else if ((arr[1].left == null && arr[1].right != null) || (arr[1].left != null && arr[1].right == null)) {
            this.OneChildCase(arr[0], arr[1]);
        } else {
            node[] arr2 = new node[2];
            arr2 = this.RightMin(arr[1].right);
            arr[1] = arr2[1];

            if (arr2[1].left == null && arr2[1].right == null) {
                this.NoChildCase(arr2[0], arr2[1]);
            } else {
                this.OneChildCase(arr2[0], arr2[1]);
            }
        }
    }

    public node[] FindToDel(String word) {
        node[] arr = new node[2];
        arr[0] = null; //previous node
        arr[1] = null;// node to be deleted
        if (word.compareTo(root.word) == 0) {
            arr[0] = root; //previous node
            arr[1] = root;// node to be deleted
            return arr;
        } else {
            arr[0] = root; //previous node
            arr[1] = root;// node to be deleted
            while (arr[1] != null && arr[1].word.compareTo(word) == 0) {
                if (arr[1].word.compareTo(word) < 0) {
                    if (arr[1].word.compareTo(word) == 0) {
                        return arr;
                    }
                    arr[0] = arr[1];
                    arr[1] = arr[1].left;
                } else {
                    if (arr[1].word.compareTo(word) == 0) {
                        return arr;
                    }
                    arr[0] = arr[1];
                    arr[1] = arr[1].right;

                }
            }
        }
        System.out.println("word not found");
        return arr;
    }

    public node[] RightMin(node n) {
        node[] arr = new node[2];
        arr[0] = n;// previous node
        arr[1] = n;//current node
        while (arr[1].left != null) {
            arr[0] = arr[1];
            arr[1] = arr[1].left;
        }
        return arr;
    }

    public void NoChildCase(node previous, node current) {
        if (current.word.compareTo(previous.word) > 0) {
            previous.right = null;
        } else {
            previous.left = null;
        }
    }

    public void OneChildCase(node previous, node current) {
        if (current.left == null) {
            if (current.word.compareTo(previous.word) < 0) {
                previous.left = current.right;
            } else {
                previous.right = current.right;
            }
        } else {

            if (current.word.compareTo(previous.word) < 0) {
                previous.left = current.left;
            } else {
                previous.right = current.left;
            }
        }

    }
}