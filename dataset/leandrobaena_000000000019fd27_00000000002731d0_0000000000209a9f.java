import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner in = new Scanner(new BufferedReader(new FileReader("b.in")));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String line = in.nextLine();
        int numCases = Integer.parseInt(line);

        for (int i = 0; i < numCases; i++) {
            line = in.nextLine();
            int currentDeep = 0;
            String result = "";
            for (int j = 0; j < line.length(); j++) {
                int number = Integer.parseInt("" + line.charAt(j));
                while(number != currentDeep){
                    if(number > currentDeep){
                        result += "(";
                        currentDeep++;
                    }
                    else {
                        result += ")";
                        currentDeep--;
                    }
                }
                result += number;
            }
            while(currentDeep > 0){
                result += ")";
                currentDeep--;
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}
