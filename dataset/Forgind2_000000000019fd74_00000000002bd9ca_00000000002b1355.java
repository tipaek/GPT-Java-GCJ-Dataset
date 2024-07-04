import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int z = in.nextInt();
		in.nextLine();
		for (int y = 1; y <= z; y++) {
			String[] input = in.nextLine().trim().split(" ");
			int r = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);
			List list = new List();
			int total = 0;
			Dancer[] row = new Dancer[c];
			for (int a = 0; a < r; a++) {
				input = in.nextLine().trim().split(" ");
				Dancer last = null;
				for (int b = 0; b < c; b++) {
					Dancer d = new Dancer(Integer.parseInt(input[b]));
					d.east = last;
					if (last != null)
						last.west = d;
					last = d;
					d.north = row[b];
					if (row[b] != null)
						row[b].south = d;
					row[b] = d;
					list.add(d);
					total += list.head.d.skill;
				}
			}
			int interest = total;
			int change = list.dance();
			while (change > 0) {
				total -= change;
				interest += total;
				change = list.dance();
			}
			System.out.println("Case #" + y + ": " + interest);
		}
		in.close();
	}
	
	private static class Node {
		private Dancer d;
		private Node prev;
		private Node next;
		public Node(Dancer k) {
			d = k;
			next = null;
			prev = null;
		}
	}
	
	private static class List {
		private Node head;
		private int size;
		public List() {
			head = null;
		}
		private void add(Dancer d) {
			Node n = new Node(d);
			n.next = head;
			if (head != null)
				head.prev = n;
			head = n;
		}
		private int dance() {
			int loss = 0;
			for (Node n = head; n != null; n = n.next)
				n.d.dance();
			for (Node n = head; n != null; n = n.next)
				if (n.d.eliminated) {
					if (n.prev != null)
						n.prev.next = n.next;
					else
						head = n.next;
					if (n.next != null)
						n.next.prev = n.prev;
					loss += n.d.skill;
				}
				else {
					Dancer d = n.d;
					while (d.north != null && d.north.eliminated)
						d.north = d.north.north;
					while (d.south != null && d.south.eliminated)
						d.south = d.south.south;
					while (d.east != null && d.east.eliminated)
						d.east = d.east.east;
					while (d.west != null && d.west.eliminated)
						d.west = d.west.west;
				}
			return loss;
		}
	}
	
	private static class Dancer {
		private int skill;
		private Dancer north;
		private Dancer south;
		private Dancer east;
		private Dancer west;
		private boolean eliminated;
		
		public Dancer(int a) {
			skill = a;
			eliminated = false;
		}
		
		public void dance() {
			int count = 0;
			int total = 0;
			if (north != null) {
				count++;
				total += north.skill;
			}
			if (south != null) {
				count++;
				total += south.skill;
			}
			if (east != null) {
				count++;
				total += east.skill;
			}
			if (west != null) {
				count++;
				total += west.skill;
			}
			if (skill * count < total) {
				eliminated = true;
			}
		}
	}
}
