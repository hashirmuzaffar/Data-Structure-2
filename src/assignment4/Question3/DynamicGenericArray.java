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

   public class DynamicGenericArray<T extends Comparable<T>> {

    T [] arr;
    int currentIndex;
    /**
     * @param args the command line arguments
     */
    
    public DynamicGenericArray(int size){
     arr = (T[])new Comparable[size];
    currentIndex=0;
    }

    public boolean isEmpty(){
    if(currentIndex==0)return true;
    return false;}
    
    public int length(){
    return currentIndex;
    } 
    public void print(){
    for(int i=0;i<this.currentIndex;i++)
    {if(arr[i]!=null)
        System.out.print(arr[i]+",");}
        System.out.println("");
    }
    public void addAtFront(T value){
    if(currentIndex==arr.length-1) {
        T arr1[]= (T[])new Comparable[2*arr.length];
        for(int i=0; i<arr.length; i++){
        arr1[i]=arr[i];}
        arr=arr1;
        currentIndex++;
    for(int j=currentIndex;j>0;j++){
    arr[j]=arr[j-1];
    }arr[0]=value;
    }
    else{
        currentIndex++;for(int i=currentIndex;i>0; i--){arr[i]=arr[i-1];}arr[0]=value;
    }   
    }
    public void addAtEnd(T value){
    if(currentIndex==arr.length-1){
    
    T arr1[]= (T[])new Comparable[arr.length*2];
        for(int i=0; i<currentIndex+1; i++){
        arr1[i]=arr[i];}
        arr=arr1;
    }
     arr[currentIndex]=value;currentIndex++;
   }
    
    
    public int Find (T value) {
    for(int j=0; j<arr.length;j++) {
    if(arr[j]==value) return j; 
    }
    return -1;
    }
    
    public void reverse(){
        T arr1[]= (T[])new Comparable[arr.length];
        int j=0;
        for(int i=arr.length-1;i>=0;i--)
        {
        arr1[j]=arr[i];
        j++;
        }
        arr=arr1;
    
    }
    public void Remove (T value) {
    int temp=Find(value);
    if(temp!=-1){
    for(int j=temp; j<arr.length-1;j++) {   
    arr[j]=arr[j+1];}
    arr[currentIndex-1]=null;
    }
    }
    public void removeAll(T value){
    int temp=this.Find(value);
    while(temp!=-1){
        this.Remove(value);
        temp=this.Find(value);
    }
    }
   }

