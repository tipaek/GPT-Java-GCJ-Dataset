import java.util.*;
import java.io.*;
import java.lang.Math;
	
class sol{
public static void main(String[] args) {
boolean debugging = false;
Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
int tcase = in.nextInt();
for (int i = 1; i <= tcase; ++i) {
int[][] masterS = new int[1440][2];
boolean impossible = false;
	
int wo = in.nextInt();
int[][] answer = new int[wo][2];
int actcount = 0;
int[][] actList = new int[wo][3];
for (int j = 0; j < wo; j++) {
actList[j][0] = in.nextInt();
actList[j][1] = in.nextInt();
actList[j][2] = actcount++;
if (debugging) {
System.out.println("" + actList[j][0] + " " + actList[j][1]);
}
}
Arrays.sort(actList, new java.util.Comparator<int[]>() {
public int compare(int[] p, int[] q) {
return Integer.compare(p[0], q[0]);
}
	});
for (int j = 0; j < wo; j++) {
int sTime = actList[j][0];
int eTime = actList[j][1];
int actRef = actList[j][2];
boolean cAva = true;
boolean jAva = true;
for (int k = sTime; k < eTime; k++) {
if (masterS[k][0] == 1) {
cAva = false;
}
}
	
	
if (cAva) {
for (int k = sTime; k < eTime; k++) {
masterS[k][0] = 1;
}
	
answer[j] = new int[] {actRef, 1};
} else {
for (int k = sTime; k < eTime; k++) {
if (masterS[k][1] == 1) {
jAva = false;
}
}
	
if (jAva) {
for (int k = sTime; k < eTime; k++) {
masterS[k][1] = 1;
}
answer[j] = new int[] {actRef, 2};
} else {
impossible = true;
}
}
}
	
String ans = "";
if (impossible) {
ans = "IMPOSSIBLE";
} else {
Arrays.sort(answer, new java.util.Comparator<int[]>() {
public int compare(int[] p, int[] q) {
return Integer.compare(p[0], q[0]);
}
});
	for (int j = 0; j < answer.length; j++) {
if (answer[j][1] == 1) {
ans += "C";
} else if (answer[j][1] == 2) {
ans += "J";
}
}
}
	
System.out.println("Case #" + i + ": " + ans);
}
}
}