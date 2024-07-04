import java.util.*;

public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i=0;i<t;i++)
        {
            int a[] = new int[1442];
            int b[] = new int[1442];
            int n = sc.nextInt();
            String op = "";
            int not=0;
            for(int j=0;j<n;j++)
            {
                int l = sc.nextInt();
                int u = sc.nextInt();
                
                if(j==0)
                {
                    for(int p=l;p<=u;p++)
                    {
                        a[p] = 1;
                        //System.out.println(a[p]);
                    }
                    op+='C';
                }
                else
                {
                   // System.out.println(a[0]);
                    if(a[l+1] == 0 && a[u-1] == 0)
                    {
                        for(int p=l;p<=u;p++)
                        {
                            
                            a[p] = 1;
                        }
                        op+='C';
                    }
                    
                    else if(b[l+1] == 0 && b[u-1] == 0)
                    {
                        for(int p=l;p<=u;p++)
                        {
                            b[p] = 1;
                        }
                        op+='J';
                    }
                    else
                    {
                        not=1;
                        break;
                    }
                }
            }
            if(not == 1)
            {
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            }
            else
            {
                System.out.println("Case #"+(i+1)+": "+op);
            }
        }
    }
}