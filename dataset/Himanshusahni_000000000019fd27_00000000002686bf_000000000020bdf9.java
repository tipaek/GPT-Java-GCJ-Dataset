import java.io.*;
import java.util.*;
public class Solution{
	public static String printShedule(int arr[][]){
		if(arr.length == 0)
			return "";
		if(arr.length == 1)
			return "C";
		//Sorting the array based on the start time
		Arrays.sort(arr, new Comparator<int[]>() { 
          @Override              
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
            if (entry1[0] > entry2[0]) 
                return 1; 
            else
                return -1; 
          } 
        }); 
        int cs,ce,ps = arr[0][0], pe = arr[0][1],p2s = -1,p2e = -1;
        int assigned = 1;
        String ans = "C";
		for(int i = 1;i<arr.length;i++){
			cs = arr[i][0];
			ce = arr[i][1];
			if(pe <= cs){
				assigned = 1;
				ans = ans +"C";
				ps = cs;
				pe = ce;	
			}else{
				 if(assigned == 1){
				}else if(assigned == 2){
					if(p2e>cs){
						return "IMPOSSIBLE";
					}
				}
				char c =  ans.charAt(ans.length()-1) == 'C' ? 'J' : 'C';
			 		ans = ans + c+"";
					assigned = 2;
					p2s = ps;
			 		p2e = pe;
			 		ps = cs;
					pe = ce;
			}

		}
		return ans;
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int i = 1;i<=testCase;i++){
			int N = Integer.parseInt(br.readLine());
			int arr[][] = new int[N][2];
			for(int j = 0;j<N;j++){
				String s[] = br.readLine().split(" ");
				arr[j][0] = Integer.parseInt(s[0]); 
				arr[j][1] = Integer.parseInt(s[1]);
			}
			System.out.println("Case #"+i+": "+printShedule(arr));
			
		}
	}

}