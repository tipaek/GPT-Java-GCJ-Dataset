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
			String line1 = scanner.nextLine();
			int num1 = Integer.parseInt(line1);
			int[] [] matrix = new int[num1][num1];
			for(int j =0; j< num1; j++){
				String line2 = scanner.nextLine();
				String[] line2_list = line2.split(" ");
				for(int k =0; k < num1; k++){
					matrix[j][k]= Integer.parseInt(line2_list[k]);
				}
			}
			int sum =0;
			for(int j =0; j< num1; j++){
				sum+= matrix[j][j];
			}
			int iterate =0;
			for(int j=0; j< num1;j++){
				Set<Integer> set1 =findDuplicates(matrix[j]);
				if(set1.size() >0){
					iterate+=1;
				}
			}
			int iteration1=0;
			for(int j =0; j < num1; j++){
				int [] setToReturn= new int[num1]; 
				for(int k =0  ; k< num1; k++){
					
					setToReturn[k]= matrix[k][j];
					
				}
				Set<Integer> set1 =findDuplicates(setToReturn);
				if(set1.size() >0){
					iteration1+=1;
				}
				
			}
			
			System.out.println("Case #" +(i+1)+": "+ sum+ " "+iterate+" "+iteration1);
			
			
			
			i++;
			}
			
		}
	}
