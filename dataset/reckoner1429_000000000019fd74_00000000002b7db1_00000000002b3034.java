import java.util.regex.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int x = 0; x < t; ++x) {
            int n = scan.nextInt();
            scan.nextLine();
            List<String> list = new ArrayList<>(n);
            for(int i = 0; i < n; ++i) {
                list.add(scan.nextLine());
            }
            Collections.sort(list, new Comparator<String>() {
                public int compare(String s1, String s2) {
                    return s1.length() - s2.length();
                }
            });
            for(int i=0;i<n;++i) {
                System.out.println(list.get(i));
            }
            Pattern p = Pattern.compile("\\w*"+list.get(0).substring(1));

            boolean matches = true;
            for(int i = 1; i < n; ++i) {
                Matcher m = p.matcher(list.get(i).substring(1));
                if(!m.matches()) {
                    System.out.println(" " + list.get(i));
                    matches = false;
                }
            }
            String y = list.get(n-1).substring(1);
            if(matches) {
                System.out.printf("Case #%d: %s\n", x+1, y);
            } else {
                System.out.println("*");
            }
        }
    }
}