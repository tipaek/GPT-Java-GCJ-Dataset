import java.util.*;

class Main {
    public static void calculator(Scanner sc, int nbr) {
        int n = Integer.parseInt(sc.nextLine());
        List<List<Integer>> matrix = new ArrayList<>();
        int trace = 0;
        int repeatRow = 0, repeatCol = 0;

        for (int i = 0; i < n; i++) {
            String[] row = sc.nextLine().split("\\s+");
            Set<Integer> uniqueElements = new HashSet<>();
            List<Integer> list = new ArrayList<>();
            boolean isRepeated = false;

            for (int j = 0; j < row.length; j++) {
                int val = Integer.parseInt(row[j]);
                list.add(val);
                if (i == j) {
                    trace += val;
                }
                if (!uniqueElements.add(val)) {
                    isRepeated = true;
                }
            }

            matrix.add(list);
            if (isRepeated) {
                repeatRow++;
            }
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            boolean isRepeated = false;

            for (int j = 0; j < n; j++) {
                int val = matrix.get(j).get(i);
                if (!uniqueElements.add(val)) {
                    isRepeated = true;
                    break;
                }
            }

            if (isRepeated) {
                repeatCol++;
            }
        }

        System.out.println("Case #" + nbr + ": " + trace + " " + repeatRow + " " + repeatCol);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tnbr = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < tnbr; i++) {
            calculator(sc, i + 1);
        }
    }
}