import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		//BufferedReader bf = new BufferedReader(new FileReader("p.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int casos = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < casos; i++) {
			
			boolean[] stateC = new boolean[1441];
			boolean[] stateJ = new boolean[1441];
			StringBuilder res = new StringBuilder();
			boolean finState = true; 
			
			int act = Integer.parseInt(bf.readLine());
			ArrayList<Pair> acts = new ArrayList<Pair>();
			
			for (int j = 0; j < act; j++) {
				String[] lims = bf.readLine().split(" ");
				int li = Integer.parseInt(lims[0]);
				int ls = Integer.parseInt(lims[1]);
				acts.add(new Pair(li,ls));
			}
			
			Collections.sort(acts,new PairComparator());
			
			for (int j = 0; j < act; j++) {
				boolean signalC = false;
				boolean signalJ = false;
				Pair cA = acts.get(j); 
				
				for (int k = cA.x; k <= cA.y; k++) {
					if(stateC[k]&&(k!=cA.y)&&(k!=cA.x)) {
						signalC = true;
						for (int o = k-1; o >= cA.x; o--) stateC[o]=false;
						break;
					}else {
						stateC[k] = true;
					}
				}
				
				if(signalC) {
					
					for (int k = cA.x; k <= cA.y; k++) {
						if(stateJ[k]&&(k!=cA.y)&&(k!=cA.x)) {
							signalJ = true;
							for (int o = k-1; o >= cA.x; o--) stateC[o]=false;
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
				}else{
					finState = false;
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

class Pair{
	
	int x,y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getDif() {
		return y-x;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + "): "+(y-x);
	}
}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return o2.getDif()-o1.getDif();
    }
}

