import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution{

    public static void main(String []args){
        int amount;

        Scanner in = new Scanner(System.in);
        amount = Integer.parseInt(in.nextLine());

        for (int i = 0; i<amount; i++){

            int n = Integer.parseInt(in.nextLine());

            int trace=0, rowE =0, colE=0;

            String[][] matrixS = new String[n][];

            for (int k = 0; k< n; k++){
                matrixS[k] = in.nextLine().split(" ");
                Set<String> s =
                        new HashSet<String>(Arrays.asList(matrixS[k]));

                if (s.size()<n) rowE++;

                trace += Integer.parseInt(matrixS[k][k]);
            }

            for (int k = 0; k<n; k++){
                Set<String> s = new HashSet<String>();
                for (int f = 0; f<n; f++){
                    s.add(matrixS[f][k]);
                }
                if (s.size()<n) colE++;
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowE + " " + colE);
        }
    }

}
