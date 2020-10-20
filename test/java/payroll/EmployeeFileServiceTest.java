package payroll;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class EmployeeFileServiceTest {

	@Test
	public void given3Employee_WhenWrittenToFile_ShouldMatchEmployeeEntries() {
		Employee[] arrayOfEmps = { new Employee(1, "Jeff Bezos", 100000), new Employee(2, "Bill Gates", 200000),
				new Employee(3, "Mark Zuckerberg", 300000) };
		EmployeePayrollService enpService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		enpService.writeData(EmployeePayrollService.IOService.FILE_IO);
		enpService.printData(EmployeePayrollService.IOService.FILE_IO);
		long result = enpService.countEntries(EmployeePayrollService.IOService.FILE_IO);
		assertEquals(3, result);
	}
	
	

}
