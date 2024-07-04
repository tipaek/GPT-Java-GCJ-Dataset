import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.util.HashSet;


public class Vestigium{

    public static void main(String[] args) {
        BufferedReader br = new BufferedInputStream(System.in);
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++){
            int n = Integer.parseInt(br.readLine());
            int m[][] = new int[n][n];
            int trace,r,c = 0;
            for(int j = 0; j < n; j++){
                String s[] = br.readLine().split(" ");
               for(int k = 0; k < n; k++){  
                    m[j][k] = Integer.parseInt(s[k]);
                    if(j == k){
                        trace += m[j][k];
                    }
               } 
            }
            
            for(int j = 0; j < n; j++){
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
               for(int k = 0; k < n; k++){  
                    rowSet.add(m[j][k]);
                    colSet.add(m[k][j]);
               } 
               if(rowSet.size() < 4){
                    r++;
               }
               if(colSet.size() <4){
                   c++;
               }
            }

            System.out.println("Case #1:" + trace + " " + r + " " + c );

        }
    }
}