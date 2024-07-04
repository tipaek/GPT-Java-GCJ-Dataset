import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int x = 0; x < t; x++) {
            String input = scanner.next();
            String[] segments = input.split("0");

            for (int j = 0; j < segments.length; j++) {
                if (segments[j].length() > 0) {
                    segments[j] = "(" + segments[j] + ")";

                    for (char digit = '2'; digit <= '9'; digit++) {
                        int index = segments[j].indexOf(digit);
                        if (index > -1) {
                            int leftIndex = index;
                            int rightIndex = index;

                            while ((leftIndex > 0 && segments[j].charAt(leftIndex - 1) > digit && segments[j].charAt(leftIndex - 1) >= '2' && segments[j].charAt(leftIndex - 1) <= '9') ||
                                   (rightIndex < segments[j].length() - 1 && segments[j].charAt(rightIndex + 1) > digit && segments[j].charAt(rightIndex + 1) >= '2' && segments[j].charAt(rightIndex + 1) <= '9')) {
                                if (leftIndex > 0 && segments[j].charAt(leftIndex - 1) > digit) {
                                    leftIndex--;
                                } else {
                                    rightIndex++;
                                }
                            }

                            segments[j] = segments[j].substring(0, leftIndex) + "(" + segments[j].substring(leftIndex, rightIndex + 1) + ")" + segments[j].substring(rightIndex + 1);
                        }
                    }
                }
            }

            StringBuilder output = new StringBuilder();
            for (String segment : segments) {
                if (segment.length() == 0) {
                    output.append("0");
                } else {
                    output.append(segment);
                }
            }

            System.out.println("Case #" + (x + 1) + ": " + output);
        }
    }
}