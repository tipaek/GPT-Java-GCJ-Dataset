import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;




public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case<= T; test_case++) {
			int N = sc.nextInt();
			int[][] S = new int[N][2];
			String answer = "";
			char[] ans = new char[N];
	        LinkedList<HashSet> same = new LinkedList<HashSet>();
	        LinkedList<HashSet> diff = new LinkedList<HashSet>();
	        boolean impossible = false;
			LinkedList<int[]> three = new LinkedList<int[]>();
			LinkedList<int[]> two = new LinkedList<int[]>();
			for(int i = 0; i < N; i++) {
				S[i][0] = sc.nextInt();
				S[i][1] = sc.nextInt();
			}
			for(int i = 0; i < N; i++) {
//				System.out.println("!!"+i);
				int[] curr_work = S[i];
				int worker_num = 1;
				int total_overlap = 1;
				LinkedList<Integer> overlap_work = new LinkedList<Integer>();
				for(int j = 0 ; j<N; j++) {
					if(j != i) {
						
						int[] cmp_work = S[j];
						if((S[j][0]>=S[i][0]&&S[j][0]<S[i][1]) || (S[j][1]>S[i][0]&&S[j][1]<=S[i][1])) {
							worker_num++;
							overlap_work.add(j);
						}
					}
				}
				if(worker_num >3) {
					answer = "IMPOSSIBLE";
					impossible = true;
				}
				else if(worker_num == 3) {
					int[] work1 = S[overlap_work.get(0)];
					int[] work2 = S[overlap_work.get(1)];
					if(work1[1] <= work2[0] || work1[0] >= work2[1]) {
						int[] arr = new int[3];
						arr[0] = i;
						arr[1] = overlap_work.get(0);
						arr[2] = overlap_work.get(1);
						three.add(arr);
						
					}
//					else if(work1[1] < work2[0] ) {
//					}
					else {
						answer = "IMPOSSIBLE";
						impossible = true;
//						System.out.println("worker num = 3");
					}
				}
				else if(worker_num == 2) {
					int[] arr = new int[2];
					arr[0] = i;
					arr[1] = overlap_work.get(0);
					two.add(arr);
				}
				if(!three.isEmpty()) {
					for(int j = 0; j< three.size();j++) {
						int[] arr = three.get(j);
//						System.out.println(arr[0]);
						HashSet<Integer> h1 = new HashSet<Integer>();
						h1.add(arr[1]);
						h1.add(arr[2]);
						HashSet<Integer> h2 = new HashSet<Integer>();
						h2.add(arr[0]);
						h2.add(arr[1]);
						HashSet<Integer> h3 = new HashSet<Integer>();
						h3.add(arr[0]);
						h3.add(arr[2]);
						same.add(h1);
						diff.add(h2);
						diff.add(h3);
					}
				}
				if(!two.isEmpty()) {
					for(int j=0; j<two.size(); j++) {
						int[] arr = two.get(j);
						HashSet<Integer> h1 = new HashSet<Integer>();
						h1.add(arr[0]);
						h1.add(arr[1]);
						diff.add(h1);
					}
				}
				if(!impossible) {
					ans[0] = 'C';
					for(int j=0;j<N;j++) {
						if(!same.isEmpty()) {
							for(int k=0;k<same.size();k++) {
								HashSet<Integer> set = same.get(k);
								if(set.contains(j)) {
								Iterator<Integer> it = set.iterator(); 
									while (it.hasNext()) { 
										int next = it.next();
										if(next != j) {
//											
											if(ans[j] == 0){
												ans[j] ='S';
												ans[next] = 'S';
											}
//											else if(ans[j] =='0'||ans[j]=='1') {
//												ans[next] = ans[j];
//											}
											else {
												ans[next] = ans[j];
											}
											
										}
									}
								}
							}
						}
						if(!diff.isEmpty()) {
							for(int k=0;k<diff.size();k++) {
								HashSet<Integer> set = diff.get(k);
								if(set.contains(j)) {
								Iterator<Integer> it = set.iterator(); 
									while (it.hasNext()) { 
//										
										int next = it.next();
										if(next != j) {
											if(ans[j] == 0) {
												ans[j] = '0';
												ans[next] = '1';
//												System.out.println("print");
											}
										    else if(ans[j] =='C' ) {
												ans[next] = 'J';
											}
											else if(ans[j] =='J') {
												ans[next] = 'C';
											}
											else if(ans[j] == 'S') {
												ans[next] = 'D';
											}
											else if(ans[j] == 'D') {
												ans[next] = 'S';
											}
											else if(ans[j] == '0'){
												ans[next] = '1';
//												System.out.println("else");
											}
											else if(ans[j] == '1') {
												ans[next] = '0';
											}
											
										}
									}
								}
							}
						}
						
					}
					
				}
			}
			if(!impossible) {
//				System.out.println("size"+ans.length);
				for(char c : ans) {
					if((int)c==0) {
//						System.out.println("@@");
						answer = answer + 'C';
					}
//					else if(c == 'C') {
//						answer = answer + 'C';
//					}
					else if(c == 'C' || c =='J') {
						answer = answer + c;
					}
					else {
						if(c == 'S') {
							answer = answer + 'C';
						}
						if(c == 'D') {
							answer = answer + 'J';
						}
						if(c == '0') {
							answer = answer + 'C';
						}
						if(c == '1') {
							answer = answer + 'J';
						}
					}
//					System.out.println(answer);
				}
			}
			System.out.println("Case #"+ test_case +": "+ answer);
		}
		sc.close();
	}
}