import java.io.*;
import java.util.*;
public class Solution{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        int sc=1;
        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            int cnt=0;
            int rcnt=0;
            int ccnt=0;
            int[][] cmem = new int[n+1][n+1];
            for(int i=0;i<n;i++) {
                String[] row = br.readLine().split(" ");
                Set<Integer> S = new HashSet<>();
                boolean seen=false;
                for(int j=0;j<n;j++) {
                    int tmp = Integer.parseInt(row[j]);
                    if(i==j)cnt+=tmp;
                    cmem[j][tmp]++;
                    if(!seen) {
                        if(S.contains(tmp)) {
                            rcnt++;
                            seen=true;
                        }
                        S.add(tmp);
                    }
                    
                }
            }
            for(int i=0;i<n;i++) {
                for(int j=1;j<=n;j++) {
                    if(cmem[i][j]>1) {
                        ccnt++;
                        break;
                    }
                }
            }
            bw.append("Case #"+(sc++)+": "+cnt+" "+rcnt+" "+ccnt);
            if(T>0) bw.append("\n");
        }
        bw.close();
    }   
}