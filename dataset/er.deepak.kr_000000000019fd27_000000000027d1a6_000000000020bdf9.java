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
             list.add(new Node(s,'s',i));
             list.add(new Node(e,'e',i));   
         }
        // Collections.sort(list,(o1,o2)->o1.getX()-o2.getX());
         Collections.sort(list,new myComp());
         String ans="";
         char ar[]=new char[n];
         int a=-1,b=-1;
         boolean ch=false;
         for(int i=0;i<list.size();i++)
         {
             //System.out.print(list.get(i).getX()+" , "+list.get(i).getY()+" c="+a+" j="+b);
             if(list.get(i).getY()=='s')
             {
                 
                 if(a!=-1&&b!=-1)
                 {
                     ch=true;
                     break;
                 }
                 else if(b==-1)
                 {  b=list.get(i).getI();
                    ar[b]='J';
                 }
                 else if(a==-1)
                 {  a=list.get(i).getI();
                    ar[a]='C';
                 }
                 
             }
             else
             {
                 if(list.get(i).getI()==a){
                     a=-1;
                 }else
                 {
                     b=-1;
                 }
                 
             }
             //System.out.println(" ans="+ans);
         }
         if(ch)
         System.out.println("Case #"+k+": IMPOSSIBLE");
         else
         System.out.println("Case #"+k+": "+new String(ar));
     }
     
 }
}
class Node{
    int x;
    char y;
    int i;
    Node(int x,char y,int i)
    {
        this.x=x;
        this.i=i;
        this.y=y;
    }
    int getX(){return x;}
    char getY(){return y;}
    int getI(){return i;}
}
class myComp implements Comparator<Node>{
    public int compare(Node a, Node b)
    {
        if(a.getX()==b.getX())
        {
            if(a.getY()==b.getY())
            {
                return 0;
            }
            else if(a.getY()=='e') return -1;
            else return 0;
        }
        else return a.getX()-b.getX();
    }
}