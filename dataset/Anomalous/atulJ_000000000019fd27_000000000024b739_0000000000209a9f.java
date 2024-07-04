import java.io.*;
import java.util.*;

public class News {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int x = 0; x < t; x++) {
            String s = scanner.next();
            String[] segments = s.split("0");

            for (int j = 0; j < segments.length; j++) {
                if (segments[j].length() > 0) {
                    segments[j] = "(" + segments[j] + ")";
                    for (int i = 50; i < 58; i++) {
                        String digit = Character.toString((char) i);
                        if (segments[j].contains(digit)) {
                            int leftIndex = segments[j].indexOf(digit);
                            int rightIndex = leftIndex;
                            int currentIndex = leftIndex;

                            while ((leftIndex > 0 && segments[j].charAt(leftIndex - 1) > segments[j].charAt(currentIndex) &&
                                    segments[j].charAt(leftIndex - 1) >= '2' && segments[j].charAt(leftIndex - 1) <= '9') ||
                                   (rightIndex < segments[j].length() - 1 && segments[j].charAt(rightIndex + 1) > segments[j].charAt(currentIndex) &&
                                    segments[j].charAt(rightIndex + 1) >= '2' && segments[j].charAt(rightIndex + 1) <= '9')) {
                                if (leftIndex > 0 && segments[j].charAt(leftIndex - 1) > segments[j].charAt(currentIndex)) {
                                    leftIndex--;
                                } else {
                                    rightIndex++;
                                }
                            }

                            segments[j] = s.substring(0, leftIndex) + "(" + s.substring(leftIndex, rightIndex + 1) + ")" + s.substring(rightIndex + 1);
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