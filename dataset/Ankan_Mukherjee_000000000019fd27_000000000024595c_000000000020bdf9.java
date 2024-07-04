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
            int arr[][]=new int[n][2];
            byte J[]=new byte[1440];
            byte C[]=new byte[1440];
            String str="";
            for(int i=0;i<n;i++)
            {
                String s=obj.nextLine();
                StringTokenizer st=new StringTokenizer(s);
                arr[i][0]=Integer.parseInt(st.nextToken());
                arr[i][1]=Integer.parseInt(st.nextToken());
            }            
            for(int i=0;i<1440;i++)
            {
                J[i]=0;
                C[i]=0;
            }
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
                    str+="C";
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
                        str+="J";
                    }
                    else
                    {
                        str="IMPOSSIBLE";
                        break;
                    }
                }
            }
            System.out.print("Case #"+f+": "+str);
            if(f!=t)
            {
                System.out.println();
            }
        }
    }
}