import java.util.*;

class Solution {
	
//	public static String recur(int x, int y, int i, String s, int objX, int objY) {
//		String res = "";
//		System.out.println(x + " - " + y);
//		if(x>objX && objX>0)
//			return "IMPOSSIBLE";
//
//		else if(y>objY && objY>0)
//			return "IMPOSSIBLE";
//		
//		else if(y<objY && objY<0)
//			return "IMPOSSIBLE";
//		
////		else if(objX<=0 && (int)Math.pow(2, i)>-objX+x)
////			return "IMPOSSIBLE";
////		else if(objY<=0 && (int)Math.pow(2, i)>-objY+y)
////			return "IMPOSSIBLE";
////		else if(objX>=0 && (int)Math.pow(2, i)>objX+x)
////			return "IMPOSSIBLE";
////		else if(objY>=0 && (int)Math.pow(2, i)>objY+y)
////			return "IMPOSSIBLE";
//		else if(objX==x && objY==y)
//			return s;
//		else {
//			
//			res = recur((int)(x+Math.pow(2, i)),y,i+1,new String(s+"N"),objX,objY);
//			
//			
//			return res;
//			
//		}
//		
//		
//	}
	
	public static void main (String[]args) {
		
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int ncase = 1;
		while(ncase<=cases) {
			Integer x = sc.nextInt()+1000;
			Integer y = sc.nextInt()+1000;
			
			
//			System.out.println(recur(0, 0, 0, "",x,y));
			

			
			boolean[][] visited = new boolean[8000][8000];
			
			Queue<VirtualGraph> cola = new LinkedList<>();
			
			cola.add(new VirtualGraph(1000,1000,0,""));
			String result = "IMPOSSIBLE";
			while(!cola.isEmpty()) {
				VirtualGraph vertex = cola.poll();
				if(!visited[vertex.getX()][vertex.getY()]) {
					if(vertex.getI()<=7) {
						cola.addAll(vertex.getNeighbor());
						if(vertex.getX().equals(x) && vertex.getY().equals(y)) {
							result = vertex.getResult();
							break;
						}
				}
				visited[vertex.getX()][vertex.getY()]=true;
			}
			
		}
			System.out.println("Case #"+ncase+": "+result);
			ncase++;
		}
		sc.close();
	}

}


class VirtualGraph{
	
	private Integer x;
	private Integer y;
	private Integer i;
	private String result;
	
	
	public Integer getX() {
		return x;
	}


	public void setX(Integer x) {
		this.x = x;
	}


	public Integer getY() {
		return y;
	}


	public void setY(Integer y) {
		this.y = y;
	}


	public Integer getI() {
		return i;
	}


	public void setI(Integer i) {
		this.i = i;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public VirtualGraph(Integer x, Integer y, Integer i,String result) {
		super();
		this.x = x;
		this.y = y;
		this.i = i;
		this.result=result;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((i == null) ? 0 : i.hashCode());
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
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
		VirtualGraph other = (VirtualGraph) obj;
		if (i == null) {
			if (other.i != null)
				return false;
		} else if (!i.equals(other.i))
			return false;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}


	public List<VirtualGraph> getNeighbor(){
		List<VirtualGraph> lista = new ArrayList<>();
		
		lista.add(new VirtualGraph(x+(int)Math.pow(2, i),y,i+1,result+"E"));
		lista.add(new VirtualGraph(x-(int)Math.pow(2, i),y,i+1,result+"W"));
		lista.add(new VirtualGraph(x,y+(int)Math.pow(2, i),i+1,result+"N"));
		lista.add(new VirtualGraph(x,y-(int)Math.pow(2, i),i+1,result+"S"));
	
		return lista;
	}
	
	
}

