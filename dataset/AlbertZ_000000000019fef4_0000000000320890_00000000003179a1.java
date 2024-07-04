import java.io.*;
import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    long mod = 1000000000;
    double[] logFac;
    double ln2 = Math.log(2);
    public static void main(String[] args)throws IOException {
//        String[] buf = reader.readLine().split(" ");
//        int T = Integer.parseInt(buf[0]);
        Solution sl = new Solution();
        int T = sc.nextInt();
        for(int i=1;i<=T;i++){
            out.print(String.format("Case #%d: ",i));
            out.println(sl.solve());
        }
        out.flush();
        System.exit(0);
    }
    String solve() {
        int u = sc.nextInt();
        int[] cnt = new int[26], res = new int[26];
        boolean[] vis = new boolean[26];
        for(int i=0;i<10000;i++){
            long m = sc.nextLong();
            char[] arr = sc.next().toCharArray();
            for(char c:arr){
                cnt[c-'A']++;
            }
            res[arr[0]-'A']++;
            vis[arr[0]-'A'] = true;
        }
        ArrayList<int[]> list = new ArrayList<>();
        char zero = ' ';
        for(int i=0;i<26;i++){
            if(cnt[i]==0) continue;
            if(!vis[i]) zero = (char)(i+'A');
            else{
                list.add(new int[]{i,res[i]});
            }
        }
        Collections.sort(list,(o1,o2)->(o2[1]-o1[1]));
        StringBuilder sb = new StringBuilder();
        sb.append(zero);
        for(int[] num:list){
            char cur = (char)(num[0]+'A');
            sb.append(cur);
        }
        return sb.toString();
    }
}
