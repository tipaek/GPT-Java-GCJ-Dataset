import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int i=1; i <= tc; i++) {
            int size = sc.nextInt();
            int[][] nums = new int[size][2];
            int[][] sorted = new int[size][2];
            boolean[] cvisited = new boolean[1441];
            boolean[] jvisited = new boolean[1441];
            String result = "";

            for(int j=0; j < size; j++) {
                nums[j][0] = sc.nextInt();
                nums[j][1] = sc.nextInt();
                sorted[j][0] = nums[j][0];
                sorted[j][1] = nums[j][1];
            }

            java.util.Arrays.sort(sorted, new java.util.Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Double.compare(a[0], b[0]);
                }
            });

            int[] index = new int[size];
            int[] sortIndex = new int[size];

            for(int j=0; j < size; j++) {
                for(int k=0; k < size; k++) {
                    if(nums[j][0] == sorted[k][0] && nums[j][1] == sorted[k][1]) {
        //                System.out.println(j + " : " + nums[j][0] + " : " + nums[j][1]);
        //                System.out.println(k + " : " + sorted[k][0] + " : " + sorted[k][1]);
                        sortIndex[j] = k;
                        break;
                    }
                }
            }

            result = search(sorted, 0, cvisited, jvisited);

            if(size != result.length())
                result = "IMPOSSIBLE";

            if(!result.equals("IMPOSSIBLE")) {
                //System.out.println(result);
                String temp = "";
                for (int j = size-1; j >= 0; j--) {
                 //   System.out.println(j + " : " + sortIndex[j]);
                  //  result = swapChars(result, j, sortIndex[j]);
                    temp += result.charAt(sortIndex[j]);
                }
               // System.out.println(temp);
                result = temp;
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String search(int[][] nums, int start, boolean[] cvisited, boolean[] jvisited) {
        String result = "";

        if(start >= nums.length)
            return "";

        boolean cCheck = false;
        boolean jCheck = false;
        String c = "";
        String j = "";

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

            c = "C" + search(nums, start+1, cvisited, jvisited);

            for (int i = nums[start][0]; i <= nums[start][1]; i++) {
                cvisited[i] = false;
            }
        }

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

            j = "J" + search(nums, start+1, cvisited, jvisited);

            for (int i = nums[start][0]; i <= nums[start][1]; i++) {
                jvisited[i] = false;
            }
        }

        if(c.length() > j.length())
            result = c;
        else
            result = j;


        return result;
    }

    public static String swapChars(String str, int lIdx, int rIdx) {
        StringBuilder sb = new StringBuilder(str);
        char l = sb.charAt(lIdx), r = sb.charAt(rIdx);
        sb.setCharAt(lIdx, r);
        sb.setCharAt(rIdx, l);
        return sb.toString();
    }
}
