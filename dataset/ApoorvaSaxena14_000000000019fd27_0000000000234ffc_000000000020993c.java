import java.util.HashSet;
import java.util.Scanner;

class Solution {
 public static void main(String[] args) {
 HashSet<Integer> setR ;
 HashSet<Integer> setC ;

 Scanner in = new Scanner(System.in);
 int n = in.nextInt();

 for (int tests = 1; tests <= n; tests++) {
 int m = in.nextInt();
 int a[][] = new int[m][m];

 for (int p = 0; p < m; p++) {
 for (int q = 0; q < m; q++) {
 a[p][q] = in.nextInt();
 }
 }
 int sumD = 0, countR = 0, countC = 0;

 for (int i = 0; i < a.length; i++) {
 setR = new HashSet<>();
 setC = new HashSet<>();
 for (int j = 0; j < a[0].length; j++) {
 if (setR.contains(a[i][j])) {
 countR++;
 }
 if (setC.contains(a[j][i])) {
 countC++;
 }
 if (i == j) {
 sumD += a[i][j];
 }
 setR.add(a[i][j]);
 setC.add(a[j][i]);
 }
 }
 System.out.printf("Case #%d: %d %d %d\n", tests, sumD, countR, countC);
 }
 }
}