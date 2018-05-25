package module3;

import java.util.Arrays;

public class SearchHelper implements ISearchHelper
{	
	static final Double DBL_VAL = 2.3;
	static final String STR_MESSG = "Found the Double Value %.2f at [Indexes] = %s";
	public boolean search(Integer [] list, Integer number)
	{
		for (int i = 0; i < list.length; i++)
		{
			if (list[i].intValue() == number.intValue())
				return true;
		}
		return false;
	}

	public boolean search(String [] list, String str)
	{
		for (int i = 0; i < list.length; i++)
		{
			if (list[i] == str)
				return true;
		}
		return false;
	}

	public static void main(String[] args) 
	{
		String [] str_list = {"Tom", "Y", "Z", "Q"};
		Integer [] int_list = {1,2,3,4,5};
		ISearchHelper sh = new SearchHelper();
		System.out.println(sh.search(int_list, 2));
		System.out.println(sh.search(str_list, "Tom"));
		
		MySearchHelper searchDbl = new MySearchHelper();
		Double dbl_list[] = {new Double(1.5), DBL_VAL , new Double(3.6), new Double(4.9), 
				DBL_VAL, new Double(5.0), DBL_VAL};
		System.out.printf(STR_MESSG , DBL_VAL, Arrays.toString( searchDbl.search(dbl_list, 
				DBL_VAL) ) );
	}
}
