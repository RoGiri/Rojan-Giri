
/**
 * Standard Cons-cells
 *
 * @author Rojan Giri 
 * @version 1
 * 
 */

/**
 * type parameter T
 * Below is an explanation for the fancy stuff
 * attached to that type parameter.
 * For the assessment you do not need to know this,
 * but if you are curious: read on!
 * 
 * Because we want to be able to compare the elements
 * of the list with one another, we require that
 * class T implements the Comparable interface.
 * That interface has itself a type parameter, which
 * gives you what these values can be compared to.
 * The reason this is (in the most general case) not just T
 * itself is the following scenario:
 * class X implements the interface,
 * so we can compare Xs with Xs, then we define a subclass Y of X,
 * so it inherits the compareTo method from X,
 * but Ys are now compared with Xs.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
public class Node<T extends Comparable<? super T>>
{
    protected T head;
    protected Node<T> tail;

    public Node(T h, Node<T> t) {
        head = h;
        tail = t;
    }

    public String toString() {
        if (tail == null) return "[" + head + "]";
        return "[" + head + tail.tailString();
    }

    private String tailString() {
        String initialPart= "," + head;
        if (tail==null) return initialPart + "]";
        return initialPart + tail.tailString();
    }

    public int length() {
        int result=1;
        for (Node<T> n=tail; n!=null; n=n.tail) { result++; }
        return result;
    }

    public Queue<Node<T>> queueSortedSegments() {
        //this method should create a queue (of linked lists),
        //split the original (this) list into its sorted non-empty sublists;
        //place those sublists in the queue and return it

        Queue<Node<T>> q = new LinkedList<>();
        Node<T> current = new Node<T>(head, null);
        q.add(current);
        for(Node<T> t = tail; t!= null; t = t.tail){
            Node<T> currentnode= new Node<>(t.head, null);
            q.add(currentnode);
        }
        return q;
    }

      public boolean isSorted() {
        //this method should check whether 'this' list is already sorted
        //return true; //keep compiler happy for now
        int pre = (Integer) head;

        for(Node<T> n =tail; n!= null; n=n.tail){
            if(pre > (Integer)n.head){
                return false;
            }
            pre = (Integer)n.head;

        }
        return true;
    }

    public Node<T> merge (Node<T> another){
        //this method should merge two sorted linked lists
        //and return their merged resulting list
        //the above are our assumptions about those lists
        //initial assumption;
        Node<T> temp = null;
        Node<T> current = this;
        while (current.head != null && another.head != null){
            if(current.head.compareTo(another.head)<0){
                temp = new Node<>(current.head, temp);
                if(current.tail == null){current.head = null;}
                else {current = current.tail;}
            } else if(another.head.compareTo(current.head)<0){
                temp = new Node<>(another.head, temp);
                if(another.tail == null){another.head= null;}
                else {another = another.tail;}
            }
            else {
                temp= new Node<>(current.head,temp);
                temp= new Node<>(another.head, temp);
                if(current.tail== null){
                    current.head = null;}
                else{
                    current = current.tail;}
                if(another.tail ==null){
                    another.head = null;}
                else{
                    another = another.tail;}
            }
        }

        while(current.head != null){
            temp= new Node<>(current.head,temp);
            if(current.tail == null){
                current.head = null;}
            else {
                another = another.tail;}
        }
        while(another.head != null){
            temp= new Node<>(another.head,temp);
            if(another.tail == null){
                another.head = null;}
            
            else {
                another = another.tail;}
        }
        Node<T> merge= null;
        while(temp.head != null){
            merge = new Node<>(temp.head,merge);
            if(temp.tail == null){
                temp.head= null;}
            
            else{
                temp= temp.tail;} 
        }
        return merge;
    }

    public Node<T> mergeSort() {
        //this method should sort the list in the following way:
        //split the list up into sorted segments and place these into a queue
        //poll pairs of lists from the queue, merge them, and put their merge
        //back into the queue
        //if there is only one list left in the queue that should be returned
        Queue<Node<T>> q = queueSortedSegments();
        while(q.size() > 1){
            Node<T> l1 = q.poll();
            Node<T> l2 = q.poll();
            Node<T> current = l1.merge(l2);
            q.add(current);
        }
        return q.poll();
    }

    static public Node<Integer> randomList(int n) {
        //for testing purposes we want some random lists to be sorted
        //the list is n elements long
        //the elements of the random list are numbers between 0 and n-1
        Random r=new Random();
        Node<Integer> result=null;
        int k=n;
        while(k>0) { 
            result=new Node<Integer>(r.nextInt(n),result);
            k--;
        }
        return result;
    }

    static public void test(int n) {
        //this method should do the following:
        //1. create a random linked list of length n
        //2. output it
        //3. report whether the 'isSorted' method thinks the list is sorted or not
        //4. sort the list using mergeSort
        //5. output the sorted list
        //6. report whether the 'isSorted' method thinks that list is sorted or not
        System.out.println("");
        Node l =randomList(n);
        System.out.println(l.toString());

        if(l.isSorted()){
            System.out.println("Sorted List");
        }else{
            System.out.println("Unsorted List");
        }
        System.out.println("");
        l = l.mergeSort();
        System.out.println(l.toString());
        if(l.isSorted()){
            System.out.println("Sorted List");
        }else{
            System.out.println("Unsorted List");
        }

    }
}
