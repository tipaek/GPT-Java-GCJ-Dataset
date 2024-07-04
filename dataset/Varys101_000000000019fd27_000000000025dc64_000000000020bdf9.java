//scheduling activities
//activity that ends at time t is
//not considered to overlap with another 
//activity that starts at time t. 
//
//input T N
//      Si Ei


import java.io.*; 
import java.util.*; 

// User defined Pair class 
class Pair { 
	int x; 
	int y; 

	// Constructor 
	public Pair(int x, int y) 
	{ 
		this.x = x; 
		this.y = y; 
	} 
	public void display() {
		System.out.println("x: "+x+" y : "+y);
	}
	public boolean equals() {
		return false;

	}
} 

// class to define user defined conparator 
class Compare { 

	static void compare(Pair arr[], int n) 
	{ 
		// Comparator to sort the pair according to second element 
		Arrays.sort(arr, new Comparator<Pair>() { 
			@Override public int compare(Pair p1, Pair p2) 
			{ 
				return p1.y - p2.y; 
			} 
		}); 

		//		for (int i = 0; i < n; i++) { 
		//			System.out.print(arr[i].x + " " + arr[i].y + " | "); 
		//		} 
		//System.out.println(); 
	} 
} 

// Driver class 
class Solution{ 

	// Driver code 
	public static void main(String[] args) 
	{ 
		//		        Scanner sc = new Scanner(System.in); 
		//		  
		//		        // length of array 
		//		        int n = 5; 
		//		  
		//		        // Array of Pair 
		//		        Pair arr[] = new Pair[n]; 
		//		  
		//		        arr[0] = new Pair(10, 20); 
		//		        arr[1] = new Pair(1, 2); 
		//		        arr[2] = new Pair(3, 1); 
		//		        arr[3] = new Pair(10, 8); 
		//		        arr[4] = new Pair(4, 3); 
		//		  
		//		        Compare obj = new Compare(); 
		//		  
		//		        obj.compare(arr, n); 
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			//int n = in.nextInt();
			int n = in.nextInt();
			Pair arr[] = new Pair[n]; 
			Pair ar[] = new Pair[n];

			for (int j = 0; j < arr.length; j++) {
				int x=in.nextInt();
				int y=in.nextInt();
				arr[j]=new Pair(x, y);
				ar[j]=new Pair(x, y);
			}
			//			for (int j = 0; j < arr.length; j++) {
			//				ar[j].display();
			//			}

			Compare obj = new Compare(); 

			obj.compare(arr, n);
			HashMap<Pair, Character> map=new HashMap<>();

			// assign activities to j c
			int j=0,c=0,flag=0;
			String s="";
			for (int k = 0; k < arr.length; k++) {
				//check if activity 
				if(k==0) {
					//assign min end time activity to c
					s+="C";
					c=arr[k].x; //value of end time stored in c
					map.put(arr[k], 'C');
					continue;
				}
				//case 1 when starting point of cur >= ending point of previous
				if(arr[k].x>=arr[k-1].y ) {

					if(arr[k].x>c) {
						s+="C";
						c=arr[k].x;
						map.put(arr[k], 'C');
					}else {
						flag=1;
					}

					// case 2 when starting point of cur<endding point of previous
				}else if(arr[k].x<arr[k-1].y) {
					flag=0;
					if(arr[k].x>j) {
						s+="J";
						j=arr[k].x;
						map.put(arr[k], 'J');
					}else {
						flag=1;
					}
				}
				if(flag==1) {
					s="IMPOSSIBLE";
					break;
				}


			}
			//System.out.println(Arrays.asList(map));

			//System.out.println(s);
			//			String ans="";
			//			for (int k = 0; k < ar.length; k++) {
			//				char ch=map.get(ar[k]);
			//				s+=ch;
			//			}
			//			System.out.println(ans);
			//			

			System.out.println("Case #" + i + ": " + (s) );

		} 
	} 	
}