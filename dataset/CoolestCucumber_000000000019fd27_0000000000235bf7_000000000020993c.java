import java.io.*;
import java.util.HashSet;

class Vestigium {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int y=1;y<=T;++y){
            int N = Integer.parseInt(br.readLine());
            int ar[][] = new int[N][N];
            for(int z = 0;z<N;++z){
                String line[] = br.readLine().split(" ");
                for(int i =0;i<N;++i){
                    ar[z][i] = Integer.parseInt(line[i]);
                }
            }
            int trace = 0;
            for(int i =0,j=0;i<N&&j<N;++i,++j){
                trace +=ar[i][j];
            }
            int row =0;
            for(int i=0;i<N;++i){
                HashSet<Integer> hs = new HashSet<>();
                for(int j=0;j<N;++j){
                    hs.add(ar[i][j]);
                }
                row = Math.max(row,N-hs.size() == 0 ? 0:N-hs.size()+1);
            }
            int col =0;
            for(int i =0;i<N;++i){
                HashSet<Integer> hs = new HashSet<>();
                for(int j=0;j<N;++j){
                    hs.add(ar[j][i]);
                }
                col = Math.max(col,N-hs.size() == 0 ? 0:N-hs.size()+1);
            }
            bw.write("Case #"+y+": "+trace+" "+row+" "+col+"\n");
        }
        bw.flush();
    }
}
