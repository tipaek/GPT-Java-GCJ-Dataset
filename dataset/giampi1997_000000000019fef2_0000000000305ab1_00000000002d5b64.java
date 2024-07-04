import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] strings) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            StringBuilder builder = new StringBuilder();
            int lines = 0;

            int N = scanner.nextInt();
            int S = scanner.nextInt();

            int ultimo = 0;
            int penultimo;
            int turno = 1;
            int totali = N * S;

            while(N!= 1) {

                while (S - turno >= 1) {
                    penultimo = N * (S - turno) + ultimo;
                    ultimo = totali - penultimo - turno;
                    builder.append(penultimo + " " + ultimo + '\n');
                    lines++;
                    turno++;
                }
                N--;

                totali = N * S;
                turno = 1;
                ultimo = 0;
            }

            System.out.println("Case #" + (i+1) + ": " + lines);
            System.out.println(builder);

        }

    }
}