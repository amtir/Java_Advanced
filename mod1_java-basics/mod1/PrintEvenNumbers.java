package mod1;

/**
 * @category Print Even numbers
 * @author Akram MTir
 * @since 04.05.2018
 *
 */

public class PrintEvenNumbers {
	
	public static void main(String[] args) {
		
		int arrNumber[] = {2,4,6,8,16,32,64,128,256,512};
		
		for(int i =0; i< arrNumber.length; i++) {
			
			if((arrNumber[i]%2) == 0) 
				System.out.println("Found an even number, arrNumber[" + i +"] = " + arrNumber[i]);
		}
	}

}
