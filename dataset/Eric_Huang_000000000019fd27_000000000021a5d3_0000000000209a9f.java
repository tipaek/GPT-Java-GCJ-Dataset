

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num = scan.nextInt();
        for (int i = 0; i < num; i++) {
            String next = scan.next();

            int[]ints = new int[next.length()];
            for (int j = 0; j < next.length(); j++) {
                ints[j] = Integer.parseInt(String.valueOf(next.charAt(j)));
            }

            String[][]output = new String[next.length()][2];
            for (int j = 0; j < next.length(); j++) {
                output[j][0] = "";
                output[j][1] = "";
            }

            for (int j = 0; j < next.length(); j++) {
                while(ints[j] > 0){
                    output[j][0] += "(";

                    int endIndex = next.length()-1;

                    for (int k = j; k < next.length(); k++) {
                        if(ints[k] <= 0){
                            endIndex = k - 1;
                            break;
                        }
                        ints[k]--;
                    }


                    output[endIndex][1] += ")";
                    ints[endIndex]--;

                    ints[j]--;

                }
            }

            String out = "";


            for (int j = 0; j < next.length(); j++) {

                out += output[j][0] + next.charAt(j) + output[j][1];

            }

            System.out.println(out);

        }
    }

}
