
import java.util.*;


public class Solution {

	static class Time{
		
		int start_point;
		int end_point;
	


		public Time(int start_point, int end_point) {
			super();
			this.start_point = start_point;
			this.end_point = end_point;
		}

		
		
		
	};
	
	
	public static boolean overlap(Time t1, Time t2)
	{    if(t1.start_point<=t2.start_point&&t1.end_point>t2.end_point)
		return true;
	 if(t1.start_point<t2.end_point&&t1.end_point>=t2.end_point)
		 return true;
	 if(t1.start_point>=t2.start_point&&t1.end_point<=t2.end_point)
		 return true;
	 
		return false;
	}
	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		
		int test=sc.nextInt();
		for (int i = 0; i <test; i++) {
			String answer="";
			int intervals=sc.nextInt();
			boolean check_condition=true;
			ArrayList<Time> array_time_J=new ArrayList<>();
			ArrayList<Time> array_time_C=new ArrayList<>();
		       Time[] time=new Time[intervals];
			for(int j=0;j<intervals;j++)
			{
				time[j]=new Time(sc.nextInt(),sc.nextInt());
				
				if(j==0)
				{  answer=answer+"C";  
					array_time_C.add(time[j]);
				}
				else {
					
					check_condition=true;
					
					for (int j2 = 0; j2 < array_time_C.size(); j2++) {
						  if (overlap(time[j], array_time_C.get(j2)))
		                    {
		                      check_condition = false;
		                        break;
		                    }
					}
					 
					  if(check_condition) 
		                {     answer=answer+"C";
		                    array_time_C.add(time[j]);
		                 
		                    continue;
		                }
					  
					  
					  check_condition=true;
						
						for (int j2 = 0; j2 < array_time_J.size(); j2++) {
							  if (overlap(time[j], array_time_J.get(j2)))
			                    {
			                      check_condition = false;
			                        break;
			                    }
						}
						
						
						 if(check_condition) 
			                { answer+="J";   
							 array_time_J.add(time[j]);
			                   
			                }
			                else
			              {
			                   answer = "IMPOSSIBLE";
			                    break;
			                }
					  
					    
					  
				}
			}	
		
			System.out.println("Case #"+i+" "+answer);
		}
		
	}
}



