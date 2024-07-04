import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static final BufferedReader reader = submission();

    private static BufferedReader submission() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static BufferedReader playGround() {
        try {
            return new BufferedReader(new FileReader("C:/temp/codejam/testInput.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Wrong File path", e);
        }
    }

    private static String formatResult(int caseId, String result) {
        return "Case #" + caseId + ": " + result;
    }

    public static void main(String... args) throws IOException {
        String[] mainEntry = reader.readLine().split(" ");
        int T = Integer.parseInt(mainEntry[0]);
        for (int i = 0; i < T; i++) {
            mainLoop(i + 1, reader, mainEntry);
        }
    }

    private static void mainLoop(int caseId, BufferedReader reader, String[] globalEntry) throws IOException {
        String[] coordinate = reader.readLine().split(" ");
        int x = Integer.parseInt(coordinate[0]);
        int y = Integer.parseInt(coordinate[1]);
        String directionsX = x > 0 ? "EW" : "WE";
        String directionsY = y > 0 ? "NS" : "SN";
        if (Math.abs(x % 2) == 1) {
            if (Math.abs(y % 2) == 1) {
                System.out.println(
                      formatResult(caseId, "IMPOSSIBLE")
                );
                return;
            }
            System.out.println(
                  formatResult(caseId, findPath((directionsX + directionsY).toCharArray(), Math.abs(x), Math.abs(y)))
            );
        } else {
            if (Math.abs(y % 2) == 0) {
                System.out.println(
                      formatResult(caseId, "IMPOSSIBLE")
                );
                return;
            }
            System.out.println(
                  formatResult(caseId, findPath((directionsY + directionsX).toCharArray(), Math.abs(y), Math.abs(x)))
            );
        }
    }

    private static String findPath(char[] direction, int odd, int even) {
        String evenBinary = Integer.toBinaryString(even);
        String candidate = Integer.toBinaryString(odd + 1);
        String result = generatePath(direction, candidate.toCharArray(), evenBinary.toCharArray());
        if (result.equals("IMPOSSIBLE")) {
            candidate = Integer.toBinaryString(odd - 1);
            result = generatePath(direction, candidate.toCharArray(), evenBinary.toCharArray());
            result = result.equals("IMPOSSIBLE") ? result : direction[0] + result;
        } else {
            result = direction[1] + result;
        }
        return result;
    }

    private static String generatePath(char[] direction, char[] firstCandidate, char[] evenBinary) {
        StringBuilder result = new StringBuilder(direction[0]);
        int i = 2;
        while (firstCandidate.length - i >= 0 || evenBinary.length - i >= 0) {
            char c1 = firstCandidate.length - i >= 0 ? firstCandidate[firstCandidate.length - i] : '0';
            char c2 = evenBinary.length - i >= 0 ? evenBinary[evenBinary.length - i] : '0';
            if (c1 == '1' && c2 == '0') {
                result.append(direction[0]);
            } else if (c1 == '0' && c2 == '1') {
                result.append(direction[2]);
            } else if (c1 == '0' && c2 == '0') {
                if (firstCandidate.length - i > 0 || evenBinary.length - i > 0) {
                    i++;
                    c1 = firstCandidate.length - i >= 0 ? firstCandidate[firstCandidate.length - i] : '0';
                    c2 = evenBinary.length - i >= 0 ? evenBinary[evenBinary.length - i] : '0';
                    if (c1 == '1' || c2 == '1') {
                        return "IMPOSSIBLE";
                    }
                    if (firstCandidate.length - i > 0) {
                        result.append(direction[1]).append(direction[0]);
                    } else {
                        result.append(direction[3]).append(direction[2]);
                    }
                } else {
                    return "IMPOSSIBLE";
                }
            } else {
                return "IMPOSSIBLE";
            }
            i++;
        }
        return result.toString();
    }
}
