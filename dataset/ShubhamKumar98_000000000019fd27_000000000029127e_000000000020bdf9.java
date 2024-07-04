
import java.util.*; 

public class Solution  {
  
   public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       int T = sc.nextInt();
       int t=1;
       while(t<=T) {
           Integer s = sc.nextInt();
           sc.nextLine();
           
           List<Integer>  list = new ArrayList<>();
           
           HashMap<Integer,Integer>  map = new HashMap<>();
           
           
           for(int i=0;i<s;i++) {
       		String in[] = sc.nextLine().split(" ");
       		list.add(Integer.parseInt(in[0]));
       		map.put(Integer.parseInt(in[0]), Integer.parseInt(in[1]));
           }
               
           List<Integer> list1 = new ArrayList<>(list);
           Collections.sort(list1);
      //  System.out.println(list1);

           
           boolean possible = true;
           boolean Co = true;
           Integer Cend = map.get(list1.get(0));
           Integer Jend = -1;
           boolean Jo = false;

           char Pattern[] = new char[s];
           Pattern[0]='C';
           
           for(int i=1;i<list1.size();i++) {
   //    System.out.println(((list1.get(i)<map.get(list1.get(i-1))&&(Jo==false)))+"--"+Jo+"__"+list1.get(i)+"--"+map.get(list1.get(i-1)));
           	
           
           
    //  System.out.println("Cend"+list1.get(i)+"___"+Cend+"__"+Co);

           if(list1.get(i)>=Cend) {
           		Co = false;
           	}

           	
           	if(list1.get(i)>=Jend) {
           		Jo = false;
           	}
         //     System.out.println("Jend"+list1.get(i)+"___"+Jend+"__"+Jo);

               if(list1.get(i)<map.get(list1.get(i-1))&&(Co==false)) {
           		Co = true;
           		Cend = map.get(list1.get(i));
           		Pattern[i] = 'C';
           	}
           	
               else if(list1.get(i)<map.get(list1.get(i-1))&&(Jo==false)) {
      //        	System.out.println("JO");
           		Jo = true;
           		Jend = map.get(list1.get(i));
           		Pattern[i] = 'J';
           	}  
               	

           	
           	
           
           	else 	if(list1.get(i)>=map.get(list1.get(i-1))) {
           	
        // System.out.println("here"+Co+Jo);


           		if(Co==false&&Jo) {
           			Pattern[i] =  'C' ;
               		Cend = map.get(list1.get(i));
               		Co=true;
               
           		} else if(Jo==false&&Co) {
                   // System.out.println("Inside Jo of false false");

           			Pattern[i] =  'J' ;
               		Jend = map.get(list1.get(i));
               		Jo = true;
           		}
           		else if(Co==false&&Jo==false) {
           			
           			
           			if(Jend==-1) {
           				Pattern[i] = 'C';
               			Cend = map.get(list1.get(i));
               			Co=true;
           			} else {
                   		if(Cend<Jend) {
                   			Pattern[i] = 'C';
                   			Cend = map.get(list1.get(i));
                   			Co=true;
                   		} 
                   		else {
                   			Pattern[i] = 'J';
                   			Jend = map.get(list1.get(i));
                   			Jo=true;
                   		} 
           				
           			}
           			
           		}
           		
//           		System.out.println(Cend<Jend);
//           		System.out.print(i);
           		
           		
           	}
           	
           	
           	
           	else   {
           		//System.out.println(String.valueOf(Pattern));
           		possible = false;
           		break;
           	}
           	
           	
    //           System.out.println("\n");
	
           	
           }
//        System.out.println(list1);
//        
//        System.out.println(list);
//
//        System.out.println(String.valueOf(Pattern));


           
//           String se = Character.toString(Pattern[list1.indexOf(list.get(0))]) ;
           
//           for(int i=1;i<list.size();i++) {
//       	
//
//           	if( list1.indexOf(list.get(i)) < list1.size()-1 && list1.get(list1.indexOf(list.get(i)))== list1.get(list1.indexOf(list.get(i))+1) ) {
//           		
//
//	//System.out.println(list.get(i));
//	int yu = list1.indexOf(list.get(i));
//	se += Character.toString(Pattern[yu+1]);
//	i++;
//
//
//           	} else {
//       			se += Character.toString(Pattern[list1.indexOf(list.get(i))]);
//           	}
//           	
//           }

       	//System.out.println(se);
           if(possible==false ){
               System.out.println("Case #"+t+": IMPOSSIBLE");

           } else {
           	
              System.out.println("Case #"+t+": "+String.valueOf(Pattern));

           	
           }
         
           
          // System.out.println("Case #"+t+": "+trac+" "+row+" "+col);
           
           t++;
           
       }
       
      sc.close();
       
       
       
   }
}