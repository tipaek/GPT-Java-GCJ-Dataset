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
	            if(line[j].equalsIgnoreCase("1") && j==0){
	                result+="(";
	                result+=line[j];
	                if(j==line.length-1) {
            			result+=")";
            		}
	            }else {
	            	if(line[j].equalsIgnoreCase("1")) {
	            		if(line[j-1].equalsIgnoreCase("0")) {
	            			result+="(";
	            		}
	            		result+=line[j];
	            		if(j==line.length-1) {
	            			result+=")";
	            		}
	            	}else if(line[j].equalsIgnoreCase("0")){
	            		if(j>0 && line[j-1].equalsIgnoreCase("1")) {
	            			result+=")";
	            		}
	            		result+=line[j];
	            	}
	            }
	        }
	        bw.write("case #"+(i+1)+" "+result+"\n");
	    }
	    
	    br.close();
	    bw.close();
	}
}