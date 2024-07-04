import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    public static class Cell {
        String value;

        public Cell(String value) {
            this.value = value;
        }

        public void addLeft() {
            StringBuilder sb = new StringBuilder(value);
            sb.insert(0, '(');
            value = sb.toString();
        }

        public void addRight() {
            StringBuilder sb = new StringBuilder(value);
            sb.append(')');
            value = sb.toString();
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for(int t = 1; t <= test; t++) {
            String s = br.readLine();
            Cell[] cells = getBalanced(s);
            System.out.print(String.format("Case #%d: ", t));
            for(int i = 0; i < s.length(); i++) {
                if(cells[i] != null) {
                    System.out.print(cells[i]);
                }
            }
            System.out.println();
        }
    }

    private static Cell[] getBalanced(String s) {
        Cell[][] X = new Cell[10][s.length()];
        for(int i = 0; i < s.length(); i++) {
            X[s.charAt(i) - '0'][i] = new Cell(String.valueOf(s.charAt(i)));
        }
        int level = 9;
        while(level > 0) {
            process(X[level]);
            for(int i = 0; i < s.length(); i++) {
                X[level - 1][i] = (X[level - 1][i] != null) ? X[level - 1][i] : X[level][i];
            }
            level--;
        }
        return X[0];
    }


    private static void process(Cell[] ar) {
        int i = 0;
        while(i < ar.length) {
            if(ar[i] != null) {
                int j = i + 1;
                while(j < ar.length && ar[j] != null) {
                    j++;
                }
                ar[i].addLeft();
                ar[j - 1].addRight();
                i = j;
            } else {
                i++;
            }
        }
    }
}
