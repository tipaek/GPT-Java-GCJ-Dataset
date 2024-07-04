import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {

            int n = in.nextInt();

            double[] arr = new double[n];
            for (int i = 0; i < n; ++i) {
                int begin = in.nextInt();
                int end = in.nextInt();
                arr[i] = begin + (end / 10000.0);
            }

            double[] arr2 = arr.clone();
            Arrays.sort(arr);

            double endC = 0;
            double endJ = 0;
            String[] answer = new String[n];
            boolean imposs = false;

            for (int i = 0; i < n; i++){
                double begin = (int)arr[i];
                double end = (int) ((arr[i]- begin)*10000);

                //test
               // System.out.println("begin end " + begin +' '+ end);

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
//             System.out.println("NOT Modified arr2[] : " + Arrays.toString(arr2));
//            System.out.println("Modified arr2[] : " + Arrays.toString(arr));
//            System.out.println("Modified answer : " + Arrays.toString(answer));


            if (imposs) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + t + ": ");
                for (int i = 0; i < n; i++){
                    for (int j = 0; j < n; j++){
                        if ( arr2[i] == arr[j]) {
                            System.out.print(answer[j]);
                            arr[j] = 2000;
                            j = n; // break
                        }
                    }
                }
                System.out.println("");
            }

        }


    }
}
