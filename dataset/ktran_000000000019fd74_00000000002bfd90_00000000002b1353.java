import java.util.*;

public class Solution {
    
  static int[][] triangles = new int[501][501];

    static int[][] directions = new int[][] {
            new int[] {-1,-1},
            new int[] {-1,0},
            new int[] {0,-1},
            new int[] {0,1},
            new int[] {1,0},
            new int[] {1,1}
    };

    static List<int[]> shuffles ;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        triangles[1][1] = 1;

        shuffles = Arrays.asList(directions);

        for(int t = 1; t <= T; t++) {

            int N = sc.nextInt();

            Set<Integer> visited = new HashSet<>();

            visited.add(1*1000+1);

            List<int[]> paths = dfs(1,1,N,0,visited);

            System.out.println("Case #"+t+":");
            for(int[] path : paths) {
                System.out.print(path[0]+ " "+path[1]+"\n");
            }
        }

    }


    public static List<int[]> dfs(int r, int k, int N, int sum, Set<Integer> visited) {

        List<int[]> list = new ArrayList<>();

        if(r < 0 || k < 0 || r > 500 || k > 500) return list;

        sum = sum + getPascalTriangle(r,k);

        if(sum == N) {
            list.add(new int[] {r,k});
            return list;
        }

        if(sum > N) {
            return list;
        }
        Collections.shuffle(shuffles);
        for(int[] direction : shuffles) {
            int r1 = r + direction[0];
            int k1 = k + direction[1];
            if(isValid(r1,k1) && !visited.contains(r1*1000+k1)) {
                visited.add(r1*1000+k1);
                List<int[]> list1 = dfs(r1,k1,N,sum,visited);
                if(list1.size() > 0) {
                    list.add(new int[]{r,k});
                    list.addAll(list1);
                    break;
                }
                visited.remove(r1*1000+k1);
            }
        }

        return list;
    }


    public static boolean isValid(int r,int k) {
        if(r == 0 || k == 0 || r > 500 || k > 500 || r < k) return false;
        return true;
    }
    public static int getPascalTriangle(int r, int k) {

        if(k == 1 || r == k) return 1;

        if(triangles[r][k] != 0) return triangles[r][k];

        int tmp = getPascalTriangle(r-1,k-1) + getPascalTriangle(r-1,k);

        triangles[r][k] = tmp;

        return tmp;


    }
}