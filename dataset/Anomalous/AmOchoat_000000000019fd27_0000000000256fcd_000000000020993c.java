import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder rta = new StringBuilder();
            int casos = Integer.parseInt(bf.readLine().trim());
            
            for (int i = 0; i < casos; i++) {
                int n = Integer.parseInt(bf.readLine().trim());
                Integer[][] tabla = new Integer[n][n];
                
                for (int x = 0; x < n; x++) {
                    String[] fila = bf.readLine().trim().split(" ");
                    for (int c = 0; c < n; c++) {
                        tabla[x][c] = Integer.parseInt(fila[c]);
                    }
                }

                int diagonalSum = 0;
                for (int z = 0; z < n; z++) {
                    diagonalSum += tabla[z][z];
                }

                int repeatedRows = 0;
                for (int a = 0; a < n; a++) {
                    boolean found = false;
                    for (int b = 0; b < n && !found; b++) {
                        for (int e = b + 1; e < n && !found; e++) {
                            if (tabla[a][b].equals(tabla[a][e])) {
                                repeatedRows++;
                                found = true;
                            }
                        }
                    }
                }

                int repeatedColumns = 0;
                for (int a = 0; a < n; a++) {
                    boolean found = false;
                    for (int b = 0; b < n && !found; b++) {
                        for (int e = b + 1; e < n && !found; e++) {
                            if (tabla[b][a].equals(tabla[e][a])) {
                                repeatedColumns++;
                                found = true;
                            }
                        }
                    }
                }

                rta.append("Case #").append(i + 1).append(": ").append(diagonalSum).append(" ").append(repeatedRows).append(" ").append(repeatedColumns).append("\n");
            }
            
            System.out.print(rta.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}