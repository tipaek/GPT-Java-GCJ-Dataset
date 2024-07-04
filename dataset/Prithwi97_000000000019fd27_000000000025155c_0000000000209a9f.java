import java.util.Scanner;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt(),tno=0;
        while(T-->0)
        {
            String s=sc.next();
            String balanced="";
            int l=s.length();
            int count=0;
            char prev='0';
            for(int i=0;i<l;i++)
            {
                char c=s.charAt(i);
                if(c>prev)
                {
                    int itr=c-prev;
                    for(int j=1;j<=itr;j++)
                    {
                        balanced=balanced+'(';
                        count++;
                    }
                }
                else if(c<prev)
                {
                    int itr=prev-c;
                    for(int j=1;j<=itr;j++)
                    {
                        balanced=balanced+')';
                        count--;
                    }
                }
                balanced=balanced+c;
                prev=c;
            }
            while(count-->0)
            {
                balanced=balanced+')';
            }
            System.out.println("Case #"+(++tno)+": "+balanced);
        }
    }
}