import java.io.*;
import java.util.*;

 class Solution {

    public static void main(String[] args) {
        int testCases = 0;
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        testCases = sc.nextInt();
        for (int t=1;t<=testCases;t++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][3];
            for (int i =0;i<n;i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                arr[i][2] = i;
            }
            Arrays.sort(arr,(int[] x, int[] y)->{return x[0]-y[0];});

            boolean jamie = false;
            boolean cameron = false;
            boolean check = false;

            char[] ans = new char[n];
            int lt1 = 0;
            int lt2=0;

            for (int x[] : arr)
            {
                int ind = x[2];
                if(lt1<=x[0])   jamie = false;
                if(lt2<=x[0])  cameron = false;

                if(cameron==false){
                    cameron = true;
                    ans[ind]='C';
                    lt2 = x[1];
                }
                else if(jamie==false){
                    jamie = true;
                    ans[ind]='J';
                    lt1 = x[1];
                }
                else{
                    check = true;
                    break;
                }

            }
            if(check)
                System.out.println("Case #"+t+": IMPOSSIBLE");
            else
                System.out.println("Case #"+t+": "+new String(ans));


        }
    }
}
