import java.util.Scanner;
import java.util.*;

public class Vestigium {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int totalTestCases=in.nextInt();
		int count=0;
		while(count<totalTestCases) {
			count++;
			int N=in.nextInt();
			int trace=0;
			Set<Integer> rowCountSet=new HashSet<Integer>();
			Set<Integer> colCountSet=new HashSet<Integer>();
			Set<Integer>[] rowArrSet=new Set[N];
			Set<Integer>[] colArrSet=new Set[N];
			for(int i=0; i<N; i++) {
				rowArrSet[i]=new HashSet<Integer>();
				colArrSet[i]=new HashSet<Integer>();
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int cur=in.nextInt();
					if(i==j) trace+=cur;
					if(!rowArrSet[i].add(cur)) rowCountSet.add(i);
					if(!colArrSet[j].add(cur)) colCountSet.add(j);
				}
			}
			
			System.out.println("Case #"+count+": "+trace+" "+rowCountSet.size()+" "+colCountSet.size());
		}
	}
}