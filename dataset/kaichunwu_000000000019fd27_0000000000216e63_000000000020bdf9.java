import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.valueOf(in.readLine());
        for(int i = 0;i < time;++i) {
            int n = Integer.valueOf(in.readLine());
            int[][] arr = new int[n][2];
            for(int j = 0;j < n;++j) {
                String[] firstMultipleInput = in.readLine().replaceAll("\\s+$", "").split(" ");
                arr[j][0] = Integer.parseInt(firstMultipleInput[0]);
                arr[j][1] = Integer.parseInt(firstMultipleInput[1]);
            }
            
            System.out.println("Case #"+(i+1)+": "+solve(n,arr));
        }
    }
    private static String solve(int n,int[][] org) {
        int[][] arr = new int[n][3];
        for(int i = 0;i < n;++i) {
            arr[i][0] = org[i][0];
            arr[i][1] = org[i][1];
            arr[i][2] = i;
        }
        Arrays.sort(arr,(i,j)->{
            int r = Integer.compare(i[0],j[0]);
            return r==0?Integer.compare(i[1],j[1]):r;
        });
        char[] res = new char[n];
        int ce = 0;
        int je = 0;
        for(int i = 0;i < n;++i) {
            if(ce<je) {
                if(ce<=arr[i][0]) {
                    res[arr[i][2]] = 'C';
                    ce = arr[i][1];
                }
                else return "IMPOSSIBLE";
            }else {
                if(je<=arr[i][0]) {
                    res[arr[i][2]] = 'J';
                    je = arr[i][1];
                }
                else return "IMPOSSIBLE";
            }
        }
        return new String(res);
    }
}    