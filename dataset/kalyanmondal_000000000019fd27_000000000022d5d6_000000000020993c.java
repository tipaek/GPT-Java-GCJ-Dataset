import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Vestigium {

    public static void main(String... args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String testcase = br.readLine();
        Integer t = Integer.parseInt(testcase);
        for (int i=0; i<t; i++) {
            String numbers = br.readLine();
            Integer n = Integer.parseInt(numbers);
            Integer k = 0;
            Integer r = 0;
            Integer c = 0;
            Integer matrix[][] = new Integer[n][n];
            for(int j=0; j<n; j++) {
                String matLine = br.readLine();
                String matLineArr[] = matLine.split(" ");
                for(int x=0; x<n; x++){
                    matrix[j][x] = Integer.parseInt(matLineArr[x]);
                }
                k+=Integer.parseInt(matLineArr[j]);
            }
            for (int x=0; x<n; x++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for(int y=0; y<n; y++) {
                    if(rowSet.contains(matrix[x][y])) {
                        r++;
                        break;
                    }
                    rowSet.add(matrix[x][y]);
                }
                for(int z=0; z<n; z++) {
                    if(colSet.contains(matrix[z][x])) {
                        c++;
                        break;
                    }
                    colSet.add(matrix[z][x]);
                }
            }
            System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
        }
    }
}
