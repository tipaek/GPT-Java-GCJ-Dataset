import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine());
        try {
            for (int ks = 1; ks <= T; ks++) {
                String str = in.nextLine();
                System.out.println("Case #" + ks + ": " + resolve(str));
            }
        } catch (NegativeArraySizeException ex) {
            System.out.println("ex: " + ex);
        }
    }

    public static String resolve(String str) {
        char[] ch = str.toCharArray();
        StringBuilder resultat = new StringBuilder();
        int parentheseOuverte = 0;

        for (int i = 0; i < ch.length; i++) {
            int currentDigit = Character.getNumericValue(ch[i]);

            if (currentDigit != 0) {
                if (i < ch.length - 1) {
                    int nextDigit = Character.getNumericValue(ch[i + 1]);

                    if (parentheseOuverte == 0) {
                        while (parentheseOuverte < currentDigit) {
                            resultat.append("(");
                            parentheseOuverte++;
                        }
                        resultat.append(ch[i]);

                        if (nextDigit == 0) {
                            while (parentheseOuverte > 0) {
                                resultat.append(")");
                                parentheseOuverte--;
                            }
                        }
                    } else {
                        while (parentheseOuverte > currentDigit) {
                            resultat.append(")");
                            parentheseOuverte--;
                        }
                        while (parentheseOuverte < currentDigit) {
                            resultat.append("(");
                            parentheseOuverte++;
                        }
                        resultat.append(ch[i]);

                        if (nextDigit == 0) {
                            while (parentheseOuverte > 0) {
                                resultat.append(")");
                                parentheseOuverte--;
                            }
                        }
                    }
                } else {
                    while (parentheseOuverte < currentDigit) {
                        resultat.append("(");
                        parentheseOuverte++;
                    }
                    resultat.append(ch[i]);
                    while (parentheseOuverte > 0) {
                        resultat.append(")");
                        parentheseOuverte--;
                    }
                }
            } else {
                while (parentheseOuverte > 0) {
                    resultat.append(")");
                    parentheseOuverte--;
                }
                resultat.append("0");
            }
        }

        return resultat.toString();
    }
}