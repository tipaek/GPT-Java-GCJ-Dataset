// package CJ1A;

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Solution {
	static boolean poss;
	static StringBuilder res ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader scn = new FastReader();
		
		int tc = scn.nextInt();
		for(int t =1;t<=tc;t++) {
			int n = scn.nextInt();
			poss = true;
			res = new StringBuilder("");
			String[] strs = new String[n];
			Node pr = new Node('.');
			Node sr = new Node('.');
			for(int i =0;i<n;i++) {
				strs[i] = scn.next();
			}
			for(int i=0;i<n;i++) {
				String s = strs[i];
				boolean sw = false;
				Node curr = pr;
				int a = -1;
				for(int j = 0;j<s.length();j++) {
					char d = s.charAt(j);
					if(s.charAt(j)=='*'&&!sw) {
						sw = true;
						a = j;
						curr = sr;
					}else if(!sw){
						if(curr.childs.containsKey(d)) {
							curr = curr.childs.get(d);	
						}else {
							Node nn = new Node(d);
							curr.childs.put(d, nn);
							curr = nn;
						}
					}else {
//						System.out.println(n+" "+j+" "+a);
						d = s.charAt(s.length()-j+a);
						if(curr.childs.containsKey(d)) {
							curr = curr.childs.get(d);	
						}else {
							Node nn = new Node(d);
							curr.childs.put(d, nn);
							curr = nn;
						}
					}
				}
			}
			
			dfs(pr, true);
			dfs(sr, false);
			if(poss) {
				System.out.println("Case #"+t+": "+res.toString());
			}else {
				System.out.println("Case #"+t+": *");
			}
		}
	}
	public static void dfs(Node node, boolean p) {
		if(node.childs.size()==0)
			return;
		if(node.childs.size()>1) {
			poss = false;
			return;
		}
		ArrayList<Character> ks = new ArrayList<Character>(node.childs.keySet());
		char d = ks.get(0);
		Node child = node.childs.get(ks.get(0));
		if(p)
			res.append(d);
		dfs(child,p);
		if(!p)
			res.append(d);
		
	}
	private static class Node{
		char ch;
		boolean eow;
		HashMap<Character, Node> childs;
		public Node(char ch) {
			this.ch = ch;
			this.eow = false;
			this.childs = new HashMap<>();
		}
	}
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
                catch (IOException  e) 
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

}
