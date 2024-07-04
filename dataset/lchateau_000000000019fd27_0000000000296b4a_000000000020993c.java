import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 1; i < t + 1; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][];
            for (int j = 0; j < matrix.length; j++) {
                int[] line = new int[n];
                for (int k = 0; k < line.length; k++) {
                    line[k] = sc.nextInt();
                }
                matrix[j] = line;
            }

            // matrix exploration
            int trace = 0;
            int r = 0;
            int c = 0;
            for (int j = 0; j < matrix.length; j++) {
                List<Integer> row = new ArrayList<>();
                List<Integer> col = new ArrayList<>();
                boolean checkRow = true;
                boolean checkCol = true;
                for (int j2 = 0; j2 < matrix.length; j2++) {
                    if (j == j2) {
                        trace += matrix[j][j];
                    }
                    if (checkRow && !testPresence(matrix[j][j2], row)){
                        r++;
                        checkRow = !checkRow;
                    }
                    if (checkCol && !testPresence(matrix[j2][j], col)){
                        c++;
                        checkCol = false;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
    }

    public static boolean testPresence(int idLivre, List<Integer> tab) {
        int debut = 0;
        int fin = tab.size() - 1;
        boolean present = false;
        if (tab.size() == 0) {
            tab.add(idLivre);
            return true;
        }
        while (!present && debut <= fin) {
            int milieu = (debut + fin) / 2;
            if (tab.get(milieu) == idLivre) {
                return false;
            }
            if (milieu + 1 == tab.size()) {
                tab.add(0, idLivre);
                return true;
            }

            if (idLivre > tab.get(milieu)) {
                if (idLivre < tab.get(milieu + 1)) {
                    tab.add(milieu + 1, idLivre);
                    return true;
                } else {
                    debut = milieu + 1;
                }
            } else {
                fin = milieu - 1;
            }
        }
        tab.add(0, idLivre);
        return true;
    }
}