import java.util.Scanner;

public class NestingDepth
{
    public static void main(String[]args)
    {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for(int i=0;i<t;i++)
        {
            String s=scan.next();
            String sp="";
            for(int j=0;j<s.length();j++)
            {
                int d=Integer.parseInt(s.substring(j,j+1));
                for(int k=0;k<d;k++)
                    sp=sp+"(";
                sp=sp+d;
                for(int k=0;k<d;k++)
                    sp=sp+")";
            }
            while(true)
            {
                int k=sp.indexOf(")(");
                if(k==-1)
                    break;
                sp=sp.substring(0,k)+sp.substring(k+2);
            }
            System.out.println("Case #"+i+": "+sp);
        }
    }
}
