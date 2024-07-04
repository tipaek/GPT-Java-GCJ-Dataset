import java.util.*;
class Solution
{
    public static void main(String[] args)
        {
            Scanner ob=new Scanner(System.in);
            int t=ob.nextInt();
            ArrayList<Integer> listr=new ArrayList<>();
            ArrayList<Integer> listc=new ArrayList<>();
            for(int it=1;it<=t;it++)
            {
                int n=ob.nextInt();
                int arr[][]=new int[n][n];
                int k=0;
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        arr[i][j]=ob.nextInt();
                        if(i==j)
                            k+=arr[i][j];
                    }
                }
                int r=0,c=0;
                for(int i=0;i<n;i++)
                {
                   int rbreak=0;
                   listr.clear();

                    int cbreak=0;
                    listc.clear();

                    for(int j=0;j<n;j++)
                    {

                        if(listr.contains(arr[i][j])&&rbreak==0)
                        {
                            r++;
                            rbreak=1;
                        }
                        else
                        {
                            listr.add(arr[i][j]);
                        }


                        if(listc.contains(arr[j][i])&&cbreak==0)
                        {
                            c++;
                            cbreak=1;
                        }
                        else
                        {
                            listc.add(arr[j][i]);
                        }
                    }
                }
                System.out.println("Case #"+it+": "+k+" "+r+" "+c);

            }
        }
}