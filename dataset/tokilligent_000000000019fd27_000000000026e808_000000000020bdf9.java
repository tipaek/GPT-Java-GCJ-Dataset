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
        boolean check1=true;
        boolean check2=true;
        for(int j=1;j<c_start.size();j++){
          if(!  ((start[i]>c_start.get(j) && start[i]>=c_end.get(j)) || (start[i]<c_start.get(j) && stop[i]<=c_start.get(j))) ){
            check1=false;
            break;
          }
        }
        for(int j=1;j<j_start.size();j++){
          if(! ((start[i]>=j_start.get(j) && start[i]>=j_end.get(j)) || (start[i]<j_start.get(j) && stop[i]<=j_start.get(j))) ){
            check2=false;
            break;
          }
        }
        if(check1==true){
          c_start.add(start[i]);
          c_end.add(stop[i]);
          c_act++;
          s=s+"C";
        }
        else if(check2==true){
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
    sc.close();
  }
}
