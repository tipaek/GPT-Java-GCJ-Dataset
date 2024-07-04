import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Solution {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	int n;

	String prefix[];
	String suffix[];
	String middle[];
	
	String cprefix;
	String csuffix;
	String cmiddle;
	
	boolean result;
	
	public void init() {
		prefix = null;
		suffix = null;
		middle = null;
		
		cprefix = "";
		csuffix = "";
		cmiddle = "";
	}

	public void input() throws IOException {
		n = Integer.parseInt(br.readLine());

		prefix = new String[n];
		suffix = new String[n];
		middle = new String[n];
		
		for(int i=0; i<n; ++i) {
			String temp = br.readLine();
			
			String[] items = temp.split("\\*");
			
			/*-
			System.out.println("" + items.length);
			for(String t:items) {
				System.out.print(t + " ");
			}
			System.out.println();
			*/
			
			prefix[i] = items[0];

			middle[i] = "";
			for(int j=1;j<items.length-1;++j) {
				middle[i] += items[j];
			}
			
			if(temp.endsWith("*")) {
				if(items.length!=1) {
					middle[i] += items[items.length-1];
				}
				suffix[i] = "";
			} else {
				suffix[i] = new StringBuilder(items[items.length-1]).reverse().toString();
			}			
			
			cmiddle += middle[i];
		}
	}

	public void process() {
	    for(int i = 0; i< n; ++i){
	        if(!cprefix.startsWith(prefix[i])) {
	        	if(prefix[i].startsWith(cprefix)) {
	        		cprefix = prefix[i];
	        	} else {
		            result = false;
		            return;
	        	}
	        }
	        if(!csuffix.startsWith(suffix[i])) {
	        	if(suffix[i].startsWith(csuffix)) {
	        		csuffix = suffix[i];
	        	} else {
		            result = false;
		            return;
	        	}
	        }
	    }
	    result=true;
	}

	public void output() throws IOException {
	    if(result){
	    	bw.write(cprefix + cmiddle + new StringBuilder(csuffix).reverse().toString()+"\n");
	    }
	    else {
	    	bw.write("*\n");	    
	    }
		bw.flush();
	}

	public void run() throws NumberFormatException, IOException {
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; ++i) {
			init();
			input();
			process();
			
			bw.write("Case #"+(i+1) +": ");
			output();
		}
	}

	public static void main(String args[]) throws NumberFormatException, IOException {
		Solution m = new Solution();
		m.run();
	}
}

