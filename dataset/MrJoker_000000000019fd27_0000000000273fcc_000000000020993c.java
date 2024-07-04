import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int test=s.nextInt();
        int count=1;
        while(test-->0) {
            int n=s.nextInt();
            int a[][]=new int[n][n];
            HashMap<Integer,Integer> map_row=new HashMap<>();;
            HashMap<Integer,Integer> map_col=new HashMap<>();;
            int row=0;
            int col=0;
            int trace=0;

            Integer row_count,col_count;
            for(int i=0;i<n;i++) {
                map_row.clear();
                for(int j=0;j<n;j++) {
                    a[i][j]=s.nextInt();
                    if(i==j)
                        trace+=a[i][i];
                    
                }
            }
            for(int i=0;i<n;i++) {
                map_col.clear();
                for(int j=0;j<n;j++) {
                    col_count=map_col.get(a[j][i]);
                    if(col_count==null)
                        map_col.put(a[j][i],0);
                    else if(col_count==0){
                        col++;
                        map_col.put(a[j][i],1);
                        break;
                    }
                }
            }
            for(int i=0;i<n;i++) {
                map_row.clear();
                for(int j=0;j<n;j++) {
                    row_count=map_row.get(a[i][j]);
                    if(row_count==null) 
                        map_row.put(a[i][j], 0);
                    else if(row_count==0){
                        row++;
                        map_row.put(a[i][j], 1);
                        
                        break;
                    }
                }
            }
            
        
             System.out.println("Case #"+(count++)+": "+trace+" "+row+" "+col);
                    
        }
    }
}