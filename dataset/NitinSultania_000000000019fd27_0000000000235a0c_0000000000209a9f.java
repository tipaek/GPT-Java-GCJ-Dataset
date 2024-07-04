import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t;
        t=sc.nextInt();
        sc.nextLine();
        int z=1;
        while(t!=0)
        {
            String str;
            str=sc.nextLine();
            StringBuffer str1=new StringBuffer();
            int cur=0;
            int n=str.length();
            for(int i=0;i<n;i++)
            {
                int temp=str.charAt(i)-48;
                while(cur<temp)
                {
                    str1.append('(');
                    cur++;
                }
                while(cur>temp)
                {
                    str1.append(')');
                    cur--;
                }
                str1.append(temp);
            }
            while(cur>0)
            {
                str1.append(')');
                cur--;
            }
            System.out.println("Case #"+z+":"+" "+str1);
            z++;
            t--;
        }
    }
}
