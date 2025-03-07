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

            for(int j=0; j < size; j++) {
                nums[j][0] = sc.nextInt();
                nums[j][1] = sc.nextInt();
            }

            java.util.Arrays.sort(nums, new java.util.Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Double.compare(a[0], b[0]);
                }
            });

            result = search(nums, cvisited, jvisited);

            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String search(int[][] nums, boolean[] cvisited, boolean[] jvisited) {
        String result = "";

        for(int start = 0; start < nums.length; start++) {
            boolean cCheck = false;
            boolean jCheck = false;

            if(nums[start][0]+1 < 1441 && cvisited[nums[start][0]] && !cvisited[nums[start][0]+1]) {
                //    System.out.println(nums[start][0]);
                cvisited[nums[start][0]] = false;
            }

            if(nums[start][1]-1 >= 0 && cvisited[nums[start][1]] && !cvisited[nums[start][1]-1]) {
                cvisited[nums[start][1]] = false;
            }

            for (int i = nums[start][0]; i <= nums[start][1]; i++) {
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
                if(nums[start][0]+1 < 1441 && jvisited[nums[start][0]] && !jvisited[nums[start][0]+1]) {
                    jvisited[nums[start][0]] = false;
                }

                if(nums[start][1]-1 >= 0 && jvisited[nums[start][1]] && !jvisited[nums[start][1]-1]) {
                    jvisited[nums[start][1]] = false;
                }


                for (int i = nums[start][0]; i <= nums[start][1]; i++) {

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
