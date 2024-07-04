import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution
{
	private Scanner scanner;
	private InputStream in;
	private PrintStream out;
	private List<Move> allMoves = new ArrayList<>();

	public Solution(InputStream in, PrintStream out)
	{
		this.in = in;
		this.out = out;
		this.scanner = new Scanner(in);

		new Move(0, 1, new Loc(0, 0), null, null);

		allMoves.sort(Comparator.comparingInt(v -> v.moveIndex));
	}

	public static void main(String args[])
	{
		Solution expogo = new Solution(System.in, System.out);
		expogo.go();
	}

	public void test(int testNum, int x, int y)
	{
		String answer = allMoves.stream()
						.filter(v -> v.position.x == x && v.position.y == y)
						.findFirst().map(this::createPath)
						.orElse("IMPOSSIBLE");

		out.println("Case #" + testNum + ": " + answer);
	}

	private String createPath(Move move)
	{
		StringBuilder moves = new StringBuilder();

		while (move.parent != null)
		{
			moves.insert(0, move.directionToGetHere.str);
			move = move.parent;
		}

		return moves.toString();
	}

	void go()
	{
		int tests = scanner.nextInt();

		for (int i = 1; i <= tests; i++)
		{
			int x = scanner.nextInt();
			int y = scanner.nextInt();

			test(i, x, y);
		}
	}

	enum Direction
	{
		NORTH("N"),
		EAST("E"),
		SOUTH("S"),
		WEST("W");

		public final String str;

		Direction(String str)
		{
			this.str = str;
		}
	}

	static class Loc
	{
		public int x, y;

		public Loc(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}

	class Move
	{
		int moveIndex;
		int moveAmount;
		Loc position;
		List<Move> nextMoves = new ArrayList<>();
		Move parent;
		Direction directionToGetHere;

		public Move(int moveIndex, int moveAmount, Loc position, Move parent, Direction directionToGetHere)
		{
			this.moveIndex = moveIndex;
			this.moveAmount = moveAmount;
			this.position = position;
			this.parent = parent;
			this.directionToGetHere = directionToGetHere;
			if (moveIndex < 10)
			{
				for (Direction d : Direction.values())
				{
					Loc nextPos = inDirection(d, position);
					nextMoves.add(new Move(moveIndex + 1, moveAmount * 2, nextPos, this, d));
				}
				allMoves.addAll(nextMoves);
			}
		}

		private Loc inDirection(Direction direction, Loc current)
		{
			switch (direction)
			{
				case EAST:
					return new Loc(current.x + moveAmount, current.y);
				case NORTH:
					return new Loc(current.x, current.y + moveAmount);
				case SOUTH:
					return new Loc(current.x, current.y - moveAmount);
				case WEST:
					return new Loc(current.x - moveAmount, current.y);
				default:
					throw new IllegalStateException();
			}
		}
	}
}
