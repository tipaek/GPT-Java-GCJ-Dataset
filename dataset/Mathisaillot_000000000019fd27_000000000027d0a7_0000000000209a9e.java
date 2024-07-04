import java.util.Scanner;

public class Solution {

    public static int requete(int v) {
        req ++;
        System.out.println(v);
        return scanner.nextInt();
        /*String rep = scanner.next();
        if (rep.equalsIgnoreCase("N")) {
            System.exit(0);
        }
        return Integer.parseInt(rep);*/
    }

    private static int other(int i) {
        return (i+1) % 2;
    }

    private static void getCouple(int id) {
        int first, second;
        first = requete(id +1);
        second = requete(b - id);
        if (first == second) {
            sames[id] = true;
            values[id] = comp ? other(first) : second;
        } else {
            sames[id] = false;
            values[id] = inv != comp ? second : first;
        }
    }

    private static void check() {
        if (req % 10 == 0 && req != 0) {
            if (same != - 1) {
                int r = requete(same + 1);
                comp = (values[same] != r);
            } else
                requete(1);

            if (op != -1) {
                int r = requete(op+1);
                if (comp) {
                    inv = r == values[op];
                } else {
                    inv = r != values[op];
                }
            } else
                requete(1);
        }
    }

    private static int b, req, same, op;
    private static boolean inv, comp;
    private static int[] values;
    private static boolean[] sames;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int t = scanner.nextInt();
        b = scanner.nextInt();

        values = new int[b/2];
        sames = new boolean[b/2];


        for (int i = 0; i < t; i++) {
            int connus = 0;
            same = -1;
            op = -1;
            req = 0;
            inv = false;
            comp = false;

            while (connus < b/2) {

                check();

                getCouple(connus);
                if (same == - 1 && sames[connus]) {
                    same = connus;
                }
                if (op == -1 && !sames[connus])
                    op = connus;
                connus ++;

            }

            int milieu = 0;

            if (b % 2 == 1) {
                check();
                milieu = requete(b/2 +1);
            }

            StringBuilder str = new StringBuilder();

            for (int j = 0; j < b / 2; j++) {
                if (sames[j]) {
                    str.append(comp ? other(values[j]) : values[j]);
                } else {
                    str.append(comp == inv ? values[j] : other(values[j]));
                }
            }

            if (b % 2 == 1) {
                str.append(milieu);
            }

            for (int j = b/2 - 1; j >= 0; j--) {
                if (sames[j]) {
                    str.append(comp ? other(values[j]) : values[j]);
                } else {
                    str.append(comp == inv ? other(values[j]) : (values[j]));
                }
            }

            System.out.println(str.toString());
            String rep = scanner.next();

            if (rep.equalsIgnoreCase("N")) {
                System.exit(0);
            }

        }

    }
}
