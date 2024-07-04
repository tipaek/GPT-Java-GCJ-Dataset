import java.io.*;
class Solution
{
    public static void main(String args[])throws IOException
    {
        InputStreamReader read =new InputStreamReader(System.in);
        BufferedReader in =new BufferedReader(read);
        int i,j,k,a,n,m,sum=0,r=0,c=0,flag=0,flag1=0;
        String s;
        //System.out.println("Enter The Number Of Test Cases.");
        m=Integer.parseInt(in.readLine());
        int sum1[] =new int[m];
        int row[] =new int[m];
        int col[] =new int[m];
        for(a=1;a<=m;a++)
        {
            //System.out.println("Enter The Dimension Of The Square Matrix.");
            n=Integer.parseInt(in.readLine());
            int ar[][] =new int[n][n];
            //System.out.println("Enter The Elements Of The Matrix.");
            for(i=0;i<n;i++)
            {
                s=in.readLine();
                String[] strs = s.trim().split("\\s+");
                int ar1[] =new int[strs.length];
                for(j=0;j<strs.length;j++)
                {
                    ar1[j]=Integer.parseInt(strs[j]);
                }
                for(j=0;j<n;j++)
                {
                    ar[i][j]=ar1[j];
                }
            }
            /*System.out.println("The Matrix.");
            System.out.println();
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    System.out.print(" "+ar[i][j]);
                }
                System.out.println();
            }*/
            for(i=0;i<n;i++)
            {
                sum=sum+ar[i][i];
            }
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    for(k=0;k<n;k++)
                    {
                        if(ar[i][j]==ar[i][k] && j!=k)
                        {
                            flag++;
                        }
                        if(ar[j][i]==ar[k][j] && i!=k)
                        {
                            flag1++;
                        }
                    }
                }
                if(flag!=0)
                {
                    r++;
                    flag=0;
                }
                if(flag1!=0)
                {
                    c++;
                    flag1=0;
                }
            }
            /*System.out.println("Number Of Duplicate Rows = "+r);
            System.out.println("Number Of Duplicate Columns = "+c);*/
            /*String result="Case #"+a+": "+sum+" "+r+" "+c;
            res[a-1]=result;*/
            sum1[a-1]=sum;
            row[a-1]=r;
            col[a-1]=c;
            sum=0;
            r=0;
            c=0;
            //result="";
        }
        for(a=0;a<m;a++)
        {
            System.out.println("Case #"+(a+1)+": "+sum1[a]+" "+row[a]+" "+col[a]);
        }
    }
}