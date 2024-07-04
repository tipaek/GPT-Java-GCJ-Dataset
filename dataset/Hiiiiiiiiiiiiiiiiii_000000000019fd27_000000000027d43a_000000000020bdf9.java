import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int i=1; i <= tc; i++) {
            int size = sc.nextInt();
            int[][] nums = new int[size][2];
            boolean[] cvisited = new boolean[1441];
            boolean[] jvisited = new boolean[1441];
            String result = "";

            for(int j=0; j <size; j++) {
                nums[j][0] = sc.nextInt();
                nums[j][1] = sc.nextInt();
            }

            result = search(nums, cvisited, jvisited);

            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String search(int[][] nums, boolean[] cvisited, boolean[] jvisited) {
        String result = "";

        for(int start = 0; start < nums.length; start++) {
            boolean cCheck = false;
            boolean jCheck = false;
            boolean cskip = false;
            boolean jskip = false;

            for (int i = nums[start][0]; i <= nums[start][1]; i++) {
                if(cvisited[i] && i == nums[start][0] && !cskip) {
                    cskip = true;
                    continue;
                }

                if(cvisited[i] && i == nums[start][1] && !cskip) {
                    cskip = true;
                    continue;
                }

                if(cvisited[i]) {
                    cCheck = true;
                    break;
                }
            }

            if (!cCheck) {
                for (int i = nums[start][0]; i <= nums[start][1]; i++) {
                    cvisited[i] = true;
                }

                result += "C";
            } else {
                for (int i = nums[start][0]; i <= nums[start][1]; i++) {
                    if(jvisited[i] && i == nums[start][0] && !jskip) {
                        jskip = true;
                        continue;
                    }

                    if(jvisited[i] && i == nums[start][1] && !jskip) {
                        jskip = true;
                        continue;
                    }

                    if (jvisited[i]) {
                     //   System.out.println(i);
                        jCheck = true;
                        break;
                    }
                }

                if (!jCheck) {
                    for (int i = nums[start][0]; i <= nums[start][1]; i++) {
                        jvisited[i] = true;
                    }

                    result += "J";
                } else {
                 //   System.out.println(result);
                    result = "IMPOSSIBLE";
                    break;
                }
            }
        }


        return result;
    }
}
