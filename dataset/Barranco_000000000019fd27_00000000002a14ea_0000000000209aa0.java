import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution {
	
	public static List<Integer> getDiagonal (VirtualVertex v){
		List<Integer> res = new ArrayList<>();
		if(v.getFather().getIndex().equals(0)) {
			res.add(v.getIndex());
			
		}
		else {
			res.add(v.getIndex());
			res.addAll(getDiagonal(v.getFather()));
		}
		return res;
	}
	
	
	
	 

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		int ncases = 1;
		while(ncases <= cases) {
			
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			Integer[] numbers = new Integer[n];
			
			for (int x= 1; x<=n; x++) {
				numbers[x-1]=x;
			}
			
			VirtualVertex v = new VirtualVertex(0,0,null,0);
			
			List<VirtualVertex> ls = new ArrayList<>();
			List<VirtualVertex> visited = new ArrayList<>();
			List<VirtualVertex> goals = new ArrayList<>();
			ls.add(v);
			boolean good = false;
			while(true) {
				VirtualVertex vertex = ls.remove(0);
				if(!visited.contains(vertex)) {
					
					if(vertex.getNumber()==k && vertex.getDistance()==n) {
						Set<Integer> st = new HashSet<>(getDiagonal(vertex));
						if (st.size()==1) {
						goals.add(vertex);
						break;}
					
					}
					if(vertex.getDistance()>k){
						break;
					}
				List<VirtualVertex> hijos = vertex.getNeighbor(numbers);
				
				ls.addAll(hijos);
				visited.add(vertex);
				}
				
			}
			if(goals.isEmpty())
				System.out.println("Case #"+ ncases +": IMPOSSIBLE");
			
			else {
				List<Integer> numss = Arrays.asList(numbers);
				String ss = "";
				for(VirtualVertex goal: goals) {
				List<Integer> diagonal = getDiagonal(goal);
				
				Set<Integer> dSet = new HashSet<>(diagonal);
				if(dSet.size()==1) {
					int j = 0;
						String s = "";
						for (int i= 0; i<n; i++) {
							
							
						s += String.valueOf((numss.get((numss.indexOf(diagonal.get(0))+i)%n)));
						
						
//						System.out.println(i);
						}
						
						for (int i= 0; i<n; i++) {
							
							String st = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
							s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
							ss += st;
							if(i+1!=n)
								ss += "\n";
							
						}
						
					good = true;
					break;
					
				}
				
				
				
				
				
				
				
				}
				if(!good)
					System.out.println("Case #"+ ncases +": IMPOSSIBLE");
				else
					System.out.println("Case #"+ ncases +": POSSIBLE");
				for(int i=0; i<ss.length(); i++) {
					System.out.print(ss.substring(i,i+1));
					if(i+1!=ss.length() && !ss.substring(i,i+1).equals("\n"))
						System.out.print(" ");
				}
				
			}
			ncases++;
		}

	}
	
	

}

class VirtualVertex{
	
	private Integer number;
	private Integer distance;
	private VirtualVertex father;
	private Integer index;
	
	
	public VirtualVertex(Integer number, Integer distance, VirtualVertex father,Integer index) {
		super();
		this.number = number;
		this.distance = distance;
		this.index = index;
		this.father = father;
		
	}
	
	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public VirtualVertex getFather() {
		return father;
	}
	public void setFather(VirtualVertex father) {
		this.father = father;
	}
	
	public List<VirtualVertex> getNeighbor(Integer[]numbers){
		
		List<VirtualVertex> res = new ArrayList<>();
		
		for(int i= 1; i<=numbers.length; i++) {
			res.add(new VirtualVertex(this.number+i,this.distance+1,this,i));	
		}
		
		return res;
		
	}
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((father == null) ? 0 : father.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VirtualVertex other = (VirtualVertex) obj;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (father == null) {
			if (other.father != null)
				return false;
		} else if (!father.equals(other.father))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VirtualVertex [number=" + number + ", distance=" + distance + ", index=" + index + ", father=" + father
				+ "]";
	}
	
}

class Graph{
	
	private int v;
	private ArrayList<Integer> [] adj;
	
	

	@SuppressWarnings("unchecked")
	Graph (int v){
		adj = new ArrayList[v];
		for (int i=0; i<v; i++) {
			adj[i] = new ArrayList<Integer>();

		}
	}
	
	void addEdge (int v, int w) {
		adj[w-1].add(v-1);
		adj[v-1].add(w-1);
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public ArrayList<Integer>[] getAdj() {
		return adj;
	}

	public void setAdj(ArrayList<Integer>[] adj) {
		this.adj = adj;
	}
	
	
}


