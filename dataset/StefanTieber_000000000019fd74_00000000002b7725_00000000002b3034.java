import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String line;
            String[] parts;

            line = reader.readLine();
            int numberOfSets = Integer.parseInt(line);

            for (int i = 0; i < numberOfSets; i++) {
                line = reader.readLine();
                parts = line.split("\\s+");
                int numberOfLines = Integer.parseInt(parts[0]);

                List<Name> names = new ArrayList<>();

                for (int j = 0; j < numberOfLines; j++) {
                    names.add(new Name(reader.readLine()));
                }

                String solution = solve(names);

                System.out.println("Case #" + (i + 1) + ": " + solution);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String solve(List<Name> names) {
        char[] begin = new char[100];
        IntStream.range(0, begin.length).forEach(i -> begin[i] = 0);

        char[] end = new char[100];
        IntStream.range(0, end.length).forEach(i -> end[i] = 0);
        
        List<Character> mid = new ArrayList<>();

        for (Name currentName : names) {
            int i;
            for (i = 0; currentName.chars[i] != '*'; i++) {
                if (begin[i] == 0) {
                    begin[i] = currentName.chars[i];
                } else if (begin[i] != currentName.chars[i]) {
                    return "*";
                }
            }

            int lastElement = currentName.chars.length - 1;
            int j;
            for (j = 0; currentName.chars[lastElement - j] != '*'; j++) {
                if (end[j] == 0) {
                    end[j] = currentName.chars[lastElement - j];
                } else if (end[j] != currentName.chars[lastElement - j]) {
                    return "*";
                }
            }

            for (int k = i + 1; k < j; k++) {
                if (currentName.chars[k] != '*') {
                    mid.add(currentName.chars[k]);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0;  i < begin.length && begin[i] != 0; i++) {
            stringBuilder.append(begin[i]);
        }

        for (char c : mid) {
            stringBuilder.append(c);
        }

        int lastElement = 0;
        while (lastElement < end.length && end[lastElement] != 0) {
            lastElement++;
        }
        lastElement--;

        for (int i = 0; lastElement - i >= 0; i++) {
            stringBuilder.append(end[lastElement - i]);
        }

        return stringBuilder.toString();
    }
}

class Name {
    public char[] chars;

    public Name(String s) {
        this.chars = s.toCharArray();
    }
}
