import java.io.*;

class Solution {
	static PrintWriter pw;
	public static void main(String args[]) throws Exception{
	    BufferedReader stdReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(stdReader.readLine());
		for(int i = 0 ; i < T ; i++){
			int N = Integer.parseInt(stdReader.readLine());
			String[] strs = new String[N];
			int[] index = new int[N];
			boolean[] aster = new boolean[N];
			for(int j = 0 ; j < N ; j++) {
				strs[j] = stdReader.readLine();
				index[j] = strs[j].length() - 1;
			}
			boolean failed = false;
			StringBuilder sb = new StringBuilder();
			while(true) {
				char tmp = '-';
				char jakutmp = '-';
				boolean allaster = false;
				int jakutmpindex = Integer.MAX_VALUE;
				for(int j = 0 ; j < N ; j++) {
					//System.out.println(j+","+index[j]);
					if(strs[j].charAt(index[j]) != '*') {
						if(aster[j]) {
							if(index[j] < jakutmpindex) {
								jakutmpindex = index[j];
								jakutmp = strs[j].charAt(index[j]);
							}
						}else if(tmp == '-') {
							tmp = strs[j].charAt(index[j]);//input
						}else if(tmp != strs[j].charAt(index[j])) {
							//not asterisk is defeated
							if(!aster[j]) {
								failed = true;
								break;
							}
						}
					}else {
						aster[j] = true;
					}
				}
				//System.out.println(tmp);
				if(tmp == '-') {
					tmp = jakutmp;
				}
				if(tmp == '-'){
					tmp = 'A';
					allaster = true;
				}
				sb = new StringBuilder(String.valueOf(tmp)).append(sb);
				if(failed)break;
				
				for(int j = 0 ; j < N ; j++) {
					if(strs[j].charAt(index[j]) == '*') {
						if(index[j] - 1 >= 0) {
							if(strs[j].charAt(index[j] - 1) == tmp) {
								//before char look
								index[j] -= 2;
								aster[j] = false;
							}else {
								//before char is different
								index[j]--;
							}
						}else {
							//start is asterisk
							aster[j] = true;
						}
					}else if(strs[j].charAt(index[j]) == tmp){
						index[j]--;
					}else {
						if(!aster[j]) {
							failed = true;
						}
					}
				}
				//index all 0 is end
				boolean allzero = true;
				boolean end = false;
				for(int j = 0 ; j < N ; j++) {
					if(index[j] != 0) {
						allzero = false;
					}
					if(index[j] < 0) {
						end = true;
						break;
					}
				}
				if(end || (allzero && allaster))break;
				//System.out.println(sb.toString());
			}
			if(failed) {
				System.out.println("Case #"+(i+1)+": *");
			}else {
				System.out.println("Case #"+(i+1)+": "+sb.toString());
			}
		}
		stdReader.close();
	}
}
