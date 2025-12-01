public class Underscore_Use 
{
	public static void main(String[] args)
	{
		long ccn = 8867_7890_9876_3456L;
		System.out.println(ccn);		//8867789098763456

		int b = 97_434;
		System.out.println(b);			//97434

		// int c = 97434_;      		// CTE =>  illegal underscore
		// int d = _97434; 				//CTE => cannot find symbol	| variable not found
	
		int  _97434 = 1000;
        System.err.println(_97434);     //1000
		

	}
}

/*Use of Underscore
1. Readability
2. Search and Replace

- Should be used in between only
- Cannot be used at end it thorws CTE as illegal underscore
- Cannot be used at beginning it thorws CTE as cannot find symbol

*/