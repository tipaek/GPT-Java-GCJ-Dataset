


import java.io.*;
import java.util.*;
class Child implements Comparable<Child>{
    int start,end,idx;
    Child(int start,int end,int idx){
        this.start=start;
        this.end=end;
        this.idx=idx;
    }

    @Override
    public int compareTo(Child p2) {
        if(this.start-p2.start==0){
            if(this.end-p2.end==0){
                return this.idx-p2.idx;
            }
            else
                return this.end-p2.end;
        }
        else
            return this.start-p2.start;
    }
}
public class Solution{
    
    static int gcd(int a, int b) 
    { 
    if (a == 0) 
        return b;  
    return gcd(b % a, a);  
    } 
      
    // method to return LCM of two numbers 
    static int lcm(int a, int b) 
    { 
        return (a*b)/gcd(a, b); 
    }
    
    static int asd(int a, int b) 
    { 
        return (a*b)/gcd(a, b); 
    }
    
    

public static void main(String[] args) throws IOException {
   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            for(int k=1;k<=t;k++){
                int n=Integer.parseInt(br.readLine());
            ArrayList<Child> arr=new ArrayList<>();
           
            for(int i=0;i<n;i++){
                String[] s=br.readLine().split(" ");
                arr.add(new Child(Integer.parseInt(s[0]),Integer.parseInt(s[1]),i));
            }
            Collections.sort(arr);
           

int c=0,j=0;
int flag=0,fgg=0;
for(int g=0;g<1000;g++)
{}
String[] st=new String[n];
   for(int i=0;i<arr.size();i++){
       if(arr.get(i).start<c && arr.get(i).start<j){
           flag=1;
           break;
       }
       else if(arr.get(i).start>=c){
           st[arr.get(i).idx]="C";
           c=arr.get(i).end;
           fgg=1;
           //if(fgg==1)System.out.println("Here");
       }
       else{
           st[arr.get(i).idx]="J";
           j=arr.get(i).end;
           fgg=1;
            //if(fgg==1)System.out.println("Here");
       }
   }
    System.out.print("Case #"+k+": ");
    
   if(flag==1){
       System.out.println("IMPOSSIBLE");
       fgg=1;
        //if(fgg==1)System.out.println("Here");
   }
   else{
       for(int i=0;i<n;i++){
           System.out.print(st[i]);
           
       }
       System.out.println("");
       fgg=1;
   }
   
//   #include<bits/stdc++.h>
//using namespace std;
//
//#define ull unsigned long long int
//#define ll long long int
//#define pb push_back
//#define MOD (ull)(double)(1e9 + 7)
//#define pii pair<int, int>
//#define pll pair<ll, ll>
//#define pull pair<ull, ull>
//#define m_p make_pair
//
//
//int main()
//{
//    ll n ;
//    cin>>n;
//    string s;
//    if(n<3)cout<<-1<<endl;
//    else if(n==3)cout<<"210\n";
//    else
//    {
//    s+='1';
//    for(int i=0;i<n-4;i++)
//    {
//        s+='0';
//    }
//    if(n%3==0)s+="030";
//    else if(n%5==0)s+="080";
//    else if(n%7==0)s+="070";
//    else if(n%2==0)s+="020";
//    
//    cout<<s<<endl;
//    }
//    
//
//	return 0;
//}


   
   
            }
            }
            }
