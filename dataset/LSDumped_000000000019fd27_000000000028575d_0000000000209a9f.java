import java.util.*;
        import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int total = in.nextInt();
        StringBuilder resultat = new StringBuilder();
        in.nextLine();
        int anterior  = 0;
        for (int i = 1; i <= total; i++) {
            String cadena = in.nextLine();//Tamany matriu
            for (int w = 0;w < cadena.length();w++) {
                int actual = cadena.charAt(w) - 48;
                if (anterior > actual) {
                    int pepe = 0;
                    while (pepe < (anterior-actual)) {
                        resultat.append(")");
                        pepe++;
                    }
                }
                else {
                    if (actual > anterior) {
                        int pepe = 0;
                        while (pepe < (actual - anterior)) {
                            resultat.append("(");
                            pepe++;
                        }
                    }
                }
                resultat.append(actual);
                anterior = actual;
            }
            int finPapu  =0;
            while (finPapu < anterior) {
                resultat.append(")");
                finPapu++;
            }
            System.out.println("Case #" + i + ": " + resultat);
            resultat = new StringBuilder();
            anterior = 0;
        }
    }
}