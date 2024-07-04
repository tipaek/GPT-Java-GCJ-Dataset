import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = in.nextInt();
			int schedule[][] = new int[n][2];
			for(int j=0; j< n; j++) {
				schedule[j][0] = in.nextInt();
				schedule[j][1] = in.nextInt();
			}
			String result = process(schedule);
			if(result.indexOf("I") >= 0) {
				result = "IMPOSSIBLE";
			}
			System.out.println("Case #" + i + ": " + result);
		}
		System.exit(0);
	}
	
	static String process(int[][] schedule) {
		ArrayList<Slot> slots = new ArrayList<>();
		for(int i=0; i < schedule.length; i++ ) {
			slots.add(new Slot("", schedule[i][0], schedule[i][1]));
		}
		
		slots = assignSlots(slots);
		String str = "";
		
		for (Slot slot : slots) {
			str+= slot.getPerson();
		}
		
		return str;
	}
	
	static ArrayList<Slot> assignSlots(ArrayList<Slot> slots) {
		for (Slot slot : slots) {
			if(!isOverLapping("C", slot, slots)) {
				slot.setPerson("C");
			} else if(!isOverLapping("J", slot, slots)) {
				slot.setPerson("J");
			} else {
				//OVERLAPPING FOR BOTH
				slot.setPerson("I");
			}
		}
		
//		System.out.println(slots);
		return slots;
	}
	
	static boolean isOverLapping(String person, Slot s, ArrayList<Slot> slots) {
		for (Slot slot : slots) {
		if(slot.getPerson().equals(person)) {
				if( ( 
						s.getPerson().equals("") &&
						s.getStart() <  slot.getEnd() && 
						slot.getStart() < s.getEnd()
					)) {
					//OVERLAPPING
					return true;
				}
			}
		}
		return false;
	}
	
	static class Slot {
		int start;
		int end;
		String person;
		
		Slot(String person, int start, int end) {
			this.start = start;
			this.person = person;
			this.end = end;
		}
		
		public String getPerson() {
			return person;
		}

		public void setPerson(String person) {
			this.person = person;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.person + ":" + this.start + ":" + this.end;
		}
	}
}
