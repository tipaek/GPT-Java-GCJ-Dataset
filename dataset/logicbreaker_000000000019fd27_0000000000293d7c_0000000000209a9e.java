import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Solution {
	public static void main(String [] args) throws IOException {
solve();
}
	
	
	
	
	
public static void solve() throws IOException {
Scanner sc = new Scanner(System.in);
int t= sc.nextInt();
int B=sc.nextInt();
StringBuilder sb = new StringBuilder("");
for(int i=0;i<t;i++) {
	for(int j=1;j<=B+1;j++) {
		sb.append(sc.nextLine()+"");
	}
	System.out.println(sb);
	String s= sc.nextLine();
	sb=new StringBuilder("");
	if(s.contains("Y")) {
		continue;
	}else {
		System.out.println("Ento 7omar");
		break;
	}
}
}


}