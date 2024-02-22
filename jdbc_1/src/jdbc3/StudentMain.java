package jdbc3;
import java.util.Scanner;
public class StudentMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = true;
		do {
			System.out.println("enter 1 to continue");
			System.out.println("enter 0 to to exit");
			int option1 = sc.nextInt();
			{
				if(option1 == 1) {
					System.out.println("enter 1 to insert");
					System.out.println("enter 2 to update");
					System.out.println("enter 3 to delete");
					int option = sc.nextInt();
				}else {
					flag = false;
				}
			}
			
		}while(flag);
	}

}
