import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {

            int n = in.nextInt();

            float[] arr = new float[n];
            for (int i = 1; i <= n; ++i) {
                int begin = in.nextInt();
                int end = in.nextInt();
                arr[i-1] = (float) (begin + (end / 10000.0));
            }

            float[] arr2 = arr.clone();
            Arrays.sort(arr);

            int endC = 0;
            int endJ = 0;
            String[] answer = new String[n];
            boolean imposs = false;

            for (int i = 0; i < n; i++){
                int begin = (int)arr[i];
                int end = Math.round((arr[i]- begin)*10000);
                if (endC <= begin) {
                    answer[i] = "C";
                    endC = end;
                } else if( endJ <= begin){
                    answer[i] = "J";
                    endJ = end;
                } else {
                    imposs = true;
                    i=n; // break
                }
            }

            //Test
           // System.out.println("NOT Modified arr2[] : " + Arrays.toString(arr2));

            if (imposs) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + t + ": ");
                for (int i = 0; i < n; i++){
                    for (int j = 0; j < n; j++){
                        if ( arr2[i] == arr[j]) {
                            System.out.print(answer[j]);
                            j = n; // break
                        }
                    }
                }

                System.out.println("");

            }



//            for (int i = 0; i < n; i++){
//                int begin = (int)arr[i];
//                System.out.print(begin + " ");
//                System.out.print( Math.round((arr[i]- begin)*10000) );
//                System.out.println("");
//            }
        }


    }
}
