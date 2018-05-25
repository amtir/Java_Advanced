package mod1;

public class MatrixAdd {
	
	
	public static boolean checkDimension(int arr2D_1[][], int arr2D_2[][]) {
		
		for (int i = 0;i < arr2D_1.length ;i++) {			
			//System.out.println(arr2D_1.length + " ,  "  +  arr2D_2.length );		
			if ( arr2D_1.length != arr2D_2.length ) {
				
				 return false;
			}
				
				for(int j = 0;j < arr2D_1[i].length ; j++) {
					//System.out.println(arr2D_1[i].length + " ,  "  +  arr2D_2[i].length );
					if(arr2D_1 [i].length != arr2D_2 [i].length) {
						return false;
					}
					
				}
		
			}
		
		return true;
		
	}

	public static void main(String[] args) {

		int 
			arr2D_1 [][] = {{1,2,3}, {4,5,6}, {7,8,9}}, 			// {{1,2,3}, {4,5,6}},
			arr2D_2 [][] = {{10,11, 12}, {13,14,15}, {16,17,18}},   //  {{10,11}, {13,14,15}, {16,17,18}}, 
			arr2D_3 [][] = new int[3][3];
		
		
		if (!checkDimension(arr2D_1, arr2D_2))
		{
			System.out.println("Not the same dimension");
			System.exit(0); 
		}
		
		
		for (int i = 0;i < arr2D_1.length ;i++) {
			for(int j = 0;j < arr2D_1[i].length ; j++) {
				arr2D_3 [i][j] = arr2D_1 [i][j] + arr2D_2 [i][j] ;
				System.out.print(	arr2D_3 [i][j] + " ");
			}
			System.out.println();
			
			}

	}

}
