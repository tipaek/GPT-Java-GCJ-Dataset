import java.util.*;
public class Solution
{
    public static void sortbyColumn(int arr[][], int col)
    {
        Arrays.sort(arr, new Comparator<int[]>() {
          @Override
          public int compare(final int[] entry1,
                             final int[] entry2) {
            if (entry1[col] > entry2[col])
                return 1;
            else
                return -1;
          }
        });
    }
    public static void main(String[] args)
    {
        int t;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        while(t-->0)
        {
            int n;
            n=sc.nextInt();
            int a[][]=new int[n][2];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<2;j++)
                {
                    a[i][j]=sc.nextInt();
                }
            }
            sortbyColumn(a,0);
            /*for(int i=0;i<n;i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(a[i][j]+" ");
                }
                System.out.println();
            }*/
            String ans="";
            boolean vacj=true,vacc=true;
            int freej=-1,freec=-1;
            for(int i=0;i<n;i++)
            {
                if(vacj && vacc)
                {
                    vacj=false;
                    freej=a[i][1];
                    ans+="J";
                }
                else if(vacc)
                {
                    vacc=false;
                    freec=a[i][1];
                    ans+="C";
                }
                else if(vacj)
                {
                    vacj=false;
                    freej=a[i][1];
                    ans+="J";
                }
                else if(!vacj && freej<=a[i][0])
                {
                    vacj=true;
                    freej=-1;
                    i=i-1;
                    continue;
                }
                else if(!vacc && freec<=a[i][0])
                {
                    vacc=true;
                    freec=-1;
                    i=i-1;
                    continue;
                }
                else
                {
                    ans="IMPOSSIBLE";
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
