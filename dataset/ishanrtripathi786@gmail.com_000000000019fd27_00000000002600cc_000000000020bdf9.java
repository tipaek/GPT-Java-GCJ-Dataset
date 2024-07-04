
import java.io.*;
import java.util.*;

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
            int[][] initialArray= new int [n][2];
            for(int i=0; i<n; i++)
            {
                a[i][0]= sc.nextInt(); initialArray[i][0]=a[i][0];
                a[i][1]= sc.nextInt(); initialArray[i][1]=a[i][1];
            }
            Arrays.sort(a, new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]==o2[0])
                        return o1[1]-o2[1];
                    return o1[0]-o2[0];
                }
            });
//            printArray(a);
            String result = getSequence(a);
            if(result.equals("IMPOSSIBLE"))
            {
                System.out.println("Case #"+itr+": IMPOSSIBLE");
            }
            else {
                Map<String, String> map = new HashMap<String, String>();
                for (int i = 0; i < a.length; i++) {
                    map.put(a[i][0] + a[i][1] + "", result.charAt(i) + "");
                }
                StringBuilder answer = new StringBuilder();
                for (int i = 0; i < initialArray.length; i++) {
                    answer.append(map.get(initialArray[i][0] + initialArray[i][1] + ""));
                }

                System.out.println("Case #" + itr + ": " + answer.toString());
            }
            itr++;
        }
    }
    private static String getSequence(int[][] a)
    {
        StringBuilder res= new StringBuilder();
        int j=-1, c=-1;
        for(int i=0; i<a.length; i++)
        {
            if(a[i][0]>=c)
            {
                c=a[i][1];
                res.append("C");
            }
            else if(a[i][0]>=j)
            {
                j=a[i][1];
                res.append("J");
            }
            else
                return "IMPOSSIBLE";
        }
        return res.toString();
    }
    /*private static void printArray(int[][]a) {
        for (int[] ints : a) {
            System.out.println(ints[0] + ", " + ints[1]);
        }
        System.out.println("-------------------------");
    }*/
}
