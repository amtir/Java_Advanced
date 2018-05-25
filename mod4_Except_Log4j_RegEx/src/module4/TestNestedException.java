package module4;

public class TestNestedException {

	public static void main(String[] args) {

		int arr1[] = {1,2,3,4,5,6};
		int arr2[] = {3,4,5,6,7,8};
		float result[]= null;
		

		try {
			
			if(arr1.length != arr2.length)
				throw new ArrayDataException("For dividing, arrays should be the same size.");
				
			try {
				result = new float[arr1.length];
				
				for(int i=0; i<arr1.length; i++)
					result[i]=(float)arr1[i]/arr2[i];
			} catch (ArithmeticException e) {
				e.printStackTrace();
			} 
			catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
			
			
			
		}catch (ArrayDataException e) {
			e.printStackTrace();
		}
		finally {
			if(result!=null) {
				for (int i=0;i<result.length;i++)
					System.out.println(result[i]);
			}
			else {
				
				System.out.println("Error occurred.");
			}
		}
		
	}
}
