import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));  
    int t = in.nextInt();
    String[] str = new String[t];
        for(int i = 0;i<t;i++){
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0;
            for(int j = 0;j<n;j++){
                for(int r = 0; r<n;r++){
                arr[j][r] = in.nextInt();
                if(r == j)
                    trace+=arr[j][r];
                }
            }
            int row = 0;
            int col = 0;
            for(int a = 0;a<n;a++) {
            	boolean rfound = false;
            	boolean cfound = false;
            	for(int d = 0;d<n;d++) {
	            	int rres = arr[a][d];
	            	int cres = arr[d][a];
	            	for(int e = d+1;e<n&&!rfound;e++) {
	            		if(arr[a][e] == rres) {
            				row++;
            				rfound = true;
            				break;
            			}
            		}
	            	for(int e = d+1;e<n&&!cfound;e++) {
	            		if(arr[e][a] == cres) {
            				col++;
            				cfound = true;
            				break;
            			}
            		}
            	}
            }
            str[i]="Case #"+(i+1)+": "+trace+" "+row+" "+col;
            }
        in.close();
        for(String s:str)
        	System.out.println(s);
        }
 }