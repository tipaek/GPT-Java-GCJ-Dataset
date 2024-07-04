import java.util.*;

public class Solution {

    public static void main (String args[]) {

        Scanner scan = new Scanner(System.in);
        int numberOfCases = scan.nextInt();
        //start each case
        int counter = 1;
        while ( counter <= numberOfCases) {
            int matrixTrace = 0;
            int repeatedRows = 0;
            int repeatedColumns =  0;

            int matrixLength = scan.nextInt();
            scan.nextLine();
            List<HashSet<Integer>> columns = new ArrayList<HashSet<Integer>>();

            for (int i=0; i<matrixLength; i++) {
                String numbers[] = scan.nextLine().split(" ");
                Set<Integer> lineSet = new HashSet<>();
                boolean rowHasNumberRepeated = false;
                for (int j=0; j< numbers.length; j++) {
                    Integer num = Integer.valueOf(numbers[j]);

                    if (i == j) {
                        matrixTrace += num;
                    }
                    if( !rowHasNumberRepeated) {
                        boolean added = lineSet.add(num);
                        if (!added) {
                            rowHasNumberRepeated = true;
                            repeatedRows++;
                        }
                    }

                    //to know if column has repeated numbers
                    HashSet<Integer> columnSet;
                    if ( columns.size()-1<j) {
                        columnSet = new HashSet<Integer>();
                        columns.add(columnSet);
                    } else {
                        columnSet = columns.get(j);
                    }
                    if (columnSet != null) {
                        boolean added = columnSet.add(num);
                        if (!added) {
                            columns.set(j, null);
                            repeatedColumns++;
                        }
                    }
                }
            }
            System.out.println("Case #"+counter+": "+matrixTrace+" "+repeatedRows+" "+repeatedColumns);
            counter++;
        }
    }
}

