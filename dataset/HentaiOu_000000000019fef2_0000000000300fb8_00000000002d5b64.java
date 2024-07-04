import java.util.*;
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(in.nextLine());
        HashMap<Integer, Integer> counts = new HashMap<>();
        HashMap<Integer, ArrayList<String>> result = new HashMap<>();

        for (int caseId = 1; caseId <= numberOfCases; caseId++) {
            ArrayList<String> path = new ArrayList<>();
            String input = in.nextLine();
            int R = Integer.parseInt(input.trim().split(" ")[0]);
            int S = Integer.parseInt(input.trim().split(" ")[1]);
            int count = (R-1)*(S-1);
            counts.put(caseId, count);
            int a, b;
            while (R != 1) {
                for (int i = 0; i < (S-1); i++) {
                    a = (R * (S-1)) - i;
                    b = R-1;
                    path.add(a + " " + b);
                }
                R--;
            }
            result.put(caseId, path);
        }

        for(int caseId = 1; caseId <= numberOfCases; caseId++) {
            int count = counts.get(caseId);
            ArrayList<String> temp = result.get(caseId);
            System.out.println("Case #" + caseId + ": " + count);
            for(int i = 0; i < temp.size(); i++) {
                System.out.println(temp.get(i));
            }
        }
    }
}