
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
    public static void main(String[] args){
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int T = Integer.parseInt(br.readLine());
            while (T-- > 0) {
                int N = Integer.parseInt(br.readLine());
                int trace = 0;
                List<Set<Integer>> row = new ArrayList<>();
                List<Set<Integer>> column = new ArrayList<>();
                for (int i = 0; i < N; i++) {
                    row.add(new HashSet<>());
                    column.add(new HashSet<>());
                }
                int columnCnt = 0;
                int rowCnt = 0;
                
                boolean[] isColumnChecked = new boolean[N];
                boolean[] isRowChecked = new boolean[N];
                
                for (int i = 0; i < N; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < N; j++) {
                        int value = Integer.parseInt(st.nextToken());
                        if (!column.get(j).add(value) && !isColumnChecked[j]) {
                            columnCnt++;
                            isColumnChecked[j] = true;
                        }
                        if (!row.get(i).add(value) && !isRowChecked[i]) {
                            rowCnt++;
                            isRowChecked[i] = true;
                        }
                        if (i == j) trace += value;
                    }
                }
                System.out.printf("Case #%d: %d %d %d\n", T, trace, rowCnt, columnCnt);
                   }
        } catch (IOException e) {

        }
    }
}
