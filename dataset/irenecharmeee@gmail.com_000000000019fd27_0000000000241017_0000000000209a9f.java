import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int T = Integer.parseInt(input);
        for (int i = 0; i < T; i++) {
            String curr = reader.readLine();
            String result = "";
            String temp = "(";
            for(int k = 0; k < curr.length(); k++) {
                //if 0 is found, just attach it to the result
                if (curr.charAt(k) == '0'){
                    //if temp is open, close it.
                    if (temp.length() > 1){
                        temp += ")";
                        result += temp;
                        temp = "(";
                    }
                    result+= "0";

                } else {
                    temp += "1";
                }
            }

            if (temp.length() > 1){
                result += temp + ")";
            }

            System.out.printf("Case #%d: %s\n", (i+1), result);
        }
    }
}
