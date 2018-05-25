package mod1;

public class PrintOddNumbers {

	
	public static void main(String[] args) {
		
		int arr2D_3x3[][] = {
								{1,2,3},
								{4,5,6},
								{7,8,9}
						};

		for(int i = 0; i < arr2D_3x3.length ; i++ ) {
			
			for(int j=0; j < arr2D_3x3[i].length; j++ ) {
				
				if(arr2D_3x3[i][j]%2==1) 
					System.out.printf("Odd Number at arr2D_3x3[%d][%d] = %d%n",  i, j, arr2D_3x3[i][j]);
				
			}
		}
	}

}
