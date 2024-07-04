import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte t = input.nextByte();
        
        for (byte x = 1; x <= t; x++) {
            boolean possible = true;
            short n = input.nextShort();
            short[][] activities = new short[n][3];
            
            for (short i = 0; i < n; i++) {
                short start = input.nextShort();
                short end = input.nextShort();
                
                if (possible) {
                    if (isFree((short) 1, start, end, activities)) {
                        activities[i][0] = 1;
                        activities[i][1] = start;
                        activities[i][2] = end;
                    } else if (isFree((short) 2, start, end, activities)) {
                        activities[i][0] = 2;
                        activities[i][1] = start;
                        activities[i][2] = end;
                    } else {
                        possible = false;
                    }
                }
            }
            
            if (possible) {
                StringBuilder result = new StringBuilder();
                for (short i = 0; i < n; i++) {
                    if (activities[i][0] == 1) {
                        result.append('J');
                    } else {
                        result.append('C');
                    }
                }
                System.out.println("Case #" + x + ": " + result);
            } else {
                System.out.println("Case #" + x + ": IMPOSSIBLE");
            }
        }
        
        input.close();
    }

    public static boolean isFree(short who, short start, short end, short[][] activities) {
        for (short[] activity : activities) {
            if (activity[0] == 0) {
                break;
            }
            if (activity[0] == who) {
                if ((start > activity[1] && start < activity[2]) || (end > activity[1] && end < activity[2])) {
                    return false;
                }
            }
        }
        return true;
    }
}