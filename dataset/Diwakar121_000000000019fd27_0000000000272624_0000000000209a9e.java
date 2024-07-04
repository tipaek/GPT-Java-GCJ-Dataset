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
            int arr[] = new int[b];
            for(int j=0;j<b;j++)
            {    System.out.println(j+1);
            System.out.flush();
                arr[j]=obj.nextInt();
            }
            StringBuilder str = new StringBuilder("");
            for(int j=0;j<b;j++)
            {if(arr[j]==1)
                str.append("1");
            else
                 str.append("0");
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