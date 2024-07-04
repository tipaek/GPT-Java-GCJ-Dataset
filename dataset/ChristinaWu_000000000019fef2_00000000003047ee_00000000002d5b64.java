import java.util.*; 
                   
public class Solution{
	static Scanner in;
	
     public static void main(String[] args) {		 
         in = new Scanner(System.in);
         int T = in.nextInt(); 	 
         for(int cas = 1; cas <= T; cas++)
		     solve(cas);
	 }
	 
	 static void solve(int cas){
		 int rank = in.nextInt(),  suit = in.nextInt();
		 Map<Integer,List<Integer>> map = new HashMap<>();
		 List<Integer> list = new ArrayList<>();
		 list.add(2);  list.add(1);
		 map.put(2*100+2,list);
		 
		 List<Integer> res = getSteps(rank, suit, map);	
		System.out.println("Case #"+cas+": "+res.size()/2);
		for(int i = 0; i < res.size()-1; i+=2){
			System.out.println(res.get(i)+" "+res.get(i+1));
		}
	 }
	 
	 static List<Integer> getSteps(int rank, int suit, Map<Integer,List<Integer>> map){
		 if(rank == 1)
			 return new ArrayList<>();
		 
		 List<Integer> list = new ArrayList<>();
		 for(int i = 1; i < suit; i++){
		     list.add(rank*(suit-1)-i+1);   list.add(rank-1);
		 }
		 list.addAll(getSteps(rank-1, suit, map));
		 map.put(rank*100+suit, list);
		 return list;
	 }
}
