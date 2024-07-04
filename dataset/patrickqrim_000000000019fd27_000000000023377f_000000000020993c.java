import java.io.*;
import java.util.*;
/**
 * Write a description of class Snail here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Vestigium
{
    static void main(String[] args) throws IOException{
        Scanner br = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = Integer.parseInt(br.nextLine());

        for(int nn = 0; nn < n; nn++){
            int test = Integer.parseInt(br.nextLine());
            int[][] grid = new int[test][test];
            
            int token = 0;
            int r = 0;
            int c = 0;
            
            for(int i = 0; i < test; i++){
                StringTokenizer st = new StringTokenizer(br.nextLine());
                for(int j = 0; j < test; j++){
                    grid[i][j] = Integer.parseInt(st.nextToken());
                    if(i == j){
                        token+= grid[i][j];
                    }
                }
            }
            
            for(int[] i : grid){
                int[] ii = new int[test];
                for(int a = 0; a < test; a++){
                    ii[a] = i[a];
                }
                Arrays.sort(ii);
                for(int j = 1; j < test; j++){
                    if(ii[j] == ii[j-1]){
                        r++;
                        break;
                    }
                }
            }
            
            for(int i = 0; i < test; i++){
                int[] y = new int[test];
                for(int j = 0; j < test; j++){
                    y[j] = grid[j][i];
                }
                Arrays.sort(y);
                for(int j = 1; j < test; j++){
                    if(y[j] == y[j-1]){
                        c++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + (nn+1) + ": " + token + " " + r + " " + c);
        }   
    }
}
