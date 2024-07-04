import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner obj =new Scanner(System.in);
        int t = obj.nextInt();
        for(int i=0;i<t ; i++)
        {
            

            int b = obj.nextInt();
          
          StringBuilder str = new StringBuilder("");
            for(int j=0;j<b;j++)
            {System.out.println(j+1);
            System.out.flush();
            char c=obj.next.charAt(0);
             
                str.append(c);
           
            }
            System.out.println(str);
             System.out.flush();
             char z =obj.next().charAt(0);
             if(z=='N')
             {
                 break;
             }
        }
    }
    
    
}