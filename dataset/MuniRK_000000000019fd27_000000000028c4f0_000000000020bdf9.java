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


public class Solution{
	
	

	public boolean schedule(int start,int end,MyTime head){

			MyTime temp ;
			MyTime next ;

			if( head.getNext() == null )
			{
				temp = new MyTime(start,end) ;
				head.setNext(temp);
				temp.setPrev(head);
				return true ;
			}
			next = temp = head.getNext();
			
			while (temp != null) {

				if ( start > temp.getStart() && start < temp.getEnd() )
						return false ;
				else if ( start <= temp.getStart() && end > temp.getStart() )
						return false ;	
				next = temp ;
				temp = temp.getNext() ;
			}

			temp = new MyTime(start,end);
			next.setNext(temp);
			temp.setPrev(next) ;


 			return true ;

	}


	public void allocate(int n,int[][] array,int c) {

		MyTime jamieTime = new MyTime(0,0); 
		MyTime cameronTime = new MyTime(0,0); 
		boolean jamieavailable = false;
		boolean cameronavailable = false;
        String order = "";
		
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