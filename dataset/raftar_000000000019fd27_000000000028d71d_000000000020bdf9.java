import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<Integer, Integer> hmm = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> hmmm = new HashMap<Integer, Integer>();
		int T = in.nextInt();
		int a = 0;
		int b = 0;
		int[] arr = new int[1441];
		int[] arr2 = new int[1441];
		int[] arr3 = new int[1000];
		int[] arr4 = new int[1000];
		int jfree = -1;
		int cfree = -1;
		int temp = 0;
		StringBuilder answerStr = new StringBuilder(); 
		int flag = 0;
		for(int i=1; i<=T; i++) {
		    jfree = -1;
		    cfree = -1;
			hm = new HashMap<Integer, String>();
			hmm = new HashMap<Integer, Integer>();
			hmmm = new HashMap<Integer, Integer>();
			flag = 0;
			temp = 0;
			answerStr = new StringBuilder();
			for(int j=0; j<1441; j++) {
				arr[j] = 0;
				arr2[j] = 0;
			}
			int N =  in.nextInt();
			for(int j=0; j<N; j++) {
				a =  in.nextInt();
				b =  in.nextInt();
				arr3[j] = a;
				if(hmm.get(a) == null){
				    hmm.put(a, b);
				}
				else{
				    hmmm.put(a, b);
				}
				arr[a]++;
				arr2[b]--;
			}
			for(int j=0; j<=1440; j++) {
				temp = temp + arr[j] + arr2[j];
				if(temp > 2) {
					flag = 1;
					System.out.print("Case #"+ i + ": IMPOSSIBLE" + "\n");
					break;
				}
				else if(arr[j] == 1) {
					if(jfree <= j) {
						hm.put(j, "J");
						jfree = hmm.get(j);
					}
					else if(cfree <= j) {
						hm.put(j, "C");
						cfree = hmm.get(j);
					}
				}
				else if(arr[j] == 2){
				    if(jfree <= j && cfree <= j) {
						hm.put(j, "J");
						jfree = hmm.get(j);
						cfree = hmmm.get(j);
					}
				}
			}
			if(flag == 0) {
				for(int j=0; j<N; j++) {
				    if(hmmm.get(arr3[j]) == null){
					    answerStr.append(hm.get(arr3[j]));
				    }
				    else{
				        if(hm.get(arr3[j]) != null){
				            answerStr.append('J');
				            hm.put(arr3[j], null);
				        }
				        else{
				            answerStr.append('C');
				        }
				    }
				}
				System.out.print("Case #"+ i + ": " + answerStr.toString()+ "\n");
			}
		}
	}
}
