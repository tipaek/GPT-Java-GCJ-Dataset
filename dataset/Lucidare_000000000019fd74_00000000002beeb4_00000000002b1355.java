    import java.util.*;

    public class Solution {
        public static String solve(Scanner scanner) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int total = 0;
            int[][] floor = new int[r][c];
            for (int i = 0;i<r;i++ ) {
                for (int j = 0;j<c;j++) {
                    floor[i][j] = scanner.nextInt();
                }
            }
            total += findSum(floor);
            
            int eliminate = eliminate(floor);
            while (eliminate > 0) {
                total += findSum(floor);
                eliminate = eliminate(floor);
            }

            return String.valueOf(total);
        }

        public static int findSum(int[][] floor) {
            int r = floor.length;
            int c = floor[0].length;
            int total = 0;
            for (int i = 0;i<r;i++ ) {
                for (int j = 0;j<c;j++) {
                    total += floor[i][j];
                }
            } 
            return total;
        }

        public static double getNeighboursAvg(int[][] floor, int i, int j) {
            double sum = 0;
            double found = 0;
            for (int above=i-1;above>=0;above--) {
                if (floor[above][j] != 0) {
                    sum+= floor[above][j];
                    found++;
                    break;
                }
            }
            for (int below=i+1;below<floor.length;below++) {
                if (floor[below][j] != 0) {
                    sum+= floor[below][j];
                    found++;
                    break;
                }
            }
            for (int left=j-1;left>=0;left--) {
                if (floor[i][left] != 0) {
                    sum+= floor[i][left];
                    found++;
                    break;
                }
            }
            for (int right=j+1;right<floor[0].length;right++) {
                if (floor[i][right] != 0) {
                    sum+= floor[i][right];
                    found++;
                    break;
                }
            }
            if (found == 0) return -1;
            return sum/found;
        }

        public static int eliminate(int[][] floor) {
            Set<String> toDelete = new HashSet<>();

            for (int i = 0; i < floor.length; i++) {
                for (int j=0;j<floor[0].length; j++) {
                    double avg = getNeighboursAvg(floor, i, j);
                    if (avg > floor[i][j] && floor[i][j] != 0) {
                        toDelete.add(i + "," + j);
                    }
                }
            }

            Iterator it = toDelete.iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                String[] ijs = key.split(",");
                int i = Integer.parseInt(ijs[0]);
                int j = Integer.parseInt(ijs[1]);
                floor[i][j] = 0;
            }
            
            return toDelete.size();
        }
        public static void main(String args[]) {
            Scanner input = new Scanner(System.in);
            int caseNum = input.nextInt();
            for (int ks = 1; ks <= caseNum; ks++) {
                System.out.println(String.format("Case #%d: %s", ks, solve(input)));
            }
        }
    }