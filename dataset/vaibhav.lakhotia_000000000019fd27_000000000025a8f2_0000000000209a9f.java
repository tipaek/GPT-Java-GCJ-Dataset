import java.util.*;
public class Main
{
public static void main(String Args[])
{
    int l ,ch=0 ,chn=0 , c=0 , x=0 ,T ; 
    Scanner sc= new Scanner(System.in);
    T=sc.nextInt();
    String S;
    for(int k=0;k<T+1;k++)
    {
S=sc.nextLine();
l=S.length();
for(int i=0;i<l;i++)
{
    ch=S.charAt(i);
    ch=ch-48;
    if(i==0)
    {
        System.out.print("Case #" + (i+1) +": ");
    for(int j=0;j<ch;j++)
    {
       
       System.out.print("(");
    }}
    else{
        x=-(c);
        for(int j=0;j<x;j++)
    {
       System.out.print("(");
    }
    }
   System.out.print(ch);
    if(i!=l-1)
    {
    chn=S.charAt(i+1);
    chn=chn-48;
    c=ch-chn;
    if(c>0)
    {
     for(int j=0;j<c;j++) 
     {
         System.out.print(")");
     }
    }
    }
    else{
        for(int j=0;j<(ch);j++) 
     {
         System.out.print(")");
         
     }
    }
   
}
 System.out.println();
}
}}