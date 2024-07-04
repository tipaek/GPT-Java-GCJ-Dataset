import java.io.*;
import java.util.*;


class Solution{ //Copy and use this
    private Node parent, tail, head, trav;
    private boolean flag;
    private StringBuilder lastPart, firstPart;
    private final int lenLimit = (int)Math.pow(10,4);
    public static void main(String[] args) throws Exception {
        int TEST,n;
        String[]ip;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Solution obj = new Solution();
        TEST = Integer.parseInt(in.readLine().trim());
       for(int caseNo = 1; caseNo <= TEST; ++caseNo){
            //Reading ip
            n = Integer.parseInt(in.readLine().trim());
            obj.initialize();
            while(n-->0){
                obj.takeIntoAccount(in.readLine().trim());
            }
            System.out.println("Case #"+caseNo+": "+obj.solve());
        }
    }
    private void initialize(){
        tail = null;
        head = null;
        trav = null;
        parent = null;
        flag = true;
        lastPart = new StringBuilder();
        firstPart = new StringBuilder();
    }

    private void takeIntoAccount(String pattern){
        if(flag){
            int index;
            //base case from last
            // index = pattern.length() - 1;
            // if(tail==null && pattern.charAt(index)!=-1) {
            //     tail = new Node(pattern.charAt(index--));
            //     trav = tail;
            //     while(index>=0 && pattern.charAt(index)!='*'){
            //         trav.prev = new Node(pattern.charAt(index));
            //         trav.prev.next = trav;
            //         trav = trav.prev;
            //         index--;
            //     }
            // }

            //base case form first
            // index = 0;
            // if(head==null && pattern.charAt(index)!='*'){
            //     head = new Node(pattern.charAt(index++));
            //     trav = head;
            //     while(index<pattern.length() && pattern.charAt(index)!='*'){
            //         trav.next = new Node(pattern.charAt(index));
            //         trav.next.prev = trav;
            //         trav = trav.next;
            //         index++;
            //     }
            // }
                
            //check from last
            index = pattern.length() - 1;
            trav = tail;
            parent = null;
            while(index >= 0 && pattern.charAt(index)!='*'){
                if(trav!=null){
                    if(trav.data != pattern.charAt(index)){
                        flag = false;
                        break;
                    }
                }
                else{
                    trav = new Node(pattern.charAt(index));
                    if(tail==null) tail = trav;
                    if(parent!=null){
                        parent.prev = trav;
                        trav.next = parent;
                    }
                }
                parent = trav;
                trav = trav.prev;
                index--;
            }

            //check from first
            index = 0;
            trav = head;
            parent = null;
            while(index < pattern.length() && pattern.charAt(index)!='*'){
                if(trav!=null){
                    if(trav.data != pattern.charAt(index)){
                        flag = false;
                        break;
                    }
                }
                else{
                    trav = new Node(pattern.charAt(index));
                    if(head==null) head = trav;
                    if(parent!=null){
                        parent.next = trav;
                        trav.prev = parent;
                    }
                }
                parent = trav;
                trav = trav.next;
                index++;
            }
        }
    }
    
    private String solve(){
        //Code logic here
        //base
        if(!flag) return "*";
        
        //last part
        trav = tail;
        while(trav!=null) {
            lastPart.append(trav.data);
            trav = trav.prev;
        }
        lastPart = lastPart.reverse(); 

        //first part
        trav = head;
        while(trav!=null){
            firstPart.append(trav.data);
            trav = trav.next;
        }

        //first 2 cases. Only one * max
        String ans = firstPart.append(lastPart).toString();

        return ans.length()<=lenLimit?ans:"*";
    }

    private class Node{
        char data;
        Node prev, next;
        Node(char inputdata){
            data = inputdata;
            prev = null;
            next = null;
        }
    }
}
