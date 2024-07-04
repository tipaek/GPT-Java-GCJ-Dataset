import java.io.*;
class Vestigium
{
    static void main()throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(in.readLine());
        int i,test,j,x;
        int n;
        int m[][];
        int k=0;
        String str;
        int r=0;
        int c=0;
        int check;
        int j1=0;
        int arr[];
        String output[]=new String[t];
        int o=0;
        
        for(test=1;test<=t;test++)
        {
            n=Integer.parseInt(in.readLine());
            m=new int[n][n];
            for(i=0;i<n;i++)
            {
                str=in.readLine();
                for(j=0;j<n;j++)
                {
                    m[i][j]=Integer.parseInt(String.valueOf(str.charAt(j)));
                    if(i==j)
                    {
                        k=k+m[i][j]; 
                    }
                }
            }
            boolean flag=false;
            for(i=0;i<n;i++)
            {
                flag=false;
                for(j=0;j<n;j++)
                {
                    check=m[i][j];
                    for(x=j+1;x<n;x++)
                    {
                        if(m[i][x]==check)
                        {
                           r++;
                           flag=true;
                           break;
                        }
                    }
                    if(flag)
                    {
                        break;
                    }
                }
            }

            for(i=0;i<n;i++)
            {   
                flag=false;
                for(j=0;j<n;j++)
                {
                    check=m[j][i];
                    for(x=j+1;x<n;x++)
                    {
                        if(m[x][i]==check)
                        {
                           c++;
                           flag=true;
                           break;
                        }
                    }
                    if(flag)
                    {
                        break;
                    }
                }
            }

            output[o++]="Case #"+test+": "+k+""+r+""+c;
        }
        for(i=0;i<t;i++)
        {
            System.out.println(output[i]);
        }
    }

}