import java.util.*;
import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n=sc.nextInt();
            int[][] brr=new int[n][2];
            int[][] brr1=new int[n][2];
            for(int j=0;j<n;j++)
            {
                int temp1 = sc.nextInt();
                int temp2= sc.nextInt();
                brr[j][0]=temp1;
                brr[j][1]=temp2;
                brr1[j][0]=temp1;
                brr1[j][1]=temp2;
            }
            sortbyColumn(brr,0);
            char[] ch=new char[n];
            int X=-1;
            int Y=-1;
            int flag=0;
            for(int j=0;j<n;j++)
            {
                int val=-1;
                for(int k=0;k<n;k++)
                {
                    if(brr[j][0]==brr1[k][0] && brr[j][1]==brr1[k][1])
                    {
                        brr1[k][0]=-1;
                        brr1[k][1]=-1;
                        val=k;
                        break;
                    }
                }
                if(brr[j][0]>=X)
                {
                    ch[val]='C';
                    X=brr[j][1];
                }
                else if(brr[j][0]>=Y)
                {
                    ch[val]='J';
                    Y=brr[j][1];
                }
                else
                {
                    flag=1;
                    break;
                }
            }
            String s= new String(ch);
            if(flag==0)
                System.out.println("Case #"+i+": "+s);
            else
                System.out.println("Case #"+i+": IMPOSSIBLE");
        }
    }
    public static void sortbyColumn(int arr[][], int col)
    {

        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });  // End of function call sort().
    }

}