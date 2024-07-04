import java.io.*;
import java.util.Arrays;
class Solution{
    public static void main(String []arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<=T;t++){
            int n = Integer.parseInt(br.readLine());
            int [][] a = new int[n][3];
            for(int i=0;i<n;i++){
                String []s = br.readLine().split(" ");
                a[i][0] = i;
                a[i][1] = Integer.parseInt(s[0]);
                a[i][2] = Integer.parseInt(s[1]);
            }
            Arrays.sort(a, (b,c) -> b[1] != c[1] ? b[1] - c[1] : b[2] - c[2]);
            char []c = new char[n];
            c[a[0][0]] = 'C';
            int cEnd = a[0][2];
            int jEnd = -1;
            boolean flag = true;
            for(int i=1;i<n;i++){
                if(a[i][1] >= cEnd){
                    c[a[i][0]] = 'C';
                    cEnd = a[i][2];
                }else if(jEnd == -1 || a[i][1] >= jEnd){
                    c[a[i][0]] = 'J';
                    jEnd = a[i][2];
                }else{
                    flag = false;
                    break;
                }
            }
            String ans = "";
            if(flag){
                ans = new String(c);
            }else{
                ans = "IMPOSSIBLE";
            }
            System.out.println("Case #" + t + ": " + ans);
        }
    }
}