import java.util.*;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int ti=1;ti<=test;ti++)
        {
            int n = sc.nextInt();
            int cc=0; int jc=0;
            int A[][] = new int[n][3];
            for(int i=0;i<n;i++)
            {
                A[i][0]=sc.nextInt();
                A[i][1]=sc.nextInt();
                A[i][2] = i+1;
            }
            for(int i=0;i<n-1;i++)
            {
                for(int j=0;j<n-i-1;j++)
                {
                    if(A[j][0] > A[j+1][0])
                    {
                        int temp = A[j][0]; int temp2 = A[j][1]; int temp3 = A[j][2];
                        A[j][0] = A[j+1][0]; A[j][1] = A[j+1][1]; A[j][2] = A[j+1][2];
                        A[j+1][0] = temp; A[j+1][1] = temp2; A[j+1][2] = temp3;
                    }
                }
            }
             boolean flag=true;
             String final_ans="";
            String ans[] = new String[n];
            for(int i=0;i<n;i++)
            {
                if(cc<=A[i][0])
                {
                    ans[i]="C";
                    cc=A[i][1]; 
                }
                else if(jc<=A[i][0])
                {
                    ans[i]="J";
                    jc=A[i][1];
                }
                else
                {
                    ans[i]="Q";
                    flag=false;
                }
            }
            if(flag==false)
            {
                System.out.println("Case #"+ti+": IMPOSSIBLE");
                continue;
            }
            else
            {
                for(int i=0;i<n-1;i++)
                {
                    for(int j=0;j<n-i-1;j++)
                    {
                        if(A[j][2] > A[j+1][2])
                        {
                            int temp = A[j][0]; int temp2 = A[j][1]; int temp3 = A[j][2]; String temp4 = ans[j];
                            A[j][0] = A[j+1][0]; A[j][1] = A[j+1][1]; A[j][2] = A[j+1][2]; ans[j] = ans[j+1];
                            A[j+1][0] = temp; A[j+1][1] = temp2; A[j+1][2] = temp3; ans[j+1] = temp4;
                        }
                    }
                }
            final_ans="";
            for(int i=0;i<n;i++)
            {
                final_ans=final_ans+ans[i];
            }
            }
            System.out.println("Case #"+ti+": "+final_ans);
        }
    }
}