import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.BitSet;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = rint(br.readLine());
        int ca=1;
        while (t-- > 0) {
            int n=rint(br.readLine());
            int arr[][]=new int [n][n];
            for(int i=0;i<n;i++){
                arr[i]=rintArr(br.readLine());

            }
            int sum=0;
            int c=0;
            int r=0;
            for(int i=0;i<n;i++){
                sum+=arr[i][i];
            }
            for(int i=0;i<n;i++){
                int re[]=new int[101];
                for(int j=0;j<n;j++){
                    re[arr[i][j]]++;
                }
                for(int g=0;g<=100;g++){
                    if(re[g]>1){r++;break;}
                }

            }
            for(int j=0;j<n;j++){
                int re[]=new int[101];
                for(int i=0;i<n;i++){
                    re[arr[i][j]]++;
                }
                for(int g=0;g<=100;g++){
                    if(re[g]>1){c++;break;}
                }

            }
            System.out.println("Case #"+ca++ +": "+sum+" "+r+" "+c);

        }
    }


    static int[] rintArr(String st) {//returns whole  String as array
        int[] rett;
        rett = Arrays.stream(st.split(" ")).mapToInt(Integer::parseInt).toArray();
        return rett;
    }

    static int rint(String gg) {//returns just one integer
        return Integer.parseInt(gg);
    }

    static long rlong(String gg) {
        return Long.parseLong(gg);
    }

    static int rint(String[] vv, int d) {
        return Integer.parseInt(vv[d]);
    }

    static void swap(int oneTwo, int twoOne) {
        int sw = oneTwo;
        oneTwo = twoOne;
        twoOne = sw;
    }

}











