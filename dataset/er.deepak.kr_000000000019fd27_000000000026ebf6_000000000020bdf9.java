import java.util.*;
public class Solution{
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
          list.add(new Node(s,'s'));
          list.add(new Node(e,'e'));   
         }
         Collections.sort(list,(o1,o2)->o1.getX()-o2.getX());
         String ans="";
         int c=0;
         for(int i=0;i<list.size();i++)
         {
             if(list.get(i).getY()=='s')
             {
                 c++;
                 if(c>2)
                 {
                     ans="IMPOSSIBLE";
                     break;
                 }
                 else if(c==1)
                 {
                     ans+="C";
                 }
                 else
                 {
                     ans+="J";
                 }
             }
             else
             {
                 c--;
                 
             }
         }
         System.out.println("Case #"+k+": "+ans);
     }
     
 }
}
class Node{
    int x;
    char y;
    Node(int x,char y)
    {
        this.x=x;
        this.y=y;
    }
    int getX(){return x;}
    char getY(){return y;}
}