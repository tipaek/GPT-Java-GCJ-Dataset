import java.util.*;
public class main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int i,j;
        int t=sc.nextInt();
        for(i=0;i<t;i++)
        {
            String str=sc.next();
            int len=str.length();
            char[] ch = new char[len];
            for(j=0;j<len;j++)
            {
                if(ch[j]==0)
                {
                    System.out.println("("+ch[j]+")");
                    j++;
                }
                  System.out.print(ch[j]);
            }
        }
    }
}
            
                  
            
