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

        for (Name currentName : names) {
            for (int i = 0; currentName.chars[i] != '*'; i++) {
                if (begin[i] == 0) {
                    begin[i] = currentName.chars[i];
                } else if (begin[i] != currentName.chars[i]) {
                    return "*";
                }
            }
        }

        char[] end = new char[100];
        IntStream.range(0, begin.length).forEach(i -> begin[i] = 0);

        for (Name currentName : names) {
            char[] chars = currentName.chars;
            for (int i = chars.length - 1; currentName.chars[i] != '*'; i--) {
                if (end[i] == 0) {
                    end[i] = currentName.chars[i];
                } else if (end[i] != currentName.chars[i]) {
                    return "*";
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0;  i < begin.length && begin[i] != 0; i++) {
            stringBuilder.append(begin[i]);
        }
        int i = 0;
        while (i < end.length && end[i] == 0) {
            i++;
        }
        for (; i < end.length; i++) {
            stringBuilder.append(end[i]);
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
