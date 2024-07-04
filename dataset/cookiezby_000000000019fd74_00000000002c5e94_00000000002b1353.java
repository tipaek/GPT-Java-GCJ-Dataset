import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCount = Integer.valueOf(sc.nextLine());
        for(int i = 0; i < caseCount; i++) {
            int N = Integer.valueOf(sc.nextLine());
            List<String> result = new ArrayList();
            solution(result, N);
            String str = String.format("Case #%d:", i + 1);
            System.out.println(str);
            for(String val: result) {
                System.out.println(val);
            }
        }
        sc.close();
    }

    public static void solution(List<String> result, int N) {
        if(N <= 500) {
            for(int i = 1; i <= N; i++) {
                String str = String.format("%d %d", i, 1);
                result.add(str);
            }
            return;
        } else {
            result.add("1, 1");
            result.add("2, 1");
            result.add("2, 2");
            result.add("3, 3");
            result.add("3, 2");
            result.add("3, 1");
            for(int i = 1; i <= N - 7; i++) {
                String str = String.format("%d %d", i + 3, 1);
                result.add(str);
            }
        }
    }
}