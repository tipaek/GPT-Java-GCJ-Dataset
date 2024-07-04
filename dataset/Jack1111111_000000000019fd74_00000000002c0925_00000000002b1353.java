import java.util.*;
class Solution {
    int maxrow = 50;
    List<int[]> result;

    int[][] dirs = new int[][] {{0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {1, 0}, {1, 1}};

    public void solve() {
        int[] nums = init();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int S = sc.nextInt();
            List<int[]> tmp = new ArrayList<>();
            tmp.add(new int[] {1, 1});
            result = null;
            backtrack(1, 1, S-1, nums, new boolean[nums.length], tmp);
            System.out.println("Case #" + t +":");
            for (int[] r : result) {
                System.out.println(r[0] + " " + r[1]);
            }
        }
    }

    public void backtrack(int r, int c, int target, int[] nums, boolean[] visited, List<int[]> tmp) {
        if (tmp.size() > 500) {
            return;
        }
        if (target == 0) {
            if (result == null || result.size() >= tmp.size()) {
                result = new ArrayList<>(tmp);
            }
            return;
        }

        for (int[] dir : dirs) {
            int newr = r+dir[0];
            int newc = c+dir[1];

            if (newr > maxrow || newr < 1 || newc > newr || newc < 1) {
                continue;
            }
            int index = (1+newr-1)*(newr-1)/2 + newc;
            if (!visited[index] ) {
                if (nums[index] > target) {
                    continue;
                }
                visited[index] = true;
                target -= nums[index];
                tmp.add(new int[] {newr,newc});

                backtrack(newr, newc,target, nums, visited, tmp);

                visited[index] = false;
                target += nums[index];
                tmp.remove(tmp.size()-1);
            }
        }
    }



    public int[] init() {
        int sum = (1+maxrow) * maxrow / 2;
        int[] nums = new int[sum+1];
        nums[1] = 1;
        nums[2] = 1;
        nums[3] = 1;
        for (int i = 4; i < nums.length; i++) {
            //compute i row and col
            int r = 1;
            while ((1+r+1)*(r+1)/2 < i) {
                r++;
            }
            int c = i - (1+r)*(r)/2;
            if (c == 1 || c == r+1) {
                nums[i] = 1;
            } else {
                nums[i] = nums[(1+r-1)*(r-1)/2+(c-1)] + nums[(1+r-1)*(r-1)/2+(c)];
            }
        }
        return nums;
    }



    public static void main(String args[]) {
        Solution s = new Solution();
        s.solve();
    }

}