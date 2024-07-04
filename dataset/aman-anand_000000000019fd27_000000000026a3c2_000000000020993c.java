import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int t= scanner.nextInt();
        int l=1;

        while(l<=t) {
            l++;
            int n=scanner.nextInt();

            int[][] a = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j]=scanner.nextInt();
            //Trace
            int trace = 0;
            for (int i = 0; i < n; i++)
                trace += a[i][i];

            //Row
            int r = 0;

            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> rowmap = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    if (!rowmap.containsKey(a[i][j])) {
                        rowmap.put(a[i][j],1);
                    }
                    else{
                        int oldVal = rowmap.get(a[i][j]);
                        int newVal = oldVal+1;
                        rowmap.put(a[i][j],newVal);
                        break;
                    }
                }

                for (Integer val: rowmap.values()) {
                    if(val>1)
                        r++;
                }
            }

            //Column
            int c = 0;
            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> colmap = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    if (!colmap.containsKey(a[j][i])) {
                        colmap.put(a[j][i],1);
                    }
                    else{
                        int oldVal = colmap.get(a[j][i]);
                        int newVal = oldVal+1;
                        colmap.put(a[j][i],newVal);
                        break;
                    }
                }

                for (Integer val: colmap.values()) {
                    if(val>1)
                        c++;
                }
            }
            System.out.println("Case #"+l+": "+trace+" "+r+" "+c);
        }
    }
}