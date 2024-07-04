import java.io.*;
import java.lang.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        for(int t=1;t<=T;t++){
            int N=Integer.parseInt(br.readLine());
            int[][] arr=new int[N][N];
            for(int i=0;i<N;i++){
                StringTokenizer st=new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++) arr[i][j]=Integer.parseInt(st.nextToken());
            }
            int trace=0;
            for(int i=0;i<N;i++) trace+=arr[i][i];
            int row=0;
            int col=0;
            int target=N*(N+1)/2;
            for(int i=0;i<N;i++){
                int[] f=new int[N];
                boolean flag=true;
                for(int j=0;j<N;j++) {
                    f[arr[i][j]-1]++;
                    if(f[arr[i][j]-1]>1){
                        flag=false;
                        break;
                    }
                }
                if(!flag) row++;
            }
            for(int i=0;i<N;i++){
                int[] f=new int[N];
                boolean flag=true;
                for(int j=0;j<N;j++) {
                    f[arr[j][i]-1]++;
                    if(f[arr[j][i]-1]>1){
                        flag=false;
                        break;
                    }
                }
                if(!flag) col++;
            }
            sb.append("Case #"+t+": "+trace+" "+row+" "+col+"\n");
        }
        System.out.print(sb);
    }
}