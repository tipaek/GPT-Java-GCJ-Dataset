import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            String s = reverse(br.readLine().substring(1));
            String aux, tmp;
            boolean possible = true;

            for(int i=1; i <N; i++) {
                aux = reverse(br.readLine().substring(1));
                if(s.length() < aux.length()) {
                    tmp = aux;
                    aux = s;
                    s = tmp;
                }
                if(!s.startsWith(aux)) {
                    possible = false;
                }
            }

            System.out.print("Case #" + t + ": ");
            if(possible) {
                System.out.println(reverse(s));
            } else {
                System.out.println("*");
            }
        }
    }

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }
        return new String(sb);
    }
}