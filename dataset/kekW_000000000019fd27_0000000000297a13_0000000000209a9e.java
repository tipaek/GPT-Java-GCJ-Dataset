import java.io.*;
import java.util.*;
public class Solution{
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int b = sc.nextInt();
    int tot = t;
    int useless;
    boolean solve = false;
    int query;
    boolean bad = false;
    int a = 1;
    int[] sol = new int[b+1];
    boolean good[] = new boolean[b+1];
    goodloop:while(t-->0) {
    	if(bad) {
    		break;
    	}
    	Arrays.fill(sol, -1);
    	query = 1;
    	ArrayList<Integer> same = new ArrayList<>();
    	ArrayList<Integer> diff = new ArrayList<>();
    	boolean change1 = false;
    	boolean change2 = false;
    	while(a==1) {
    		if(same.size()>0) {
    			System.out.println(same.get(0));
    			System.out.flush();
    			useless=sc.nextInt();
    			if(useless!=sol[same.get(0)]) {
    				change1=true;
    			}
    		}else {
    			System.out.println(1);
    			System.out.flush();
    			useless=sc.nextInt();
    		}
    		if(diff.size()>0) {
    			System.out.println(diff.get(0));
    			System.out.flush();
    			useless=sc.nextInt();
    			if(useless!=sol[diff.get(0)]) {
    				change2=true;
    			}
    		}else {
    			System.out.println(1);
    			System.out.flush();
    			useless=sc.nextInt();
    		}
    		if(change1) {
    			for(int i:same) {
    				if(sol[i]==1) sol[i]=0;
    				else if(sol[i]==0) sol[i]=1;
    			}
    		}
    		if(change2) {
    			for(int i:diff) {
    				if(sol[i]==1) sol[i]=0;
    				else if(sol[i]==0) sol[i]=1;
    			}
    		}
    		for(int i=query; i<query+4; i++) {
    			if(sol[i]!=-1) {
    				print(sol);
    				String f = sc.next();
    				if(f.equals("N")) bad = true;
    				continue goodloop;
    			}
    			System.out.println(i);
    			System.out.flush();
    			int k1 = sc.nextInt();
    			System.out.println(b-i+1);
    			System.out.flush();
    			int k2 = sc.nextInt();
    			if(k1==k2) {
    				same.add(i);
    				same.add(b-i+1);
    			}
    			if(k1!=k2) {
    				diff.add(i);
    				diff.add(b-i+1);
    			}
    			sol[i] = k1;
    			sol[b-i+1] = k2;
    		}
    		query+=4;
    		change1 = false;
    		change2 = false;
    	}
    }
    sc.close();
  }
  public static void print(int arr[]) {
	  String k = "";
	  for(int i=1; i<arr.length;i++) {
		  k = k+arr[i];
	  }
	  System.out.println(k);
	  System.out.flush();
  }
}