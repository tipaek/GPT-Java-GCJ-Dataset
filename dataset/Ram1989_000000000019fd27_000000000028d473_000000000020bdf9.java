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
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    if((lower[j]<lower[k] && upper[j]>lower[k]) || (lower[j]>lower[k] && lower[j] < upper[k]) || (lower[j] == lower[k])) 
                        solution[j][k] = 1;
                }
            }
            System.out.print("Case #" + (i+1) + ": ");
            String res = "C";
            String current = "C";
            String reverse = "J";
            boolean impossible = false;
            for(int j=0; j<n; j++) {
                List<Integer> alist = new ArrayList<>();
                for(int k=j+1; k<n; k++) {
                    if(k == j+1) {
                        if(solution[j][k] != 1) res += current;
                        else {
                            String temp = reverse;
                            res += temp;
                            reverse = current;
                            current = temp;
                        }
                    }
                    if(solution[j][k] == 1) alist.add(k);
                }
                for(int k=0; k<alist.size(); k++) {
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
                System.out.println("IMPOSSIBLE");
            }
            else System.out.println(res);
        }   
    }
}