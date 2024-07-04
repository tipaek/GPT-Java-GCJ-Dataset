import java.util.Scanner;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<t;i++)
        {
            
            String s=sc.nextLine();
            String sa=new String();
            int op=0,cp=0,prevele=0,presele=0;
            for(int j=0;j<s.length();j++)
            {
                if(j==0)
                {
                    prevele=s.charAt(j)-48;
                    op=prevele;
                    cp=prevele;
                    for(int k=0;k<op;k++)
                    {
                        sa+="(";
                    }
                    sa+=prevele;
                }
                else
                {
                    presele=s.charAt(j)-48;
                    if(presele>prevele)
                    {
                        op=presele-prevele;
                        cp=cp+op;
                        for(int k=0;k<op;k++)
                        {
                            sa+="(";
                        }
                        sa+=presele;
                        prevele=presele;
                    }
                    else if(prevele>presele)
                    {
                        for(int k=0;k<(prevele-presele);k++)
                        {
                            sa+=")";
                        }
                        sa+=presele;
                        
                        cp=cp-(prevele-presele);
                        prevele=presele;
                    }
                    else
                    sa+=presele;
                }
                if(j==s.length()-1)
                {
                    for(int k=0;k<cp;k++)
                    {
                        sa+=")";
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+sa);
        }
    }
}