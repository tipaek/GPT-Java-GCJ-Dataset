
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = 0;
            int r = 0;
            int c = 0;
            Map<Integer, Object> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                Map<Integer, Integer> rowint = new HashMap<>();
                boolean isRowCounted = false;
                for (int l = 0; l < n; l++) {
                    int m = sc.nextInt();
                    if (l == j) {
                        k += m;
                    }
                    //row count
                    Integer rowi = rowint.get(m);
                    if (!isRowCounted) {
                        if (rowi != null && rowi > 0) {
                            r++;
                            rowint.put(m, -1);
                            isRowCounted = true;
                        } else if (rowi == null || rowi == 0) {
                            rowint.put(m, 1);
                        }
                    }

                    //col count
                    if (!(map.get(l) instanceof Integer)) {
                        Map<Integer, Integer> colList = (Map<Integer, Integer>) map.get(l);
                        if (colList != null) {
                            Integer coli = colList.get(m);
                            if (coli != null && coli > 0) {
                                c++;
                                colList.put(m, -1);
                                map.put(l, -1);
                            }else if(coli==null){
                                colList.put(m, 1);
                            }

                        } else {
                            colList = new HashMap<>();
                            colList.put(m, 1);
                            map.put(l, colList);
                        }
                    }

                }
            }

            System.out.printf("Case #%d: %d %d %d\n", i + 1, k, r, c);

        }
    }

}
