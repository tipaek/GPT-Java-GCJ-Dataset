public final class Arrays
{
	public static STLSet[] initializeWithDefaultSTLSetInstances(int length)
	{
		STLSet[] array = new STLSet[length];
		for (int i = 0; i < length; i++)
		{
			array[i] = new STLSet();
		}
		return array;
	}

	public static <T extends java.io.Closeable> void deleteArray(T[] array)
	{
		for (T element : array)
		{
			if (element != null)
				element.close();
		}
	}
}