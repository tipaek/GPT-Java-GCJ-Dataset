import java.util.*;
class Solution{
 public static void main(String arg[]){
 
 Scanner ob=new Scanner(System.in);
 int t=ob.nextInt();
 int k=0;
 while(t-->0)
 {
     k++;
    String s=ob.next();
    int size=0;
    String ans="";
    for(int i=0;i<s.length();i++)
    {
        int x=Character.getNumericValue(s.charAt(i));
        if(size==x)
        {
            
        }
        else if(size<x)
        {
            while(size<x)
            {
            ans+="(";
            size++;
            }
         
        }
        else
        {
            while(size>x)
            {
                ans+=")";
                size--;
            }
        }
        ans+=s.charAt(i);
    }
    while(size>0)
            {
                ans+=")";
                size--;
            }
    System.out.println("Case #"+k+": "+ans);
 
 }
 
 }
}