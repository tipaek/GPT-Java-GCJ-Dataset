

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;

 class Solution {
	 static class Pair{
		int start;
		int end;
		public Pair(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public String toString() {
			return "Pair [start=" + start + ", end=" + end + "]";
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCase; t++) {
			ArrayList<Pair> al=new ArrayList<ThirdQuestion.Pair>();
			ArrayList<Pair> initalOrder=new ArrayList<Pair>();
			ArrayList<Pair> c=new ArrayList<ThirdQuestion.Pair>();
			ArrayList<Pair> j=new ArrayList<ThirdQuestion.Pair>();
			ArrayList<Pair> temp=new ArrayList<ThirdQuestion.Pair>();
			int n=Integer.parseInt(br.readLine());
			for(int re=0;re<n;re++) {
			String s[]=br.readLine().split(" ");
			int start=Integer.parseInt(s[0]);
			int end =Integer.parseInt(s[1]);
			Pair p=new Pair(start,end);
			al.add(p);
			initalOrder.add(p);
			}
			al.sort(new Comparator<Pair>() {
				@Override
				public int compare(Pair o1, Pair o2) {
					// TODO Auto-generated method stub
					if(o1.end>o2.end)
					return 1;
					if(o1.end==o2.end && o2.start>o1.start) {
						return 1;
						
					}
					return -1;
				}
			});
			c.add(al.get(0));
			int i=0;
			for (int k = 1; k < n; k++) 
		    { 
		      // If this activity has start time greater than or 
		      // equal to the finish time of previously selected 
		      // activity, then select it 
		      if (al.get(k).start >= al.get(i).end) 
		      { 
		         c.add(al.get(k));
		          i = k; 
		      } 
		      else {
		    	  temp.add(al.get(k));
		      }
		    } 
			i=0;
			if(temp.size()!=0) {
				j.add(temp.get(0));
			}
			for (int k = 1; k < temp.size(); k++) 
		    { 
		      // If this activity has start time greater than or 
		      // equal to the finish time of previously selected 
		      // activity, then select it 
		      if (temp.get(k).start >= temp.get(i).end) 
		      { 
		         j.add(temp.get(k));
		          i = k; 
		      } 
		     
		    }
			StringBuilder sb=new StringBuilder("");
			if(c.size()+j.size()==initalOrder.size()) {
				for(int d=0;d<initalOrder.size();d++) {
					if(c.contains(initalOrder.get(d))){
						sb=sb.append("C");
					}
					else {
						sb=sb.append("J");
					}
				}
			}
			else {
				sb=sb.append("IMPOSSIBLE");
			}
			bw.write(""+"Case #"+(t+1)+": "+sb.toString()+"\n");
           
			
		}
		bw.flush();
	}
}
