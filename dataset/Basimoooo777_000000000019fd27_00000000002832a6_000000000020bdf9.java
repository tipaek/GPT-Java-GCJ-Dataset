import java.util.*;

class Interval implements Comparable<Interval> {
    int start;
    int end;
    char symbol;
    int index;
    
    public Interval(int start, int end, int index) {
    	this.start = start;
    	this.end = end;
    	this.index = index;
    }
    
	@Override
	public int compareTo(Interval o) {
        return this.start - o.start;
	}
}

public class Solution {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int testCasesIterator = 1;
        String result = "";
        boolean impossible = false;
        ArrayList<Interval> originalList = new ArrayList<>();
        Interval temp;
        int n = 0;
        int maxC, maxJ;
        char [] resultCharArr;
        while(testCasesIterator <= testCases) {
        	result = "";
            impossible = false;
            originalList = new ArrayList<>();
            maxC = 0;
            maxJ = 0;

            n = sc.nextInt();
            int iter = 0;
            while (iter < n) {
            	temp = new Interval(sc.nextInt(), sc.nextInt(), iter);
            	originalList.add(temp);
            	iter++;
            }
            Collections.sort(originalList);
            for (int i = 0; i < originalList.size(); i++) {
            	temp = originalList.get(i);
                if (temp.start < maxC && temp.start < maxJ) {
                	result = "IMPOSSIBLE";
                	impossible = true;
                	break;
                }
                
                if (temp.start >= maxC) {
                	originalList.get(i).symbol = 'C';
                	maxC = temp.end;
                } else if (temp.start >= maxJ) {
                	originalList.get(i).symbol = 'J';
                	maxJ = temp.end;
                }
            }
            if (! impossible) {
                resultCharArr = new char[n];
                for (Interval i : originalList) {
                	resultCharArr[i.index] = i.symbol;
                }
                result = new String(resultCharArr);
            }
        	System.out.println("Case #" + testCasesIterator + ": " + result);

            testCasesIterator ++;
        }
        sc.close();
    }
}
