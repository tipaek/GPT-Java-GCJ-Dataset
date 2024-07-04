import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0; i<t; i++) {
            int n = sc.nextInt();
            int[] lower = new int[n];
            int[] upper = new int[n];
            int [][] solution = new int[n][n];
            for(int j=0; j<n; j++) {
                lower[j] = sc.nextInt();
                upper[j] = sc.nextInt();
            }
            for(int j=0; j<n-1; j++) {
                for(int k=j+1; k<n; k++) {
                    if((lower[j]<lower[k] && upper[j]>lower[k]) || (lower[j]>lower[k] && lower[j] < upper[k]) || (lower[j] == lower[k])) 
                        solution[j][k] = 1;
                }
            }
            System.out.print("\nCase #" + (i+1) + ": ");
            boolean impossible = false;
            String res = "";
            for(int j=0; j<n; j++) res += "C";
            for(int j=0; j<n; j++) {
                String current = "";
                if(res.charAt(j) == 'C')
                    current = "J";
                else current = "C";
                List<Integer> alist = new ArrayList<>();
                for(int k=j+1; k<n; k++) {
                    if(solution[j][k] == 1) {
                        alist.add(k);
                        res = res.substring(0,k) + current + res.substring(k+1);
                    }
                }
                for(int k=0; k<alist.size()-1; k++) {
                    for(int q=k+1; q<alist.size(); q++) {
                        if(solution[alist.get(k)][alist.get(q)] == 1) {
                            impossible = true;
                            break;
                        }
                    }
                    if(impossible) break;
                }
                if(impossible) break;
            }
            if(impossible) {
                System.out.print("IMPOSSIBLE");
            }
            else {
                System.out.print(res);
            }
        }   
    }
}