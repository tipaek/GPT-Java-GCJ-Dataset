import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] Args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        int count = 1;
        String appended = "";
        while (count <= cases) {
            appended = "";
            String init = in.readLine();
            int num = Character.getNumericValue(init.charAt(0));
            int pastNum = num;
            for(int i = 0; i < num; i++) {
                appended += "(";
            }
            appended += num;
            for (int i = 1; i < init.length(); i++) {
                num = Character.getNumericValue(init.charAt(i));
                if (pastNum > num) {
                    for (int j = 0; j < pastNum - num; j++) {
                        appended += ")";
                    }
                    appended += num;
                    pastNum = num;
                } else if (pastNum == num){
                    appended += num;
                    pastNum = num;
                } else {
                    for (int j = 0; j < num - pastNum; j++) {
                        appended += "(";
                    }
                    appended += num;
                    pastNum = num;
                }
            }
            for (int i = 0; i < pastNum; i++) {
                appended += ")";
            }
            System.out.println("Case #" + count + ": " + appended);
            count++;
        }
    }
}
