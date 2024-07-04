 import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
       
        
     
		
Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
int lol=0;
		int x=0;
		ArrayList<String> asd = new ArrayList<String>(); 
		ArrayList<Character> lel = new ArrayList<Character>();
		ArrayList<Character> answer = new ArrayList<Character>();
		lol = in.nextInt();
		while(in.hasNext()){
			
			asd.add(in.next());
			
		}

		
		for(int i=0; i< asd.size(); i++){
			
			for(int z=0; z< asd.get(i).length(); z++){
				lel.add(asd.get(i).charAt(z));
			}
			
			
			x=0;
			x = 0-Character.getNumericValue(lel.get(0));
			if(x < 0){
				for(int w=0; w<Math.abs(x); w++){
					answer.add('(');
					
				}
				answer.add(lel.get(0));
			}else if( x == 0){
				answer.add(lel.get(0));
			}else if( x > 0){
				for(int w=0; w<Math.abs(x); w++){
					answer.add(')');
				}
				answer.add(lel.get(0));
			}
			
			
			
			for(int z=0; z<lel.size()-1; z++){
				x=0;
				x = Character.getNumericValue(lel.get(z)) - Character.getNumericValue(lel.get(z+1));
				if(x < 0){
					for(int w=0; w<Math.abs(x); w++){
						answer.add('(');
					}
					answer.add(lel.get(z+1));
				}else if( x == 0){
					answer.add(lel.get(z+1));
				}else if( x > 0){
					for(int w=0; w<Math.abs(x); w++){
						answer.add(')');
					}
					answer.add(lel.get(z+1));
				}
			}
			
			
			
			
			x = 0;
			x = Character.getNumericValue(lel.get(lel.size()-1)) - 0;
			if(x < 0){
				for(int w=0; w<Math.abs(x); w++){
					answer.add('(');
				}
				
			}else if( x == 0){
				
			}else if( x > 0){
				for(int w=0; w<Math.abs(x); w++){
					answer.add(')');
				}
				
			}
			
			//System.out.println(lel);
			//System.out.println(answer);
			
			
			    StringBuilder builder = new StringBuilder(answer.size());
			    for(Character ch: answer)
			    {
			        builder.append(ch);
			    }
			    
			    String a =  builder.toString();
			System.out.println("Case #"+(i+1)+": "+a);
			//System.out.println(a);
			lel.clear();
			answer.clear();
		}
		
		
	}
}
