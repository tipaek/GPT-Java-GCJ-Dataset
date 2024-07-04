import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    // Converts a long number to its binary representation as a string
    public static String toBinary(long n) {
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.insert(0, n % 2);
            n /= 2;
        }
        return binary.toString();
    }

    // Checks if a number is a power of two
    static boolean isPowerOfTwo(int n) {
        return (int) (Math.ceil(Math.log(n) / Math.log(2))) == (int) (Math.floor(Math.log(n) / Math.log(2)));
    }

    // Converts an integer to its binary representation as a string
    static String intToBinary(int n) {
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.append(n % 2);
            n /= 2;
        }
        return binary.toString();
    }

    // Computes the answer based on given x and y
    public static String findPath(int x, int y) {
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        boolean flag = (x != 0 && y != 0 && (y & x) == 0);
        boolean flag1 = isPowerOfTwo(absY + ~absX);
        boolean flag2 = isPowerOfTwo(~absY + absX);
        boolean flag1_1 = isPowerOfTwo(absY + 1);
        boolean flag2_1 = isPowerOfTwo(absX + 1);

        if (!(flag || (absX > 0 && absX < absY && flag1) || (absX == 0 && flag1_1) || (absY > 0 && absX > absY && flag2) || (absY == 0 && flag2_1))) {
            return "IMPOSSIBLE";
        }

        String binX = intToBinary(absX);
        String binY = intToBinary(absY);
        char[] result = new char[Math.max(binX.length(), binY.length())];

        for (int i = 0; i < result.length; i++) {
            if (flag) {
                if (i < binY.length() && binY.charAt(i) == '1') {
                    result[i] = y > 0 ? 'N' : 'S';
                } else if (i < binX.length() && binX.charAt(i) == '1') {
                    result[i] = x > 0 ? 'E' : 'W';
                }
            } else if (absX > 0 && absX < absY && flag1) {
                if (i < binX.length() && binX.charAt(i) == '1') {
                    result[i] = x > 0 ? 'E' : 'W';
                } else if (i < binY.length() && binY.charAt(i) == '1') {
                    result[i] = y > 0 ? 'S' : 'N';
                }
            } else if (absX == 0 && flag1_1) {
                result[i] = y > 0 ? 'N' : 'S';
            } else if (absY > 0 && absX > absY && flag2) {
                if (i < binY.length() && binY.charAt(i) == '1') {
                    result[i] = y > 0 ? 'N' : 'S';
                } else if (i < binX.length() && binX.charAt(i) == '1') {
                    result[i] = x > 0 ? 'W' : 'E';
                }
            } else if (absY == 0 && flag2_1) {
                result[i] = x > 0 ? 'E' : 'W';
            }
        }

        StringBuilder finalResult = new StringBuilder();
        for (char c : result) {
            finalResult.append(c);
        }

        if (flag || (absX == 0 && flag1_1) || (absY == 0 && flag2_1)) {
            return finalResult.toString();
        }
        if (absX > 0 && absX < absY && flag1) {
            return finalResult.append(y > 0 ? 'N' : 'S').toString();
        }
        return finalResult.append(x > 0 ? 'E' : 'W').toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().split(" ")[0]);

        for (int i = 1; i <= testCases; i++) {
            String[] input = reader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String result = findPath(x, y);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}