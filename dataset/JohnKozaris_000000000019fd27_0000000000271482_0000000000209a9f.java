import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = in.nextInt();
        in.nextLine();
        ArrayList<String> output = new ArrayList<>();
        for (int i = 0; i < testcases; i++) {
            StringBuilder caseBuilder = new StringBuilder();
            String S = in.nextLine();
            boolean flip = false;
            int[] arr = new int[S.length()];
            for (int j = 0; j < S.length(); j++) {
                arr[j] = S.charAt(j) - '0';
            }
            int oldNum = 0;
            int memory = 0;
            int openP = 0;
            for (int num : arr) {
                if (oldNum != num) {
                    for (int k = 0; k < Math.abs(oldNum - num); k++) {
                        if (flip) {
                            if (openP > num) {
                                caseBuilder.append(")");
                            } else {
                                caseBuilder.append("(");
                                openP++;
                            }
                        } else {
                            caseBuilder.append("(");
                            openP++;
                        }
                    }
                    memory += (oldNum - num);

                    flip = !flip;

                    oldNum = num;
                }
                caseBuilder.append(num);
            }
            for (int l = 0; l < Math.abs(memory); l++) {
                caseBuilder.append(")");
            }
            output.add("Case #" + (i + 1) + ": " + caseBuilder.toString());
        }
        for (String mycase : output) {
            System.out.println(mycase);
        }
    }
}
