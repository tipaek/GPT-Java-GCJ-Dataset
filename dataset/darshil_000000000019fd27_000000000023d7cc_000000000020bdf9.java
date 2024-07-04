import java.util.*;

public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i=0;i<t;i++)
        {
            boolean a[] = new boolean[1442];
            boolean b[] = new boolean[1442];
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
                        a[p] = true;
                        //System.out.println(a[p]);
                    }
                    op+='C';
                }
                else
                {
                   // System.out.println(a[0]);
                    if(a[l+1] == false && a[u-1] == false)
                    {
                        for(int p=l;p<=u;p++)
                        {
                            
                            a[p] = true;
                        }
                        op+='C';
                    }
                    
                    else if(b[l+1] == false && b[u-1] == false)
                    {
                        for(int p=l;p<=u;p++)
                        {
                            b[p] = true;
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