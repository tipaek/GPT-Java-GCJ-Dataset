import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(sc.nextLine());
        }
        for(int i = 0; i < n; i++){
            System.out.println("Case #" + (i + 1) + ": " + change(list.get(i)));
        }
        //System.out.println(change("1234"));
    }

    public static String change(String s){
        for(int i = 0; i < s.length(); i++){
            String s1 = s;
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (i == 0) {
                    String cc = "";
                    int k = (s.charAt(i) - '0');
                    for (int j = 0; j < k; j++) {
                        cc += '(';
                    }
                    s = cc + s;
                    i += k;
                } else {
                    String cc = "";
                    int k = (s.charAt(i) - s.charAt(i - 1));
                    for (int j = 0; j < k; j++) {
                        cc += '(';
                    }
                    s = s.substring(0, i) + cc + s.substring(i);
                    if(k >= 0)
                        i += k;
                }
            }
        }
        System.out.println(s);
        s = rev(s);
        for(int i = 0; i < s.length(); i++){
            String s1 = s;
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (i == 0) {
                    String cc = "";
                    int k = (s.charAt(i) - '0');
                    for (int j = 0; j < k; j++) {
                        cc += ')';
                    }
                    s = cc + s;
                    i += k;
                } else {
                    String cc = "";
                    int d = i - 1;
                    while (s.charAt(d) < '0' || s.charAt(d) > '9') {
                          d--;
                    }
                    int k = (s.charAt(i) - s.charAt(d));
                    for (int j = 0; j < k; j++) {
                        cc += ')';
                    }
                    s = s.substring(0, i) + cc + s.substring(i);
                    if(k >= 0)
                        i += k;
                }
            }
        }
        s = rev(s);
        return s;
    }

    public static String rev(String s){
        String ans = "";
        for(int i = s.length() - 1; i >= 0; i--){
            ans += s.charAt(i);
        }
        return ans;
    }
}
