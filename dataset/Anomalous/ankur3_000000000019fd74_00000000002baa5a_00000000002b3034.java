import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            String[] arr = new String[n];
            String[] start = new String[n];
            String[] end = new String[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.next();
                start[i] = getStart(arr[i]);
                end[i] = getEnd(arr[i]);
            }

            String startString = getStartString(start);
            if (startString.equals("*")) {
                System.out.println("*");
                continue;
            }

            String endString = getEndString(end);
            if (endString.equals("*")) {
                System.out.println("*");
                continue;
            }

            StringBuilder mainString = new StringBuilder();
            for (String s : arr) {
                int startCounter = s.indexOf('*');
                int endCounter = s.lastIndexOf('*');
                if (startCounter != -1 && endCounter != -1 && startCounter != endCounter) {
                    mainString.append(s, startCounter + 1, endCounter);
                }
            }

            System.out.println(startString + mainString + endString);
        }
    }

    private static String getEndString(String[] end) {
        String longest = "";
        for (String s : end) {
            if (s.length() > longest.length()) {
                longest = s;
            }
        }

        for (String s : end) {
            if (!longest.endsWith(s)) {
                return "*";
            }
        }

        return new StringBuilder(longest).reverse().toString();
    }

    private static String getStartString(String[] start) {
        String longest = "";
        for (String s : start) {
            if (s.length() > longest.length()) {
                longest = s;
            }
        }

        for (String s : start) {
            if (!longest.startsWith(s)) {
                return "*";
            }
        }

        return longest;
    }

    private static String getStart(String s) {
        int index = s.indexOf('*');
        return index == -1 ? s : s.substring(0, index);
    }

    private static String getEnd(String s) {
        int index = s.lastIndexOf('*');
        return index == -1 ? "" : s.substring(index + 1);
    }
}