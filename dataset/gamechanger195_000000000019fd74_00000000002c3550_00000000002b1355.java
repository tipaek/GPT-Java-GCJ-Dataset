import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class Solution {
    static int n,m;
    public static boolean check(int x,int y){
        if(x>=0 && x<n && y>=0 && y<m)
            return true;
        return false;

    }
    public static void main(String args[]) throws IOException {
        FastReader in = new FastReader(System.in);
        StringBuilder sb = new StringBuilder();
        int i, j;
        int t0 = 0;
        int t = in.nextInt();
        while (t0++ < t) {
            n = in.nextInt();
            m=in.nextInt();
            int arr[][]=new int[n][m];
            boolean visit[][]=new boolean[n][m];
            int pos[][]={{-1,0},{1,0},{0,1},{0,-1}};
            for(i=0;i<n;i++){
                for(j=0;j<m;j++){
                    arr[i][j]=in.nextInt();
                }
                Arrays.fill(visit[i],true);
            }
            long ans=0;
            while(true){
                long sum=0;
               for(i=0;i<n;i++){
                   for(j=0;j<m;j++){
                       if(visit[i][j])
                           sum+=arr[i][j];


                   }
               }
               ans+=sum;
               int death=0;
               boolean temp[][]=new boolean[n][m];
               for(i=0;i<n;i++){
                   for(j=0;j<m;j++)
                       temp[i][j]=visit[i][j];
               }
               for(i=0;i<n;i++){
                   for(j=0;j<m;j++){
                        long val=0,count=0;
                        if(temp[i][j]) {
                            for (int k = 0; k < 4; k++) {
                                int a = i, b = j;
                                while (true) {
                                    a = a + pos[k][0];
                                    b = b + pos[k][1];
                                    if (!check(a, b))
                                        break;
                                    else if (temp[a][b]) {
                                        val += arr[a][b];
                                        count++;
                                        break;
                                    }
                                }
                            }
                            if(count==0)
                                continue;
                            long div=val/count;
                            long rem=val%count;
                            if(arr[i][j]<div || (arr[i][j]==div && rem>0)){
                                death++;
                                visit[i][j]=false;
                            }
                        }
                   }
               }
               if (death==0)
                   break;

            }
            sb.append("Case #"+t0+": "+ans).append("\n");


        }
        System.out.print(sb);


    }
}

class FastReader {

    byte[] buf = new byte[2048];
    int index, total;
    InputStream in;

    FastReader(InputStream is) {
        in = is;
    }

    int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0) {
                return -1;
            }
        }
        return buf[index++];
    }

    String next() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c > 32; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }

    int nextInt() throws IOException {
        int c, val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }

    long nextLong() throws IOException {
        int c;
        long val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }
}
