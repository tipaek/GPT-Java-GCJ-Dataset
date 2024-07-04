import java.util.ArrayList;
import java.util.Scanner;

class Solution
{
static ArrayList<String> ans = new ArrayList<>();


   public static void main(String args[])
   {
     Scanner input = new Scanner(System.in);
      int casenum = input.nextInt();
        String[][] answer;
        answer = new String[casenum][2];
      
      for (int n = 0; n < casenum; n++) 
      {
           String N = input.next();
        
             
              
             
            answer[n][0]= Integer.toString(n);
            answer[n][1]= brack(N); 
            ans.clear();
            
      }
          
          
      
       
         for (int n = 0; n < casenum; n++) 
         {
            
            
            System.out.println("Case #" + (Integer.parseInt(answer[n][0])+1) + ": " + answer[n][1]);
         }    
       
   }
   
   
   public static String brack(String n)
   {  
       int br =0;
       
        
       
        for (int i = 0; i < n.length(); i++)
        {
            if(n.charAt(i)== '0')
            {
               if(br != 0)
               {
                   close(br);
                    br = 0;
               }
                
                ans.add("0");
              
               
            }
            
            
            else if(n.charAt(i)== '1')
            {
                if( br> 1)
               {
                   close(br-1 );
                    br = 1;
               }else if(br <1 )
               {
                   open( 1 - br);
                    br =1 ;
                }
                
                
                ans.add("1");
                 if (i ==(n.length()-1))
        {
                  close(br);
        }
                      
            }
            
            
            
            else if(n.charAt(i)=='2')
            {
                 if( br> 2)
               {
                   close(br-2 );
                    br = 2;
               }else if(br <2 )
               {
                   open( 2 - br);
                    br =2 ;
                }
              
             
               ans.add("2");
                if (i ==(n.length()-1))
        {
                  close(br);
        }
            }
            
            
            
            else if(n.charAt(i)=='3')
            {
                 if( br> 3)
               {
                   close(br-3 );
                    br = 3;
               }else if(br <3 )
               {
                   open( 3 - br);
                    br =3 ;
                }
                 ans.add("3");
                  if (i ==(n.length()-1))
        {
                  close(br);
        }
            }
            
            
            
            
            else if(n.charAt(i)=='4')
            {
                if( br> 4)
               {
                   close(br-4 );
                    br = 4;
               }else if(br <4 )
               {
                   open( 4 - br);
                    br =4 ;
                }
               ans.add("4");
                if (i ==(n.length()-1))
        {
                  close(br);
        }
            }
            
            
            
            
            else if(n.charAt(i)=='5')
            {
              if( br> 5)
               {
                   close(br-5 );
                    br = 5;
               }else if(br <5 )
               {
                   open( 5 - br);
                    br =5 ;
                }
               ans.add("5"); 
                if (i ==(n.length()-1))
        {
                  close(br);
        }
               
            }
            
            
            
            
            else if(n.charAt(i)=='6')
            {
                
                if( br> 6)
               {
                   close(br-6 );
                    br = 6;
               }else if(br <6 )
               {
                   open( 6 - br);
                    br =6 ;
                }
               
             ans.add("6");
              if (i ==(n.length()-1))
        {
                  close(br);
        }
               
            }
            
            
            
            else if(n.charAt(i)=='7')
            {
             if( br> 7)
               {
                   close(br-7 );
                    br = 7;
               }else if(br <7 )
               {
                   open( 7 - br);
                    br =7 ;
                }
             
              ans.add("7");
               if (i ==(n.length()-1))
        {
                  close(br);
        }
            } 
            
            
            
            else if(n.charAt(i)=='8')
            {
                if( br> 8)
               {
                   close(br-8 );
                    br = 8;
               }else if(br <8 )
               {
                   open( 8 - br);
                    br =8 ;
                }
               
               ans.add("8");
                if (i ==(n.length()-1))
        {
                  close(br);
        }
            } 
            
            
            
            else if(n.charAt(i)=='9')
            {
                if(br <9 )
               {
                   open( 9 - br);
                    br =9 ;
                }
               
              ans.add("9");
               if (i ==(n.length()-1))
        {
                  close(br);
        }
               
            }
            
            
            
        }
     
       String k = ans.toString().replace(",", "").replace("[", "").replace("]", "").trim();
     return k;  
   }
   
   
   public static void open (int t )
   {
       if (t == 0)
       { return;}
       
      for (int i = 0; i < t; i++)
      {
          ans.add("(");
      }
   }
   
   public static void  close ( int t)
   {
        if (t == 0)
       { return;}
     for (int i = 0; i < t; i++)
     {
         ans.add(")"); 
     }
   }
    
}
