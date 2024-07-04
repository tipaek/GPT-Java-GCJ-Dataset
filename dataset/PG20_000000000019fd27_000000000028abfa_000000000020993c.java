import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream
        int cases= sc.nextInt();
        for (int k=0; k<cases; k++){
            int rows = sc.nextInt();
            int trace = 0;
            int duplicateRows = 0;
            ArrayList<Map<Integer, Boolean>> columnChecks = new ArrayList<>();
            ArrayList<Boolean> columnDuplicates = new ArrayList<>();
            for (int l=0; l<rows;l++) {
                columnChecks.add(new HashMap<>());
                columnDuplicates.add(false);
            }
            for (int i=0; i<rows; i++){
                Map<Integer, Boolean> duplicates = new HashMap<>();
                boolean isDuplicate = false;
                for (int j=0; j<rows; j++){
                    int el = sc.nextInt();
                    if (i==j) trace+=el;
                    if (duplicates.containsKey(el)) isDuplicate = true;
                    else duplicates.put(el, true);
                    if (columnChecks.get(j).containsKey(el)) columnDuplicates.set(j, true);
                    else columnChecks.get(j).put(el, true);
                }
                if (isDuplicate) duplicateRows+=1;
            }
            int duplicateColumns = Collections.frequency(columnDuplicates, true);
            System.out.println("Case #"+(k+1)+": "+trace+" "+duplicateRows+" "+duplicateColumns+" ");
        }
    }
}