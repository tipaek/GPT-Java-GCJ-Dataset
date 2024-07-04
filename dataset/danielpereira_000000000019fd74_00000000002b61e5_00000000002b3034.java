import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            List<String> words = new ArrayList<>(t);
            for (int x = 0; x < n; x++) {
                words.add(reader.readLine());
            }
            words.sort((a, b) -> b.length() - a.length());
            boolean matches = true;
            for (int x = 0; x < words.size() - 1; x++) {
                if (!words.get(x).substring(1).endsWith(words.get(x + 1).substring(1))) {
                    matches = false;
                    break;
                }
            }
            String word = words.get(0).replaceFirst("\\*", "");
            if (matches) {
                System.out.println(String.format("Case #%d: %s", (i + 1), word));
            } else {
                System.out.println(String.format("Case #%d: *", (i + 1)));
            }
        }
    }

}