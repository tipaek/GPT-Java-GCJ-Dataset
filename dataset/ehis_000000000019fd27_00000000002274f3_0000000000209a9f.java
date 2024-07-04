
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
        boolean parentheseOuverte = false;
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i] + " ");

            if (ch[i] == '1') {
                if (i < ch.length - 1) {
                    if (!parentheseOuverte) {
                        if(i < ch.length - 1 && ch[i + 1] == '1')
                        {
                            resultat += "(1";
                            parentheseOuverte = true;
                        }
                        else if(i < ch.length - 1 && ch[i + 1] == '0')
                        {
                            resultat += "(1)";
                            parentheseOuverte = false;
                        }
                        
                        
                    } else if (i < ch.length - 1 && ch[i + 1] == '1') {
                        resultat += "1";
                    } else if (i < ch.length - 1 && ch[i + 1] == '0') {
                        resultat += "1)";
                        parentheseOuverte = false;
                    }
                } else {
                    if (!parentheseOuverte) {
                        resultat += "(1)";
                        parentheseOuverte = false;
                    } else {
                        resultat += "1)";
                        parentheseOuverte = false;
                    }
                }

            } else if (ch[i] == '0') {
                resultat += "0";
            }

        }

        return resultat;
    }

}
