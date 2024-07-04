import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tcase = 1; tcase <= t; tcase++) {
            int n = sc.nextInt();

            List<String> patterns = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                patterns.add(sc.next());
            }

            String prefix = "";
            String suffix = "";
            String middle = "";
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                String line = patterns.get(i);
                String[] split = line.split("\\Q*\\E", -1);

                if (line.charAt(0) != '*') {
                    if (prefix.startsWith(split[0]) ) {

                    } else if (split[0].startsWith(prefix)) {
                        prefix = split[0];
                    } else {
                        valid = false;
                    }
                }

                for (int j = 1; j < split.length - 1; j++) {
                    middle += split[j];
                }

                if (line.charAt(line.length() - 1) != '*') {
                    if (suffix.endsWith(split[split.length - 1]) ) {

                    } else if (split[split.length - 1].endsWith(suffix)) {
                        suffix = split[split.length - 1];
                    } else {
                        valid = false;
                    }
                }
            }

            System.out.print("Case #" + tcase + ": ");
            if (valid) {
                System.out.println(prefix + middle + suffix);
            } else {
                System.out.println("*");
            }
        }
        sc.close();
    }
}