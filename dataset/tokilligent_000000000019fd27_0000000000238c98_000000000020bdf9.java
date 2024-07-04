import java.util.*;
public class Solution{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int k=sc.nextInt();
    for(int l=0;l<k;l++){
      int n=sc.nextInt();
      int start[]=new int[n];
      int stop[]=new int[n];
      for(int i=0;i<n;i++){
        start[i]=sc.nextInt();
        stop[i]=sc.nextInt();
      }
      LinkedList <Integer> copy_start=new LinkedList<Integer>();
      for(int i=0;i<start.length;i++){
        copy_start.add(start[i]);
      }
      Arrays.sort(start);
      int copy_stop[]=new int[stop.length];
      for(int i=0;i<stop.length;i++){
        copy_stop[i]=stop[copy_start.indexOf(start[i])];
      }
      stop=copy_stop;
      int c_act=0,j_act=0;
      String s="";
      LinkedList <Integer> c_start=new LinkedList<Integer>();
      LinkedList <Integer> c_end=new LinkedList<Integer>();
      LinkedList <Integer> j_start=new LinkedList<Integer>();
      LinkedList <Integer> j_end=new LinkedList<Integer>();
      
      c_start.add(-100);
      c_end.add(-100);
      j_start.add(-100);
      j_end.add(-100);
      
      for(int i=0;i<n;i++){
        if(start[i]>=c_end.getLast()){
          c_start.add(start[i]);
          c_end.add(stop[i]);
          c_act++;
          s=s+"C";
        }
        else if(start[i]>=j_end.getLast()){
          j_start.add(start[i]);
          j_end.add(stop[i]);
          j_act++;
          s=s+"J";
        }
      }

      if(c_act+j_act==n)
        System.out.println("Case #"+(l+1)+": "+s);
      else
        System.out.println("Case #"+(l+1)+": "+"IMPOSSIBLE");
    }
  }
}   
      