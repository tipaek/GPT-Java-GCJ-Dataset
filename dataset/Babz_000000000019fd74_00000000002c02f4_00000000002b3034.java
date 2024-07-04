import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int j = 1; j <= t; ++j) {
            int noOfPattern = in.nextInt();
            List<MyString> patterns = new ArrayList<>();
            int finalFirstPosition = -1;
            boolean multiple = false;
            for (int i = 0; i < noOfPattern; i++) {

                String pattern = in.next();
                int firstPosition = pattern.indexOf("*");
                int count = countCharacter(pattern);
                MyString myString = new MyString(pattern, count, firstPosition);
                patterns.add(myString);

                if (multiple || count > 1) {
                    multiple = true;
                }
                if (firstPosition > finalFirstPosition) {
                    finalFirstPosition = firstPosition;
                }

            }

            StringBuilder sb = new StringBuilder();
            if (multiple) {

            } else {
                if (finalFirstPosition == 0) {
                    List<MyString> patternsByLength = patterns.stream()
                            .sorted(Comparator.comparing(MyString::getLength).reversed())
                            .collect(Collectors.toList());
                    String patternToCompare = patternsByLength.get(0).getName().replace("*", "");
                    for (int i = 1; i < noOfPattern; i++) {
                        if (!iSubString(patternToCompare, patternsByLength.get(i).getName().replace("*", ""))) {
                            sb.append("*");
                            break;
                        }
                    }
                    if (!sb.toString().equals("*")) {
                        sb.append(patternToCompare);
                    }

                } else {
                    List<MyString> patternsByFirstOccurance = patterns.stream()
                            .sorted(Comparator.comparing(MyString::getFirstPosition).reversed())
                            .collect(Collectors.toList());
                    String[] array = patternsByFirstOccurance.get(0).getName().split("\\*");
                    String first = array[0];
                    String last = array.length > 1 ? array[1] : "";

                    for (int i = 1; i < noOfPattern; i++) {
                        String[] arrayTemp = patternsByFirstOccurance.get(i).getName().split("\\*");
                        String firstTemp = arrayTemp[0];
                        String lastTemp = arrayTemp.length > 1 ? arrayTemp[1] : "";

                        if (patternsByFirstOccurance.get(i).getFirstPosition() <= first.length() && !iSubString(first, firstTemp)) {
                            sb.append("*");
                            break;
                        }
                        if (last.length() > lastTemp.length() && !iSubString(lastTemp, last)) {
                            sb.append("*");
                            break;
                        } else {
                            last = lastTemp;
                        }
                    }
                    if (!sb.toString().equals("*")) {
                        sb.append(first.replace("*", ""));
                        sb.append(last.replace("*", ""));
                    }
                }
            }


            System.out.println("Case #" + j + ": " + sb.toString());
        }
        in.close();
    }

    public static boolean iSubString(String string1, String string2) {
        return string1.contains(string2);
    }

    public static int countCharacter(String pattern) {
        char someChar = '*';
        int count = 0;

        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == someChar) {
                count++;
            }
        }
        return count;
    }

}

class MyString {
    String name;
    int count;
    int firstPosition;

    public MyString(String name, int count, int firstPosition) {
        this.name = name;
        this.count = count;
        this.firstPosition = firstPosition;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getFirstPosition() {
        return firstPosition;
    }

    public int getLength() {
        return name.length();
    }

    @Override
    public String toString() {
        return "MyString{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", firstPosition=" + firstPosition +
                '}';
    }
}