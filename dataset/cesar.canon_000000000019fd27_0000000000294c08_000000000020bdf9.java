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
			boolean finState = true; 
			
			int act = Integer.parseInt(bf.readLine());
			ArrayList<Pair> acts = new ArrayList<Pair>();
			
			for (int j = 0; j < act; j++) {
				String[] lims = bf.readLine().split(" ");
				int li = Integer.parseInt(lims[0]);
				int ls = Integer.parseInt(lims[1]);
				acts.add(new Pair(li,ls,(j+1)));
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
					acts.get(j).setP("C");
				}else if(!signalJ){
					acts.get(j).setP("J");
				}else{
					finState = false;
				}
				
			}
			
			if(finState) {
				Collections.sort(acts,new PairComparatorNum());
				StringBuilder res = new StringBuilder("Case #"+(i+1)+": ");
				for (Pair pair : acts) {
					res.append(pair.getP());
				}
				System.out.println(res);
			}else {
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
			}
			
			
		}
	}
}

class Pair{
	
	int x,y,n;
	String p;

	public Pair(int x, int y,int n) {
		super();
		this.x = x;
		this.y = y;
		this.n = n;
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
		return "(" + x + ":" + y + "): "+(y-x);
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}
	
	public int getN() {
		return n;
	}
}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return o1.getX()-o2.getX();
    }
}

class PairComparatorNum implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return o1.getN()-o2.getN();
    }
}
