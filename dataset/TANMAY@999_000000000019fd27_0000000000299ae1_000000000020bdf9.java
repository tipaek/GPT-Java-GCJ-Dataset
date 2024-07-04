
import  java.io.*;
import  java.util.*;




  public class Solution{
      static class Node{
    int start;
    int end;
    char ch;
    int pos;
    public Node(int start,int end,int pos){
        this.start=start;
        this.end =end;
        this.pos=pos;
    }
      }
    
     
     public static void main(String args[]) throws IOException{
           
           BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
         
         
         int test_case = Integer.parseInt(in.readLine());
         
     for(int t=1;t<=test_case;t++){
         
           int n = Integer.parseInt(in.readLine());
          
           
          // ArrrayList<Node> timesheet2= new ArrayList<Integer>(n);
           ArrayList<Node> timesheet1 = new ArrayList<Node>(n);
     
             for(int i=0;i<n;i++){
                 String input[]=in.readLine().split(" ");
                  int start= Integer.parseInt(input[0]);
               int end= Integer.parseInt(input[1]);
           Node na = new Node(start,end,i+1);
           timesheet1.add(na);
           
          

         }
        // Collections.copy(timesheet2,timesheet1);
         Collections.sort(timesheet1,(a,b)->(a.start-b.start));
     
         boolean flag=false;
      //  String str[]  = new String[n]; 
       timesheet1.get(0).ch ='C';
         int  global_C= timesheet1.get(0).end;
         int global_J = 0;
         for(int i=1;i<n;i++){
             
             if(timesheet1.get(i).start>=global_C){
                
                    global_C =timesheet1.get(i).end ;
                    timesheet1.get(i).ch ='C';
                    
                
             }
             else if(timesheet1.get(i).start>=global_J)
             {
                   global_J =timesheet1.get(i).end ;
                    timesheet1.get(i).ch ='J';
             }
             else {
                 flag=true;
                 break;
             }
         }
         
         String str="";
         
         if(flag==true){
             System.out.println("Case #"+t+": IMPOSSIBLE");
         }
         else
         {
             Collections.sort(timesheet1,(a,b)->(a.pos-b.pos));
             for(int i=0;i<n;i++){
             char c=timesheet1.get(i).ch;
             str=str+c;
              
             }
             System.out.println("Case #"+t+": "+str);
         }
         
     }
 
 }
  }