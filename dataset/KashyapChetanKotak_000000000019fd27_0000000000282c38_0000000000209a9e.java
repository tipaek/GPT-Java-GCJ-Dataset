import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int B = sc.nextInt();
		int count=0;
		for (int tc = 1; tc <= T; tc++) {
			
			ArrayList<Integer> lH = new ArrayList<Integer>(Collections.nCopies(B/2+1, 9));
			ArrayList<Boolean> rHR = new ArrayList<Boolean>(Collections.nCopies(B/2+1, false));// true=same;false=different
			int sameInd = -1, diffInd = -1;

			for (int i = 1; i <= B/2-2; i++) {
				//System.out.println("==");// remove
				System.out.println(i);
				int fHi = Integer.parseInt(sc.next());
				if(i>((B/2)-10)) {
					//System.out.println("add in Fh");
					lH.set(i,fHi);
				}
				System.out.println(B-i+1);
				int sHi = Integer.parseInt(sc.next());
				if (fHi == sHi) {
					rHR.set(i,true);
					sameInd = i;
				} else {
					rHR.set(i,false);
					diffInd = i;
				}
			}
			count=(B/2-2)*2;
			//System.out.println("========");
			if((sameInd==-1 || diffInd==-1) || (sameInd>((B/2)-10) && diffInd>((B/2)-10))) { // all are different or both pivots are in last 10
				//System.out.println("first");
				System.out.println(B/2-1);
				int fHi = Integer.parseInt(sc.next());
				//System.out.println("add in Fh");
				lH.set(B/2-1,fHi);
				System.out.println(B-(B/2-2));
				int sHi = Integer.parseInt(sc.next());
				if (fHi == sHi) {
					rHR.set(B/2-1,true);
					sameInd = B/2-1;
				} else {
					rHR.set(B/2-1,false);
					diffInd = B/2-1;
				}
				System.out.println(B/2);
				fHi = Integer.parseInt(sc.next());
				//System.out.println("add in Fh");
				lH.set(B/2,fHi);
				System.out.println(B-(B/2-1));
				sHi = Integer.parseInt(sc.next());
				if (fHi == sHi) {
					rHR.set(B/2,true);
					sameInd = B/2;
				} else {
					rHR.set(B/2,false);
					diffInd = B/2;
				}
				count=count+4;
			} else { // both pivots present and either of pivot outside last 10  
				if(sameInd>((B/2)-10) || diffInd>((B/2)-10)) {
					//System.out.println("second");
					System.out.println(B/2-1);
					int fHi = Integer.parseInt(sc.next());
					//System.out.println("add in Fh");
					lH.set(B/2-1,fHi);
					System.out.println(B-(B/2-2));
					int sHi = Integer.parseInt(sc.next());
					if (fHi == sHi) {
						rHR.set(B/2-1,true);
						sameInd = B/2-1;
					} else {
						rHR.set(B/2-1,false);
						diffInd = B/2-1;
					}
					count=count+2;
				}
				if(sameInd<=((B/2)-10)) {
					//System.out.println("third");
					System.out.println(sameInd);
					int fHi = Integer.parseInt(sc.next());
					System.out.println(sameInd);
					fHi = Integer.parseInt(sc.next());
					//System.out.println("add in Fh");
					lH.set(sameInd,fHi);
					count=count+2;
				} else if(diffInd<=((B/2)-10)) {
					//System.out.println("fourth");
					System.out.println(diffInd);
					int fHi = Integer.parseInt(sc.next());
					System.out.println(diffInd);
					fHi = Integer.parseInt(sc.next());
					//System.out.println("add in Fh");
					lH.set(diffInd,fHi);
					count=count+2;
				}
				
			}
//			System.out.println("queries till now:"+count);
//			System.out.println(lH);
//			System.out.println(rHR);
//			System.out.println("________________________________________");
//			
//			System.out.println("sameInd:"+sameInd);
//			System.out.println("diffInd:"+diffInd);
//			compArray(lH);
//			System.out.println(lH);
			
			
			if(sameInd==-1) {
				arrayWithOnePivot(lH, rHR, diffInd, sc);
			} else if(diffInd==-1) {
				arrayWithOnePivot(lH, rHR, sameInd, sc);
			} else {
				arrayWithTwoPivot(lH, rHR, sameInd, diffInd, sc);
			}
			
			System.out.flush();	
			String resultResponse = sc.next();
// 			if (resultResponse.equals("N")) {
// 				break;
// 			}
			
			count=0;	
		} // tc end
	}// main end
	
	public static int comp(int x,boolean flag) {
		if(flag && x==0)
			return 1;
		else if(flag && x==1)
			return 0;
		return x;
	}
	
	public static void revArray(ArrayList<Integer> lH, ArrayList<Boolean> rHR) {
		for(int i=1;i<lH.size();i++) {
			if(rHR.get(i)==false)
				lH.set(i,comp(lH.get(i),true));
		}
	}
	
	public static void compArray(ArrayList<Integer> lH) {
		for(int i=1;i<lH.size();i++) {
			lH.set(i,comp(lH.get(i),true));
		}
	}
	
	public static void arrayWithOnePivot(ArrayList<Integer> lH, ArrayList<Boolean> rHR, int pivotInd, Scanner sc) {
		int prevPivotVal=lH.get(pivotInd);
		int queryCounter=0;
		for(int i=1;i<lH.size();i++) {
			if(queryCounter%10==0) {
				System.out.println(pivotInd);
				queryCounter++;
				int newPivotVal = Integer.parseInt(sc.next());
				if(prevPivotVal!=newPivotVal) {
					compArray(lH);
				}
				prevPivotVal=newPivotVal;
				continue;
			}
			if(lH.get(i)==9) {
				System.out.println(i);
				queryCounter++;
				lH.set(i,Integer.parseInt(sc.next()));
			}
		}
		printArr(lH, rHR);
	}
	
	public static void arrayWithTwoPivot(ArrayList<Integer> lH, ArrayList<Boolean> rHR, int sameInd, int diffInd, Scanner sc) {
		int prevSameInd=lH.get(sameInd);
		int prevDiffInd=lH.get(diffInd);
		int queryCounter=0;
		for(int i=1;i<lH.size();i++) {
			if(queryCounter%10==0) {
				System.out.println(sameInd);
				queryCounter++;
				int newSameInd = Integer.parseInt(sc.next());
				System.out.println(diffInd);
				queryCounter++;
				int newDiffInd = Integer.parseInt(sc.next());
				if(prevSameInd==newSameInd && prevDiffInd!=newDiffInd) {
					revArray(lH,rHR);
				} else if(prevSameInd!=newSameInd && prevDiffInd!=newDiffInd) {
					compArray(lH);
				} else if(prevSameInd!=newSameInd && prevDiffInd==newDiffInd) {
					revArray(lH,rHR);
					compArray(lH);
				}
				prevSameInd=newSameInd;
				prevDiffInd=newDiffInd;
				continue;
			}
			if(lH.get(i)==9) {
				System.out.println(i);
				queryCounter++;
				lH.set(i,Integer.parseInt(sc.next()));
			}
		}
		printArr(lH, rHR);
	}
	
	public static void printArr(ArrayList<Integer> lH, ArrayList<Boolean> rHR){
		//System.out.println("printing");
		int totSize=(lH.size()*2)-2;
		//System.out.println("total size:"+totSize);
		char[] chars = new char[totSize+1];
		Arrays.fill(chars,'*');
		StringBuilder result=new StringBuilder(String.copyValueOf(chars));
		
		for (int i = 1; i <= totSize/2; i++) {
			//System.out.println(i);
			result.setCharAt(i, Character.forDigit(lH.get(i),10));
			int rHbit=comp(lH.get(i),!rHR.get(i));
			result.setCharAt(totSize-i+1, Character.forDigit(rHbit,10));
		}
		
		System.out.println(result.toString().replace("*",""));
		
	}

}
