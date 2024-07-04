import java.util.*;
class Solution{
    public static void main(String args[])
    {
       Scanner Sc=new Scanner(System.in);
       int tests=Sc.nextInt();
       for(int i=0;i<tests;i++)
       {
           String s = Sc.next();
           String s2 = "";
           int countconsecutiveones=0;
           for(int j=0;j<s.length();j++)
           {
               char currentdigit=s.charAt(j);
               if(currentdigit=='0')
               {
                   if(countconsecutiveones==0)
                   {
                      s2=s2+"0"; 
                   }
                   else
                   {
                     String repeated = new String(new char[countconsecutiveones]).replace("\0", "1");
                     s2=s2+"("+repeated+")";
                     countconsecutiveones=0; 
                     s2=s2+"0";
                   }
                   
               }
               else
               {
                 countconsecutiveones++;
               }
           }
            if(countconsecutiveones!=0)
            {
                String repeated = new String(new char[countconsecutiveones]).replace("\0", "1");
                s2=s2+"("+repeated+")";
                countconsecutiveones=0; 
            }
           System.out.println("Case #"+(i+1)+": "+s2);
       }
    }
}