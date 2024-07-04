import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        boolean DEBUG = false;

        InputStream is = DEBUG ? new FileInputStream("test1.in") : System.in;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));

        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            String line = in.next();

            String result = "";
            String prevChar = "";
            for (int j=0;j<line.length();j++){
                String currentChar = line.substring(j,j+1);
                if (j==0){
                    result = addChars(result, "(", Integer.parseInt(currentChar)) + currentChar;
                } else if (Integer.parseInt(currentChar) == Integer.parseInt(prevChar)){
                    result = result + currentChar;
                } else if (Integer.parseInt(currentChar) < Integer.parseInt(prevChar)){
                    result = addChars(result, ")", (Integer.parseInt(prevChar)-Integer.parseInt(currentChar))) + currentChar;
                } else if (Integer.parseInt(currentChar) > Integer.parseInt(prevChar)){
                    result = addChars(result, "(", (Integer.parseInt(currentChar)-Integer.parseInt(prevChar))) + currentChar;
                }
                prevChar = currentChar;
            }
            result = addChars(result, ")", Integer.parseInt(prevChar));
            System.out.println("Case #" + i + ": " + result);
        }

        in.close();
    }

    private static String addChars(String str, String charInput, int counter){
        for (int i=0;i<counter;i++){
            str = str + charInput;
        }
        return str;
    }
}