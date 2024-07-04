import java.util.*;

class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            String string = scanner.nextLine();
            ArrayList<String> arrayList = new ArrayList<>();
            int n = string.length();

            char[] C = string.toCharArray();

            int j = 0;
            while (j < Integer.parseInt(String.valueOf(C[0]))) {
                arrayList.add("(");
                j++;
            }
            arrayList.add(String.valueOf(C[0]));

            for (int i = 1; i < n; i++) {
                int prev = Integer.parseInt(String.valueOf(C[i - 1]));
                int next = Integer.parseInt(String.valueOf(C[i]));
                if (next > prev) {
                    int x = prev;
                    while (x != next) {
                        arrayList.add("(");
                        x++;
                    }
                    arrayList.add(String.valueOf(next));
                } else if (next < prev) {
                    int x = prev;
                    while (x != next) {
                        arrayList.add(")");
                        x--;
                    }
                    arrayList.add(String.valueOf(next));
                } else {
                    arrayList.add(String.valueOf(next));
                }
            }

            j = 0;
            while (j < Integer.parseInt(String.valueOf(C[n - 1]))) {
                arrayList.add(")");
                j++;
            }

            StringBuilder ans = new StringBuilder();
            for (String value : arrayList) {
                ans.append(value);
            }
            
            System.out.println("Case #" + (t + 1) + ": " + ans.toString());
        }
    }
}


