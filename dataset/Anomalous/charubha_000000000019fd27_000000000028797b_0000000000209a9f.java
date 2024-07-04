import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = Integer.parseInt(sc.nextLine());
        String[] output = new String[tc];

        for (int i = 0; i < tc; i++) {
            String input = sc.nextLine();
            StringBuilder tempout = new StringBuilder();
            String[] res = input.split("");
            int[] resint = new int[res.length];

            for (int k = 0; k < res.length; k++) {
                resint[k] = Integer.parseInt(res[k]);
            }

            int temp = resint[0];
            tempout.append("(".repeat(temp));
            tempout.append(resint[0]);

            for (int j = 1; j < resint.length; j++) {
                if (resint[j] < resint[j - 1]) {
                    int diff = resint[j - 1] - resint[j];
                    tempout.append(")".repeat(diff));
                    tempout.append(resint[j]);
                } else if (resint[j] > resint[j - 1]) {
                    int diff = resint[j] - resint[j - 1];
                    tempout.append("(".repeat(diff));
                    tempout.append(resint[j]);
                } else {
                    tempout.append(resint[j]);
                }
            }

            tempout.append(")".repeat(resint[resint.length - 1]));
            output[i] = tempout.toString();
        }

        for (String out : output) {
            System.out.println(out);
        }
    }
}