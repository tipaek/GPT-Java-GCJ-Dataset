

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

 class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCase; t++) {
			int n=Integer.parseInt(br.readLine());
			int matrix[][]=new int[n][n];
			for(int i=0;i<n;i++) {
			String s[] = br.readLine().split(" ");
			  for(int j=0;j<n;j++) {
				  matrix[i][j]=Integer.parseInt(s[j]);
			  }
			}
			int rowCount=0;
			int colCount=0;
			long sum=0;
			for(int i=0;i<n;i++) {
				boolean flag1=true,flag2=true;
				HashSet<Integer> rows=new HashSet<Integer>();
				HashSet<Integer> cols=new HashSet<Integer>();
                
				for(int j=0;j<n;j++) {
					if(i==j)
						sum=sum+matrix[i][j];
					if(rows.contains(matrix[i][j])) {
                    	flag1=false;
                    }
                    else {
                    	rows.add(matrix[i][j]);
                    }
                    if(cols.contains(matrix[j][i])) {
                    	flag2=false;
                    }
                    else {
                    	cols.add(matrix[j][i]);
                    }
                    
				}
				if(!flag1)
					rowCount++;
				if(!flag2)
					colCount++;
			}
			bw.write(""+"Case #"+(t+1)+": "+sum+" "+rowCount+" "+colCount+"\n");
			
		}
		bw.flush();
	}
}
