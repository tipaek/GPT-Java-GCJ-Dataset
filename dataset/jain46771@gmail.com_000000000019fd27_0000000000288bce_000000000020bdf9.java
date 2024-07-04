import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        int testCases = 0;
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        testCases = sc.nextInt();
        for (int t=1;t<=testCases;t++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for (int i =0;i<n;i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            Arrays.sort(arr,(int[] x, int[] y)->{return x[0]-y[0];});

            boolean jamie = false;
            boolean cameron = false;
            boolean check = false;
            StringBuffer ans = new StringBuffer();


            int lt1 = 0;
            int lt2=0;

            for (int x[] : arr)
            {
                if(lt1<=x[0])   jamie = false;
                if(lt2<=x[0])  cameron = false;

                if(cameron==false){
                    cameron = true;
                    ans.append('C');
                    lt2 = x[1];
                }
                else if(jamie==false){
                    jamie = true;
                    ans.append('J');
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
                System.out.println("Case #"+t+": "+ans.toString());


        }
    }
}
