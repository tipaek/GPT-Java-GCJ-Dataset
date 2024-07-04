import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {


    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        int tc=s.nextInt();
        List<int[]> list=new ArrayList<>();


        for (int i=0;i<tc;i++)
        {
            int[] arr=new int[2];
            arr[0]=s.nextInt();
            arr[1]=s.nextInt();

            list.add(arr);
        }

        int pc=1;
        for (int[] arr:list)
        {
            int n=arr[0];
            int k=arr[1];

            int temp=1;
            int start=temp;
           // System.out.println("val: "+n+" "+k);
            //int myr[][]=new int[n][n];
            List<int[]> col_list=new ArrayList<>();

            for (int i=0;i<n;i++)
            {
                temp=start;
                start++;
                int myr[]=new int[n];
                for (int j=0;j<n;j++)
                {

                    if(temp<=n)
                    {
                        myr[j]=temp;
                        temp++;
                        continue;
                    }
                    else
                    {
                        temp=1;
                        myr[j]=temp;
                        temp++;
                    }

                }
                col_list.add(myr);
            }
            boolean found=false;
            for (int f=1;f<n;f++)
            {

                int sum=0;
                int z=0;
                for (int[] myr:col_list)
                {
                    sum+=myr[z];
                    z++;

                }
                if (sum==k)
                {
                    found=true;
                    break;
                }
                else {
                    int a[]=col_list.get(0);
                    col_list.remove(0);
                    col_list.add(a);
                }
            }

            if (found)
            {
                System.out.println("Case #"+pc+": POSSIBLE");
                printArr(col_list);
                pc++;
            }
            else
            {
                System.out.println("Case #"+pc+": IMPOSSIBLE");
                pc++;
            }

        }


    }

    private static void printArr(List<int[]> col) {

        for (int[] myr:col)
        {
            for (int j=0;j<myr.length;j++)
            {
                System.out.print(myr[j]+" ");


            }
            System.out.println();
        }
    }


}
