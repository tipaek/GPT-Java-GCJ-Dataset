import java.util.*;
import java.io.*;
class Solution{  
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int t_=1;t_<=t;t_++){
            int n = Integer.parseInt(br.readLine());
            
            int m[][] = new int[n][n];
            long sum = 0;
            for(int i=0;i<n;i++){
                String s[] = br.readLine().trim().split(" ");
                for(int j=0;j<n;j++){
                    int cur = Integer.parseInt(s[j]);
                    m[i][j] = cur;
                    if(i == j) sum += cur;
                }
            }
            
            int nrow = 0;
            for(int i=0;i<n;i++){
                HashMap<Integer, Integer> hm = new HashMap();
                for(int j=0;j<n;j++){
                    int cur = m[i][j];
                    if(hm.containsKey(cur)){
                        nrow++;
                        break;
                    }
                    hm.put(cur, 0);
                }
            }
            
            int ncol = 0;
            for(int i=0;i<n;i++){
                HashMap<Integer, Integer> hm = new HashMap();
                for(int j=0;j<n;j++){
                    int cur = m[j][i];
                    if(hm.containsKey(cur)){
                        ncol++;
                        break;
                    }
                    hm.put(cur, 0);
                }
            }
            
            System.out.println("Case #"+t_+": "+sum+" "+nrow+" "+ncol);
        }
    } 
} 
