import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class MyClass {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String Solve(int N) throws java.lang.Exception {
        String stringArray[] = new String[N];
        int maximum = 0;
        int position = -1;
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            stringArray[i] = br.readLine();
            if (i >= 1)
                if (maximum < stringArray[i].length()) {
                    maximum = stringArray[i].length();
                    position = i;
                }
        }

        for (int i = 0; i < N; i++) {
            String subString = stringArray[i].substring(1);
            if (flag && !stringArray[position].contains(subString)) {
                flag = false;
                break;
            }
        }
        if (flag)
            return stringArray[position].substring(1);
        return "*";
    }

    public static void main(String[] args) throws java.lang.Exception {

        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            String res = Solve(Integer.parseInt(br.readLine()));
            System.out.println("Case #" + i + ": " + res);

        }
    }

}