import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st=new StringTokenizer(br.readLine());
			int t=Integer.parseInt(st.nextToken());
			
			for(int k=0;k<t;k++)
			{  
				
				
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
			    	System.out.println("Case #"+(k+1)+": "+"IMPOSSIBLE");
			    }else{
			    	System.out.println("Case #"+(k+1)+": "+new String(output));
			    }
			   		    //caseN++;
				
			}
		
			

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
