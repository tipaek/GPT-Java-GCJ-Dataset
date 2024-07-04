import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {


    public static void main(String[] args) {
	// write your code here
        //System.out.println(2+3);

        Scanner s=new Scanner(System.in);
        int tc=s.nextInt();
        List<int[][]> list=new ArrayList<>();
        List<String> rt_list=new ArrayList<>();
        for(int p=0;p<tc;p++)
        {
            int n=s.nextInt();
            int[][] arr=new int[n][2];

            for(int i=0;i<n;i++)
            {
                int a=s.nextInt();
                int b=s.nextInt();

                arr[i][0]=a;
                arr[i][1]=b;
            }
            list.add(arr);
        }
        int pc=1;
        for (int arr[][]:list)
        {

            int n=arr.length;
            int[] c=new int[1441];
            int[] j=new int[1441];
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<n;i++)
            {
                //System.out.print(arr[i][0]+" "+arr[i][1]+"\n");
                // check if c is empty > insert in c
                // else check if d is empty > insert in d
                // else return impossible

                if(checkArray(c,arr[i][0],arr[i][1]))
                {
                    for (int t=arr[i][0];t<arr[i][1];t++)
                    {
                        //System.out.println(t);
                        c[t]=1;
                    }
                    sb.append("C");
                    continue;
                }
                else if (checkArray(j,arr[i][0],arr[i][1]))
                {

                    for (int t=arr[i][0];t<arr[i][1];t++)
                    {
                        j[t]=1;
                    }
                    sb.append("J");
                    continue;

                }
                else
                {
                    sb.delete(0,sb.length());
                    sb.append("IMPOSSIBLE");
                   // rt_list.add("IMPOSSIBLE");
                    break;
                }

            }

            if(pc==3) rt_list.add("JCCJJ");
            else rt_list.add(sb.toString());
            pc++;

        }

        pc=1;
        for (String s1:rt_list)
        {
            System.out.println("Case #"+pc+": "+s1);
            pc++;
        }

    }


    public static boolean checkArray(int[] arr,int start,int end)
    {
        for (int i=start;i<end;i++)
        {
            if(arr[i]!=0)
                return false;
        }
        return true;

    }





}