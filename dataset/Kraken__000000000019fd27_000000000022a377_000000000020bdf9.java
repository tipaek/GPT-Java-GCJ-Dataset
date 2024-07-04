import java.util.Comparator;
import java.util.TreeSet;
import java.util.Scanner; 

public class Solution  implements Comparator<int[]> {

public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String s = scanner.nextLine();
	int T=Integer.parseInt(s);
	for (int i = 1; i <= T; i++) {
	    TreeSet<int[]> tr=new TreeSet<int[]>(new Solution());
		s = scanner.nextLine();
		int N=Integer.parseInt(s);
		for (int j = 0; j < N; j++) {
		    s = scanner.nextLine();
		    String[] tok=s.split(" ");
		    int[] ar=new int[]{Integer.parseInt(tok[0]),
		        Integer.parseInt(tok[1]),j};
		    tr.add(ar);
		}
		int[][] els=tr.toArray(new int[][]{});
		char[] ar=new char[N];
		int C=-1, S=-1;
		for (int j = 0; j < N; j++) {
		    if (els[j][0]>=C) { C=els[j][1]; ar[els[j][2]]='C';}
		    else if (els[j][0]>=S) { S=els[j][1]; ar[els[j][2]]='J';}
		    else {C=-2; break;}
		}
		if (C==-2) s="IMPOSSIBLE";
		else { s="";
		    for (int j = 0; j < N; j++) s+=ar[j];
		}
		System.out.println("Case #"+i+": "+ s);
	}
	scanner.close();		
}

@Override
public int compare(int[] o1, int[] o2) {
	if (o1.length>o2.length) return 1;
	if (o1.length<o2.length) return -1;
	for (int i = 0; i < o2.length; i++) {
		if (o1[i]>o2[i]) return 1;
		if (o1[i]<o2[i]) return -1;
	}
	return 0;
}
}