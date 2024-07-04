

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int U = in.nextInt();
            in.nextLine();
            String[] str = new String[10000];
            double[][] probs = new double[10][10];
            ArrayList<Character> allChars = new ArrayList<>();
            HashSet<Character> firstChar = new HashSet<>();
            HashSet<Character> used = new HashSet<>();
            StringBuilder result = new StringBuilder();
            char first = 'A';
            for (int i = 0; i < 10000; i++) {
                str[i] = in.nextLine().split(" ")[1];
                for (int j = 0; j < str[i].length(); j++) {
                    char tmp = str[i].charAt(j);
                    if (!allChars.contains(tmp)) {
                        allChars.add(tmp);
                    }
                    int index = allChars.indexOf(tmp);
                    double p = 0;
                    for (int k = 9; k >= 0; k--) {
                        probs[index][k] += p;
                        p += 1. / 9 / k;
                    }
                }
                firstChar.add(str[i].charAt(0));
            }
            for (char ch : allChars) {
                if (!firstChar.contains(ch)) {
                    first = ch;
                }
            }

            used.add(first);
            result.append(first);

            for (int i = 1; i <= 9; i++) {
                double maxValue = -1;
                int jmax = 0;
                for (int j = 0; j <= 9; j++) {
                    if (probs[j][i] > maxValue && !used.contains(allChars.get(j))) {
                        maxValue = probs[j][i];
                        jmax = j;
                    }
                }
                result.append(allChars.get(jmax));
                used.add(allChars.get(jmax));
            }
            out.write(String.format("Case #%d: %s\n", t + 1, result.toString()));
        }

        out.close();
        in.close();
    }

}
