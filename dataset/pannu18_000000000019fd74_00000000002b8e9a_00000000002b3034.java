import java.util.*;

  class Solution{
    
    
    
    
    public static void main (String[] args){
        
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int q=1;
        while(t-->0)
        {
            int n=s.nextInt();
            // int k=s.nextInt();
            String a[]=new String[n];
            // TreeMap<Integer,Integer> b=new TreeSet<>();
            
            for(int i=0;i<n;i++)
            {
                a[i]=s.next();
            }
            String b=a[0];
            for(int i=1;i<n;i++){
                String c="";
                // for(int j=0;j<a[i].length();j++){
                int k=b.length()-1,j=a[i].length()-1;
                while(k>=0&&j>=0){
                    if(b.charAt(k)!=a[i].charAt(j)){
                        if(b.charAt(k)!='*'&&a[i].charAt(j)!='*'){
                        c="*";
                        break;
                        }
                        else if(b.charAt(k)=='*'){
                            c=a[i].charAt(j)+c;
                            j--;
                        }
                        else{
                            c=b.charAt(k)+c;
                            k--;
                        }
                    }
                    else //if(k!=0&&j!=0)
                    {
                        
                        c=b.charAt(k)+c;
                        k--;
                        j--;
                    }
                }
                
                b=c;
                if(b=="*")
                break;
            }
              if(b.length()>1&&b.charAt(0)=='*')
              b=b.substring(1);
            System.out.println("Case #"+q+": "+b);
            q++;
        }
    }
    
}