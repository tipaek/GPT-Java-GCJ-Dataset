
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        int itr=1;
        while(itr<=t)
        {
            int n= sc.nextInt();
            int[][] a= new int [n][2];
            for(int i=0; i<n; i++)
            {
                a[i][0]= sc.nextInt();
                a[i][1]= sc.nextInt();
            }
            Arrays.sort(a, new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]==o2[0])
                        return o1[1]-o2[1];
                    return o1[0]-o2[0];
                }
            });
//            printArray(a);
            System.out.println("Case #"+itr+": "+getSequence(a));
            itr++;
        }
    }
    private static String getSequence(int[][] a)
    {
        String res="";
        int j=-1, c=-1;
        for(int i=0; i<a.length; i++)
        {
            if(a[i][0]>=j)
            {
                j=a[i][1];
                res+="J";
            }
            else if(a[i][0]>=c)
            {
                c=a[i][1];
                res+="C";
            }
            else
                return "IMPOSSIBLE";
        }
        return res;
    }
    /*private static void printArray(int[][]a) {
        for (int[] ints : a) {
            System.out.println(ints[0] + ", " + ints[1]);
        }
        System.out.println("-------------------------");
    }*/
}
