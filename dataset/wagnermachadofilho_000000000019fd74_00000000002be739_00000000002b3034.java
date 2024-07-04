import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();
		for( int x = 0; x < T; x++ ) {
			Integer n = input.nextInt();
			
			List<Pattern> patterns = new ArrayList<Pattern>(n);
			
			for( int i = 0; i < n; i++ ) {
				String pattern = input.next();
				
				String[] startEnd = pattern.split("\\*");
				if( startEnd.length > 1 ) {
					patterns.add( new Pattern( startEnd[0], startEnd[1] ) );
				} else {
					patterns.add( new Pattern( startEnd[0], "" ) );
				}
			}
			
			Collections.sort( patterns, new Comparator<Pattern>() {
				@Override
				public int compare(Pattern p1, Pattern p2) {
					return new Integer( p1.start.length() ).compareTo( p2.start.length() );
				}
			} );
			
			String name = "";
			if( checkPattternsStart( patterns ) ) {
				name = getLongestStart( patterns );

				Collections.sort( patterns, new Comparator<Pattern>() {
					@Override
					public int compare(Pattern p1, Pattern p2) {
						return new Integer( p1.end.length() ).compareTo( p2.end.length() );
					}
				} );
				
				if( checkPattternsEnd( patterns ) ) {
					name += getLongestEnd( patterns );
				}
			}

			if( !name.isEmpty() ) {
				System.out.println("Case #" + ( x + 1 ) + ": " + name);
			} else {
				System.out.println("Case #" + ( x + 1 ) + ": *");
			}
		}

		input.close();
	}

	private static String getLongestStart(List<Pattern> patterns) {
		String longestStart = patterns.get( 0 ).start;

		for( int i = 1; i < patterns.size(); i++ ) {
			if( patterns.get( i ).start.length() > longestStart.length() ) {
				longestStart = patterns.get( i ).start;
			}
		}
		
		return longestStart;
	}

	private static String getLongestEnd(List<Pattern> patterns) {
		String longestEnd = patterns.get( 0 ).end;

		for( int i = 1; i < patterns.size(); i++ ) {
			if( patterns.get( i ).end.length() > longestEnd.length() ) {
				longestEnd = patterns.get( i ).end;
			}
		}
		
		return longestEnd;
	}

	private static boolean checkPattternsStart(List<Pattern> patterns) {
		for( int i = 0; i < patterns.size() - 1; i++ ) {
			if( !patterns.get( i ).matchStart( patterns.get( i + 1) ) ) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkPattternsEnd(List<Pattern> patterns) {
		for( int i = 0; i < patterns.size() - 1; i++ ) {
			if( !patterns.get( i ).matchEnd( patterns.get( i + 1) ) ) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkPattterns(List<Pattern> patterns) {
		for( int i = 0; i < patterns.size() - 1; i++ ) {
			if( !patterns.get( i ).match( patterns.get( i + 1) ) ) {
				return false;
			}
		}
		return true;
	}

}

class Pattern {
	public String start;
	public String end;

	public Pattern(String start, String end) {
		super();
		this.start = start;
		this.end = end;
	}

	public boolean matchStart(Pattern otherPattern) {
		if( !this.start.isEmpty() && !otherPattern.start.isEmpty() ) {
			if( !otherPattern.start.startsWith( this.start ) ) {
				return false;
			}
		}

		return true;
	}

	public boolean matchEnd(Pattern otherPattern) {
		if( !this.end.isEmpty() && !otherPattern.end.isEmpty() ) {
			if( !otherPattern.end.endsWith( this.end ) ) {
				return false;
			}
		}

		return true;
	}

	public boolean match(Pattern otherPattern) {
		if( !this.start.isEmpty() && !otherPattern.start.isEmpty() ) {
			if( this.start.length() < otherPattern.start.length() ) {
				if( !otherPattern.start.startsWith( this.start ) ) {
					return false;
				}
			} else {
				if( !this.start.startsWith( otherPattern.start ) ) {
					return false;
				}
			}
		}

		if( !this.end.isEmpty() && !otherPattern.end.isEmpty() ) {
			if( this.end.length() < otherPattern.end.length() ) {
				if( !otherPattern.end.endsWith( this.end ) ) {
					return false;
				}
			} else {
				if( !this.end.endsWith( otherPattern.end ) ) {
					return false;
				}
			}
		}
		
		return true;
	}
	
}