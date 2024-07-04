import java.util.*;

/**
 * For Google Code Jam 2020: Round 1A
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> output = new ArrayList<>();
        int t = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String start = "";
            String end = "";
            StringBuilder middle = new StringBuilder();
            boolean stop = false;

            for (int j = 0; j < n; j++) {
                String pattern = scanner.nextLine();
                if (!stop && !pattern.isEmpty() && !(pattern.length() == 1 && pattern.charAt(0) == '*')) {
                    String[] parts = pattern.split("\\*");
                    boolean isStartElement = pattern.charAt(0) != '*';
                    boolean isEndElement = pattern.charAt(pattern.length() - 1) != '*';

                    for (int k = 0; k < parts.length; k++) {
                        if (k == 0 && isStartElement) {
                            start = processPrefix(start, parts[0]);
                            if (start.equals("*")) {
                                stop = true;
                                output.add("*");
                                break;
                            }
                        } else if (k == parts.length - 1 && isEndElement) {
                            end = processSuffix(end, parts[parts.length - 1]);
                            if (end.equals("*")) {
                                stop = true;
                                output.add("*");
                                break;
                            }
                        } else {
                            middle.append(parts[k]);
                        }
                    }
                }
            }

            if (!stop) {
                if (start.length() + end.length() + middle.length() < 10000) {
                    output.add(start + middle + end);
                } else {
                    output.add("*");
                }
            }
        }

        for (int i = 0; i < output.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + output.get(i));
        }

        scanner.close();
    }

    private static String processPrefix(String prefix, String element) {
        if (prefix.length() == element.length()) {
            return prefix.equals(element) ? prefix : "*";
        } else if (prefix.length() < element.length()) {
            return element.startsWith(prefix) ? element : "*";
        } else {
            return prefix.startsWith(element) ? prefix : "*";
        }
    }

    private static String processSuffix(String suffix, String element) {
        if (suffix.length() == element.length()) {
            return suffix.equals(element) ? suffix : "*";
        } else if (suffix.length() < element.length()) {
            return element.endsWith(suffix) ? element : "*";
        } else {
            return suffix.endsWith(element) ? suffix : "*";
        }
    }
}