import java.util.*;
import java.lang.*;
import java.io.*;

class Solution implements Comparable<Solution> {
    
    int index;
    int start;
    int end;
    char parent;
    
    Solution(int i, int s, int e){
        index = i;
        start = s;
        end = e;
        parent = '.';
    }

    @Override
    public String toString(){
        return "Index: " + index + " Start time: " + start + " End time: " + end + " Parent: " + parent;
    }

    @Override
    public int compareTo(Solution o) {
         return (this.start - o.start);
    }
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    for(int tt = 1; tt <= t; tt++){
	        int n = sc.nextInt();
	        ArrayList<Solution> al = new ArrayList<Solution>();
	        for(int i = 0; i < n; i++){
	            int s = sc.nextInt();
	            int e = sc.nextInt();
	            Solution obj = new Solution(i, s, e);
	            al.add(obj);
	        }
	        Collections.sort(al);
	        int CbussyEndTime = 0;
	        int JbussyEndTime = 0;
	        String s = "";
	        int i = 0;
	        for(i = 0; i < al.size(); i++){
	            if(CbussyEndTime <= al.get(i).start){
	                CbussyEndTime = al.get(i).end;
	                al.get(i).parent = 'C';
	            }
	            else if(JbussyEndTime <= al.get(i).start){
	                JbussyEndTime = al.get(i).end;
	                al.get(i).parent = 'J';
	            }
	            else{
	                s = "IMPOSSIBLE";
	                break;
	            }
	        }
	        if(i == al.size()){
	            char ch[] = new char[al.size()];
	            Arrays.fill(ch, '.');
	            for(i = 0; i < al.size(); i++){
	                ch[al.get(i).index] = al.get(i).parent;
	            }
	            s = String.valueOf(ch);
	        }
	        System.out.println("Case #" + tt + ": " + s);
	    }
	}
}