package module3;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class CapitalCountry {
	
	public static void main(String args[]) {
	
		ResourceBundle resBundle = ResourceBundle.getBundle( "I18nBundle", new Locale("fr", "FR") );
		
		Enumeration<String> keys = resBundle.getKeys();
		String country = null;
		String capital = null;
		
		while(keys.hasMoreElements()) {
			country = (String)keys.nextElement();
			capital = resBundle.getString(country);
			System.out.println("The capital of " + country + " is " + capital + ".");
		}
	}
}
