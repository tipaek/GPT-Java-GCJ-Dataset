import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static class FastReader 
	{ 
		BufferedReader br; 
		StringTokenizer st; 
 
		public FastReader() 
		{ 
			br = new BufferedReader(new
					InputStreamReader(System.in)); 
		} 
 
		String next() 
		{ 
			while (st == null || !st.hasMoreElements()) 
			{ 
				try
				{ 
					st = new StringTokenizer(br.readLine()); 
				} 
				catch (IOException e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
		} 
 
		int nextInt() 
		{ 
			return Integer.parseInt(next()); 
		} 
 
		long nextLong() 
		{ 
			return Long.parseLong(next()); 
		} 
 
		double nextDouble() 
		{ 
			return Double.parseDouble(next()); 
		} 
 
		String nextLine() 
		{ 
			String str = ""; 
			try
			{ 
				str = br.readLine(); 
			} 
			catch (IOException e) 
			{ 
				e.printStackTrace(); 
			} 
			return str; 
		} 
	} 
	public static void main(String[] args) {
		FastReader fs = new FastReader();
		int i,j,k,t= fs.nextInt();
		for(i=0;i<t;i++){
			int N = fs.nextInt();
			int a[][] = new int[N][2];
			boolean overLapFlag = false;
			int low = Integer.MAX_VALUE, high=Integer.MIN_VALUE;
			for(j=0;j<N;j++){
				int st, en;
				st =fs.nextInt();
				en =fs.nextInt();
				if(st<low){
					low = st;
				}
				if(en>high){
					high=en;
				}
				a[j][0]=st;
				a[j][1]=en;
			}
			StringBuilder[] sortedArr, sArr = new StringBuilder[N];
			char out[] =new char[N];
			boolean flow[] =new boolean[N];
			int max=Integer.MIN_VALUE, maxInd=0;
			String lastPair ="";
			for(j=low;j<=high;j++){
				int overLap=-1;
				int[] ovArr = new int[2];
				for(k=0;k<N;k++){
					if(sArr[k] == null){
						sArr[k]=new StringBuilder("");
					}
					if(a[k][0]<j && a[k][1]>j){
						overLap++;
						if(overLap>1){
							overLapFlag= true;
							break;
						}
						ovArr[overLap]=k;
					}
					else if((a[k][0])<(j+0.5) && a[k][1]>(j+0.5)){
						overLap++;
						if(overLap>1){
							overLapFlag= true;
							break;
						}
						ovArr[overLap]=k;
					}
				}
				if(overLapFlag){
					break;
				}
				if(overLap!=1){
					continue;
				}
				String currPair = ""+ovArr[0]+""+ovArr[1];
				if(currPair.equals(lastPair)){
					continue;
				}
				lastPair=currPair;
				
				if(sArr[ovArr[0]].toString().equals("")){
					sArr[ovArr[0]].append(ovArr[0]).append(",").append(ovArr[1]);
				}
				else{
	    		   sArr[ovArr[0]].append(",").append(ovArr[1]);
	    	   	}
			}
			if(overLapFlag){
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
			}
			else{
				sortedArr = mergeSort(sArr, 0, sArr.length);
				for(k=0;k<sortedArr.length;k++){
					//System.out.println(k+" " +sortedArr[k].toString());
					if(sortedArr[k].toString().length()==0){
						break;
					}
					populate(out, sortedArr[k].toString().split(","),flow,'J',sArr);
				}

				for(k=0;k<N;k++){
					if(out[k]=='\u0000'){
						out[k]='C';
					}
				}
				System.out.println("Case #"+(i+1)+": "+Arrays.toString(out).replaceAll("[\\[|\\]|\\,|\\ ]", ""));
			}
		}
		
	}
	public static void populate(char out[], String[] sArr, boolean[] flow, char ch, StringBuilder[] sArr1){
		if(sArr[0].equals("")){
			return;
		}
		int s0=Integer.valueOf(sArr[0]);
		if(flow[s0]){
			return;
		}
		if(out[s0]=='\u0000'){
			out[s0]=ch;
		}
		ch = (ch == 'C')?'J':'C';
		int i;
		for(i=1;i<sArr.length;i++){
			int si=Integer.valueOf(sArr[i]);
			if(out[si]=='\u0000'){
				out[si]=ch;
			}
		}
		for(i=1;i<sArr.length;i++){
			int si=Integer.valueOf(sArr[i]);
			populate(out, sArr1[si].toString().split(","),flow,ch,sArr1);
		}
		
		
	}
	public static StringBuilder[] mergeSort(StringBuilder[] arr, int x, int y){
		if(y-x==1){
			return new StringBuilder[]{arr[x]};
		}
		int mid = (y-x)/2;
		StringBuilder A[] = mergeSort(arr, x, x+mid);
		StringBuilder B[] = mergeSort(arr, x+mid, y);
		return merge(A, B);
	}
	public static StringBuilder[] merge(StringBuilder[] arr1,StringBuilder[] arr2){
		int n1 = arr1.length;
		int n2 = arr2.length;
		StringBuilder[] outArr = new StringBuilder[n1+n2];
		int p1=0,p2=0,c=0;
		while(p1<n1 && p2<n2){
			if(arr1[p1].length() > arr2[p2].length()){
				outArr[c++]=arr1[p1++];
			}
			else{
				outArr[c++]=arr2[p2++];
			}
		}
		while(p1<n1){
			outArr[c++]=arr1[p1++];
		}
		while(p2<n2){
			outArr[c++]=arr2[p2++];
		}
		return outArr;
	}
}
