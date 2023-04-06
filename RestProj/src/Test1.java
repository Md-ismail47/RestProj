import java.util.Arrays;

public class Test1 
{
	public static void main(String[] args)
	{
		String a="dcba";
		char[] ab = a.toCharArray();
		System.out.println(ab);
		Arrays.sort(ab);
		System.out.println(ab);
	}

}
