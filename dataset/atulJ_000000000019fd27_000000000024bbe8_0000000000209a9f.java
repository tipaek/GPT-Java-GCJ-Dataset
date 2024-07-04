import java.io.*;
import java.util.*;

public class Solution 
{
    public static void main(String[] args) 
    {
        Scanner in= new Scanner(System.in);
        int  t=in.nextInt();

        for (int x = 0; x < t; x++) 
        {
            String s= in.next();
            
           


            String a[]=s.split("0");

            for (int j = 0; j < a.length; j++)             
            {
                if(a[j].length()>0)
                {
                    a[j]="("+a[j]+")";
                    for (int i =50; i < 58; i++) 
                    {
                      String d= Character.toString((char)i);
                      if(a[j].indexOf(d)>-1)
                      {
                          int li=a[j].indexOf(d),ri=a[j].indexOf(d), ind=a[j].indexOf(d);
                          while( ( a[j].charAt(li-1)> a[j].charAt(ind) && ( (char)50< a[j].charAt(li-1) && a[j].charAt(li-1)<(char)58 ) ) ||( a[j].charAt(ri+1)> a[j].charAt(ind) ) && ( (char)50< a[j].charAt(ri+1) && a[j].charAt(ri+1)<(char)58 ) ) 
                          { 
                              if(a[j].charAt(li-1)> a[j].charAt(ind))    li--;
                              else     ri++;                 
                          }
                          a[j]=s.substring(0, li)+"("+s.substring(li,ri+1)+ ")"+s.substring(ri, a[j].length()) ;

                      }
                    }
                }
            }
        
            String out="";
            
            for (int i = 0; i < a.length; i++) 
            {
                if(a[i].length()==0)
                {
                out+="0";
                }
                else
                {
                    out+=a[i];
                }

            }
            
            System.out.println("Case #"+x+1+": "+ out);
        }


    }   
}