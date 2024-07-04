import java.util.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
    int  t=sc.nextInt();
    for(int  z=0;z<t;z++)
    {
       int n=sc.nextInt(); 
           String s[]=new String[n];
           
           for(int i=0;i<n;i++)
               s[i]=sc.next();
           
           int y=1,w,j=-1;
           int ni=z+1;
           
           for(int i=0;i<n;i++)
           {
               w=s[i].length();
               if(w>y)
               {
                   y=w;
                   j=i;
               }
           }
           //System.out.println(j);
           char array[]=new char[s[j].length()-1];
           for(int i=1;i<s[j].length();i++)
           {
               array[i-1]=s[j].charAt(i);
           }
           boolean flag=true;
           char x,h;
           int l=0;
           for(int i=0;i<n;i++)
           {
                l=s[i].length()-1;
           for(int k=s[j].length()-1;k>=1;k--,l--)
           {
           x=s[j].charAt(k);
          // System.out.println("x= "+x);

               if(l>=1)
               {
               h=s[i].charAt(l);
             //  System.out.println("h= "+h);
               if(x!=h)
               {
                   flag=false;
                   break;
               }
               }
           }
           }
           System.out.print("Case #"+ni+": ");
           if(flag==false)
               System.out.println("*");
           else
           {
               for(int i=0;i<s[j].length()-1;i++)
               {
                   System.out.print(array[i]);
                   
               }
               System.out.println();
           }
           
        }
    }
}