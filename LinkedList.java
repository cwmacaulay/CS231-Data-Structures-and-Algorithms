/* Charles Macaulay
 * October 16, 2014
 * LinkedList.java
 */

import java.util.*;
import java.util.Collections;



public class LinkedList<T> implements Iterable<T>{
  
  private Node head;
  private Node tail; 
  private int numItems;
  
  
  private class Node{
    
    Node next;
    Node prev;
    T var;
    
    
    public Node(T item, Node nd, Node pd ) {
      this.next = nd;
      this.prev = pd;
      this.var = item;
    }
    
    
    
    public T getThing() {
      return this.var;
    }
    
    
    
    public void setNext( Node n ) {
      this.next = n;
    }
    
    
    public void setPrevious( Node p ){
      this.prev = p;
    }
    
    
    public Node getNext() {
      return this.next;
      
    }
    
    
    
    public Node getPrevious() {
      return this.prev;
    }
    
    
    
    
    public int length() {
      int count = 0;
      Node current = this;
      while (current != null) {
        count++;
        current = current.next;
      }
      return count;
    }
  }
  
  
  
  
  public LinkedList(){
    this.head = null;
    this.numItems = 0;
  }
  
  
  
  public void clear() {
    this.head = null;
    this.numItems = 0;
  }
  
  
  public int size() {
    if(head == null )
      return 0;
    else
      return this.numItems;
  }
  
  
  
  
  public void append(T item ) {
    if(this.head == null) {
      this.head = new Node( item , null, null);
      this.tail = this.head;
    }
    else {
      this.tail.next = new Node( item, null, this.tail);
      this.tail = this.tail.next;
    }
    this.numItems++;
  }
  
  
  
  
  public void add( T item ){
    
    this.head = new Node( item, this.head, null );
    this.numItems ++;
    if (this.numItems > 1){
      this.head.next.prev = this.head;
    }
    if (this.numItems == 1){
      this.tail = this.head;
    }
  }
  
  
  
  
  public boolean remove( Object obj ) {
    
    Node current = this.head;
    if (this.numItems < 1){
      return false;
    }
    else if (this.numItems == 1) {
      if (current.var == obj){
        this.head = null;
        this.tail = null;
        this.numItems = 0;
        return true;
      } else {
        return false;
      }
    }
    else {
      if ( current == this.head && current.var.equals(obj) ){
        this.head = this.head.next;
        this.head.prev = null;
        this.numItems --;
        return true;
      }
      else if ( current.next ==null && current.var.equals(obj) ) {
        current = current.prev;
        current.next = null;
        this.numItems --;
        return true;
      } else {
        for (int i = 0; i < this.numItems; i++){
          if (current.next != null && current.var.equals( obj )) {
            current.prev.next = current.next;
            current.prev = current.next.prev;
            this.numItems --;
            return true;
          }
          else if ( current.next ==null && current.var.equals(obj) ) {
            current = current.prev;
            current.next = null;
            this.numItems --;
            return true;
          } else { current = current.next; } 
        }
        return false;
      }
    }
  }
  
  public boolean remove_from_head(){
  
  
  
  
  
  
  public Iterator<T> iterator(){
    
    LLIterator iter = new LLIterator( this.head );
    return iter;
    
  }
  
  
  private class LLIterator implements Iterator<T>{
    
    private Node current;
    
    public LLIterator(Node head) {
      this.current = head;
      
    }
    
    public boolean hasNext() {
      return (this.current != null);
    }
    
    
    public T next() {
      if ( numItems == 0) {
        return null;
      } else {
        T t = this.current.getThing();
        current = current.next;
        return t;
      }
    }
    
         
    public T prev() {
      if ( numItems == 0) {
        return null;
      } else {
        T t = this.current.getThing();
        current = current.prev;
        return t;
      }
    }
    
    
    public void remove() {;
    }
  }
  
  
  
  
  
  
  public ArrayList<T> toArrayList(){
    LinkedList<T> orderedlist = this;
    ArrayList<T> arr = new ArrayList<T>();
    Node current = head;
    
    if (this.head == null){
      return arr;
    }else{
      
      while ( current != null ){
        arr.add( current.var );
        current = current.next;
      }
    }
    return arr; 
  }
  
  
  public ArrayList<T> toShuffledList(){
    ArrayList<T> shuffledlist= this.toArrayList();
    Collections.shuffle(shuffledlist);
    return shuffledlist;
  }
  
  
  
  
  
  
  
  
  
  public static void main(String[] argv) {
    LinkedList<Integer> llist = new LinkedList<Integer>();
    
    
    llist.add(88888);
    llist.add(3);   
    llist.add(5);
    llist.add(10);
    
    llist.add(20);
    llist.add(4);
    
    llist.add(10);
    llist.add(20);
    llist.add(5);
    llist.add(10);
    
    
    llist.remove( 88888 );
    
    
    ArrayList  cumquat = llist.toArrayList();
    
    System.out.println( cumquat );
    
    
  }     
}