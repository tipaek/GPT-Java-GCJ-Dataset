import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		//BufferedReader bf = new BufferedReader(new FileReader("p.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int casos = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < casos; i++) {
			
			boolean[] stateC = new boolean[1441];
			boolean[] stateJ = new boolean[1441];
			StringBuilder res = new StringBuilder();
			boolean[] auxC;
			boolean[] auxJ;
			boolean finState = true; 
			
			int act = Integer.parseInt(bf.readLine());
			
			for (int j = 0; j < act; j++) {
				String[] lims = bf.readLine().split(" ");
				int li = Integer.parseInt(lims[0]);
				int ls = Integer.parseInt(lims[1]);
				boolean signalC = false;
				boolean signalJ = false;
				
				for (int k = li; k < ls; k++) {
					if(stateC[k]) {
						signalC = true;
						for (int o = li; o < ls; o++) stateC[o] = false;
						break;
					}else {
						stateC[k] = true;
					}
				}
				
				if(signalC) {
					
					for (int k = li; k < ls; k++) {
						if(stateJ[k]) {
							signalJ = true;
							for (int o = li; o < ls; o++) stateJ[o] = false;
							break;
						}else {
							stateJ[k] = true;
						}
					}
					
				}
				
				if(!signalC){
					res.append("C");
				}else if(!signalJ){
					res.append("J");
				}else if(signalC&&signalJ) {
					finState = false;
				}else {
					res.append("x");
				}
				
			}
			
			if(finState) {
				System.out.println("Case #"+(i+1)+": "+res);
			}else {
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
			}
			
			
		}
	}
}
