public class Solution{

 public static void main(String[] args) {
  
        Scanner br = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//            br = new BufferedReader(new InputStreamReader(input));
        int count = Integer.parseInt(br.nextLine());


        // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= count; ++i) {
            int sum = 0;
            int lines = Integer.parseInt(br.nextLine());
            int rowCount = 0;
            int columnCount = 0;
            int[][]  arrayTable = new int[lines][lines];
            for (int j = 0; j < lines; j++) {
                StringTokenizer sk = new StringTokenizer(br.nextLine());
                int tokenCount = sk.countTokens();

                Set<Integer> sets = new HashSet<>();
                boolean isCounted = false;
                for (int k = 0; k < tokenCount; k++) {

                    int digit = Integer.parseInt(sk.nextToken());
                    arrayTable[j][k] = digit;
                    if (k == j) {
                        sum += digit;
                    }
                    if (!isCounted) {
                        if (sets.contains(digit)) {
                            rowCount++;
                            isCounted = true;
                        }
                        sets.add(digit);
                    }
                }


            }
            for (int a = 0; a < arrayTable.length; a++) {

                Set<Integer> sets = new HashSet<>();
                for (int b = 0; b < arrayTable[a].length; b++) {
                    int digit = arrayTable[b][a];
                    if (sets.contains(digit)) {
                        columnCount++;
                        break;
                    }
                    sets.add(digit);

                }
            }

//            Log.d("yu.test", "Case #" + i + ": " + sum + " " + rowCount + " " + columnCount);
                System.out.println("Case #" + i + ": " + sum + " " + rowCount + " " + columnCount);

        }
 }

}