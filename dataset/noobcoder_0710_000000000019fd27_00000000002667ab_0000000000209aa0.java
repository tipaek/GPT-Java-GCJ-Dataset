import javautil.*;
public class Solution
{
    public static void main(String args[])throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());
        for(int x=0;x<t;x++)
        {
            String str[]=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int k=Integer.parseInt(str[1]);
            if(n==2)
            {
                if(k==3)
                pw.println("Case #"+(x+1)+": IMPOSSIBLE");
                else
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    if(k==4)
                    {
                        pw.println("2 1");
                        pw.println("1 2");
                    }
                    if(k==2)
                    {
                        pw.println("1 2");
                        pw.println("2 1");
                    }
                }
            }
            else if(n==3)
            {
                if(k==3)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("1 2 3");
                    pw.println("3 1 2");
                    pw.println("2 3 1");
                }
                else if(k==6)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("2 1 3");
                    pw.println("3 2 1");
                    pw.println("1 3 2");
                }
                else if(k==9)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("3 1 2");
                    pw.println("2 3 1");
                    pw.println("1 2 3");
                }
                else
                pw.println("Case #"+(x+1)+": IMPOSSIBLE");
            }
            else if(n==4)
            {
                if(k==4)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("1 2 3 4");
                    pw.println("2 1 4 3");
                    pw.println("3 4 1 2");
                    pw.println("4 3 2 1");
                }
                else if(k==6)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("1 2 3 4");
                    pw.println("2 1 4 3");
                    pw.println("3 4 2 1");
                    pw.println("4 3 1 2");
                }
                else if(k==7)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("1 2 3 4");
                    pw.println("2 1 4 3");
                    pw.println("3 4 2 1");
                    pw.println("4 3 1 2");
                }
                else if(k==8)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("2 3 4 1");
                    pw.println("1 2 3 4");
                    pw.println("4 1 2 3");
                    pw.println("3 4 1 2");
                }
                else if(k==9)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("1 4 2 3");
                    pw.println("3 1 4 2");
                    pw.println("4 2 3 1");
                    pw.println("2 3 1 4");
                }
                else if(k==10)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("1 4 3 2");
                    pw.println("4 1 2 3");
                    pw.println("2 3 4 1");
                    pw.println("3 2 1 4");
                }
                else if(k==11)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("1 4 2 3");
                    pw.println("3 1 4 2");
                    pw.println("4 2 3 1");
                    pw.println("2 3 1 4");
                }
                else if(k==12)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("3 4 1 2");
                    pw.println("2 3 4 1");
                    pw.println("1 2 3 4");
                    pw.println("4 1 2 3");
                }
                else if(k==13)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("2 4 3 1");
                    pw.println("4 3 1 2");
                    pw.println("1 2 4 3");
                    pw.println("3 1 2 4");
                }
                else if(k==14)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("3 4 2 1");
                    pw.println("4 3 1 2");
                    pw.println("1 2 4 3");
                    pw.println("2 1 3 4");
                }
                else if(k==16)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("4 1 2 3");
                    pw.println("3 4 1 2");
                    pw.println("2 3 4 1");
                    pw.println("1 2 3 4");
                }
                else
                pw.println("Case #"+(x+1)+": IMPOSSIBLE");
            }
            else if(n==5)
            {
                if(k==5)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("1 2 3 4 5");
                    pw.println("5 1 2 3 4");
                    pw.println("4 5 1 2 3");
                    pw.println("3 4 5 1 2");
                    pw.println("2 3 4 5 1");
                }
                else if(k==7)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("1 4 3 2 5");
                    pw.println("2 1 4 5 3");
                    pw.println("5 3 2 4 1");
                    pw.println("3 2 5 1 4");
                    pw.println("4 5 1 3 2");
                }
                else if(k==8)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("1 5 3 2 4");
                    pw.println("5 3 2 4 1");
                    pw.println("4 2 1 3 5");
                    pw.println("2 4 5 1 3");
                    pw.println("3 1 4 5 2");
                }
                else if(k==9)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("3 4 2 1 5");
                    pw.println("1 2 3 5 4");
                    pw.println("5 3 1 4 2");
                    pw.println("4 1 5 2 3");
                    pw.println("2 5 4 3 1");
                }
                else if(k==10)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("2 3 4 5 1");
                    pw.println("1 2 3 4 5");
                    pw.println("5 1 2 3 4");
                    pw.println("4 5 1 2 3");
                    pw.println("3 4 5 1 2");
                }
                else if(k==11)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("3 1 5 4 2");
                    pw.println("2 3 4 1 5");
                    pw.println("1 5 2 3 4");
                    pw.println("5 4 1 2 3");
                    pw.println("4 2 3 5 1");
                }
                else if(k==12)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("5 4 1 3 2");
                    pw.println("1 2 5 4 3");
                    pw.println("2 1 3 5 4");
                    pw.println("4 3 2 1 5");
                    pw.println("3 5 4 2 1");
                }
                else if(k==13)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("5 1 2 4 3");
                    pw.println("2 3 1 5 4");
                    pw.println("1 4 3 2 5");
                    pw.println("3 5 4 1 2");
                    pw.println("4 2 5 3 1");
                }
                else if(k==14)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("5 1 2 4 3");
                    pw.println("3 4 1 5 2");
                    pw.println("1 5 3 2 4");
                    pw.println("2 3 4 1 5");
                    pw.println("4 2 5 3 1");
                }
                else if(k==15)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("5 2 4 1 3");
                    pw.println("1 4 5 3 2");
                    pw.println("3 5 1 2 4");
                    pw.println("2 1 3 4 5");
                    pw.println("4 3 2 5 1");
                }
                else if(k==16)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("5 2 3 1 4");
                    pw.println("1 5 4 3 2");
                    pw.println("3 4 1 2 5");
                    pw.println("2 1 5 4 3");
                    pw.println("4 3 2 5 1");
                }
                else if(k==17)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("5 2 4 1 3");
                    pw.println("3 5 1 2 4");
                    pw.println("4 1 2 3 5");
                    pw.println("1 3 5 4 2");
                    pw.println("2 4 3 5 1");
                }
                else if(k==18)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("5 2 1 3 4");
                    pw.println("1 5 4 2 3");
                    pw.println("2 4 3 1 5");
                    pw.println("3 1 5 4 2");
                    pw.println("4 3 2 5 1");
                }
                else if(k==19)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("5 1 3 2 4");
                    pw.println("4 5 2 1 3");
                    pw.println("1 3 4 5 2");
                    pw.println("3 2 1 4 5");
                    pw.println("2 4 5 3 1");
                }
                else if(k==20)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("5 2 1 3 4");
                    pw.println("4 5 2 1 3");
                    pw.println("3 1 4 2 5");
                    pw.println("2 3 5 4 1");
                    pw.println("1 4 3 5 2");
                }
                else if(k==21)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("5 2 1 3 4");
                    pw.println("4 5 3 2 1");
                    pw.println("2 3 4 1 5");
                    pw.println("3 1 5 4 2");
                    pw.println("1 4 2 5 3");
                }
                else if(k==22)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("5 4 3 2 1");
                    pw.println("4 5 1 3 2");
                    pw.println("2 1 4 5 3");
                    pw.println("1 3 2 4 5");
                    pw.println("3 2 5 1 4");
                }
                else if(k==23)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("5 3 4 1 2");
                    pw.println("4 5 2 3 1");
                    pw.println("1 4 5 2 3");
                    pw.println("3 2 1 4 5");
                    pw.println("2 1 3 5 4");
                }
                else if(k==25)
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    pw.println("5 1 2 3 4");
                    pw.println("4 5 1 2 3");
                    pw.println("3 4 5 1 2");
                    pw.println("2 3 4 5 1");
                    pw.println("1 2 3 4 5");
                }
                else
                pw.println("Case #"+(x+1)+": IMPOSSIBLE");
            }
        }
        pw.flush();
        pw.close();
    }
}