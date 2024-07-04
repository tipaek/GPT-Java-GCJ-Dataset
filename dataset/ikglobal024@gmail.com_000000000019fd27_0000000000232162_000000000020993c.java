public class Vestigium {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        //System.out.println(T);
        for (int t=1; t<=T; t++) {
            int N = in.nextInt();
            //System.out.println(N);
            int[][] matrix = new int[N][N];
            int trace = 0;
            int duplicateRowsCount = 0;
            int duplicateColsCount = 0;

            Map<Integer, ColValue> cols = new HashMap<>();

            for (int r=0; r<N; r++) {
                List<Integer> rowValues = new ArrayList<>();
                boolean rowHasDuplicate = false;

                for (int c=0; c<N; c++) {
                    int value = in.nextInt();
                    //System.out.print(value+" ");
                    matrix[r][c] = value;

                    if (r == c) {
                        trace += matrix[r][c];
                    }

                    if (!rowHasDuplicate) {
                        if (rowValues.contains(value)) {
                            duplicateRowsCount++;
                            rowHasDuplicate = true;
                        }
                        rowValues.add(value);
                    }

                    if (cols.containsKey(c)) {
                        ColValue cv = cols.get(c);
                        if (!cv.hasDuplicates) {
                            List<Integer> list = cv.values;
                            if (list.contains(value)) {
                                cv.hasDuplicates = true;
                                duplicateColsCount++;
                            }
                            list.add(value);
                            cv.values = list;
                            cols.put(c, cv);
                        }
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(value);
                        ColValue cv = new ColValue();
                        cv.values = list;
                        cols.put(c, cv);
                    }

                }
                //System.out.println();

            }

            System.out.println("Case #" + t + ": " + " " + trace + " " + duplicateRowsCount + " " + duplicateColsCount);

        }
    }

    static class ColValue{
        List<Integer> values;
        boolean hasDuplicates;
    }

}