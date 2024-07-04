import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int total = t;

        while (t-- > 0) {
            int n = in.nextInt();
            String[] arr = new String[n];
            String[] start = new String[n];
            String[] end = new String[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.next();
                start[i] = extractStart(arr[i]);
                end[i] = extractEnd(arr[i]);
            }

            String startString = assembleStartString(start);
            if (startString.equals("*")) {
                System.out.println("Case #" + (total - t) + ": " + "*");
            } else {
                String endString = assembleEndString(end);
                if (endString.equals("*")) {
                    System.out.println("Case #" + (total - t) + ": " + "*");
                } else {
                    StringBuilder mainString = new StringBuilder();
                    for (String s : arr) {
                        int startCounter = s.indexOf('*');
                        int endCounter = s.lastIndexOf('*');
                        if (s.split("\\*").length > 2) {
                            for (int j = startCounter + 1; j < endCounter; j++) {
                                if (s.charAt(j) != '*') {
                                    mainString.append(s.charAt(j));
                                }
                            }
                        }
                    }
                    if (startString.isEmpty() && endString.isEmpty() && mainString.toString().isEmpty()) {
                        System.out.println("Case #" + (total - t) + ": " + "*");
                    } else {
                        System.out.println("Case #" + (total - t) + ": " + startString + mainString + endString);
                    }
                }
            }
        }
    }

    private static String assembleEndString(String[] end) {
        String overall = "";
        int maxLength = 0;

        for (String s : end) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                overall = s;
            }
        }

        for (String s : end) {
            for (int j = 0; j < s.length(); j++) {
                if (overall.charAt(j) != s.charAt(j)) {
                    return "*";
                }
            }
        }

        return new StringBuilder(overall).reverse().toString();
    }

    private static String assembleStartString(String[] start) {
        String overall = "";
        int maxLength = 0;

        for (String s : start) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                overall = s;
            }
        }

        for (String s : start) {
            for (int j = 0; j < s.length(); j++) {
                if (overall.charAt(j) != s.charAt(j)) {
                    return "*";
                }
            }
        }
        return overall;
    }

    public static String extractStart(String s) {
        int index = s.indexOf('*');
        return (index == -1) ? s : s.substring(0, index);
    }

    public static String extractEnd(String s) {
        int index = s.lastIndexOf('*');
        return (index == -1) ? "" : new StringBuilder(s.substring(index + 1)).reverse().toString();
    }
}