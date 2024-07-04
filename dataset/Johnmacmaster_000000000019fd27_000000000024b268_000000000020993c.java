
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int rows=Integer.parseInt(br.readLine());
            int[][] matrix=new int[rows][rows];
            int trace=0;
            int row_count=0;
            int column_count=0;
//            Set<String> set=new HashSet<>();
            String[] column_values=new String[rows];
            Arrays.fill(column_values," ");
            for(int j=0;j<rows;j++){
                Set<String> set=new HashSet<>();
                String[] row_values=br.readLine().split(" ");
                int count=0;
                int flag=0;
                for (int k = 0; k < row_values.length; k++) {
                    column_values[k] = column_values[k]+" "+row_values[k];
                    if(count++==0)trace+=Integer.parseInt(row_values[j]);
                    if (flag==0&&set.add(row_values[k]) == false) {
                        row_count++;
                        flag=1;
                    }
                }
            }
            for (int j = 0; j < column_values.length; j++) {
                Set<String> set=new HashSet<>();
                column_values[j]=column_values[j].trim();
                String[] column=column_values[j].split(" ");
                for (int k = 0; k < column.length; k++) {
                    if (set.add(column[k]) == false) {
                        column_count++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+row_count+" "+column_count);
        }
    }
}
