import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String... arguments){
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int diagSum, rowsWithDuplicates, colsWithDuplicates;

        int t = scanner.nextInt();
        for (int i=1;i<=t;i++) {
            int n = scanner.nextInt();
            int k=0;
            colsWithDuplicates = 0;
            rowsWithDuplicates = 0;
            diagSum = 0;
            List<Set<String>> cols = new ArrayList<>();
            while(k<n){
                cols.add(new HashSet<>());
                k++;
            }
            scanner.nextLine();

            for(int j=0;j<n;j++){
                String line = scanner.nextLine();
                String[] lineElems = line.split(" ");
                // Adding to the diagonal sum
                diagSum += Integer.parseInt(lineElems[j]);
                // Is there duplicates in each row
                Set<String> row = new HashSet<>(Arrays.asList(lineElems));
                if(row.size() != n)
                    rowsWithDuplicates++;
                // Updating sets of columns
                k= 0;
                while(k<n){
                    cols.get(k).add(lineElems[k]);
                    k++;
                }
            }
            // Is there duplicates in each column
            Iterator<Set<String>> ite = cols.iterator();
            while(ite.hasNext()){
                if(ite.next().size() != n)
                    colsWithDuplicates++;
            }
            System.out.println("Case #"+ i);
        }
    }
}