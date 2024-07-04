import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        for(int i = 1; i <= S; i++)
        {
            int s = sc.nextInt();
            int[][] startArr=new int[s][2];
            int[][] endArr=new int[s][2];
            for(int j = 0; j < s; j++)
            {
                int val1 = sc.nextInt();
                int val2 = sc.nextInt();
                startArr[j][0] = val1;
                startArr[j][1] = val2;
                endArr[j][0] = val1;
                endArr[j][1] = val2;
            }
            for(int j = 0; j < s - 1; j++)
            {
                for(int k = 0; k < s-j-1; k++)
                {
                    if(startArr[k][0] > startArr[k+1][0])
                    {
                        int temp = startArr[k][0];
                        startArr[k][0] = startArr[k+1][0];
                        startArr[k+1][0] = temp;
                        temp = startArr[k][1];
                        startArr[k][1] = startArr[k+1][1];
                        startArr[k+1][1] = temp;
                    }
                    if(startArr[k][0]==startArr[k+1][0])
                    {
                        if(startArr[k][1] > startArr[k+1][1])
                        {
                            int temp = startArr[k][1];
                            startArr[k][1] = startArr[k + 1][1];
                            startArr[k + 1][1] = temp;
                        }
                    }
                }
            }
            char[] ch = new char[s];
            int lastc =-1;
            int lastf =-1;
            int flag = 0;
            for(int j = 0; j < s; j++)
            {
                int val=-1;
                for(int k = 0; k < s; k++)
                {
                    if(startArr[j][0]==endArr[k][0] && startArr[j][1]==endArr[k][1])
                    {
                        endArr[k][0]=-1;
                        endArr[k][1]=-1;
                        val=k;
                        break;
                    }
                }
                if(startArr[j][0]>=lastc)
                {
                    ch[val]='C';
                    lastc=startArr[j][1];
                }
                else if(startArr[j][0]>=lastf)
                {
                    ch[val]='J';
                    lastf=startArr[j][1];
                }
                else
                {
                    flag=1;
                    break;
                }
            }
            String  t = new String(ch);
            if(flag==0)
            {
                System.out.println("Case #"+ i+ ": "+t);
            }
            else
            {
                System.out.println("Case #"+ i+ ": IMPOSSIBLE");
            }
        }
    }
}