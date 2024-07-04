import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int i=1; i <= tc; i++) {
            int size = sc.nextInt();
            int[][] nums = new int[size][2];
            boolean[] visited = new boolean[size];

            for(int j=0; j <size; j++) {
                nums[j][0] = sc.nextInt();
                nums[j][1] = sc.nextInt();
            }

            String result = search(nums, 0, -1, Integer.MIN_VALUE, -1, Integer.MIN_VALUE, visited);

            if(result.length() != size)
                result = "IMPOSSIBLE";

            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String search(int[][] nums, int start, int cstart, int cend, int jstart, int jend, boolean[] visited) {
        String result = "";
        String c = "";
        String j = "";

        if(start >= nums.length)
            return "";

        if (((nums[start][0] >= cend && cstart < nums[start][0]) || (nums[start][1] <= cstart && nums[start][1] < cend)) && !visited[start]) {
            visited[start] = true;
            c = "C" + search(nums, start+1, nums[start][0], nums[start][1], jstart, jend, visited);
            visited[start] = false;
        }

        if (((nums[start][0] >= jend && jstart < nums[start][0]) || (nums[start][1] <= jstart && nums[start][1] < jend)) && !visited[start]) {
            visited[start] = true;
            j = "J" + search(nums, start+1, cstart, cend, nums[start][0], nums[start][1], visited);
            visited[start] = false;
        }

        if(c.length() > j.length())
            result = c;
        else
            result = j;

        /*
        if(c.length() > j.length())
            result = c;
        else if(j.length() > c.length())
            result = j;
        else if(c.length() == j.length()) {
            if(j.length() > 1 && j.charAt(0) == j.charAt(1)) {
                result = j;
            } else
                result = c;
        } */
      //  System.out.println(result);
        return result;
    }
}
