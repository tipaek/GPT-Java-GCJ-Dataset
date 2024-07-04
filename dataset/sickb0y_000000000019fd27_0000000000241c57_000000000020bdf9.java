import java.util.*;
import java.io.*;

public class Solution{
	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader (System.in));
		int no_test;
		String notest;
		notest = input.readLine();
		String[] tem;
		if(notest == null)
			return;
		no_test = Integer.parseInt(notest);
		int k=0;
		while(k < no_test){
			String NN = input.readLine();
			int N = Integer.parseInt(NN);
			int[] start = new int[N];
			int[] dub = new int[N];
			int[] end = new int[N];
			int[] index = new int[N];
			for(int i =0; i < N;i++){
				NN = input.readLine();
				tem = NN.split(" ");
				start[i] = Integer.parseInt(tem[0]);
				dub[i] = Integer.parseInt(tem[0]);
				end[i] = Integer.parseInt(tem[1]);
				index[i] = i;
			}
			for (int i = 0; i < N-1; i++){
            	int min_idx = i;
            	for (int j = i+1; j < N; j++){
            		if (dub[j] < dub[min_idx])
                    	min_idx = j;
            		else if(dub[j] == dub[min_idx]){
            			if(end[j] > end[min_idx])
            				min_idx = j;
            		}
            	}
            int temp = dub[min_idx];
            dub[min_idx] = dub[i];
            dub[i] = temp;
            temp = index[min_idx];
            index[min_idx] = index[i];
            index[i] = temp;
        	}
			int C = 0;
			int J = 0;
			int flag = 0;
			char[] value = new char[N];
			value[index[0]] = 'C';
			value[index[1]] = 'J';
			C = end[index[0]];
			J = end[index[1]];
			for(int i=2;i<N;i++){
				if(start[index[i]] < C && start[index[i]] < J){
					System.out.println("Case #"+Integer.toString(k+1) + ": IMPOSSIBLE");
					k++;
					flag = 1;
					break;
				}
				if(start[index[i]] >= C){
					C = end[index[i]];
					value[index[i]] = 'C';
				}
				else if(start[index[i]] >= J){
					J = end[index[i]];
					value[index[i]] = 'J';
				}
			}
			if(flag == 1){
				continue;
			}
			String ans = "";
			for(int i=0;i<N;i++)
				ans += Character.toString(value[i]);
			System.out.println("Case #"+Integer.toString(k+1) + ": "+ans);
			k++;
		}
	}
}