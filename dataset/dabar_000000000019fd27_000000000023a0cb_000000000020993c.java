import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System. in);
        String input = scanner.nextLine();
        int numOfCases = Integer.parseInt(input);
        for(int i=0;i<numOfCases;i++) {
            input = scanner.nextLine();
            int size = Integer.parseInt(input);
            List<String> data = new ArrayList<>();
            for (int j =0;j<size;j++) {
                data.add(scanner.nextLine());
            }
            TestCase tc = new TestCase(size, data);
            int [] result = tc.getResult();
            System.out.println("Case #"+(i+1)+": "+result[0]+ " "+result[1]+" "+result[2]);
        }

    }

    public static class TestCase {
        private final int size;
        private final List<String> data;
        public TestCase(int size, List<String> data) {
            this.size = size;
            this.data = data;
        }

        private int[] getResult() {
            int trace=0;
            int rows=0;
            int cols=0;
            Set<String> s = new HashSet<>();
            boolean dupfound;

            boolean[] colDupFound = new boolean[size];
            Set[] colDupFoundSet = new Set[size];
            for (int i=0;i<size;i++) {
                colDupFoundSet[i] = new HashSet();
            }
            for(int i =0;i<size;i++) {
                dupfound=false;
                s.clear();
                String row = data.get(i);
                String[] vals = row.split(" ");
                trace+=Integer.parseInt(vals[i]);
                for (int j=0;j<size ;j++) {
                    if (!dupfound && s.contains(vals[j])) {
                        rows++;
                        dupfound=true;
                    }
                    s.add(vals[j]);
                    if (!colDupFound[j] && colDupFoundSet[j].contains(vals[j])) {
                        cols++;
                        colDupFound[j] = true;
                    }
                    colDupFoundSet[j].add(vals[j]);
                }

            }


            int[] result = new int[3];
            result[0] = trace;
            result[1] = rows;
            result[2] = cols;

            return result;
        }
    }
}