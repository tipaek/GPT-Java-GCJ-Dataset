package playGround;

import java.util.Scanner;

public class PPR {
	static public class Node{
		Node(){
//			System.out.println("Const0 should not be enetered");
			next = null;}
		Node(int jn, int time, int se){
			this.jn = jn; this.time = time; this.se = se;
			this.next = null;
//			System.out.println("In Constructor1: "+this.jn+sp+this.time+sp+this.se);
		}
		public int jn, time, se; 
		public Node next;
//		void print() {System.out.println("jn, time, se: "+this.jn+" "+this.time+" "+this.se);}
	};
/*	
	static void printlst(Node head) {
		Node p = head;
		p.print();
		while(p.next != null) {
			p = p.next;
			p.print();
		}
	}
	*/
	static boolean f1 = false;
//	static String sp = ", ";
	
	static Node ins(Node head, Node t) {
		Node p = head;
		int d = p.se;
		if(t.time<p.time || (t.time == p.time && t.se<p.se)) {
			t.next = p;
			return t;
		}else {
			while(p.next != null && (t.time>p.next.time || 
					(t.time == p.next.time && t.se>p.next.se))) {
				p = p.next;	
				d += p.se;
			}
			t.next = p.next;
			
			p.next = t;			
			d+= t.se;
			if(d>2) {
				f1 = true;
			}
			return head;
		}
	}
	
	static boolean fc = false;
	static boolean fj = false;
//	static void fprint() {System.out.println("fc, fj: "+fc+" "+fj);};

	public static void main(String[] args) {
		Node head = null;
		Node t = null;
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			String y = "Case #" + (i+1) + ": ";
			int N = sc.nextInt();
			f1 = false;			
			//first 2 nodes
			head = new Node(0, sc.nextInt(), 1);
			t = new Node(0, sc.nextInt(), -1);
			head.next = t;
			//make list
			for(int j=1; j<N; j++) {
				t = new Node(j, sc.nextInt(), 1);
				head = ins(head, t);
				t = new Node(j, sc.nextInt(), -1);
				head = ins(head, t);
				if(f1) {
					y+="IMPOSSIBLE";
					break;
				}
			}
			//list print
//			printlst(head);
			//assign job
//			boolean fc = false;
//			boolean fj = false;
			fc = false; fj = false;
			
			int cjn = -1; int jjn = -1;
			if(!f1) {
				char[] ans = new char[N];
				fc = true; cjn = head.jn;
				
//				fprint();
				
				ans[head.jn] = 'C';
				t = head.next;
				while(t!=null) {
					if(t.se == 1) {
						if(!fc) {
							ans[t.jn] = 'C';
							fc = true; cjn = t.jn;
//							System.out.println("case 1-C");
						}
						else if(!fj) {
							ans[t.jn] = 'J';
							fj = true; jjn = t.jn;
//							System.out.println("case 1-J");
						}
					}else if(t.se == -1) {
						if(fc && cjn == t.jn) {
							fc = false; cjn = -1;
//							System.out.println("case -1-C");
						}
						if(fj && jjn == t.jn) {
							fj = false; jjn = -1;
//							System.out.println("case -1-J");
						}
					}
//					t.print();//node print
//					fprint();//print flags
					t = t.next;
				}
//				System.out.println(ans);
				y += String.valueOf(ans);
			}	
			
			System.out.println(y);
		}
		sc.close();
	}

}
