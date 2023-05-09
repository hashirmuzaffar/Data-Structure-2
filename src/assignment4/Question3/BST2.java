/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4.Question3;

/**
 *
 * @author BABAR
 */
class node {

    int data;
    node left;
    node right;

    node(int d) {
        data = d;
    }
}

public class BST2 {

    node root;
    static int c;


    public void insert(int key) { // required non-recursive implementation

        node newnode = new node(key);
        if (root == null) {
            root = newnode;
        } else {
            node temp = root;
            node temp2 = root;
            while (temp != null) {
                if (key > temp.data) {
                    temp2 = temp;
                    temp = temp.right;
                } else {
                    temp2 = temp;
                    temp = temp.left;
                }
            }
            if (temp2 == null) {
                temp2 = newnode;
            } else if (key > temp2.data) {
                temp2.right = newnode;
            } else {
                temp2.left = newnode;
            }
        }

    }

    public void TotalNodes(node n) {

        if (n == null) {
            return;
        } else {
            TotalNodes(n.left);
            BST2.c++;
            TotalNodes(n.right);
        }
    }
    
    DynamicGenericArray<Integer> arr =  new DynamicGenericArray<Integer>(5);
    
    public void balanceBST(node n,int c) 
    {
              
        if (n == null) {
            return;
        } else {
            balanceBST(n.left,c++);
            arr.addAtEnd(n.data);
            balanceBST(n.right,c++);
               
        }
      }
    public node balanceRecursive(DynamicGenericArray<Integer> Arr, int start, int end)
{
   
    if(start > end)
       return null;
    int mid = (start + end)/2;
    //node Root = new node(Arr[mid]);
    root.left = balanceRecursive(Arr, start, mid - 1);
    root.right = balanceRecursive(Arr, mid + 1, end);
    return root;
}
    
    public static void main(String[] args) {
        // TODO code application logic here
      BST2 bst = new  BST2();
         bst.insert(11);

        bst.insert(18);

        bst.insert(20);
        
        bst.insert(28);

        bst.insert(32);
        
        bst.insert(40);

        bst.insert(41);

        bst.insert(42);
        
        bst.balanceBST(bst.root, 0);
        
        bst.root=bst.balanceRecursive(bst.arr, 0, bst.arr.length());
      
  }
}
