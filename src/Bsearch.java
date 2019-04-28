import java.util.Scanner;

public class Bsearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1,2,3,4,6,7,8,9};
		int i = 0;
		int j = a.length-1;
		int mid = j/2;
		//while(true)
		//{
		int req = new Scanner(System.in).nextInt();
		
		while(i<j){

			if(req==a[mid]){
				System.out.println("At index " + mid);
				break;
			}
			else if(req>a[mid]){
				i=mid;
				mid = j -  (j-i)/2;
				
			}
			else
			{
				j=mid;
				mid = i + (j-i)/2;
			}

		}
		System.out.println("search complete");
	}

}
//}