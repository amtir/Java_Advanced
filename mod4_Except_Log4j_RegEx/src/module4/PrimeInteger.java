package module4;

import java.util.Arrays;

public class PrimeInteger {

	public static void verifyPrime(int intArr[]) throws NotPrimeIntException {
		for(int i =0;i<intArr.length; i++) {
			if(!isPrime(intArr[i]))
				throw new NotPrimeIntException(intArr[i] + " at index " + i + 
						" is not a Prime number.");
		}
	}
	
	private static boolean isPrime(int n) {
		for(int i =2;i<=n/2;i++) 
			if(n % i == 0) return false;
		return true;
	}
	
	public static void main(String[] args) {
		try {
			int arrInt[] = {6,11,13,17,13,29,31,37,41,43,53,59,61,67};
			PrimeInteger.verifyPrime(arrInt);
			System.out.println(Arrays.toString(arrInt));
			System.out.println("Array with Prime numbers Verified");
		}catch (NotPrimeIntException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
