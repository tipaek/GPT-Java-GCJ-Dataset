
import java.util.*;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
          int inputCount = scanner.nextInt();

        for (int c = 0; c < inputCount; c++) {
            int N = Integer.parseInt( scanner.next());
            System.out.print("Case #" + (c + 1) + ":");
            createString(N);
            System.out.println();
        }

    }

    public static void createString(int N) {
        List<String> starts = new ArrayList<>();
        List<String> ends = new ArrayList<>();
        List<String> middles = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String s = scanner.next();

            StringBuilder sb = new StringBuilder();
            boolean startFinished = false;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c != '*') {
                    sb.append(c);
                } else {
                    if (startFinished == false) {
                        startFinished = true;
                        if (sb.length() != 0) {
                            starts.add(sb.toString());
                            sb = new StringBuilder();
                        }

                    } else {
                        if (sb.length() != 0) {
                            middles.add(sb.toString());
                            sb = new StringBuilder();
                        }
                    }
                }
            }
            if (sb.length() != 0) {
                ends.add(sb.reverse().toString());
            }
        }

        Collections.sort(starts, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        Collections.sort(ends, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        boolean notMatched = false;


        for (int i = 1; i < starts.size(); i++) {
            if (notMatched) {
                break;
            }
            String a = starts.get(0);
            String b = starts.get(0);
            for (int j = 0; j < b.length(); j++) {
                if (!(a.charAt(j) == b.charAt(j))) {
                    notMatched = true;
                    break;
                }
            }

        }

        for (int i = 1; i < ends.size(); i++) {
            if (notMatched) {
                break;
            }
            String a = ends.get(0);
            String b = ends.get(i);
            for (int j = 0; j < b.length(); j++) {
                if (!(a.charAt(j) == b.charAt(j))) {
                    notMatched = true;
                    break;
                }
            }

        }


        if (notMatched) {
            System.out.print(" *");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(" ");
            if (starts.size() > 0) {
                sb.append(starts.get(0));
            }
            for (String s : middles) {
                sb.append(s);
            }

            if (ends.size() > 0) {
                for (int j = ends.get(0).length() - 1; j >= 0; j--) {
                    sb.append(ends.get(0).charAt(j));
                }
            }
            System.out.print(sb.toString());
        }


    }
}
