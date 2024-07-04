import java.util.*;
public class Solution {

	public static Set<Integer> findDuplicates(int [] listContainingDuplicates)
{ 
  Set<Integer> setToReturn = new HashSet<>(); 
	Set<Integer> set1 = new HashSet<>();

  for (int yourInt : listContainingDuplicates)
  {
   if (!set1.add(yourInt))
   {
    setToReturn.add(yourInt);
   }
  }
  return setToReturn;
}
	public static void main(String[] args){
		 Scanner scanner = new Scanner(System.in);
      int num_line = Integer.parseInt(scanner.nextLine());
      int i =0;
		
		while(i< num_line){
			String string = scanner.nextLine();
			char c = string.charAt(0);
			String s= "";
			int a=Character.getNumericValue(c); 
			for(int j =0 ; j < a; j++){
				s+="(";
			}
			s+=c;
			for(int j =0 ; j < a; j++){
				s+=")";
			}
			int check=0;
			int previous =a;
			int check1 =0;
			for(int j =1 ; j< string.length(); j++){
				int b=Character.getNumericValue(string.charAt(j)); 
				if(b ==0){
					check=1;
					
						s+='0';
					previous = b;
					continue;
				}
				if(check ==1){
					a= b; 
					check =0;
					for(int k =0 ; k < a; k++){
						s+="(";
					}
					s+=string.charAt(j);
					for(int k =0 ; k < a; k++){
						s+=")";
					}
					previous = b;
					continue;
				}
				
				
				
				if(b<= a && previous >=b ){
					
					int index =0;
					int index1=0;
					for(int k =s.length()-1; k>=0; k--){
						if(s.charAt(k) ==')'){
							index+=1;
							index1 = k;
							if(index == b){
								
								break;
							}
						}
					}
					
					String new_s = s.substring(0, index1)+ string.charAt(j)+ s.substring(index1, s.length());
					check1 = index1;
					s = new_s;
					previous = b;
				}else  {
					
					check =0;
					String s1 ="";
					for(int k =0 ; k < b-previous; k++){
						s1+="(";
					}
					s1+=string.charAt(j);
					for(int k =0 ; k< b-previous; k++){
						s1+=")";
					}
					String new_s = s.substring(0, check1+1)+ s1+ s.substring(check1+1, s.length());
					s= new_s;
					check1+=s1.length()-1;
					previous = b;
					a= b; 
				}
				
			}
			
			System.out.println("Case #" +(i+1)+": "+ s);
			
			
			
			i++;
			}
			
		}
	}
