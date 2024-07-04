import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte t = input.nextByte();
        
        for (byte x = 1; x <= t; x++) {
            boolean possible = true;
            short n = input.nextShort();
            short[][] arr = new short[n][3];
            
            for (short i = 0; i < n; i++) {
                short s = input.nextShort();
                short e = input.nextShort();
                
                if (possible) {
                    if (isFree((short) 1, s, e, arr)) {
                        arr[i][0] = 1;
                        arr[i][1] = s;
                        arr[i][2] = e;
                    } else if (isFree((short) 2, s, e, arr)) {
                        arr[i][0] = 2;
                        arr[i][1] = s;
                        arr[i][2] = e;
                    } else {
                        possible = false;
                    }
                }
            }
            
            if (possible) {
                StringBuilder result = new StringBuilder();
                for (short i = 0; i < n; i++) {
                    result.append(arr[i][0] == 1 ? 'J' : 'C');
                }
                System.out.println("Case #" + x + ": " + result.toString());
            } else {
                System.out.println("Case #" + x + ": IMPOSSIBLE");
            }
        }
        
        input.close();
    }

    public static boolean isFree(short who, short s, short e, short[][] arr) {
        for (short[] activity : arr) {
            if (activity[0] == 0) {
                break;
            }
            if (activity[0] == who) {
                if ((s > activity[1] && s < activity[2]) || (e > activity[1] && e < activity[2])) {
                    return false;
                }
            }
        }
        return true;
    }
}