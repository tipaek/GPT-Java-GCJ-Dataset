/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
class Main
{
    public static String balance(String str)
    {
       
       String  st  = " ";
       int have , lose, want, add;
       have=0;
       lose=0;
       add=0;
       want=0;
       for(int i=0;i<str.length();i++)
       {
           want=str.charAt(i) - '0'; // digitd h ques ki
           if(have==want) // want is 0 so have is 0 digit 
           {
            st+=str.charAt(i);   
           }
           else if(want>have)
           {
               add= want-have; // add k andr () hai
               for(int iii=0 ; iii<add ; iii++)
               {
                   st+="(";
                   st+=str.charAt(iii);
                   have = want;
               }
           }
           else
           {
               lose = have- want;
               for(int ii =0 ; ii<lose;ii++)
               {
                   st+=")";
                   st+=str.charAt(ii);
                   have = want;
               }
           }
       }
       for(int i = 0 ; i <have ;i++)
       {
           st+=")";
       }
         
        return st;
        
        
    }
    public static void main (String[] args)
    {
         Scanner scn =new Scanner (System.in);
       
        int t = scn.nextInt();
        // test_case=1;
        while(t>0)
        {
         String str = scn.next();
        String st = balance(str);
        System.out.println("Case # "+  t++ +":" +st);
        t--;
        
    }
}
}