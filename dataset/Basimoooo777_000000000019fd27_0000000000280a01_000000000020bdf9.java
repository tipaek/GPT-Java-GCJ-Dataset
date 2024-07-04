import java.util.*;

class Interval implements Comparable<Interval> {
    int start;
    int end;
    
    public Interval(int start, int end) {
    	this.start = start;
    	this.end = end;
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
        HashMap<Interval, Character> outputMap = new HashMap<>();
        ArrayList<Interval> myList = new ArrayList<>();
        ArrayList<Interval> sortedList = new ArrayList<>();
        Interval temp;
        int n = 0;
        int maxC, maxJ;
        while(testCasesIterator <= testCases) {
        	result = "";
            impossible = false;
            outputMap = new HashMap<>();
            myList = new ArrayList<>();
            sortedList = new ArrayList<>();
            maxC = 0;
            maxJ = 0;

            n = sc.nextInt();
            while (n -- > 0) {
            	temp = new Interval(sc.nextInt(), sc.nextInt());
            	myList.add(temp);
            	sortedList.add(temp);
            }
            Collections.sort(sortedList);
            for (int i = 0; i < sortedList.size(); i ++) {
            	temp = sortedList.get(i);
                if (temp.start < maxC && temp.start < maxJ) {
                	result = "IMPOSSIBLE";
                	impossible = true;
                	break;
                }
                
                if (temp.start >= maxC) {
                	outputMap.put(temp, 'C');
                	maxC = temp.end;
                } else if (temp.start >= maxJ) {
                	outputMap.put(temp, 'J');
                	maxJ = temp.end;
                }
            }
            if (! impossible) {
            	result = "";
                for (Interval i : myList) {
                	result += outputMap.get(i);
                }
            }
        	System.out.println("Case #" + testCasesIterator + ": " + result);

            testCasesIterator ++;
        }
        sc.close();
    }
}
