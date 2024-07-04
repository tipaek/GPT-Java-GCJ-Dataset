import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= t; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            String s = tokenizer.nextToken();
            int time = -1;
            
            for (int j = 0; j < s.length(); j++) {
                char direction = s.charAt(j);
                switch (direction) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
                
                if (Math.abs(x) + Math.abs(y) <= j + 1) {
                    time = j + 1;
                    break;
                }
            }
            
            if (time == -1) {
                System.out.println("Case " + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case " + i + ": " + time);
            }
        }
    }
}