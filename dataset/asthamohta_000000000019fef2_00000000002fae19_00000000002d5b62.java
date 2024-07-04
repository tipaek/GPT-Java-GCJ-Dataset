import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution {
    public static class Node
    {
       int x;int y;String dir;
    Node(int a, int b,String d)
    {
       x=a;
       y=b;
       dir=d;    
    }
    
    }
    public static boolean inBound(int x1,int y1,int x,int y, int quad)
    {   
        if(quad==1)
        {
           if(x1>x||y1>y)
           return false;
           else return true;
        
        }
        if(quad==2)
        {
           if(x1<x||y1>y)
           return false;
           else return true;
        
        }
        if(quad==3)
        {
           if(x1<x||y1<y)
           return false;
           else return true;
        
        }
        if(quad==4)
        {
           if(x1>x||y1<y)
           return false;
           else return true;
        
        }
        return true;
    
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for(int t=1;t<=test;t++)
        {   
           int x=sc.nextInt();
           int y=sc.nextInt();
           int quad=0;
           if(x>=0&&y>=0)
           quad=1;
           if(x<=0&&y>=0)
           quad=2;
           if(x<=0&&y<=0)
           quad=3;
           if(x>=0&&y<=0)
           quad=4;
           LinkedList<Node> list=new LinkedList<Node>();
           list.add(new Node(0,0,""));
           Node sol=null;
           while(!list.isEmpty())
           {
              Node curr=list.removeFirst();
              if(curr.x>10007 ||curr.y>10007)
                  break;
            //   System.out.println(curr.x+" "+curr.y);
              if(curr.x==x&& curr.y==y)
              {sol=curr;
              break;}
              if(inBound(curr.x+(int)Math.pow(2,curr.dir.length()),curr.y,x,y,quad))
              {   
                list.addLast(new Node(curr.x+(int)Math.pow(2,curr.dir.length()),curr.y,curr.dir+"N"));   
              }
              if(inBound(curr.x-(int)Math.pow(2,curr.dir.length()),curr.y,x,y,quad))
              {   
                list.addLast(new Node(curr.x-(int)Math.pow(2,curr.dir.length()),curr.y,curr.dir+"S"));   
              }
              if(inBound(curr.x,curr.y+(int)Math.pow(2,curr.dir.length()),x,y,quad))
              {   
                list.addLast(new Node(curr.x,curr.y+(int)Math.pow(2,curr.dir.length()),curr.dir+"E"));   
              }
              if(inBound(curr.x,curr.y-(int)Math.pow(2,curr.dir.length()),x,y,quad))
              {   
                list.addLast(new Node(curr.x,curr.y-(int)Math.pow(2,curr.dir.length()),curr.dir+"W"));   
              }
           
           }
           if(sol==null){
           System.out.println("Case #"+t+": IMPOSSIBLE");}
           else System.out.println("Case #"+t+": "+sol.dir);
        
        }
        
    }
}