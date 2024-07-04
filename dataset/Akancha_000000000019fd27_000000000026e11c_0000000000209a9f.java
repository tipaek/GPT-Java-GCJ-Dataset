import java.util.*;
class Stack{
	private int capacity=2;
	public int top=-1;
	private char a[]=new char[capacity];
	public void push(char c){
		if(capacity==(top+1)){
			char b[]=new char[capacity*2];
			for(int i=0;i<=top;i++)	b[i]=a[i];
			a=b;
			capacity*=2;
		}
		a[++top]=c;
		System.out.print(c);
	}
	public void pop(){
		if(!isEmpty()){
			char data=a[top];
			top--;
		}
	}
	public char peek(){
		return a[top];
	}
	public boolean isEmpty(){
		if(top>=0) return false;
		else return true;
	}
	public int size(){
		return (top+1);
	}
	public void show(){
		for(int i=0;i<=top;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}
public class Solution{
	public static void nest(char[] s){
		Stack s1=new Stack();
		Stack s2=new Stack();
		for(int i=0;i<s.length;i++){
			if(s1.isEmpty() && s[i]=='0')	{s2.push('0');}
			else{
				if(s1.isEmpty()){
					for(int j=0;j<Character.getNumericValue(s[i]);j++){
						s1.push('(');
					}
					s2.push(s[i]);
				}
				else{
					if(Character.getNumericValue(s[i])==Character.getNumericValue(s2.peek())) s2.push(s[i]);
					else if(Character.getNumericValue(s[i])>Character.getNumericValue(s2.peek())){
						int itr=Character.getNumericValue(s[i])-s1.top-1;
						for(int j=0;j<itr;j++){
							s1.push('(');
						}
						s2.push(s[i]);
					}
					else{
						int itr=s1.top+1-Character.getNumericValue(s[i]);
						for(int j=0;j<itr;j++){
							s1.pop();
							System.out.print(")");
						}
						s2.push(s[i]);
					}
				}
			}
		}
		while(!s1.isEmpty()){
			s1.pop();
			System.out.print(")");
		}
		System.out.println();
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(sc.nextLine());
		String s[]=new String[t];
		for(int i=0;i<t;i++){
			s[i]=sc.nextLine();
		}
		for(int i=0;i<t;i++){
			System.out.print("Case #"+(i+1)+": ");
			nest(s[i].toCharArray());
		}
	}
}