import java.util.*;
class Solution{

public static void main(String args[])
{
Scanner s=new Scanner(System.in);
int t=s.nextInt();

for(int i=1;i<=t;i++)
{
 int n=s.nextInt();
 int k=s.nextInt();
 switch(n)
 {
 case 2: if(k==2 || k==4)
 {
  System.out.println("case #"+i+": POSSIBLE" );  
 }
 else{
 System.out.println("case #"+i+": IMPOSSIBLE" );
 }
 break;
 case 3:if(k==6)
 {
  System.out.println("case #"+i+": POSSIBLE" );  
 }
 else{
 System.out.println("case #"+i+": IMPOSSIBLE" );
 }
 break;
 case 4:if(k==8 || k==12)
 {
  System.out.println("case #"+i+": POSSIBLE" );  
 }
 else{
 System.out.println("case #"+i+": IMPOSSIBLE" );
 }
 break;
 case 5:if(k==15)
 {
  System.out.println("case #"+i+": POSSIBLE" );  
 }
 else{
 System.out.println("case #"+i+": IMPOSSIBLE" );
 }
 break;
 }

 
}

}


}