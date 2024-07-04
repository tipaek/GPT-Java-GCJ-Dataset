
import java.io.BufferedReader;
import java.io.InputStreamReader;




import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;




import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

//package kickstartA20;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.PriorityQueue;
//import java.util.Scanner;
//
//
//public class zc {
//	public static void main(String[] args) {
//		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//		long t = s.nextLong();
//		int j = 1;
//		while (t-- > 0) {
//			int n = s.nextInt();
//			int k = s.nextInt();
//			int[] arr = new int[n];
//			int[] ans = new int[n-1];
//			for(int i = 0 ; i < n ; i++) {
//				arr[i] = s.nextInt();
//				if(i>=1) {
//					ans[i-1]=arr[i] - arr[i-1];
//				}
//			}
//			Arrays.sort(ans);
//			
//			int rv = ans[ans.length-1];
//			ans[ans.length-1] = (rv/2 + (rv%2));
//			Arrays.sort(ans);
//
//		       System.out.println("Case #"+j+": "+ans[ans.length-1]);
//
//	}
//}
//}
public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		long fgsdgs = s.nextLong();
		int pint = 1;
		while (fgsdgs-- > 0) {
			int n = s.nextInt();
			String[] ar = new String[n];
			String srfgesrge5gresrhgdeg = "";
		
			
			
			
			
			String aserfaetfewaftewa = "";
			boolean fin_ans = true;
			for (int i = 0; i < n; i++) {
				String sdzgesrgedgserf = s.next();
			
				
				
				
				
				
				String aefewfvswgfDFESFSZD = "";
				String asgfwaergvsrge = "";
				int saefawegvesdgwefw = 0;
				for (saefawegvesdgwefw = 0; saefawegvesdgwefw < sdzgesrgedgserf.length(); saefawegvesdgwefw++) {
					if (sdzgesrgedgserf.charAt(saefawegvesdgwefw) == '*') {
						break;
					}
					aefewfvswgfDFESFSZD += sdzgesrgedgserf.charAt(saefawegvesdgwefw);
				}
				saefawegvesdgwefw++;
			
				
				
				
				asgfwaergvsrge = sdzgesrgedgserf.substring(saefawegvesdgwefw);
				boolean lans = alkfdjjasgjafasdgdsadg(aefewfvswgfDFESFSZD, srfgesrge5gresrhgdeg);
				if(lans) {
					if(aefewfvswgfDFESFSZD.length() > srfgesrge5gresrhgdeg.length())
						srfgesrge5gresrhgdeg = aefewfvswgfDFESFSZD;
				}
		
				
				
				
				
				
				
				
				
				boolean rans = eraefwgeagrgsdvertat4wtgesdgs(aserfaetfewaftewa,asgfwaergvsrge );
				if(rans) {
					if(asgfwaergvsrge.length() > aserfaetfewaftewa.length())
						aserfaetfewaftewa = asgfwaergvsrge ;
				}
				if(!lans || !rans) {
					
					fin_ans = false;
				}
				
			}
			System.out.print("Case #"+pint+": ");
			pint++;
			if(fin_ans) {
				
				System.out.println(srfgesrge5gresrhgdeg+aserfaetfewaftewa);
			}else {
				System.out.println("*");
				
			}
		}
	}
public static boolean alkfdjjasgjafasdgdsadg(String a , String b) {
	int i = 0 ;
	int j = 0 ;
	while(i < a.length() && j < b.length()) {
		if(a.charAt(i) != b.charAt(j))
			return false;
		i++;
		j++;
		
	}
	return true;
}







//package kickstartA20;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.PriorityQueue;
//import java.util.Scanner;
//
//
//public class zc {
//	public static void main(String[] args) {
//		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//		long t = s.nextLong();
//		int j = 1;
//		while (t-- > 0) {
//			int n = s.nextInt();
//			int k = s.nextInt();
//			int[] arr = new int[n];
//			int[] ans = new int[n-1];
//			



//for(int i = 0 ; i < n ; i++) {
//				arr[i] = s.nextInt();
//				if(i>=1) {
//					ans[i-1]=arr[i] - arr[i-1];
//				}
//			}
//			Arrays.sort(ans);
//			
//			int rv = ans[ans.length-1];
//			ans[ans.length-1] = (rv/2 + (rv%2));
//			Arrays.sort(ans);
//
//		       System.out.println("Case #"+j+": "+ans[ans.length-1]);
//
//	}
//}
//}














public static boolean eraefwgeagrgsdvertat4wtgesdgs(String a , String b) {
	int i = a.length()-1 ;
	int j = b.length()-1 ;
	while(i >=0  && j >=0 ) {
		if(a.charAt(i) != b.charAt(j))
			return false;
		i--;
		j--;
		
	}
	return true;
}
}



