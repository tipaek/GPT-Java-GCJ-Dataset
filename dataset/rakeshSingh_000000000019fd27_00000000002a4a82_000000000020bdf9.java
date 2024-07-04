import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		int caseN=1;
		
		while(t-->0){
	       
			StringTokenizer st;
			
			
			boolean isJamieBusy[]=new boolean[1441];
			boolean isCameronBusy[]=new boolean[1441];
			
			
			int n=Integer.parseInt(br.readLine());
			int[][] matrix=new int[n][2];
			int[][] matrixSorted=matrix.clone();
			char couple = 'J';
			
			char output[]=new char[n];
			Stack<int[]> JamieWorkStack=new Stack<>();
			Stack<int[]> CameronWorkStack=new Stack<>();
			
			boolean isImpossible=false;
			
			
			Map<int[],Integer> map=new HashMap<>();
			
			for(int i=0;i<matrix.length;i++){
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<matrix[i].length;j++){
					matrix[i][j]=Integer.parseInt(st.nextToken());
				}
				
				map.put(matrix[i],i);
			}
			
			
			sort(matrixSorted);
			
			
	      for(int i=0;i<matrixSorted.length;i++){
	    	  output[map.get(matrixSorted[i])]=couple;
	    	  
	    	  if(i<matrixSorted.length-1 && isLap(matrixSorted[i], matrixSorted[i+1])){
	    		  if(couple=='J'){
	    			  JamieWorkStack.push(matrixSorted[i]);
	    			  couple=changePerson(couple);
	    			  
	    			  if(!CameronWorkStack.isEmpty() && isLap(CameronWorkStack.peek(),matrixSorted[i+1])){
	    				  isImpossible=true;
	    				  break;
	    			  }
	    		  }else{
	    			  CameronWorkStack.push(matrixSorted[i]);
	    			  couple=changePerson(couple);
	    			  
	    			  if(!JamieWorkStack.isEmpty() && isLap(JamieWorkStack.peek(), matrixSorted[i+1])){
	    				  isImpossible=true;
	    				  break;
	    			  }
	    		  }
	    	  }else{
	    		  if(couple=='J'){
	    			  JamieWorkStack.push(matrixSorted[i]);
	    		  }else{
	    			  CameronWorkStack.push(matrixSorted[i]);
	    		  }
	    	  }
	      }
			
		    if(isImpossible){
		    	out.println("Case #"+(caseN++)+": "+"IMPOSSIBLE");
		    }else{
		    	out.println("Case #"+(caseN++)+": "+new String(output));
		    }
		   		    //caseN++;
			
		}
		out.flush();
		out.close();
		

	}
	
	private static void sort(int[][] matrixSorted) {
		// TODO Auto-generated method stub
		Arrays.sort(matrixSorted,new Comparator<int[]>() {
			@Override
			public int compare(int[] a,int[] b){
				return a[0]-b[0];
			}
			
			});
		
	}

	static char changePerson(char p){
		return p=='J'?'C':'J';
	}
	
	static boolean isLap(int[] a,int[] b){
		return a[1]>b[0];
	}

}
