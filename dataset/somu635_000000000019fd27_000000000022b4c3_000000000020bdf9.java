
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

class Time{
  int left,right,rank;
  Character c;
  Time(int l,int r,int p){
    left=l;
    right=r;
    rank=p;
    
  }
  void assign(Character c) {
    this.c=c;
  }
  Character getAssign() {
    return c;
  }
  int get_left() {
    return left;
  }
  int get_right() {
    return right;
  }
}

class Solution {
  

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    for(int a=1;a<=t;a++) {
      int n=sc.nextInt();
      ArrayList<Time> arr=new ArrayList<Time>();
      for(int i=0;i<n;i++) {
        int l=sc.nextInt();
        int r=sc.nextInt();
        Time t1=new Time(l,r,i+1);
        arr.add(t1);
      }
      
      Collections.sort(arr, new Comparator<Time>() {

        @Override
        public int compare(Time o1, Time o2) {
          // TODO Auto-generated method stub
          if(o1.left==o2.left)
            return o1.right-o2.right;
          return o1.left-o2.left;
        }});
      
      Stack<Time> c=new Stack<Time>();
      Stack<Time> j=new Stack<Time>();
      boolean flag= true;
      arr.get(0).assign('C');
      c.push(arr.get(0));
      for(int i=1;i<n;i++) {
        
         if(Math.max(c.peek().left, arr.get(i).left)<Math.min(c.peek().right, arr.get(i).right)) {
           if(j.size()==0) {
             arr.get(i).assign('J');
             j.push(arr.get(i));
           }
           else if(Math.max(j.peek().left, arr.get(i).left)<Math.min(j.peek().right, arr.get(i).right)){
             flag=false;
             break;
           }else {
             arr.get(i).assign('J');
             j.push(arr.get(i));
           }
         }else {
           arr.get(i).assign('C');
           c.push(arr.get(i));
         }
        
      }
      if(flag==false) {
        System.out.println("Case #"+a+": IMPOSSIBLE");
        continue;
      }
      Collections.sort(arr, new Comparator<Time>() {

        @Override
        public int compare(Time o1, Time o2) {
          // TODO Auto-generated method stub
          
          return o1.rank-o2.rank;
        }});
      StringBuilder string=new StringBuilder();
      for(int i=0;i<n;i++) {
        string.append(arr.get(i).getAssign());
      }
      System.out.println("Case #"+a+": "+string);
      
    }
    
    
  }

}
