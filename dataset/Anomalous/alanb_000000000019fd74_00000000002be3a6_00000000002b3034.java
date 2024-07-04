import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    static Scanner scanner;

    public static void main(String[] args) throws FileNotFoundException {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] patterns = new String[n];
            String[] begins = new String[n];
            String[] ends = new String[n];
            String[] mids = new String[n];

            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.nextLine();
                begins[i] = patterns[i].substring(0, patterns[i].indexOf("*"));
                ends[i] = new StringBuilder(patterns[i].substring(patterns[i].lastIndexOf("*") + 1)).reverse().toString();
                mids[i] = patterns[i].substring(patterns[i].indexOf("*") + 1, patterns[i].lastIndexOf("*")).replace("*", "");
            }

            boolean fail = false;
            ArrayList<Character> beginningList = new ArrayList<>();
            for (String s : begins) {
                if (fail) break;
                char[] arr = s.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    if (i >= beginningList.size()) {
                        beginningList.add(arr[i]);
                    } else if (beginningList.get(i) != arr[i]) {
                        fail = true;
                        break;
                    }
                }
            }

            StringBuilder beginning = new StringBuilder();
            for (char c : beginningList) {
                beginning.append(c);
            }

            ArrayList<Character> endingList = new ArrayList<>();
            for (String s : ends) {
                if (fail) break;
                char[] arr = s.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    if (i >= endingList.size()) {
                        endingList.add(arr[i]);
                    } else if (endingList.get(i) != arr[i]) {
                        fail = true;
                        break;
                    }
                }
            }

            StringBuilder ending = new StringBuilder();
            for (int i = endingList.size() - 1; i >= 0; i--) {
                ending.append(endingList.get(i));
            }

            StringBuilder output = new StringBuilder(beginning);
            for (String s : mids) {
                output.append(s);
            }
            output.append(ending);

            if (fail || output.length() > 10000) {
                System.out.println("Case #" + (t + 1) + ": *");
            } else {
                System.out.println("Case #" + (t + 1) + ": " + output);
            }
        }
        scanner.close();
    }
}