import java.util.*;

public class Solution{

     public static void main(String []args){
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int t=0 ; t < T ; t++){
            
            int numOfActivity = sc.nextInt();
		
			int numArr[][] = new int[numOfActivity][2];
			
			for(int i=0 ; i < numOfActivity ; i++){

				for(int j=0 ; j < 2 ; j++){
					numArr[i][j] = sc.nextInt();
				}
			}
			
			char[] takenActivity = new char[numOfActivity];
			
			takenActivity[0] = 'C';
		
			boolean imPossible = false;
			for(int i=1 ; i<numOfActivity ; i++){
			
				for(int j=0 ; j<numOfActivity ; j++){
					
					if(i != j){
						
						if( ( numArr[i][0] >  numArr[j][0] && numArr[i][0] < numArr[j][1] ) || ( numArr[i][1] >  numArr[j][0] && numArr[i][1] < numArr[j][1] ) ){
							
							// Conflict in activity
							boolean possibleToBookActivity = false;
							
							//System.out.println("Conflict :: takenActivity = "+ takenActivity[j]);
							if(takenActivity[j] == 'C'){
								// Already taken activity of conflited time by C
								
								//System.out.println("Taken activity is C");
								// totalActivity, activity time arr, new activity id, taken activity id, Person to assign activity, activity taken char arr
								possibleToBookActivity = checkIfActivityCanPerformByPerson(numOfActivity, numArr, i, j, 'J', takenActivity);
								
								//System.out.println("possibleToBookActivity in C ::"+possibleToBookActivity);
								if(possibleToBookActivity){
									takenActivity[i] = 'J'; // Assigning activity to J
									//System.out.println(takenActivity[i]);
								}
								else{
									imPossible = true;
								}
								
							}
							else if(takenActivity[j] == 'J'){
								// Already taken activity of conflited time by J
								
								//System.out.println("Taken activity is J");
								possibleToBookActivity = checkIfActivityCanPerformByPerson(numOfActivity, numArr, i, j, 'C', takenActivity);
								
								if(possibleToBookActivity){
									takenActivity[i] = 'C'; // Assigning activity to C
								}
								else{
									imPossible = true;
								}
								
							}
							else{
								//System.out.println("Invalid case");
							}
						}
						else{
							
							//System.out.println("No Conflict in activity :: "+ i);
							// No conflict in activity we can assign it to anyone
							takenActivity[i] = 'C'; // Assigning activity to C
							
						}
						
						break;
						
					}
					
				}
				
				if(imPossible){
					break;
				}
			}
			
			if(imPossible){
				System.out.println("Case #" +(t+1)+ ": IMPOSSIBLE");
			}
			else{
				
				String activityStr = new String(takenActivity);
				System.out.println("Case #" +(t+1)+ ": "+ activityStr);
			}
			
        }
        
        sc.close();
        System.exit(0);
        
     }
	 
	 public static boolean checkIfActivityCanPerformByPerson(int numOfActivity, int[][] numArr, int activityId, int alreadyTakenActivity, char personCharPref, char[] takenActivityArr){
		
		//System.out.println("In Function");
		 for(int a=0; a<numOfActivity; a++){
			 
			 //System.out.println("a != alreadyTakenActivity "+ (a != alreadyTakenActivity) );
			 //System.out.println(" numArr[activityId][0] >  numArr[a][0] && numArr[activityId][0] < numArr[a][1] "+  (numArr[activityId][0] >  numArr[a][0] && numArr[activityId][0] < numArr[a][1]) );
			 //System.out.println(" numArr[activityId][1] >  numArr[a][0] && numArr[activityId][1] < numArr[a][1] "+  (numArr[activityId][1] >  numArr[a][0] && numArr[activityId][1] < numArr[a][1]) );
			 //System.out.println(" takenActivityArr[a] == personCharPref " + (takenActivityArr[a] == personCharPref) );
			 if(a != alreadyTakenActivity && ( ( numArr[activityId][0] >  numArr[a][0] && numArr[activityId][0] < numArr[a][1] ) || ( numArr[activityId][1] >  numArr[a][0] && numArr[activityId][1] < numArr[a][1] ) &&  takenActivityArr[a] == personCharPref ) ){

				// This activity already occupied by personCharPref
				return false;
			 }
		 }
		 
		 return true;
	 }
}