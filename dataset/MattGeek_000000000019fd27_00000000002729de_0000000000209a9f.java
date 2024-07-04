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
            String out = getSolution(s);
            System.out.println("Case #"+i+": "+out);
        }
    }

    private static String getSolution(String s){
        byte[] digits = new byte[s.length()];

        for (byte i = 0; i < s.length(); i++)
            digits[i] = Byte.parseByte(s.substring(i, i+1));

        return wrapDigits(s, digits, (byte) 0, (byte)digits.length);
    }

    private static String wrapDigits(String s, byte[] d, byte start, byte end){
        StringBuilder wrapper = new StringBuilder();
        byte i = start;
        byte j;

        while(i < end){
            if(d[i] > 0) {
                d[i]--;
                for (j = (byte) (i + 1); j < end && d[j] > 0; j++)
                    d[j]--;
                wrapper.append('(').append(wrapDigits(s, d, i, j)).append(')');
                i = j;
            }
            else {
                wrapper.append(s.charAt(i));
                i++;
            }
        }

        return wrapper.toString();
    }
}
