import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static int max = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tt=0;tt<t;tt++) {
            int n = Integer.parseInt(br.readLine());
            int ans[] = new int[10];
            Arrays.fill(ans, Integer.MAX_VALUE);
            for (int i = 0; i < max; i++) {
                String st[] = br.readLine().split(" ");
                String val = st[0];
                String s = st[1];
                if(val.length()==1 && Integer.parseInt(val)!=-1){
                    int index=Integer.parseInt(val);
                    int mapping=s.charAt(0)-65;
                    ans[index]=Math.min(index,mapping);
                }
            }
            boolean vis[]=new boolean[26];
            for(int i=0;i<10;i++){
                int index=ans[i];
                if(index!=Integer.MAX_VALUE)
                    vis[index]=true;
            }
            int j=0;
            while (vis[j]){
                j++;
            }
            for(int i=0;i<10;i++){
                if(ans[i]==Integer.MAX_VALUE){
                    ans[i]=j;
                    vis[j]=true;
                    while (vis[j]){
                        j++;
                    }
                }else
                    continue;
            }

            StringBuilder sb=new StringBuilder("");
            for(int i=0;i<10;i++){
                char c= (char) (ans[i]+65);
                sb.append(c);
            }
            System.out.println("Case #"+t+": "+sb);
        }
    }
}
