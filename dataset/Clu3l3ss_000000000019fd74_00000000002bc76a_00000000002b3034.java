import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.print("Case #" + (i + 1) + ": ");
            String[] words = new String[N];
            for (int j = 0; j < N; j++) {
                words[j] = br.readLine().substring(1);
            }
            String biggest = words[0];
            for (int j = 1; j < N; j++) {
                if(words[j].length() == biggest.length()) {
                    if(!words[j].equals(biggest)) {
                        break;
                    }
                }
                else if(words[j].length() > biggest.length()) {
                    biggest = words[j];
                }
            }
            boolean flag = true;
            for (int j = 0; j < N; j++) {
                if(biggest.contains(words[j])) {
                    continue;
                }
                else {
                    System.out.println("*");
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.println(biggest);
        }

    }
}
