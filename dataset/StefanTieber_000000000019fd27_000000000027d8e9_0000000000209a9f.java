import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String line;
            String[] parts;

            line = reader.readLine();
            int numberOfSets = Integer.parseInt(line);

            for (int i = 0; i < numberOfSets; i++) {
                char[] chars = reader.readLine().toCharArray();
                
                StringBuilder stringBuilder = new StringBuilder();
                
                int level = 0;
                for (char c : chars) {
                    int levelchange = c - '0' - level;
                    level = c - '0';

                    while (levelchange > 0) {
                        stringBuilder.append("(");
                        levelchange--;
                    }
                    while (levelchange < 0) {
                        stringBuilder.append(")");
                        levelchange++;
                    }

                    stringBuilder.append(c);
                }
                while (level > 0) {
                    stringBuilder.append(")");
                    level--;
                }

                System.out.println("Case #" + (i + 1) + ": " + stringBuilder.toString());
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
