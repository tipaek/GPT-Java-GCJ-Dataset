import java.util.*;
  class Solution{
 public static void main(String argp[])
 {
     Scanner ob=new Scanner(System.in);
     int t=ob.nextInt();
     int k=0;
     
     while(t-->0)
     {
         ArrayList<Node>list=new ArrayList<>();
         k++;
         int n=ob.nextInt();
         for(int i=0;i<n;i++)
         {
             int s=ob.nextInt();
             int e=ob.nextInt();
          list.add(new Node(s,'s',e));
          list.add(new Node(e,'e',s));   
         }
         Collections.sort(list,(o1,o2)->o1.getX()-o2.getX());
         String ans="";
         int a=0,b=0;
         for(int i=0;i<list.size();i++)
         {
             if(list.get(i).getY()=='s')
             {
                 
                 if(a!=0&&b!=0)
                 {
                     ans="IMPOSSIBLE";
                     break;
                 }
                 else if(a==0)
                 {
                     ans+="C";
                     a=list.get(i).getO();
                 }
                 else
                 {
                     ans+="J";
                     b=list.get(i).getO();
                 }
             }
             else
             {
                 if(list.get(i).getX()==a){
                     a=0;
                 }else
                 {
                     b=0;
                 }
                 
             }
         }
         System.out.println("Case #"+k+": "+ans);
     }
     
 }
}
class Node{
    int x;
    char y;
    int o;
    Node(int x,char y,int o)
    {
        this.o=o;
        this.x=x;
        this.y=y;
    }
    int getO(){return o;}
    int getX(){return x;}
    char getY(){return y;}
}