package module4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DateFormatChecker {
	
	public static void main(String[] args) {
		// Regex pattern for date DD/MM/YYY format
		String pattern = "[0-9]{2}/[0-9]{2}/[0-9]{4}";
		String strDateInput = "06/05/2018";
		
		// Create a pattern object
		Pattern patt = Pattern.compile(pattern);
		Matcher m = patt.matcher(strDateInput);
		
		if(m.find())
			System.out.println("Date DD/MM/YYY format: YES");
		else 
			System.out.println("Date DD/MM/YYY format: NO");
	}

}
