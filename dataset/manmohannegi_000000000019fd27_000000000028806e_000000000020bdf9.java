import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
        //File f = new File("C:\\GoogleCodeJam\\Test.txt");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //Scanner in = new Scanner(f);
        int T = in.nextInt();
        for (int i = 1; i <= T; ++i) {
            int N = in.nextInt();
            int a[][]=new int[N][2];
            for(int j=0;j<N;j++) {
                a[j][0] = in.nextInt();
                a[j][1] = in.nextInt();
            }
            String ans="";
            if( N != 2 ) {
            sortArray(a);
            int parent[]=new int[2];
            parent[0]=a[0][1];
            parent[1]=a[1][1];
            ans="CJ";
            boolean breakloop=false;
            for(int j=2;j<N && !breakloop;j++) {
                if(a[j][0]>=parent[0]){
                    ans=ans+"C";
                    parent[0]=a[j][1];
                }
                else{
                    if(a[j][0]>=parent[1]){
                        ans=ans+"J";
                        parent[1]=a[j][1];
                    }
                    else{
                        ans="IMPOSSIBLE";
                        breakloop=true;
                    }
                }
            }
            }
            else
                ans="CJ";
            System.out.println("Case #" + i+": "+ans);
        }
        in.close();
    }
    public static void sortArray(int arr[][])
    {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {
                if (entry1[0] > entry2[0])
                    return 1;
                else
                    return -1;
            }
        });
    }
}
