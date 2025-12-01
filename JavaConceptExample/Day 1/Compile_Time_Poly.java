import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Compile_Time_Poly 
{
	//add(10,20);		---> CT Polymorphism
	public static void add(int x, int y) throws IOException
	{
		System.out.println(x+y);
	}

	//add(10,20,30);	---> CT Polymorphism
	protected static int add(int x, int y, int z) throws FileNotFoundException
	{
		return (x+y+z);
	}

	//add(10,20.5);		---> CT Polymorphism
	static double add(int x, double y) throws SQLException
	{
		return (x+y);
	}

	//add(10.5, 20);	---> CT Polymorphism
	private static double add(double x, int y)
	{
		return (x+y);
	}

	public static void main(String[] args){
		try {
            add(10,20);				 //Calling statement
            add(10,20,30);			 //Number of argments
            add(10,20.5);				//Type of argments
            add(10.5, 20);			//Order of arguments

        } catch (IOException |  SQLException e) {
            e.printStackTrace();
        }
	}
}
