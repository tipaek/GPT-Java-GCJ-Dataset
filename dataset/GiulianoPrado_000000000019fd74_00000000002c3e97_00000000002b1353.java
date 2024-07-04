import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static ArrayList<Dupla> caminho = new ArrayList<>();
    static class Dupla {
        int i;
        int j;

        public Dupla(int i, int j) {
            this.i = i;
            this.j = j;
        }
        public Dupla getCorrigido() {
            return new Dupla(i+1,j+1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Dupla dupla = (Dupla) o;

            if (i != dupla.i) return false;
            return j == dupla.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
    public static boolean isValid (int i, int j) {
        return i>=j && i>=0 && j>=0;
    }

    public static int getValue (int[][] array, int i, int j) {
        if (i<0 || j<0 || !isValid(i,j)) {
            return 0;
        }
        if (array[i][j]==0) {
            array[i][j] = getValue(array, i-1, j-1) + getValue(array, i-1, j);
        }
        return array[i][j];
    }

    public static List<Dupla> solve(Scanner in, int sum) {
        caminho = new ArrayList<>();
        int[][] pascTable = new int[500][500];
        pascTable[0][0] = 1;
        Set<Dupla> visited = new HashSet<Dupla>();
//        List<Dupla> caminho = new ArrayList<Dupla>();

        visit(pascTable,0,0,visited,0,sum);
        return caminho;
    }

    public static int visit (int[][] table, int i, int j, Set<Dupla> visited, int sum, int objetivo) {
        if (!isValid(i,j)) return -1;
        if (visited.contains(new Dupla(i,j))) return -1;
        visited.add(new Dupla(i,j));

        if (sum+getValue(table,i,j) > objetivo) return -1;
        if (sum+getValue(table,i,j) == objetivo) {
            caminho.add(new Dupla(i,j));
            return 1;
        }
        else if (visit(table,i-1,j-1,visited,sum+getValue(table,i,j),objetivo) == 1) {
            caminho.add(new Dupla(i,j));
            return 1;
        }
        else if (visit(table,i-1,j,visited,sum+getValue(table,i,j),objetivo) == 1) {
            caminho.add(new Dupla(i,j));
            return 1;
        }
        else if (visit(table,i,j-1,visited,sum+getValue(table,i,j),objetivo) == 1) {
            caminho.add(new Dupla(i,j));
            return 1;
        }
        else if (visit(table,i,j+1,visited,sum+getValue(table,i,j),objetivo) == 1) {
            caminho.add(new Dupla(i,j));
            return 1;
        }
        else if (visit(table,i+1,j,visited,sum+getValue(table,i,j),objetivo) == 1) {
            caminho.add(new Dupla(i,j));
            return 1;
        }
        else if (visit(table,i+1,j+1,visited,sum+getValue(table,i,j),objetivo) == 1) {
            caminho.add(new Dupla(i,j));
            return 1;
        }
        visited.remove(new Dupla(i,j));
        return -1;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int prob = 1; prob <= N; ++prob) {
            int sum = in.nextInt();
            List<Dupla> caminho = solve(in, sum);
            List<Dupla> caminhoCorreto = new ArrayList<Dupla>();
            for (int i=caminho.size()-1; i>=0; i--) {
                caminhoCorreto.add(caminho.get(i).getCorrigido());
            }
            System.out.println("Case #" + prob + ": " );
            for (Dupla duplaElem : caminhoCorreto) {
                System.out.println(duplaElem.i + " " + duplaElem.j);
            }
        }

    }
}
