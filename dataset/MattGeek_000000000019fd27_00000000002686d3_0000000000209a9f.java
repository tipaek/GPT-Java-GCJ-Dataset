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
        byte missingP = 0;

        for(byte i=0; i<s.length(); i++){
            byte d = Byte.parseByte(s.substring(i, i+1));

            if(d > 0) {
                if(missingP == 0)
                    for (byte j = 0; j < d; j++)
                        wrapper.append('(');
                wrapper.append(d);
                if(i+2 < s.length()) {
                    byte nD = Byte.parseByte(s.substring(i + 1, i + 2));
                    if (nD > d) {
                        missingP = (byte) (nD - d);
                        for (byte j = 0; j < missingP; j++)
                            wrapper.append('(');
                        wrapper.append(nD);
                    } else if (nD < d) {
                        for (byte j = 0; j < d - nD; j++)
                            wrapper.append(')');
                        wrapper.append(nD);
                        missingP = nD;
                    } else {
                        wrapper.append(nD);
                        missingP = nD;
                    }
                    i++;
                }else{
                    missingP = d;
                }
            }else{
                if (missingP > 0)
                    for (int j = 0; j < missingP; j++)
                        wrapper.append(')');
                wrapper.append(d);
            }
        }

        if (missingP > 0)
            for (int j = 0; j < missingP; j++)
                wrapper.append(')');


        return wrapper.toString();
    }
}
