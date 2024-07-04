import java.util.Scanner;

/**
 * @author Mattia D'ambrosio
 * Created on 04/04/2020.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte tests = scanner.nextByte();
        scanner.nextLine();

        for (byte i=1; i<=tests ; i++) {
            String s = scanner.nextLine();
            String out = wrapDigits(s);
            System.out.println("Case #"+i+": "+out);
        }
    }

    private static String wrapDigits(String s){
        StringBuilder wrapper = new StringBuilder();

        for(byte i=0; i<s.length(); i++){
            byte d = Byte.parseByte(s.substring(i, i+1));
            for (byte j = 0; j < d; j++)
                wrapper.append('(');
            wrapper.append(d);
            for (int j = 0; j < d ; j++)
                wrapper.append(')');
        }

        return wrapper.toString();
    }
}
