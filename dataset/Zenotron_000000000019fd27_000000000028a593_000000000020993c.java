import java.io.*;
class calc
{
    public static void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int i,j,p;
        int t=Integer.parseInt(br.readLine());
        for(p=0;p<t;p++)
        {
            int n=Integer.parseInt(br.readLine());
            int arr[][]=new int[n][n],row[]=new int[n],col[]=new int[n];
            String str,st[];
            int sum=0,r=0,c=0;
            for(i=0;i<n;i++)
            {
                str=br.readLine();
                st=str.split(" ");
                for(j=0;j<n;j++)
                {
                    arr[i][j]=Integer.parseInt(st[j]);
                }
                sum=sum+arr[i][i];
                
            }
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    row[arr[i][j]-1]=row[arr[i][j]-1]+1;
                    col[arr[j][i]-1]=col[arr[j][i]-1]+1;
                }
                for(j=0;j<n;j++)
                {
                    if(row[j]>1)
                        r++;
                    row[j]=0;
                    if(col[j]>1)
                        c++;
                    col[j]=0;
                }
            }
            System.out.println("Case #"+p+":"+" "+sum+" "+r+" "+c);
            
        }
    }
}