import java.io.*;
import java.util.*;
        
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        in.nextLine();

        for (int tcase = 1; tcase <= t; tcase++) {
          
            char[] car = in.nextLine().toCharArray();
            LList list = new LList();
            LList ret = new LList();
            
            //make original list
            for(int i = 0; i < car.length; i++) list.insert(car[i]);
            
            //insert brackets
            Node at = list.head;
            while(at != null){
                int num = at.c - '0';
                for(int i = 0; i < num; i++) ret.insert('(');
                ret.insert((char)(num + '0'));
                for(int i = 0; i < num; i++) ret.insert(')');
                at = at.next;
            }
            
            //get rid of duplicates
            boolean done = false;
            while(!done){
                done = true;
                at = ret.head;
                while(at != null && at.next != null && at.next.next != null){
                    if(at.next.c == ')' && at.next.next.c == '('){
                        ret.deleteAfter(at);
                        ret.deleteAfter(at);
                        done = false;
                    } else {
                        at = at.next;
                    }
                }
            }
            //output
            System.out.print("Case #" + tcase + ": ");
            at = ret.head;
            while(at != null){
                System.out.print(at.c);
                at = at.next;
            }
            System.out.println("");
        }
    }
    
}

class Node{
    public char c;
    public Node next;
    
    public Node(char c, Node next){
        this.c = c;
        this.next = next;
    }
}

class LList{
    Node head;
    Node tail;
    
    public LList(){
        head = null;
        tail = null;
    }
    
    public void insert(char c){
        if(head == null){
            head = new Node(c, null);
            tail = head;
        } else {
            tail.next = new Node(c, null);
            tail = tail.next;
        }
    }
    
    public void insertAfter(Node n, char c){
        Node temp = new Node(c, n.next);
        n.next = temp;
    }
    
    public void deleteAfter(Node n){
        n.next = n.next.next;
    }
}