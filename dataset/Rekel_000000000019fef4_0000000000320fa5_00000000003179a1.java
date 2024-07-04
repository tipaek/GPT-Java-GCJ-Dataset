import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class Solution {
    static Scanner in;

    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(System.in);
        int T = in.nextInt();

        for (int test = 1; test <= T; test++) {
            System.out.println("Case #" + test + ": " + losOp());
        }
    }

    public static String losOp() {
        HashMap<Character, String> D = new HashMap<>(10);

        int U = in.nextInt();
        for (int regel = 0; regel < 10000; regel++) {
            long Q = in.nextLong();
            if (Q == -1) Q = ((int) Math.pow(10, U)) - 1;
            char[] R = in.nextLine().trim().toCharArray();
            if (D.size() < 10) {
                for (char c : R) {
                    if (!D.containsKey(c)) D.put(c, "0123456789");
                }
            }

            D.put(R[0], D.get(R[0]).replace("0", "")); // Eerste is nooit nul.
            String Qs = Long.toString(Q);
            if (R.length < Qs.length()) continue; // Kan volgende logica stap niet zetten.

            for (int getal = 0; getal < Qs.length(); getal++) { // Zolang maximaal.
                int Qg = Integer.parseInt(Qs.charAt(getal) + "");
                char Rg = R[getal];
                for (int i = Qg + 1; i <= 9; i++) {
                    D.put(Rg, D.get(Rg).replace(Integer.toString(i), "")); // Alles hoger dan Q kan niet.
                }
                if (Rg != Qg) break;
            }
        }

        Character[] gs = new Character[10];
        D.keySet().toArray(gs);
        boolean gevonden = true;
        ArrayList<Integer> index = new ArrayList<>(10);
        while (gevonden) {
            gevonden = false;
            for (int j = 0; j <= 9; j++) {
                String s2 = D.get(gs[j]);
                if (s2.length() == 1 && !index.contains(j)) { // Haal getal uit anderen.
                    gevonden = true;
                    index.add(j);
                    for (int k = 0; k <= 9; k++) {
                        if (k == j) continue;
                        D.put(gs[k], D.get(gs[k]).replace(s2, ""));
                    }
                }
            }
        }

        String resultaat = "";
        for (int i = 0; i <= 9; i++) {
            for (Entry<Character, String> g : D.entrySet()) {
                if (Integer.parseInt(g.getValue()) == i) {
                    resultaat = resultaat + g.getKey();
                    break;
                }
            }
        }
        assert resultaat.length() == 10;
        return resultaat;
    }
}