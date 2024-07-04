import java.util.*;
class Solution{
	static ArrayList<String>al;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int in=1;in<=t;in++){
            int n=sc.nextInt();
			al=new ArrayList();
            method(1,0,n,in);
            
        }
    }
    public static void method(int i,int sum,int n,int in){
        al.add("1 1");
		boolean boo = method1(1,1,1,n,0);
		
        if(boo){
			System.out.println("Case #"+in+":");
			for(int j=0;j<al.size();j++){
				System.out.println(al.get(j));
			}
		}
    }
	public static boolean method1(int i,int j,int sum,int n,int c){
		
		if(n==sum && c<500)return true;
		else if(sum>n || n==sum && c >=500)return false;
		//System.out.println("sum = "+sum+" i="+i+" j="+j);
		boolean boo = false;
		String key1=Integer.toString(i-1)+" "+Integer.toString(j-1);
		String key2=Integer.toString(i-1)+" "+Integer.toString(j);
		String key3=Integer.toString(i)+" "+Integer.toString(j-1);
		String key4=Integer.toString(i)+" "+Integer.toString(j+1);
		String key5=Integer.toString(i+1)+" "+Integer.toString(j);
		String key6=Integer.toString(i+1)+" "+Integer.toString(j+1);
		
		if(i-1>=1 && j-1>=1 && !al.contains(key1)){
			int k=i-1,l=j-1;
			int val = ((k*l)-l)/l;
			if(k==1||l==1)val=1;
			if(sum+val<=n){
				al.add(key1);
				boo = method1(i-1,j-1,sum+val,n,c+1);
				if(boo)return true;
				al.remove(new String(key1));
			}
		}	
		if(i-1>=1 && j<=i-1 && !al.contains(key2)){
			int k=i-1,l=j;
			int val = ((k*l)-l)/l;
			if(k==1||l==1)val=1;
			if(sum+val<=n){
				al.add(key2);
				boo = method1(i-1,j,sum+val,n,c+1);
				if(boo)return true;
				al.remove(new String(key2));
			}
		}
		if(j-1>=1 && !al.contains(key3)){
			int k=i,l=j-1;
			int val = ((k*l)-l)/l;
			if(k==1||l==1)val=1;
			if(sum+val<=n){
				al.add(key3);
				boo = method1(i,j-1,sum+val,n,c+1);
				if(boo)return true;
				al.remove(new String(key3));
			}
		}
		if(j+1<=i && !al.contains(key4)){
			int k=i,l=j+1;
			int val = ((k*l)-l)/l;
			if(k==1||l==1)val=1;
			if(sum+val<=n){
				al.add(key4);
				boo = method1(i,j+1,sum+val,n,c+1);
				if(boo)return true;
				al.remove(new String(key4));
			}
		}
		if(j<=i && !al.contains(key5)){
			int k=i+1,l=j;
			int val = ((k*l)-l)/l;
			if(k==1||l==1)val=1;
			if(sum+val<=n){
				al.add(key5);
				boo = method1(i+1,j,sum+val,n,c+1);
				if(boo)return true;
				al.remove(new String(key5));
			}
			
		}
		if(j+1<=i && !al.contains(key6)){
			int k=i+1,l=j+1;
			int val = ((k*l)-l)/l;
			if(k==1||l==1)val=1;
			if(sum+val<=n){
				al.add(key6);
				boo = method1(i+1,j+1,sum+val,n,c+1);
				if(boo)return true;
				al.remove(new String(key6));
			}
		}
			return boo;
	}
}