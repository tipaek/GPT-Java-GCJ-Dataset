import java.util.*;
public class Solution1 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int test=s.nextInt();
        int count=1;
        while(test-->0) {
            int n=s.nextInt();
            int array[][]=new int[n][n];
            HashMap<Integer,Integer> map_row=new HashMap<>();;
            HashMap<Integer,Integer> map_column=new HashMap<>();;
            int rows=0;
            int columns=0;
            int trace=0;

            Integer row_count,column_count;
            for(int i=0;i<n;i++) {
                map_row.clear();
                for(int j=0;j<n;j++) {
                    array[i][j]=s.nextInt();
                    if(i==j)
                        trace+=array[i][i];

                }
            }
            for(int i=0;i<n;i++) {
                map_column.clear();
                for(int j=0;j<n;j++) {
                    column_count=map_column.get(array[j][i]);
                    if(column_count==null)
                        map_column.put(array[j][i],0);
                    else if(column_count==0){
                        columns++;
                        map_column.put(array[j][i],1);
                        break;
                    }
                }
            }
            for(int i=0;i<n;i++) {
                map_row.clear();
                for(int j=0;j<n;j++) {
                    row_count=map_row.get(array[i][j]);
                    if(row_count==null)
                        map_row.put(a[i][j], 0);
                    else if(row_count==0){
                        rows++;
                        map_row.put(array[i][j], 1);

                        break;
                    }
                }
            }


            System.out.println("Case #"+(count++)+": "+trace+" "+rows+" "+columns);

        }
    }
}