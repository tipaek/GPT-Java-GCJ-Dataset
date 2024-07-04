import java.util.HashSet;
import java.util.Scanner;

class Solution {
 public static void main(String[] args) {
 HashSet<Integer> setR ;
 HashSet<Integer> setC ;

 Scanner in = new Scanner(System.in);
 int sumD = 0, countR = 0, countC = 0;
 int n = in.nextInt();

 for (int tests = 1; tests <= n; tests++) {
 int m = in.nextInt();
 int a[][] = new int[m][m];

 for (int p = 0; p < m; p++) {
 for (int q = 0; q < m; q++) {
 a[p][q] = in.nextInt();
 if(p==q){
 sumD+= a[p][q];}
 }
 }
 

 for (int i = 0; i < a.length; i++) {
 setR = new HashSet<>();
 setC = new HashSet<>();
 boolean continuR = false, continuC = false;
 for (int j = 0; j < a[0].length; j++) {
 if (setR.contains(a[i][j]) && !continuR) {
 countR++;
 continuR = true;
 
 }
 if (setC.contains(a[j][i]) && !continuC) {
 countC++;
 continuC = true;
 }
 
 setR.add(a[i][j]);
 setC.add(a[j][i]);
 if(continuC && continuR){
     break;
 }
 }
 }
 System.out.printf("Case #%d: %d %d %d\n", tests, sumD, countR, countC);
 }
 }
}