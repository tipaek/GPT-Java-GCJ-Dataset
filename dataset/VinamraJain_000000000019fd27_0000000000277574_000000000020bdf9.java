import java.util.*;
import java.io.*;

//c=1 and j=2

public class Solution {

    public static void solve(int x, int arr[][]) {
        String str="";
        for(int i=0;i<arr.length;i++) {
            str+="C";
        }
        int newarr[][] = arr;
        Arrays.sort(newarr,new Comparator<int[]>(){
            public int compare(int a[], int b[]) {
                if(a[0]>b[0]) return 1;
                else return -1;
            }
        });
        int startC=newarr[0][0],endC=newarr[0][1];
        // str=str+"C";
        StringBuilder sb = new StringBuilder(str);
        int startJ=-1,endJ=-1;
        for(int i=1;i<arr.length;i++) {
            if(newarr[i][0]>=startC && newarr[i][0]<endC) {
                if(newarr[i][0]>=startJ && newarr[i][0]<endJ) {
                    System.out.printf("Case #%d: IMPOSSIBLE\n",x+1);
                    return ;
                } else {
                    startJ = newarr[i][0];
                    endJ = newarr[i][1];
                    sb.setCharAt(newarr[i][2],'J');
                    // str+="J";
                }
            } else {
                startC = newarr[i][0];
                endC = newarr[i][1];
                str+="C";
            }
        }
        System.out.printf("Case #%d: %s\n",x+1,sb.toString());
    }

    public static void main(String[] args)throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        int t = Integer.parseInt(br.readLine());
        for(int m=0;m<t;m++) {
            int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[n][3];
            for(int i=0;i<n;i++) {
                String line[] = br.readLine().split(" ");
                arr[i][0] = Integer.parseInt(line[0]);
                arr[i][1] = Integer.parseInt(line[1]);
                arr[i][2] = i;
            }
            solve(m,arr);
        }
    }
}