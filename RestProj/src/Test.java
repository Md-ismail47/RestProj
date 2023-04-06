import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args)
	{
		 String s="aman";
		 s.length();
		 String rev="";
		 for(int i=s.length()-1;i>=0;i--)
		 {
			 //System.out.println(s.charAt(i));
			 rev=rev+s.charAt(i);
		 }
		 System.out.println(rev);
		 
		List<String> li =  new ArrayList<String>();
		li.add("habibi");
		li.add("habibi");
		System.out.println(li);
		Set<String> set = new HashSet<String>(); 
		set.addAll(li);
		System.out.println(set);
//		for (String string : li) 
//		{
//			set.add(string);
//			
//		}
//		System.out.println(set);
//		for (String string : set) 
//		{
//			System.out.println(string);
//			
//		}
		
		
	}

}
