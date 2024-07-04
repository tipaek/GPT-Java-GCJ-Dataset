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
          list.add(new Node(s,'s',e,i));
          list.add(new Node(e,'e',s,i));   
         }
         Collections.sort(list,(o1,o2)->o1.getX()-o2.getX());
         String ans="";
         char ar[]=new char[n];
         int a=0,b=0;
         boolean ch=false;
         for(int i=0;i<list.size();i++)
         {
             //System.out.print(list.get(i).getX()+" , "+list.get(i).getY()+" c="+a+" j="+b);
             if(list.get(i).getY()=='s')
             {
                 
                 if(a!=0&&b!=0)
                 {
                     ch=true;
                     break;
                 }
                 else if(a==0)
                 {
                    ar[list.get(i).getI()]='C';
                     a=list.get(i).getO();
                 }
                 else if(b==0)
                 {
                    ar[list.get(i).getI()]='J';
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
    int o;
    int i;
    Node(int x,char y,int o,int i)
    {
        this.o=o;
        this.x=x;
        this.i=i;
        this.y=y;
    }
    int getO(){return o;}
    int getX(){return x;}
    char getY(){return y;}
    int getI(){return i;}
}