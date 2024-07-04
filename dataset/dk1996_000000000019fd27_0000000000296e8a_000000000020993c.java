import java.util.*;

class Vestigium
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextLine();
        int temp=1;
        while(temp!=r)
        {
            int c=sc.nextLine();
            int mat[][]=new int[c][c];
            for(int i=0;i<c;i++)
            {
                for(int j=0;j<c;j++)
                {
                    mat[i][j]=sc.nextLine();
                }
            }
            int trace=0;
            for(int i=0;i<c;i++)
            {
                trace+=mat[i][i];
            }
            int c_count=0;
            int r_count=0;
            for(int i=0;i<c;i++)
            {
                for(int j=0;j<c-1;j++)
                {
                    for(int k=j+1;k<c;k++)
                    {
                        if(mat[j][i]==mat[k][i])
                        {
                            c_count++;
                            break;
                        }
                    }
                }
            }
            for(int i=0;i<c;i++)
            {
                for(int j=0;j<c-1;j++)
                {
                    for(int k=j+1;k<c;k++)
                    {
                        if(mat[i][j]==mat[i][k])
                        {
                            r_count++;
                            break;
                        }
                    }
                }
            }
            System.out.println("Case #"+temp+": "+trace+" "+r_count+" "+c_count);
            temp++;
        }
    }
}
                    