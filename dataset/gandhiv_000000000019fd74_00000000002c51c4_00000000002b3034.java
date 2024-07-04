import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1, i1;
        n1 = sc.nextInt();
        for (i1 = 1; i1 <= n1; i1++) {
            int n = sc.nextInt();
            List < String > li = new ArrayList < String > ();
            String st = "";
            int i;
            for (i = 0; i < n; i++) {
                st = sc.next();
                li.add(st);
            }
            TreeSet < String > ts = new TreeSet < > (li);
            li = new ArrayList < > (ts);
            String[] arr = new String[li.size()];
            i = 0;
            for (String x: li) {
                arr[i++] = x;
            }
            for (i = 1; i < li.size(); i++) {
                String temp = arr[i];
                int j = i - 1;
                while (j >= 0 && temp.length() > arr[j].length()) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = temp;
            }
            boolean f = true;
            st = arr[0];
            st = st.replace("*","");
            for (i = 1; i < li.size() && f == true; i++) {
                if (!match(arr[i], st))
                    f = false;
            }
            System.out.print("Case #" + i1 + ": ");
            if (f == true)
                System.out.println(st);
            else
                System.out.println("*");
        }
    }
    public static boolean match(String first, String second) {
        if (first.length() == 0 && second.length() == 0)
            return true;
        if (first.length() > 1 && first.charAt(0) == '*' &&
            second.length() == 0)
            return false;
        if (first.length() != 0 && second.length() != 0 &&
            first.charAt(0) == second.charAt(0))
            return match(first.substring(1), second.substring(1));
        if (first.length() > 0 && first.charAt(0) == '*')
            return match(first.substring(1), second) ||
                match(first, second.substring(1));
        return false;
    }
}