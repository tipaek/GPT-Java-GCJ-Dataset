import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	    int n = Integer.parseInt(br.readLine());
	    
	    for(int i=0;i<n;i++){
	        String[] line = br.readLine().split("");
	        
	        String result = "";
	        
	        for(int j=0;j<line.length;j++){
	            if(j==0){
	            	int num = Integer.parseInt(line[j]);
	            	for(int k=0;k<num;k++) {
	            		result+="(";
	            	}
	            	
	                result+=line[j];
	                if(j==line.length-1) {
	                	for(int k=0;k<num;k++) {
		            		result+=")";
		            	}
	            	}else {
	            		int diff = num-Integer.parseInt(line[j+1]);
	            		for(int k=0;k<diff;k++) {
		            		result+=")";
		            	}
	            	}

	            }else {
	            	int num = Integer.parseInt(line[j])-Integer.parseInt(line[j-1]);

	            	for(int k=0;k<num;k++) {
	            		result+="(";
	            	}
	            	num = Integer.parseInt(line[j]);
	            	result+=line[j];
	            	if(j==line.length-1) {
	            		for(int k=0;k<num;k++) {
	            			result+=")";
	            		}
	            	}else {
	            		int diff = num-Integer.parseInt(line[j+1]);
	            		for(int k=0;k<diff;k++) {
	            			result+=")";
	            		}

	            	}
	            }
	        }
	        bw.write("Case #"+(i+1)+": "+result+"\n");
	    }
	    
	    br.close();
	    bw.close();
	}
}