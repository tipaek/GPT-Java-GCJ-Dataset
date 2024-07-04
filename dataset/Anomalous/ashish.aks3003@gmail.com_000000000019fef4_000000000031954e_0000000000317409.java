import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputReader scanner = new InputReader(inputStream);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();
            int result = -1;
            
            for (int j = 0; j < directions.length(); j++) {
                char direction = directions.charAt(j);
                switch (direction) {
                    case 'S':
                        y--;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'E':
                        x++;
                        break;
                }
                
                int time = Math.abs(x) + Math.abs(y);
                if (time <= (j + 1)) {
                    result = j + 1;
                    break;
                }
            }
            
            if (result == -1) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }
    
    static class InputReader {
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;
        
        public InputReader(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }
        
        String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}