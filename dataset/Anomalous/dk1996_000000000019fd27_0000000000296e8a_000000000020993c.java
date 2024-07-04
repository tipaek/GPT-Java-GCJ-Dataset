import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = Integer.parseInt(sc.nextLine());
        
        for (int temp = 1; temp <= r; temp++) {
            int c = Integer.parseInt(sc.nextLine());
            int[][] mat = new int[c][c];
            
            for (int i = 0; i < c; i++) {
                String[] row = sc.nextLine().split(" ");
                for (int j = 0; j < c; j++) {
                    mat[i][j] = Integer.parseInt(row[j]);
                }
            }
            
            int trace = 0;
            for (int i = 0; i < c; i++) {
                trace += mat[i][i];
            }
            
            int rCount = 0;
            int cCount = 0;
            
            for (int i = 0; i < c; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                
                for (int j = 0; j < c; j++) {
                    if (!rowSet.add(mat[i][j])) {
                        rCount++;
                        break;
                    }
                }
                
                for (int j = 0; j < c; j++) {
                    if (!colSet.add(mat[j][i])) {
                        cCount++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + temp + ": " + trace + " " + rCount + " " + cCount);
        }
        
        sc.close();
    }
}