import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));;
        int w = in.nextInt();
        for (int a = 1; a <= w; ++a) {
            String c = new String(new char[24*60]).replace('\0', '0');
            String j = new String(new char[24*60]).replace('\0', '0');

            StringBuilder stringBuilder = new StringBuilder();
            int n =in.nextInt();
            for (int i = 0; i < n ; i++) {
                int start = in.nextInt();
                int end = in.nextInt();

                if (c.substring(start, end).contains("1")) {
                    if (j.substring(start, end).contains("1")) {
                        stringBuilder = new StringBuilder("IMPOSSIBLE");
                        break;
                    } else {
                        stringBuilder.append("J");
                        j=j.substring(0,start)+new String(new char[end-start]).replace('\0', '1')+j.substring(end);
                    }
                } else {
                    stringBuilder.append("C");
                    c=c.substring(0,start)+new String(new char[end-start]).replace('\0', '1')+c.substring(end);
               
                }
            }

            System.out.println("Case #" + a + ": " + stringBuilder.toString());
        }
    }

}