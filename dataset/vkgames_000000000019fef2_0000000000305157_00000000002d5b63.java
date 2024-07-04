import java.util.Scanner;

public class Solution {
	static Scanner sc;
	static int x,y;
	static int centerX = -1, centerY = -1;
	public static void main(String[] args) {
		 sc= new Scanner(System.in);
		int t = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		while(t>0) {
			boolean center = false;
			t--;
			for(int i=-5;i<=5;i++){
			    if(center) continue;
			    for(int j=-5;j<=5;j++){
			    	if(center) continue;
			        System.out.println(i+ " " + j);
			        System.out.flush();
			        String s = sc.next();
			        if(s.equals("CENTER")){
			            center = true;
			            continue;
			        }
			    }
			}
			if(center) continue;
//			x = 0; y =0;
//			y = binarySearchUp(0,1000000000);
//			if(center) {
//				continue;
//			}
//			//0 y
//			x = binarySearchRight(0,1000000000,y);
//			if(center) {
//				continue;
//			}
//			int y2 = 0; int x2 = x;
//			y2 = binarySearchDown(-1000000000,0,x2);
//			if(center) {
//				continue;
//			}
//			int x3 = 0; int y3 = y2;
//			x3 = binarySearchLeft(-1000000000,0,y3);
//			if(center) {
//				continue;
//			}
//			centerX = (x3+x)/2;
//			centerY = (y3+y)/2;
//			System.out.println(centerX + " " + centerY);
//			continue;
			

		}
	}

	 private static int binarySearchLeft(int i, int j, int y3) {
		// TODO Auto-generated method stub
		 int mid = (i+j)/2;
		 System.out.println(mid + " " + y3);
		 String s =sc.next();
		 if(s.equals("CENTER")) {
			 center = true;
			 centerX = mid;
			 centerY = y3;
			 return -1;
		 }
		 else if(s.equals("MISS")) {
			 System.out.println((mid+1) + " " + y3);
			 String r = sc.next();
			 if(r.equals("CENTER")) {
				 center = true;
				 centerX = (mid+1);
				 centerY = y3;
				 return -1;
			 }
			 else if(r.equals("MISS"))
				 binarySearchLeft(mid+1,j,y3);
			 else {
				 return mid+1;
			 }
		 }
		 else { //HIT
			 System.out.println((mid-1) + " " + y3);
			String r = sc.next();
			if(r.equals("CENTER")) {
				center = true;
				centerX = (mid-1);
				centerY = y3;
				return -1;
			}
			else if(r.equals("MISS")) {
				return mid;
			}
			else {
				return binarySearchLeft(i,mid-1,y3);
			}
		 }
		 return 0;
	}

	private static int binarySearchDown(int i, int j, int x2) {
		// TODO Auto-generated method stub
		 int mid = (i+j)/2;
		 System.out.println(x2 + " " + mid);
		 String s =sc.next();
		 if(s.equals("CENTER")) {
			 center = true;
			 centerX = x2; centerY = mid;
			 return -1;
		 }
		 else if(s.equals("MISS")) {
			 System.out.println(x2 + " " + (mid+1));
			 String r = sc.next();
			 if(r.equals("CENTER")) {
				 center = true;
				 centerX = x2; centerY = (mid+1);
				 return -1;
			 }
			 else if(r.equals("MISS"))
				 binarySearchDown(mid+1,j,x2);
			 else {
				 return mid+1;
			 }
		 }
		 else { //HIT
			 System.out.println(x2 + " " + (mid-1));
			String r = sc.next();
			if(r.equals("CENTER")) {
				center = true;
				centerX = x2; centerY = (mid-1);
				return -1;
			}
			else if(r.equals("MISS")) {
				return mid;
			}
			else {
				return binarySearchDown(i,mid-1,x2);
			}
		 }
		 return 0;
	}

	private static int binarySearchRight(int i, int j,int y) {
		 int mid = (i+j)/2;
		 System.out.println(mid + " " + y);
		 String s =sc.next();
		 if(s.equals("CENTER")) {
			 center = true;
			 centerX = mid; centerY = y;
			 return -1;
		 }
		 else if(s.equals("MISS")) {
			 System.out.println((mid-1) + " " + y);
			 String r = sc.next();
			 if(r.equals("CENTER")) {
				 center = true;
				 centerX = (mid-1); centerY = y;
				 return -1;
			 }
			 else if(r.equals("MISS"))
				 binarySearchRight(i,mid-1,y);
			 else {
				 return mid-1;
			 }
		 }
		 else { //HIT
			 System.out.println((mid+1) + " " + y);
			String r = sc.next();
			if(r.equals("CENTER")) {
				center = true;
				centerX = (mid+1); centerY = y;
				return -1;
			}
			else if(r.equals("MISS")) {
				return mid;
			}
			else {
				return binarySearchRight(mid+1,j,y);
			}
		 }
		 return 0;
	}

	static int binarySearchUp(int i, int j) {
		 int mid = (i+j)/2;
		 System.out.println(0 + " " + mid);
		 String s =sc.next();
		 if(s.equals("CENTER")) {
			 center = true;
			 centerX = 0; centerY = mid;
			 return -1;
		 }
		 else if(s.equals("MISS")) {
			 System.out.println(0 + " " + (mid-1));
			 String r = sc.next();
			 if(r.equals("CENTER")) {
				 center = true;
				 centerX = 0; centerY = (mid-1);
				 return -1;
			 }
			 else if(r.equals("MISS"))
				 binarySearchUp(i,mid-1);
			 else {
				 return mid-1;
			 }
		 }
		 else { //HIT
			 System.out.println(0 + " " + (mid+1));
			String r = sc.next();
			if(r.equals("CENTER")) {
				center = true;
				centerX = 0; centerY = (mid+1);
				return -1;
			}
			else if(r.equals("MISS")) {
				return mid;
			}
			else {
				return binarySearchUp(mid+1,j);
			}
		 }
		 return 0;
	}
}
