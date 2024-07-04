
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
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
        String resultat = "";
        // Printing array 
        int parentheseOuverte = 0;
        for (int i = 0; i < ch.length; i++) {

            if (ch[i] != '0') {
                if (i < ch.length - 1) {
                    if (parentheseOuverte == 0) {
                        if (i < ch.length - 1 && ch[i + 1] != '0') {
                            while (parentheseOuverte < Character.getNumericValue(ch[i])) {
                                resultat += "(";
                                parentheseOuverte++;
                            }
                            resultat += ch[i];

                        } else if (i < ch.length - 1 && ch[i + 1] == '0') {

                            while (parentheseOuverte < Character.getNumericValue(ch[i])) {
                                resultat += "(";
                                parentheseOuverte++;

                            }
                            resultat += ch[i];
                            while (parentheseOuverte >= Character.getNumericValue(ch[i])) {
                                resultat += ")";
                                parentheseOuverte--;
                            }

                        }

                    } else if (i < ch.length - 1 && ch[i + 1] != '0') {
                        if (parentheseOuverte > Character.getNumericValue(ch[i])) {
                            while (parentheseOuverte > Character.getNumericValue(ch[i])) {
                                resultat += ")";
                                parentheseOuverte--;
                            }
                        } else if (parentheseOuverte < Character.getNumericValue(ch[i])) {
                            while (parentheseOuverte < Character.getNumericValue(ch[i])) {
                                resultat += "(";
                                parentheseOuverte++;
                            }
                        }
                        resultat += ch[i];
                    } else if (i < ch.length - 1 && ch[i + 1] == '0') {

                        while (parentheseOuverte < Character.getNumericValue(ch[i])) {
                            resultat += "(";
                            parentheseOuverte++;
                        }
                        while (parentheseOuverte > Character.getNumericValue(ch[i])) {
                            resultat += ")";
                            parentheseOuverte--;
                        }
                        resultat += ch[i];
                        while (parentheseOuverte > 0) {
                            resultat += ")";
                            parentheseOuverte--;
                        }

                    }
                } else {
                    if (parentheseOuverte == 0) {

                        while (parentheseOuverte < Character.getNumericValue(ch[i])) {
                            resultat += "(";
                            parentheseOuverte++;
                        }
                        resultat += ch[i];
                        while (parentheseOuverte > 0) {
                            resultat += ")";
                            parentheseOuverte--;
                        }

                    } else {
                        while (parentheseOuverte > Character.getNumericValue(ch[i])) {
                            resultat += ")";
                            parentheseOuverte--;
                        }
                        
                        while (parentheseOuverte < Character.getNumericValue(ch[i])) {
                            resultat += "(";
                            parentheseOuverte++;
                        }

                        resultat += ch[i];
                        while (parentheseOuverte > 0) {
                            resultat += ")";
                            parentheseOuverte--;
                        }
                    }
                }

            } else if (ch[i] == '0') {
                resultat += "0";
            }

        }

        return resultat;
    }

}
