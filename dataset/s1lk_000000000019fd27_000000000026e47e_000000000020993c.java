import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();

        for (int c = 0; c < cases; c++) {

            int repRowCount = 0;
            int repColCount = 0;
            int latinSqr = 0;

            int n = scan.nextInt();
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < n; i++) {
                matrix.add(new ArrayList<Integer>());
                for (int j = 0; j < n; j++) {
                    int cell = scan.nextInt();
                    matrix.get(i).add(cell);
                    if (i == j) {
                        latinSqr += cell;
                    };
                }
            }

            for (int i = 0; i < n; i++) {
                if (checkDuplicate(matrix.get(i))) {
                    ++repRowCount;
                }
            }

            for (int i = 0; i < n; i++){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for (int j = 0; j < n; j++) {
                    temp.add(matrix.get(j).get(i));
                }
                if (checkDuplicate(temp)) {
                    ++repColCount;
                }
            }

            System.out.println("Case #" + (c+1) + ": " + latinSqr + " " + repRowCount + " " + repColCount);
        }

    }

    public static boolean checkDuplicate(ArrayList<Integer> input) {
        Set inputSet = new HashSet(input);
        if (inputSet.size() < input.size())
            return true;
        return false;
    }

}
