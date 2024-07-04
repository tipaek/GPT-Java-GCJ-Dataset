import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        
    
		
		
		
		
		
		
		
		
		
		
		int size=0;
		int loop=0;
		int n=0;
		int min=0;
		int who=0;
		String solstring="";
		ArrayList<scheduler> col = new ArrayList<scheduler>(); 
		ArrayList<Character> sol = new ArrayList<Character>(); 
		String finishsol="";
		int impossible = 0;
		size = in.nextInt();
		int counter = 1;
		while(in.hasNext()){
//			System.out.println("case: ");
		loop = in.nextInt();
		
		//fase 1, lettura
		for(int i=0; i<loop; i++){
			col.add(new scheduler(i, in.nextInt(), in.nextInt()));
		}
		/*
		for(int i=0; i<col.size(); i++){
			System.out.println(col.get(i).start);
		}
		*/
		//fase 2, ordine
		n = col.size();
		for(int i=0; i<n-1; i++){
			min = i;
			for(int j=i+1; j<n; j++){
				if(col.get(j).start < col.get(min).start){
					Collections.swap(col, j, min);
				}
			}
		}
		
		//fase 3, assegno
		sol.add('C');
		for(int i=1; i<col.size(); i++){
			
			//System.out.println("asd "+col.get(i-1).start+" "+col.get(i-1).finish);
			//System.out.println("asd "+col.get(i).start+" "+col.get(i).finish);
			//System.out.println(who);
			if(who == 0){
				if(col.get(i).start >= col.get(i-1).finish){
					sol.add('C');
					//non si interseca
					//System.out.println(col.get(i).start+" "+col.get(i-1).finish+" lol");
				}else if(col.get(i).start < col.get(i-1).finish){
					//si interseca
					//System.out.println("si baby");
					
					if(i-2 < 0){
						//System.out.println("ops");
						sol.add('J');
						who = 1;
					}else{
						if(col.get(i-2).finish > col.get(i).start){
							finishsol = "IMPOSSIBLE";
							//System.out.println("CASE #"+i+": "+finishsol);
							impossible=1;
						}
						else{
							sol.add('J');
							who = 1;
							
						}
					}
					
				}
			}else if(who == 1){
				if(col.get(i).start >= col.get(i-1).finish){
					sol.add('J');
				}else if(col.get(i).start < col.get(i-1).finish){
					if(i-2 < 0){
						sol.add('C');
						who = 0;
					}else{
						if(col.get(i-2).finish > col.get(i).start){
							finishsol = "IMPOSSIBLE";
							impossible = 1;
							
						}
						else{
							sol.add('C');
							who = 0;
						}
					}
				}
				
				
			}
		}
		
		
		
		//fase 4, riordino
		n = col.size();
		for(int i=0; i<n-1; i++){
			min = i;
			for(int j=i+1; j<n; j++){
				if(col.get(j).ordine < col.get(min).ordine){
					Collections.swap(sol, j, min);
					
				}
			}
		}
		
		
		
		
		
		
		/*
		for(int i=0; i<col.size(); i++){
			System.out.print(col.get(i).start+" ");
			System.out.println(col.get(i).finish);
		}*/
		   
		    StringBuilder builder = new StringBuilder(sol.size());
		    for(Character ch: sol)
		    {
		        builder.append(ch);
		    }
		    solstring = builder.toString();
		
		//System.out.println(solstring);
		    if(impossible == 1){
		    	System.out.println("CASE #"+counter+": IMPOSSIBLE");
		    }else{
		    	System.out.println("CASE #"+counter+": "+solstring);
		    }
		
		
		
		
		
		sol.clear();
		col.clear();
		impossible=0;
		
		
		
		counter++;
		}
	}
	
}

class scheduler {
	public int ordine;
	public int start;
	public int finish;
	
	
	public scheduler(int ordine, int start, int finish){
		this.ordine = ordine;
		this.start = start;
		this.finish = finish;
	}
}

