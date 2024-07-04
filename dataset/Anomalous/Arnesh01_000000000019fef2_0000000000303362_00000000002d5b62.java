import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    
    public static long mod(long a, long b) {
        long result = a % b;
        if (result < 0) {
            result += b;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();
        
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            String[] inputs = reader.readLine().split(" ");
            long X = Long.parseLong(inputs[0]);
            long Y = Long.parseLong(inputs[1]);
            StringBuilder path = new StringBuilder();
            long power = 1;
            
            while (X != 0 || Y != 0) {
                power *= 2;
                long halfPower = power / 2;
                if (mod(X, power) == mod(Y, power)) {
                    path.setLength(0); // Clear the path
                    path.append("IMPOSSIBLE");
                    break;
                } else {
                    if (mod(X, power) == halfPower) {
                        if (Y == 0 && (X == halfPower || X + halfPower == 0)) {
                            path.append(X == halfPower ? 'E' : 'W');
                            break;
                        }
                        if (mod(X - halfPower, 2 * power) != mod(Y, 2 * power)) {
                            path.append('E');
                            X -= halfPower;
                        } else {
                            path.append('W');
                            X += halfPower;
                        }
                    } else {
                        if (X == 0 && (Y == halfPower || Y + halfPower == 0)) {
                            path.append(Y == halfPower ? 'N' : 'S');
                            break;
                        }
                        if (mod(X, 2 * power) != mod(Y - halfPower, 2 * power)) {
                            path.append('N');
                            Y -= halfPower;
                        } else {
                            path.append('S');
                            Y += halfPower;
                        }
                    }
                }
            }
            output.append("Case #").append(testCase).append(": ").append(path).append("\n");
        }
        System.out.print(output);
    }
}