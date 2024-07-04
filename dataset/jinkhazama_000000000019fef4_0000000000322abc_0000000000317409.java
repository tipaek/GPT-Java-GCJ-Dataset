import java.util.*;
class Solution
{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int q=1;q<=t;q++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            String s=sc.next();
            int n=s.length();
            int i;
            for(i=0;i<n;i++){
                if(x==0 && y==0)
                break;
                char ch=s.charAt(i);
                if(ch=='N'){
                    if(y<0){
                    y=y+1;
                    if(x==1)
                        x=0;
                        
                    }
                    if(y==0){
                        if(x==1){
                            if(i<n-1){
                                if(s.charAt(i+1)=='W' || s.charAt(i+1)=='S'){
                                    //x=0;
                                    y=1;
                                }
                                
                                
                            }
                        }
                        if(x>1)
                            x=x-1;
                        
                        
                    }
                    else if(x>0){
                        x=x-1;
                    }
                    
                    
                }
                if(ch=='E'){
                    if(x<0){
                        x=x+1;
                    if(y==1)
                        y=0;}
                    if(x==0){
                        if(y==1){
                            if(i<n-1){
                                if(s.charAt(i+1)=='W' ||s.charAt(i+1)=='S'){
                                    //x=0;
                                    x=1;
                                }
                                
                            }
                        }
                        if(y>1)
                            y=y-1;
                        
                        
                    }
                    else if(y>0){
                        y=y-1;
                    }
                    
                }
                if(ch=='S'){
                    if(x==1 && y==1)
                    {
                        x=0;
                        y=0;
                    }
                    if(y==0){
                        if(x==1){
                            if(i<n-1){
                                if(s.charAt(i+1)=='N'){
                                    //x=0;
                                    y=-1;
                                }
                                
                            }
                        }
                    }
                    if(x==0){
                        if(y==1){
                            y=0;
                        }
                        if(y>1){
                            y=y-2;
                        }
                    }
                    if(y>0 && x>0){
                        y=y-1;
                        x=x-1;
                    }
                }
                if(ch=='W'){
                    if(x==1 && y==1){
                        x=0;
                        y=0;
                    }
                    if(y==0){
                        if(x==1){
                            x=0;
                        }
                        if(x>1){
                            x=x-2;
                        }
                    }
                    if(x==0){
                        if(y==1){
                            if(i<n-1){
                                if(s.charAt(i+1)=='E'){
                                    //y=0;
                                    x=-1;
                                }
                                
                            }
                        }
                    }
                    if(y>0 && x>0){
                        y=y-1;
                        x=x-1;
                    }
                }
            }
            if(x==0 && y==0){
                System.out.println("Case #"+q+": "+i);
            }
            else{
                System.out.println("Case #"+q+": IMPOSSIBLE");
            }
        }
    }
    
    
}