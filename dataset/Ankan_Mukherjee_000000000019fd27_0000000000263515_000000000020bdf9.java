import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner obj=new Scanner(System.in);
        int t=Integer.parseInt(obj.nextLine());
        for(int f=1;f<=t;f++)
        {
            int n=Integer.parseInt(obj.nextLine());
            int arr[][]=new int[n][4];
            int J[]=new int[1440];
            int C[]=new int[1440];
            String str=" ";
            for(int i=0;i<n;i++)
            {
                String s=obj.nextLine();
                StringTokenizer st=new StringTokenizer(s);
                arr[i][0]=Integer.parseInt(st.nextToken());
                arr[i][1]=Integer.parseInt(st.nextToken());
                arr[i][2]=i;
                arr[i][3]=0;
            }
            for(int i=0;i<n;i++)
            {
                int min=arr[i][0];
                int pos=i;
                for(int j=i+1;j<n;j++)
                {
                    if(arr[j][0]<min)
                    {
                        min=arr[j][0];
                        pos=j;
                    }
                }
                for(int j=0;j<=3;j++)
                {
                    int temp=arr[pos][j];
                    arr[pos][j]=arr[i][j];
                    arr[i][j]=temp;
                }
            }
            for(int i=0;i<1440;i++)
            {
                J[i]=0;
                C[i]=0;
            }
            boolean flag=true;
            for(int i=0;i<n;i++)
            {
                boolean flagc=true;
                boolean flagj=true;
                for(int j=arr[i][0];j<arr[i][1];j++)
                {
                    if(C[j]!=0)
                    {
                        flagc=false;
                        break;
                    }
                }
                if(flagc)
                {
                    for(int j=arr[i][0];j<arr[i][1];j++)
                    {
                        C[j]=1;
                    }
                    arr[i][3]=1;
                    str=str.concat("C");
                }
                else
                {
                    for(int j=arr[i][0];j<arr[i][1];j++)
                    {
                        if(J[j]!=0)
                        {
                            flagj=false;
                            break;
                        }
                    }
                    if(flagj)
                    {
                        for(int j=arr[i][0];j<arr[i][1];j++)
                        {
                            J[j]=1;
                        }
                        arr[i][3]=2;
                        str=str.concat("J");
                    }
                    else
                    {
                        str=" IMPOSSIBLE";
                        flag=false;
                        break;
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                int min=arr[i][2];
                int pos=i;
                for(int j=i+1;j<n;j++)
                {
                    if(arr[j][2]<min)
                    {
                        min=arr[j][2];
                        pos=j;
                    }
                }
                for(int j=0;j<=3;j++)
                {
                    int temp=arr[pos][j];
                    arr[pos][j]=arr[i][j];
                    arr[i][j]=temp;
                }
            }
            if(flag)
            {
                str=" ";
                for(int i=0;i<n;i++)
                {
                    if(arr[i][3]==1)
                    {
                        str+="C";
                    }
                    if(arr[i][3]==2)
                    {
                        str+="J";
                    }
                }
            }
            System.out.println("Case #"+f+":"+str);
        }
    }
}