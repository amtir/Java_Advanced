package module4;

public class ArrayUtil {

	public static float[] divArrays(int arr1[], int arr2[]) throws ArrayDataException {
		
		float result[]= null;
		
		try {
			if(arr1.length != arr2.length)
				throw new ArrayDataException("For dividing, arrays should be the same size.");
				
			result = new float[arr1.length];
			
			for(int i=0; i<arr1.length; i++)
				result[i]=(float)arr1[i]/arr2[i];
			
			return result;
		}catch (Exception e) {
			throw e;
		}
		finally {
			
		}
	}
		
	public static void main(String[] args) {
		int arr1[] = {1,2,3,4,5};
		int arr2[] = {3,4,5,6,7,8};
		
		try {
			float result[] = ArrayUtil.divArrays(arr1, arr2);
			
			for (int i=0;i<result.length;i++)
				System.out.println(result[i]);
					
		} catch (ArrayDataException e) {
			e.printStackTrace();
		}		
	}
}
