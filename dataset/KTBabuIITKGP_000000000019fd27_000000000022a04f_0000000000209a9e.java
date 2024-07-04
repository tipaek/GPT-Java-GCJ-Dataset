import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = reader.readLine().trim().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        for (int t=1; t<T; t++){
            StringBuilder s = new StringBuilder();
            int count = 1;
            int position = 1;
            while (position <= B){
                writer.write(position);
                char c = (char)reader.read();
                if (count%10 != 1){
                    s.append(c);
                    position++;
                }
                count++;
            }
            writer.write(s.toString());
            char ans = (char) reader.read();
            if (ans == 'N'){
                break;
            }
        }

        reader.close();
        writer.close();
    }
}