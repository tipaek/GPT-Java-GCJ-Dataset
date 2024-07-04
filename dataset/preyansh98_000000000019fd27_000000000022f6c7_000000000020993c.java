import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i<=T; ++i){
            int N = Integer.parseInt(br.readLine());
            int trace = 0;
            int dupRows = 0, dupCols = 0;

            Set<String> solns = new HashSet<>();
            Map<Integer, Set<Integer>> colMap = new HashMap<>();

            for(int row = 0; row<N; row++) {
                Set<Integer> rowsSet = new HashSet<>();
                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int col = 0; col < N; col++){
                    int num = Integer.parseInt(st.nextToken());

                    if(rowsSet.contains(num))
                        solns.add("row"+row);

                    if(colMap.get(col)!=null && colMap.get(col).contains(num))
                        solns.add("col"+col);

                    if(row == col){
                        trace+=num;
                    }

                    Set<Integer> colsSet = colMap.get(col);
                    if(colsSet==null) colsSet = new HashSet<>();
                    colsSet.add(num);

                    colMap.put(col,colsSet);
                    rowsSet.add(num);
                }
            }

            for(String s : solns){
                if(s.startsWith("row"))
                    dupRows++;
                else
                    dupCols++;
            }

            System.out.println("Case #" + i + ": " + trace + " " + dupRows + " " + dupCols);
        }
    }
}