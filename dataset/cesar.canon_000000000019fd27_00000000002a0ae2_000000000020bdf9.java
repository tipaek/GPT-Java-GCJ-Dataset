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
			
			int act = Integer.parseInt(bf.readLine());
			ArrayList<Pair> acts = new ArrayList<Pair>();
			
			for (int j = 0; j < act; j++) {
				String[] lims = bf.readLine().split(" ");
				int li = Integer.parseInt(lims[0]);
				int ls = Integer.parseInt(lims[1]);
				acts.add(new Pair(li,ls,(j+1)));
			}
			
			Collections.sort(acts,new PairComparator());
			
			int time = 0;
			
			boolean cambio = true;
			while(cambio){
				cambio = false;
				
				for (Pair pair : acts) {
					if(pair.getDone()) continue;
					if(pair.getX()<time) continue;
					pair.setDone(true);
					time = pair.getY();
					cambio = true;
					pair.setP("C");
				}
			}
			
			time = 0;
			
			boolean posible = true;
			for (Pair pair : acts) {
				if(pair.getDone()) continue;
				if(pair.getX()<time) posible=false;
				time = pair.getY();
				pair.setP("J");
			}
			
			if(posible) {
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
	boolean done;

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

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}
	
	public int getN() {
		return n;
	}
	
	public boolean getDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
	@Override
	public String toString() {
		return "(" + x + ":" + y + "): "+(y-x)+" "+done;
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
