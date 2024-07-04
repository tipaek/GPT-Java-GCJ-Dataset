import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            int cases = Integer.parseInt(scan.nextLine());
            for (int t = 0; t < cases-1; t++) {
                String line[] = scan.nextLine().split("");
                String sol = solve(line);
                System.out.println("Case #" + (t + 1) + ": " + sol.substring(0, sol.length() - 1));
            }
        } catch (Exception e) { }
        /*

        String a = "101";
        System.out.println(solve(a.split("")));
         */
    }

    private static String solve(String line[]) {
        int nums[] = new int[line.length + 2];
        for(int i = 0; i < line.length; i++) {
            int d = Integer.parseInt(line[i]);
            nums[i+1] = d;
        }
        nums[0] = 0;
        nums[nums.length-1] = 0;

        StringBuilder stb = new StringBuilder();
        //System.out.println("________");
        for (int i = 1; i < nums.length; i++) {
            String toAdd = getParString(nums[i-1]-nums[i], nums[i]);
            //System.out.println(toAdd);
            stb.append(toAdd);
        }
        return stb.toString();
    }

    private static String getParString(int i, int n) {
        StringBuilder stb = new StringBuilder();
        for (int c = 0; c < Math.abs(i); c++) {
            if (i < 0) {
                stb.append("(");
            } else if (i > 0) {
                stb.append(")");
            }
        }
        stb.append(n);
        return stb.toString();
    }
}
