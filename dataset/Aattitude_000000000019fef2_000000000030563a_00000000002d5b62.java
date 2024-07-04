

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase=Integer.parseInt(br.readLine());
		HashMap<String,String> map=new HashMap<String, String>();

		map.put("1 0","E");
		map.put("3 0","EE");
		map.put("-1 0","W");
		map.put("-3 0","WW");
		
		map.put("0 1","N");
		map.put("0 -1","S");
		map.put("2 1","NE");
		map.put("4 1","SNE");
		
		map.put("2 -1","SE");
		map.put("4 -1","NSE");
		
		map.put("-2 -1","SW");
		map.put("-4 -1","NSW");
		
		map.put("-2 1","NW");
		map.put("-4 1","SNW");
		
		map.put("1 2","EN");
		map.put("3 2","WNE");
		
		map.put("1 -2","ES");
		map.put("3 -2","WSE");
		
		map.put("-1 -2","WS");
		map.put("-3 -2","ESW");
	
		map.put("-1 2","WN");
		map.put("-3 2","ENW");
		
		
		map.put("0 3","NN");
		map.put("0 -3","SS");
		map.put("2 3","SEN");
		map.put("4 3","NNE");
		
		map.put("2 -3","NES");
		map.put("4 -3","SSE");
		
		map.put("-2 -3","NWS");
		map.put("-4 -3","SSW");
		
		map.put("-2 3","SWN");
		map.put("-4 3","NNW");
	
		map.put("1 4","WEN");
		map.put("3 4","EEN");
		
		map.put("1 -4","WES");
		map.put("3 -4","EES");
		
		map.put("-1 -4","EWS");
		map.put("-3 -4","WWS");
		
		map.put("-1 4","EWN");
		map.put("-3 4","WWN");
		
		for(int t=0;t<testCase;t++) {
		String s=br.readLine();
		if(map.containsKey(s)) {
		    bw.write("Case #"+t+": "+map.get(s)+"\n");	
		}
		else {
			bw.write("Case #"+t+": IMPOSSIBLE\n");
		}
		
		}
		bw.flush();
	}
}
