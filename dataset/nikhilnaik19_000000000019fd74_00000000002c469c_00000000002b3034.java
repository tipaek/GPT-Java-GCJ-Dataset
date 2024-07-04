import java.io.*;

public class Solution {

    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String answer = answer(n);
            sb.append(String.format("CASE #%d: %s\n", i + 1, answer));
        }
        System.out.println(sb);
    }

    public static String answer(int number) throws IOException {
        String[] array = new String[number];
        array[0] = bufferedReader.readLine().replace("*", "");
        String key = array[0];
        boolean flag = false;
        for (int i = 1; i < number; i++) {
            array[i] = bufferedReader.readLine().replace("*", "");
            if (array[i].contains(key)) {
                key = array[i];
                for (int j = 0; j < i; j++) {
                    if (!key.contains(array[j])) {
                        return "*";
                    }
                }
            } else if (key.contains(array[i])) {
                flag = true;
            } else {
                return "*";
            }
        }
        if (flag) {
            return key;
        } else {
            return "*";
        }
    }
}