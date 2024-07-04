import java.util.*;
import java.io.*;
import java.lang.*;

class naya implements Comparable<naya> {

    int x, y, ndx;

    public naya(String str[], int ndx) {
        this.x = Integer.parseInt(str[0]);
        this.y = Integer.parseInt(str[1]);
        this.ndx = ndx;
    }

    @Override
    public int compareTo(naya o) {
        if (this.x - o.x == 0) {
            return this.y - o.y;
        } else {
            return this.x - o.x;
        }
    }
}

public class Solution {

    private static void printArr(String seq[]) {
        for (String s : seq) {
            System.out.print(s);
        }
        System.out.println("");
    }

    private static String[] compute(naya arr[],int n) {

        Arrays.sort(arr);
        int c = 0, j = 0;
        String seq[] = new String[n];
        boolean overlap = false;
        for (int i = 0; i < n; i++) {
            if (arr[i].x < c && arr[i].x < j) {
                overlap = true;
                break;
            } else if (arr[i].x >= c) {
                c = arr[i].y;
                seq[arr[i].ndx] = "C";
            } else {
                j = arr[i].y;
                seq[arr[i].ndx] = "J";
            }
        }
        if(overlap){
            return null;
        }
       return seq;
    }

    public static void main(String[] args) throws Exception {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            int test = Integer.parseInt(br.readLine());
            for (int t = 1; t <= test; t++) {
                int n = Integer.parseInt(br.readLine());
                naya arr[] = new naya[n];
                String str[] = null;
                for (int i = 0; i < n; i++) {
                    str = br.readLine().split(" ");
                    arr[i] = new naya(str, i);
                }
                System.out.print("Case #" + t + ":" + " ");
               String seq[]  = compute(arr, n);
                if (seq==null) {
                    System.out.println("IMPOSSIBLE");
                } else {
                    printArr(seq);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}