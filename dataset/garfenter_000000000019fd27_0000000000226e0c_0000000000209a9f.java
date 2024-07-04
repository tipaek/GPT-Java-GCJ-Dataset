import java.util.*;
import java.io.*;

/**
 *
 * @author Garfenter
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        in.nextLine();
        for (int c = 1; c <= cases; ++c) {
            String line = in.nextLine();
            String queue = "";
            String result = "";
            int lastNumber = 0;
            for (char character : line.toCharArray()) {
                int number = Character.getNumericValue(character);
                if (number > lastNumber) {
                    for (int i = lastNumber; i < number; i++) {
                        queue += "(";
                    }
                    queue += number;
                } else if (number == lastNumber) {
                    queue += number;
                } else {
                    for (int i = 0; i < lastNumber - number; i++) {
                        queue += ")";
                    }
                    queue += number;
                }
                lastNumber = number;

            }
            for (int i = 0; i < lastNumber; i++) {
                queue += ")";
            }
            System.out.println("Case #" + c + ": " + result + queue);
        }
    }
}
