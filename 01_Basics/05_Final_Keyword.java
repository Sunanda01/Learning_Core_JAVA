class Final_Keyword
{
    public final static int a = 1000;
	// public final static int b;		//CTE => variable b might not have been initialized

	public static void main(String[] args)
	{
		int c = 10;
		System.out.println(c);		//10
		c = 20;
		System.out.println(c);		//20

		final int d = 30;
		// d = 40;					//CTE => cannot assign a value to final variable d

		final int e;				//decl+not init => no error
		e = 100;					//valid
		// e = 200;					//invalid => variable e might already have been assigned

		// b = 300;					//CTE => cannot find symbol
    }
}
