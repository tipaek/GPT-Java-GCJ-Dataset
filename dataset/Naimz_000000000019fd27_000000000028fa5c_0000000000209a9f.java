import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int nbCas = sc.nextInt();
        String laString;
        StringBuilder stringFinale;

        int nb;
        int lastNb = 0;

        for (int i = 0; i < nbCas + 1; i++) {

            laString = sc.next();
            stringFinale = new StringBuilder();
            lastNb = 0;

            for (int j = 0; j < laString.length(); j++) {

                nb = laString.charAt(j) - '0';

                if (lastNb < nb) {
                    for (int k = 0; k < nb - lastNb; k++) {
                        stringFinale.append("(");
                    }
                } else if (lastNb > nb) {
                    for (int k = 0; k < lastNb - nb; k++) {
                        stringFinale.append(")");
                    }
                }
                stringFinale.append(laString.charAt(j) - '0');
                lastNb = nb;
            }

            for (int j = 0; j < lastNb; j++) {
                stringFinale.append(")");
            }

            System.out.println("Case #" + (i + 1) + ": " + stringFinale);
        }
    }
}
