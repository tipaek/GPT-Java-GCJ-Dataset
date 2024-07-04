import java.lang.*;
import java.util.*;
import java.io.*;



public class Solution{

    public static class TMPair{
	public int start;
	public int end;
	public int ind;
    }

    public class TMComparator implements Comparator<TMPair>{
	public int compare(TMPair tmp1, TMPair tmp2){
	    int retV = 0;
	    if(tmp1.start<tmp2.start){
		retV = -1;
	    }else if(tmp1.start==tmp2.start){
		if(tmp1.end<tmp2.end){
		    retV = -1;
		}else if(tmp1.end>tmp2.end){
		    retV = 1;
		}
	    }else{
		retV = 1;
	    }
	    return retV;
	}
    }

    
    static Integer[]strToIntArr(String s){
	//	s = s.substring(1,s.length()-1);
	//	String[] sArr = s.split(",");
	String[] sArr = s.split(" ");	
	int len = sArr.length;
	Integer[] retArr = new Integer[len];
	for(int i=0;i<len;i++){
	    retArr[i] = Integer.parseInt(sArr[i]);
	}
	return retArr;
    }

    public String getSchedule(int n, Vector<TMPair>startEnds){
	TMComparator tmc = new TMComparator();
	Collections.sort(startEnds,tmc);
	boolean possible = true;
	StringBuffer sb = new StringBuffer();
	int nextCFree = -1;
	int nextJFree = -1;
	for(int i=0;i<n;i++){
	    sb.append(' ');
	}
	for(int i=0;i<n;i++){
	    TMPair tp = startEnds.elementAt(i);
	    int s = tp.start;
	    int e = tp.end;
	    if(s>=nextCFree){
		nextCFree = e;
		sb.setCharAt(tp.ind,'C');
	    }else if(s>=nextJFree){
		nextJFree = e;
		sb.setCharAt(tp.ind,'J');
	    }else{
		possible = false;
		break;
	    }
	}
	String retS = "IMPOSSIBLE";
	if(possible){
	    retS = sb.toString();
	}
	return retS;
    }

    public static void main(String[]args) throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	Solution s = new Solution();
	String tLn = br.readLine();
	int t = Integer.parseInt(tLn);
	for(int i=0;i<t;i++){
	    String nLn = br.readLine();
	    int n = Integer.parseInt(nLn);
	    Vector<TMPair>startEnds = new Vector<TMPair>();
	    for(int j=0;j<n;j++){
		TMPair tp = new TMPair();
		String seLn = br.readLine();
		Integer[]seArr = strToIntArr(seLn);
		tp.start = seArr[0];
		tp.end = seArr[1];
		tp.ind = j;
		startEnds.add(tp);
	    }
	    String sched = s.getSchedule(n,startEnds);
	    String outStr = "Case #"+(i+1)+": "+sched;
	    bw.write(outStr);
	    bw.newLine();
	    bw.flush();
	}
    }

}
