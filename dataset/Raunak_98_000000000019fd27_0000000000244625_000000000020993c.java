import java.util.*;
public class Solution
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int tc=1;
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[][]=new int[n][n];
            int sum = 0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=sc.nextInt();
                    if(i==j)
                        sum+=arr[i][j];
                }
            }
            int kr = 0;
            int kc = 0;
            

            for(int i =0;i<n;i++)
            {
                HashSet<Integer> mapR = new HashSet<>();
                HashSet<Integer> mapC = new HashSet<>();
                boolean flagR =true, flagC=true;
                for(int j=0;j<n;j++)
                {
                    int x =arr[i][j];
                    int y = arr[j][i];
                    if(mapR.contains(x))
                    {
                        if(flagR)
                        {
                            kr++;
                            flagR=false;
                        }
                    }
                    if(mapC.contains(y))
                    {
                        if(flagC)
                        {
                            kc++;
                            flagC=false;
                        }
                    }
                    mapR.add(x);
                    mapC.add(y);
                }
            }
            System.out.println("Case #"+tc+": "+sum+" "+kr+" "+kc);
            tc++;
        }
    }
}