    import java.util.*;
    import java.io.*;
    
    public class Solution {
      public static void main(String[] args){
    		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    		int t = scan.nextInt();
    		for(int i=0;i<t;i++){
    		    int x = scan.nextInt();
    		    int y = scan.nextInt();
    		    int x2 = x+4;
    		    int y2 = Math.abs(y-4);
    		    String[][] s = {{"IMPOSSIBLE","WWN","IMPOSSIBLE","EWN","IMPOSSIBLE","WEN","IMPOSSIBLE","EEN","IMPOSSIBLE"},
    {"NNW","IMPOSSIBLE","SWN","IMPOSSIBLE","NN","IMPOSSIBLE","SEN","IMPOSSIBLE","NNE"},
    {"IMPOSSIBLE","ENW","IMPOSSIBLE","WN","IMPOSSIBLE","EN","IMPOSSIBLE","WNE","IMPOSSIBLE"},
    {"SNW","IMPOSSIBLE","NW","IMPOSSIBLE","N","IMPOSSIBLE","NE","IMPOSSIBLE","SNE"},
    {"IMPOSSIBLE","WW","IMPOSSIBLE","W","IMPOSSIBLE","E","IMPOSSIBLE","EE","IMPOSSIBLE"},
    {"NSW","IMPOSSIBLE","SW","IMPOSSIBLE","S","IMPOSSIBLE","SE","IMPOSSIBLE","NSE"},
    {"IMPOSSIBLE","ESW","IMPOSSIBLE","WS","IMPOSSIBLE","ES","IMPOSSIBLE","WSE","IMPOSSIBLE"},
    {"SSW","IMPOSSIBLE","NWS","IMPOSSIBLE","SS","IMPOSSIBLE","NES","IMPOSSIBLE","SSE"},
    {"IMPOSSIBLE","WWS","IMPOSSIBLE","EWS","IMPOSSIBLE","WES","IMPOSSIBLE","EES","IMPOSSIBLE"}
    };
    		    if((x2<=8 && x2>=0) && (y2<=8 && y2>=0)){
    		        System.out.println("Case #"+(i+1)+": "+s[y2][x2]);
    		    }else{
    		         System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
    		    }
    		}
    	
    }
    }