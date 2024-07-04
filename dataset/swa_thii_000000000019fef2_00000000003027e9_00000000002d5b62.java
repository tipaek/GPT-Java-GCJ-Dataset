import java.util.*;
class position
{
    int p1,p2;
    String s="";
    position(int a,int b,String str)
    {
        p1=a;
        p2=b;
        s=s+str;
    }
}
public class Solution
{
 public static void main(String args[])
 {
     Scanner sc=new Scanner(System.in);
     int t=sc.nextInt();
     for(int j=1;j<=t;j++)
     {
         int x=sc.nextInt();
         int y=sc.nextInt();
         String ans="";
         Queue<position> q=new LinkedList<>();
         HashMap<Integer,Set<Integer>> map=new HashMap<>();
         q.add(new position(0,0,""));
         map.put(0,new HashSet<>());
         map.get(0).add(0);
         int i=1;
         while(true)
         {
             int k=q.size();
             int flag=0;
             int step=(int)Math.pow(2,i-1);
             //System.out.println(map);
             while(k!=0)
             {
                 position p=q.remove();
                 //System.out.println(p.p1+" "+p.p2+" "+p.s);
                 if(p.p1+step==x&&p.p2==y)
                 {
                     ans=p.s+"E";
                     flag=1;
                     break;
                 }
                 else if(p.p1-step==x&&p.p2==y)
                 {
                     ans=p.s+"W";
                     flag=1;
                     break;
                 }
                 else if(p.p1==x&&p.p2+step==y)
                 {
                     ans=p.s+"N";
                     flag=1;
                     break;
                 }
                 else if(p.p1==x&&p.p2-step==y)
                 {
                     ans=p.s+"S";
                     flag=1;
                     break;
                 }
                 if((!map.containsKey(p.p1+step))||(map.containsKey(p.p1+step)&&!map.get(p.p1+step).contains(p.p2)))
                 {
                     q.add(new position(p.p1+step,p.p2,p.s+"E"));
                     if(!map.containsKey(p.p1+step))
                     map.put(p.p1+step,new HashSet<>());
                     map.get(p.p1+step).add(p.p2);
                 }
                 if((!map.containsKey(p.p1-step))||(map.containsKey(p.p1-step)&&!map.get(p.p1-step).contains(p.p2)))
                 {
                     q.add(new position(p.p1-step,p.p2,p.s+"W"));
                     if(!map.containsKey(p.p1-step))
                     map.put(p.p1-step,new HashSet<>());
                     map.get(p.p1-step).add(p.p2);
                 }
                 if((!map.containsKey(p.p1))||(map.containsKey(p.p1)&&!map.get(p.p1).contains(p.p2+step)))
                 {
                     q.add(new position(p.p1,p.p2+step,p.s+"N"));
                     if(!map.containsKey(p.p1))
                     map.put(p.p1,new HashSet<>());
                     map.get(p.p1).add(p.p2+step);
                 }
                 if((!map.containsKey(p.p1))||(map.containsKey(p.p1)&&!map.get(p.p1).contains(p.p2-step)))
                 {
                     q.add(new position(p.p1,p.p2-step,p.s+"S"));
                     if(!map.containsKey(p.p1))
                     map.put(p.p1,new HashSet<>());
                     map.get(p.p1).add(p.p2-step);
                 }
                 --k;
             }
             ++i;
             System.out.println();
             if(flag==1){
                 System.out.println("Case #"+j+": "+ans);
                 break;
             }
         }
     }
 }
}