import java.io.*;
import java.util.*;
class Solution{
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
        for(int q=1;q<=T;q++){
            int N =Integer.parseInt(br.readLine());
            String[] a = new String[N];
            for(int i=0;i<N;i++){
                a[i]=br.readLine();
            }
            int[][] mat =new int[N][N];
            for(int i=0;i<N;i++){
                String[] m = a[i].split(" ");
                for(int j=0;j<N;j++){
                    mat[i][j]=Integer.parseInt(m[j]);
                }
            }
            int trace=0,row_count=0,col_count=0;
            //row_count
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    List<Integer> row = new ArrayList<>(N);
                    if(!row.contains(mat[i][j])){
                        row.add(mat[i][j]);
                    }
                    else{
                        row_count++;
                        break;
                    }
                }
            }
            //column_count
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    List<Integer> col =new ArrayList<>(N);
                    if(!col.contains(mat[j][i])){
                        col.add(mat[j][i]);
                    }
                    else{
                        col_count++;
                        break;
                    }
                }
            }
            for(int i=0;i<N;i++){
                trace+=mat[N][N];
            }
            String ans = "Case #"+q+": "+trace+" "+row_count+" "+col_count;
            System.out.println(ans);
        
                
                
        }
            
    }
}
