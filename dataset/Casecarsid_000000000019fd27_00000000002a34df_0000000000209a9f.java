import java.util.*;
  
public class Solution
{ 
    public static void main(String[] args) 
    { 

        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        
        for(int i=1 ; i<= testCases ; i++)
        {
            String st = sc.nextLine();
            System.out.println("Case #"+i+": "+nestDepth(st));
         } 
    }

    public static String nestDepth(String s){
        StringBuilder res = new StringBuilder(s);
        int x=0;
        int b = Character.getNumericValue(s.charAt(0));
        for(int i = b ; i>0 ; i--)
        {
        res.insert(0, '(');
        }
       
       for(int i = 1 ; i < s.length() ; i++)
       {
            x = Character.getNumericValue(s.charAt(i));
            if(x>b && b!=0)
            {
                for(int j = x-b ; j>0 ; j--)
                    {
                        res.insert(i+b, '(');
                    }
            }
            else if(x<b)
            {
                for(int j = b-x ; j>0 ; j--)
                    {
                        res.insert(i+b, ')');
                    }
            }
            b = x;
       }
       
       for(int j = x ; j>0 ; j--)
                    {
                        res.insert(s.length()+x, ')');
                    }
            

        return res.toString();
    }

}