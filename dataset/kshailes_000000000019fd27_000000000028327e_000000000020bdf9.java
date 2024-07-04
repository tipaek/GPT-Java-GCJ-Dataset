


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int t = 0;
        int caseNumber = 1;
        Scanner scanner = new Scanner(System.in);
        t = Integer.parseInt(scanner.nextLine());
        while (caseNumber <= t) {
            String ans = "";
            int c = 0;
            int j = 0;
            int n = scanner.nextInt();
            List<AbstractMap.Entry<AbstractMap.Entry<Integer, Integer>,Integer>> activity = new ArrayList(n);
            for (int i = 0; i < n; i++) {
                int s = scanner.nextInt();
                int e = scanner.nextInt();
                activity.add(new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(s, e), i));
            }

            activity.sort((o1, o2) -> o1.getKey().getKey() - o2.getKey().getKey());

            for (int i = 0; i < n; i++) {
                int temp = activity.get(i).getKey().getKey();
                if(temp >= c) {
                    ans += 'C';
                    c =  activity.get(i).getKey().getValue();
                }
                else if( temp >= j) {
                    ans += 'J';
                    j =  activity.get(i).getKey().getValue();
                }
                else {
                    ans = "IMPOSSIBLE";
                    break;
                }
            }

            if(!ans.equals("IMPOSSIBLE")) {
                char[] chars = new char[n];
                for(int i = 0;i<n;i++) {
                    int temp =  activity.get(i).getValue();
                    chars[temp] = ans.charAt(i);
                }
                ans = new String(chars);
            }

            System.out.println("Case #" + caseNumber + ": " + ans);

            caseNumber++;
        }
    }
}
