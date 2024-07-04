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
            while (temp > 0) {
                tempout.append("(");
                temp--;
            }
            tempout.append(resint[0]);

            for (int j = 1; j < resint.length; j++) {
                if (resint[j] < resint[j - 1]) {
                    int diff = resint[j - 1] - resint[j];
                    while (diff > 0) {
                        tempout.append(")");
                        diff--;
                    }
                    tempout.append(resint[j]);
                } else if (resint[j] > resint[j - 1]) {
                    int diff = resint[j] - resint[j - 1];
                    while (diff > 0) {
                        tempout.append("(");
                        diff--;
                    }
                    tempout.append(resint[j]);
                } else {
                    tempout.append(resint[j]);
                }
            }

            int lastDigit = resint[resint.length - 1];
            while (lastDigit > 0) {
                tempout.append(")");
                lastDigit--;
            }

            output[i] = tempout.toString();
        }

        for (int h = 0; h < tc; h++) {
            System.out.println("Case #" + (h + 1) + ": " + output[h]);
        }

        sc.close();
    }
}