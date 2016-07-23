import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) 
	{
		Map<String, Object> empDetails=new HashMap<String, Object>();
		Scanner sc=new Scanner(System.in);
		
		empDetails.put("empId", sc.nextInt());
		empDetails.put("empName", sc.next());
		
		Employee employee=new Employee();
		
		employee.setEmpId((Integer) empDetails.get("empId"));
		employee.setEmpName((String) empDetails.get("empName"));
		
		System.out.println(empDetails.get("empId"));
		System.out.println(empDetails.get("empName"));

	}

}
