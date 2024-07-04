
import java.util.Scanner;

class Soluation {

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            String sInput = "";
            String sOutput = "";
            sInput = sc.next();
            int k = sInput.length();
            int r = 0;
            int c = 0;
            int prev = 0;
            int input = 0;
            for (int i = 0; i < k; i++) {
                input = Integer.parseInt("" + sInput.charAt(i));
                if (input < prev) {
                    int loop = prev - input;
                    while (loop > 0) {
                        sOutput += ")";
                        loop--;
                    }
                } else if (input == prev) {

                } else if (input > prev) {
                    int loop = input - prev;
                    while (loop > 0) {
                        sOutput += "(";
                        loop--;
                    }

                }
                sOutput += "" + input;
                prev = input;
            }
            for (int i = 0; i < input; i++) {
                sOutput += ")";
            }
            System.out.println("Case #" + t + ": " + sOutput);
        }

    }
   
    static Scanner sc=null;

}
