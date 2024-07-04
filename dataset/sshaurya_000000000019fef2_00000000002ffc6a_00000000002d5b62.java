import java.util.*;


class Solution{
    
    
    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);
        
        int t=sc.nextInt();
        
        for(int a=1;a<=t;a++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            Queue<int[]> que=new LinkedList<>();
		Set<List<Integer>> visited=new HashSet<>();
		que.offer(new int[] {0,0});
		int i=1;
		HashMap<List<Integer>,String> res=new HashMap<>();
		if(Math.abs(x)==Math.abs(y) && x!=0 ){
			System.out.println("Case #"+a+": IMPOSSIBLE");
			continue;
		}
			boolean flag=false;
			while(que.size()!=0 && !flag && i<100) {
			
			
			int size=que.size();
			while(size-->0) {
				int[] data=que.poll();
				
				int x1=data[0];
				int y1=data[1];
				
				if(x1==x && y1==y) {
					System.out.println("Case #"+a+": "+res.get(Arrays.asList(x1,y1)).substring(4));
					flag=true;
					break;
					
					
				}
				
			int newx=north(x1,y1,i)[0];
			
			int newy=north(x1,y1,i)[1];
			
			if(visited.add(Arrays.asList(newx,newy))) {
				res.put(Arrays.asList(newx,newy),res.get(Arrays.asList(x1,y1))+"N");
				que.offer(new int[] {newx,newy});
			}
			newx=south(x1,y1,i)[0];
			
			 newy=south(x1,y1,i)[1];
			if(visited.add(Arrays.asList(newx,newy))) {
				res.put(Arrays.asList(newx,newy),res.get(Arrays.asList(x1,y1))+"S");
				que.offer(new int[] {newx,newy});
			}
			 newx=east(x1,y1,i)[0];
			newy=east(x1,y1,i)[1];
			if(visited.add(Arrays.asList(newx,newy))) {
				res.put(Arrays.asList(newx,newy),res.get(Arrays.asList(x1,y1))+"E");
				que.offer(new int[] {newx,newy});
			}
			 newx=west(x1,y1,i)[0];
			 newy=west(x1,y1,i)[1];
			if(visited.add(Arrays.asList(newx,newy))) {
				res.put(Arrays.asList(newx,newy),res.get(Arrays.asList(x1,y1))+"W");
				que.offer(new int[] {newx,newy});
			}
			
			
			}
			i++;
			
		}
		if(!flag)
		System.out.println("Case #"+a+": "+"IMPOSSIBLE");
		
	}
	
	
            
            
            
            
        }
        
        public static int[]  north(int x,int y,int i) {
		int move=(int) Math.pow(2, i-1);
		
		return new int[]{x,y+move};
		
	}
	public static int[]  south(int x,int y,int i) {
		int move=(int) Math.pow(2, i-1);
		
		return new int[]{x,y-move};
		
	}
	public static int[]  east(int x,int y,int i) {
		int move=(int) Math.pow(2, i-1);
		
		return new int[]{x+move,y};
		
	}
	public static int[]  west(int x,int y,int i) {
		int move=(int) Math.pow(2, i-1);
		
		return new int[]{x-move,y};
		
	}

    }
