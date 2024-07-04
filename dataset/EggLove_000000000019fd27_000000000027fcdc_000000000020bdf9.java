import java.util.*;
import java.io.*;

public class Solution{

	public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            solve(in, i+1);
        }
    }
    
    public static void solve(Scanner in, int num){
    	boolean possible = true;
        int n = in.nextInt();
        ArrayList<Slot> slots = new ArrayList<Slot>();
        for(int i = 1; i <= n; i++){
            slots.add(new Slot(i, in.nextInt(), in.nextInt()));
        }
        for(int i = 0; i < slots.size() - 1; i++) {
        	for(int j = i + 1; j < slots.size(); j++) {
        		if(slots.get(i).conflicts(slots.get(j))) {
        			slots.get(i).addOverlap(slots.get(j));
        			slots.get(j).addOverlap(slots.get(i));
        		}
        	}
        }
        Queue<Slot> fifo = new LinkedList<Slot>();
        for(int i = 0; i < slots.size(); i++) {
        	if(slots.get(i).owner == -1) {
        		slots.get(i).owner = 0;
        		slots.get(i).visited = true;
        		fifo.add(slots.get(0));
        		while(!fifo.isEmpty()) {
        			Slot e = fifo.poll();
        			for(Slot s : e.overlaps) {
        				if(!s.visited) {
        					s.visited = true;
        					if(e.owner == 0) {
        						s.owner = 1;
        					} else {
        						s.owner = 0;
        					}
        					fifo.add(s);
        				} else {
        					if(e.owner == s.owner) {
        						possible = false;
        						break;
        					}
        				}
        			}
        		}
        	}
        }
        
        System.out.print("Case #" + num + ": ");
        if(!possible) {
        	System.out.println("IMPOSSIBLE");
        } else {
        	for(Slot e : slots) {
        		if(e.owner == 0) {
        			System.out.print("C");
        		} else {
        			System.out.print("J");
        		}
        	}
        	System.out.println();
        }
    }
}

class Slot{
    public int number;
    public int start;
    public int end;
    public int owner;
    public boolean visited;
    public ArrayList<Slot> overlaps;
    
    Slot(int number, int start, int end){
        this.number = number;
        this.start = start;
        this.end = end;
        overlaps = new ArrayList<Slot>();
        visited = false;
        this.owner = -1;
    }
    
    public void addOverlap(Slot e) {
    	overlaps.add(e);
    }
    
    public boolean conflicts(Slot e) {
    	if((this.start < e.start && this.end > e.start) || (this.start < e.end && this.end > e.end)) {
    		return true;
    	}
    	return false;
    }
}