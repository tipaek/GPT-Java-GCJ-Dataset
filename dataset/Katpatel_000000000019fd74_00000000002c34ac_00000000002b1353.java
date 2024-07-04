import java.util.*;

class Solution{
	static HashMap<Integer,HashMap<Integer,Integer>> val; 
	static HashMap<Integer,HashMap<Integer,HashSet<Integer>>> vis;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int test= sc.nextInt();
		for(int t=1;t<=test;t++){
			int target=sc.nextInt();
			val= new HashMap();
			vis = new HashMap();
			System.out.println("Case #"+t+":");
			Queue<node>  q  = new LinkedList();
			q.add(new node(1,1,null));
			if(target==1) {
				System.out.println("1 1");
				continue;
			}
			while(q.size()>0){
				node a = q.poll();
				ArrayList<node> peer = nextp(a.r,a.k,a);
				boolean flag=false;
				for(node p : peer){
					if(a.visited.containsKey(p.r) && a.visited.get(p.r).contains(p.k)) continue;
					if(p.pSum>target) continue;
					if(vis.get(p.r)==null) vis.put(p.r, new HashMap());
					if(vis.get(p.r).get(p.k)==null) vis.get(p.r).put(p.k, new HashSet());
					if(vis.get(p.r).get(p.k).contains(p.pSum))continue;
					else vis.get(p.r).get(p.k).add(p.pSum);
					if(p.pSum==target) {
						traverseBack(p,0);
						flag=true;
						break;
					}
					if(p.sum.contains(p.pSum-target)){
						traverseBack(p,p.pSum-target);
						flag=true;
						break;
					}
					q.add(p);
				}
				if(flag)break;
			}
		}
	}
	public static void traverseBack(node p,int sum){
		if(p==null || p.pSum==sum) return;
		System.out.println((p.r+1) + " " + (p.k+1));
		traverseBack(p.parent,sum-p.val);
	}
	 //(ri - 1, ki - 1), (ri - 1, ki), (ri, ki - 1), (ri, ki + 1), (ri + 1, ki), (ri + 1, ki + 1)
	public static ArrayList<node> nextp(int r, int k, node parent){
		ArrayList<node> p = new ArrayList();
		if(r-1 > 0) {
			if(k-1>0)p.add(new node(r-1,k-1,parent));
			 p.add(new node(r-1,k,parent));
		}
		if(k-1>0) p.add(new node(r,k-1,parent));
		if(k+1<=r) p.add(new node(r,k+1,parent));
		p.add(new node(r+1,k,parent));
		p.add(new node(r+1,k+1,parent));
		return p;
	}
	public static int cal(int r, int k){
		if(val.get(r)==null || val.get(r).get(k)==null){
			int n=r;
			long sum=1;
			while(n>=(r-k+1)) sum*=(n--);
			int i=k;
			while(i>1) sum/=(i--);
			if(val.get(r)==null) val.put(r, new HashMap());
			val.get(r).put(k, (int) sum);
		}
		return val.get(r).get(k);
	}
	static class node{
		HashSet<Integer> sum = new HashSet<Integer>();
		HashMap<Integer,HashSet> visited;
		int r;
		int k;
		int val;
		int pSum;
		node parent=null;
		node(int r, int k, node parent){
			this.r=r;
			this.k=k;
			this.parent=parent;
			val = cal(r,k);
			if(parent!=null){
				sum.addAll(parent.sum);
				visited = (HashMap<Integer, HashSet>) parent.visited.clone();
				pSum=parent.pSum+val;
			}else{
				visited = new HashMap();
				pSum=val;
			}
			if(visited.get(r)==null)visited.put(r,new HashSet());
			visited.get(r).add(k);
			sum.add(pSum);
		}
	}
}