    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= t; ++i) {
          
          int m = in.nextInt();
          //System.out.println("M "+m);
          int arr[][] = new int[m][2];
          HashMap<String, Integer> map = new HashMap<String, Integer>();
          for(int j=0;j<m;j++)
          {
            
                arr[j][0] = in.nextInt();
                arr[j][1] = in.nextInt();
                map.put(arr[j][0]+"-"+arr[j][1], j);
          }
          Arrays.sort(arr, new Comparator<int[]>() { 
              
              @Override              
              // Compare values according to columns 
              public int compare(final int[] entry1,  
                                 final int[] entry2) { 
      
                // To sort in descending order revert  
                // the '>' Operator 
                if (entry1[0] > entry2[0]) 
                    return 1; 
                  else  if (entry1[0] == entry2[0])
                      return 0;
                else
                    return -1; 
              } 
            });
          //sb.append("Start\n");
          	 Stack<String> stackA = new Stack<String>();
          	Stack<String> stackB = new Stack<String>();
          	char [] result = new char[m];
          	String answer = "";
	          for(int[] interval : arr)
	          {
	        	  String val = interval[0]+"-"+interval[1];
	        	  if(stackA.isEmpty())
	        	  {
	        		  stackA.push(val);
	        		  result[map.get(val)]='C';
	        	  }
	        	  
	        	  else
	        	  {
	        		  String topA = stackA.peek();
	        		  
	        		  int endA = Integer.parseInt(topA.split("-")[1]);
	        		  if(interval[0]>=endA)
	        		  {
	        			  stackA.push(val);
	        			  result[map.get(val)]='C';
	        		  }
	        		  else
	        		  {
	        			  if(stackB.isEmpty())
	        			  {
	        				  stackB.push(val);
	        				  result[map.get(val)]='J';
	        			  }
	        			  else
	        			  {
	        				  String topB = stackB.peek();
			        		  //int start = Integer.parseInt(topB.split("-")[0]);
			        		  int end = Integer.parseInt(topB.split("-")[1]);
			        		  if(interval[0]>=end)
			        		  {
			        			  stackB.push(val);
			        			  result[map.get(val)]='J';
			        		  }
			        		  else
			        		  {
			        			  answer = "Case #"+i+": IMPOSSIBLE";
			        			  break;
			        		  }
	        			   }
	        			  
	        		  }
	        		  
	        	  }
	          }
	          if(answer.isEmpty())
	        	  answer = "Case #"+i+": "+String.valueOf(result);
	          sb.append(answer);
	          if(i!=t)
	        	  sb.append("\n");
	          
           }
        System.out.print(sb.toString());
      }
    }