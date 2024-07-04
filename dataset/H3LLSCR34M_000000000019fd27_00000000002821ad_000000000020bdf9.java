import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));  
    int t = in.nextInt();
    String[] arr = new String[t];
    for(int w = 0;w<t;w++) {
    	int u = in.nextInt();
    	List<Integer> start = new ArrayList<>();
    	List<Integer> end = new ArrayList<>();
    	for(int q = 0;q<u;q++) {
    		start.add(in.nextInt());
    		end.add(in.nextInt());
    	}
    	List<Integer> Ostart = new ArrayList<>(start);
    	
    	for(int i = 0;i<u;i++) {
    		int min = Integer.MAX_VALUE;
    		int index = 0;
    		for(int j = i;j<u;j++) {
    			if(min>start.get(j)) {
    				index = j;
    				min = start.get(j);
    			}
    		}
    		int temp = start.get(i);
    		start.set(i, min);
    		start.set(index, temp);    
    		int temp1 = end.get(i);
    		end.set(i, end.get(index));
    		end.set(index, temp1);    		
    	}
    	String res = "";
    	List<Integer> cStart = new ArrayList<>();
    	List<Integer> cEnd = new ArrayList<>();
    	List<Integer> jStart = new ArrayList<>();
    	List<Integer> jEnd = new ArrayList<>();
		char[] rest = new char[u];
    	for(int i = 0;i<u;i++) {
    		int st = start.get(i);
    		int ed = end.get(i);
    		boolean cdone = true;
    		boolean jdone = true;

    		for(int a = 0;a<cStart.size()&&cdone;a++) {
    			if((ed>cStart.get(a))&&st<cEnd.get(a)) {
    				cdone = false;
    			}
    		}
    		if(cdone) {
    			cStart.add(st);
    			cEnd.add(ed);
    			rest[Ostart.indexOf(st)]='C';
    			continue;
    		}
    		for(int a = 0;a<jStart.size()&&jdone;a++) {
    			if((ed>jStart.get(a))&&st<jEnd.get(a)) {
    				jdone = false;
    			}
    		}
			if(jdone) {
    			jStart.add(st);
    			jEnd.add(ed);
    			rest[Ostart.indexOf(st)]='J';
    			continue;
			}
    		if(!cdone && !jdone) {
    			res = "IMPOSSIBLE";
    			break;
    		}
    	}
    	for(char ch:rest)
    		res+=ch;
    	arr[w] = "Case #"+(w+1)+": "+res;
    }
    in.close();
    for(String s:arr)
    	System.out.println(s);
  }
}