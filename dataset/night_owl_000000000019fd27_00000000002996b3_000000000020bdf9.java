
import java.util.*;

class Solution {
	public static void main(String args[]){
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    int testCase = 1,n;
	    List<Pair> pairs;
	    for ( ; testCase <= testCases; testCase++){
	    	pairs = new ArrayList<>();
	        n = sc.nextInt();
	        for(int i=0;i<n;i++) {
	        	pairs.add(getPair(i, sc));
	        }
	        sortOnFirstElement(pairs);
	        assingnPossiblePairsToC(pairs);
	        boolean succeded = canWeAssignAllOthersToJ(pairs);
	        printIfWeCanAssign(pairs, succeded, testCase);
	    }
    }

	private static Pair getPair(int i, Scanner sc) {
		Pair pair = new Pair();
    	pair.x= sc.nextInt();
    	pair.y= sc.nextInt();
    	pair.index = i;
    	pair.assingnedTo = null;
    	return pair;
	}

	private static void printIfWeCanAssign(List<Pair> pairs, boolean succeded, int testCase) {

        if(!succeded) {
        	System.out.println("Case #" + testCase + ": IMPOSSIBLE");
        	return;
        }
        sortOnIndex(pairs);
        StringBuilder sb = new StringBuilder();
        for(Pair pair:pairs) {
        	sb.append(pair.assingnedTo);
        }
        System.out.println("Case #" + testCase +": "+ sb.toString());
	}

	private static boolean canWeAssignAllOthersToJ(List<Pair> pairs) {
		int previousEndIndex = 0;
        for(Pair pair: pairs) {
        	if(pair.assingnedTo == null) {
        		if(pair.x >= previousEndIndex) {
        			previousEndIndex = pair.y;
        			pair.assingnedTo = new String("J");
        		} else {
        			return false;
        		}
        	}
        }
        return true;
	}

	private static void assingnPossiblePairsToC(List<Pair> pairs) {
		int previousEndIndex = 0;
        for(Pair pair:pairs) {
        	if(pair.x >= previousEndIndex) {
        		previousEndIndex = pair.y;
        		pair.assingnedTo = new String("C");
        	}
        }
	}

	private static void sortOnIndex(List<Pair> pairs) {
		Collections.sort(pairs, new Comparator<Pair>() {
        	public int compare(Pair p1, Pair p2) {
        		return p1.index - p2.index;
        	}
        });
	}

	private static void sortOnFirstElement(List<Pair> pairs) {
		Collections.sort(pairs, new Comparator<Pair>() {
        	public int compare(Pair p1, Pair p2) {
        		return p1.x - p2.x;
        	}
        });
	}
}

class Pair {
	public int x;
	public int y;
	public String assingnedTo;
	public int index;
}