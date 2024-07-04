import java.util.*;
import java.io.* ;

class MyTime {

		int start ;
		int end ;
		MyTime next,prev ;
		int size ;
		public MyTime(int start,int end) {
			this.start = start;
			this.end   = end ;
		}

		public int getStart() {
			return this.start ;
		}
		public int getEnd() {
			return this.end ;
		}

		public void setNext(MyTime m) 
		{
			this.next = m ;
		}
		public void setPrev(MyTime m) 
		{
			this.prev = m ;
		}

		public MyTime getNext() 
		{
			return this.next ;
		}

		public MyTime getPrev() 
		{
			return this.prev ;
		}




}


class Solution{
	
	

	public boolean schedule(int start,int end,MyTime head){

			MyTime temp ;

			if(head.getNext() == null ) {
					MyTime mt = new MyTime(start,end) ;
					mt.setPrev(head) ;
					head.setNext(mt) ;
					return true;
					
			}
			MyTime next = head.getNext() ;

			while( next != null ) {

        	    if ( start > next.getStart() && start < next.getEnd() ) {
					    return false ;
					}
				else if ( start < next.getStart() && end > next.getStart())
				{
				
					    return false ;
				}

				if(start >= next.getStart() && start >= next.getEnd()) {
				       temp = new MyTime(start,end) ;
				       temp.setPrev(next) ;
                       next.setNext(temp);
                   
					break ;
				}
				else if ( start <= next.getStart() && end <= next.getStart() ){
				 	   temp = new MyTime(start,end) ;
				 	   temp.setNext(next);
				 	   next.getPrev().setNext(temp);
				 	 
					break ;
				}
				next = next.getNext();
				
 			}
 			
           
 			return true ;

	}


	public void allocate(int n,int[][] array,int c) {

		MyTime jamieTime = new MyTime(0,0); 
		MyTime cameronTime = new MyTime(0,0); 
		boolean jamieavailable = false;
		boolean cameronavailable = false;
        String order = "";
		//Always start with jamie
            for ( int i = 0 ; i < n ; i++ ) {
		   
			jamieavailable = this.schedule(array[i][0],array[i][1],jamieTime) ;
			if (jamieavailable == false) {
			
				cameronavailable = this.schedule(array[i][0],array[i][1],cameronTime) ;
				order= order + "C" ;
			
			} 
			else
				order= order + "J" ;


			if ( jamieavailable == false && cameronavailable == false ) {
					 System.out.println("Case #"+c+": IMPOSSIBLE");
					 return ;
			}

		}

		System.out.println("Case #"+c+": "+order);


	}

	public static void main(String args[]) {
		int n,c = 1 ;
		int[][] array ;
		Solution p = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
 		
        while(c <= t) {

        	n = in.nextInt() ;
            array = new int[n][2] ;
        	for ( int i = 0 ; i < n ; i++ )
        		for ( int j = 0 ; j < 2 ; j++ )
                    array[i][j] = in.nextInt() ;

             p.allocate(n,array,c);
             c++ ;
              

        }


	}


}