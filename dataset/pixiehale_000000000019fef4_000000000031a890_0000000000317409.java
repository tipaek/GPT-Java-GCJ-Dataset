import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str[] = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            String m = str[2];
            int n = m.length();
            sb.append("Case #").append(i+1).append(": ");
            if (x==0&&y==0){
                sb.append(0).append("\n");
                continue;
            }
            boolean found = false;
            for (int j = 0; j < n; j++) {
                switch (m.charAt(j)){
                    case 'N': y++; break;
                    case 'S': y--; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }
                if (Math.abs(x)+Math.abs(y)<=j+1){
                    sb.append(j+1).append("\n");
                    found=true;
                    break;
                }
            }
            if (!found)
                sb.append("IMPOSSIBLE").append("\n");
        }
        System.out.println(sb);
    }
}
