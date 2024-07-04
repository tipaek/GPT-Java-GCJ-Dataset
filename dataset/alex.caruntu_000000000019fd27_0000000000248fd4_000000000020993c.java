import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int n = 0; n < numCases; n++) {
            int N = input.nextInt();
            
            boolean duplicatedCols[] = new boolean[N];
            List<Set<Integer>> cols = new ArrayList<Set<Integer>>();
            for (int i = 0;i < N;i++) {
                cols.add(new HashSet<Integer>());
            }
            
            int k = 0;
            int r = 0;
            int c = 0;
            
            for (int i = 0;i < N;i++) {
                Set<Integer> row = new HashSet<Integer>();
                boolean isDuplicate = false;
                for (int j = 0;j < N;j++) {
                    int p = input.nextInt();
                    if (row.add(p) == false) isDuplicate = true;
                    if (cols.get(j).add(p) == false) duplicatedCols[j] = true;
                    if (i == j) k += p;
                }
                
                if (isDuplicate) r++;
            }
            
            for (int i = 0;i < N;i++) {
                if (duplicatedCols[i] == true) c++;
            }
            
            System.out.printf("Case #%d: ", n + 1);
            System.out.println(k + " " + r + " " + c);
        }
    }
}