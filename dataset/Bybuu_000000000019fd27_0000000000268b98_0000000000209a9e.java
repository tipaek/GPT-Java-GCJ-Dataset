import java.util.*;
import java.lang.*;
import java.io.*;
 public class Solution {
	public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
		int b = scanner.nextInt();
		int size = b/2 + b%2;
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<b;i++) sb.append(" ");
		int query = 0;
		for (int i = 0; i<t; i++) {
			Pair[] pairsArray = new Pair[size];
			System.out.println(1);
			scanner.nextInt();
			query++;
			System.out.println(1);
			query++;
			scanner.nextInt();
			Queue<Integer> myQueue = new LinkedList<Integer>();
			Pair pairSame = null;
			Pair pairDiff = null;
			for(int j=0; j<size;j++){
				if (query/10!=0){
					
					int first=j+1;
					if (first == size && size%2 == 1) {
						System.out.println(first);
						int bite = scanner.nextInt();
						pairsArray[j]=new Pair(first,false,bite);
						query++;
						break;
					}
					System.out.println(first);
					int bite = scanner.nextInt();
					query++;
					int end=b-j;
					System.out.println(end);
					int bite2 = scanner.nextInt();
					query++;
					boolean isDiff = bite != bite2 ? true: false;
					if (isDiff) {
						pairSame = new Pair(first,isDiff,bite);
					} else {
						pairDiff = new Pair(first,isDiff,bite);
					}
					pairsArray[j]=new Pair(first,isDiff,bite);
				} else {
					System.out.println(pairSame.getIndex());
					int value1 = scanner.nextInt();
					System.out.println(pairDiff.getIndex());
					int value2 = scanner.nextInt();
					int lastOp = whichChange(pairSame,pairDiff,value1,value2);
					query++;
					query++;
					myQueue.add(lastOp);
				}
			}
			int iteration = 1;
			int cur= 0;
			int operation;
			while (!myQueue.isEmpty()) {
				operation = myQueue.peek();
				cur = iteration*8;
				if (operation == 1) {
					while(cur < size) {
						pairsArray[cur].inverse();
						cur++;
					}
				} else if(operation == 2) {
					while(cur < size) {
						pairsArray[cur].inverseBit();
						cur++;
					}
				} else if(operation == 3) {
					while(cur < size) {
						pairsArray[cur].inverseBit();
						cur++;
					}
				}
			}
			String r = "N";
			String r2 = "N";
			operation = 4;
			while (r.equals("N") || r2.equals("N")) {
				Pair[] pairsArrayTemp = pairsArray;
				cur = 0;
				if (operation == 1) {
					while(cur < size) {
						pairsArrayTemp[cur].inverse();
						sb.setCharAt(cur,Character.forDigit(pairsArrayTemp[cur].getPrev(),10));
						sb.setCharAt(size - cur - 1, Character.forDigit(pairsArrayTemp[cur].getReversed(),10));
						cur++;
					}
				} else if(operation == 2) {
					while(cur < size) {
						pairsArrayTemp[cur].inverseBit();
						sb.setCharAt(cur, Character.forDigit(pairsArrayTemp[cur].getPrev(),10));
						sb.setCharAt(size - cur - 1, Character.forDigit(pairsArrayTemp[cur].getReversed(),10));
						cur++;
					}
				} else if(operation == 3) {
					while(cur < size) {
						pairsArrayTemp[cur].inverse2();
						sb.setCharAt(cur, Character.forDigit(pairsArrayTemp[cur].getPrev(),10));
						sb.setCharAt(size - cur - 1, Character.forDigit(pairsArrayTemp[cur].getReversed(),10));
						cur++;
					}
				} else {
					while(cur < size) {
						sb.setCharAt(cur, Character.forDigit(pairsArrayTemp[cur].getPrev(),10));
						sb.setCharAt(size - cur - 1, Character.forDigit(pairsArrayTemp[cur].getReversed(),10));
					}
				}
				System.out.println(sb.toString());
				r = scanner.nextLine();
				r2 = scanner.nextLine();
				operation--;
			}
			
			System.out.println("");
		}
	}
	public static int whichChange(Pair pairSame,Pair pairDiff,int value1,int value2) {
		if(pairSame!= null && pairDiff!= null) {
			if (value1 == pairSame.getPrev()) {
				int operation = value2 == pairDiff.getPrev() ? 4:1;
				pairSame.setPrev(value1);
				pairDiff.setPrev(value2);
				return operation;
			} else {
				int operation = value2 == pairDiff.getPrev() ? 3:2;
				pairSame.setPrev(value1);
				pairDiff.setPrev(value2);
				return operation;
			}
		} else if (pairDiff == null) {
			
		} else {
			
		}
		return 4;
	}
	
}

class Pair {
	int index;
	boolean diff;
	int prev;
	int sequence;
	public Pair() {
	}
	public Pair(int index, boolean diff, int prev) {
		this.index = index;
		this.prev = prev;
		this.diff = diff;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public void setDiff(boolean diff) {
		this.diff = diff;
	}
	public int getIndex() {
		return this.index;
	}
	public int getPrev() {
		return this.prev;
	}
	public boolean getDiff() {
		return this.diff;
	}
	public void inverse() {
		if(diff == true ){
			this.prev = this.prev == 0 ? 1:0; 
		}
	}
	public void inverseBit() {
		this.prev = this.prev == 0 ? 1:0; 
	}
	public void inverse2() {
		if(diff == false ){
			this.prev = this.prev == 0 ? 1:0; 
		} 
	}
	
	public int getReversed() {
		if(diff == true ){
			return this.prev == 0 ? 1:0; 
		}
		return this.prev;
	}
	
}
