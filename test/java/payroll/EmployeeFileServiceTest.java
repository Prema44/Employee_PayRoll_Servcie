package payroll;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class EmployeeFileServiceTest {


	/**
	 * Writing the data to the file
	 */
	@Test
	public void given3Employee_WhenWrittenToFile_ShouldMatchEmployeeEntries() {
		Employee[] arrayOfEmps = { new Employee(1, "Jeff Bezos", 100000), new Employee(2, "Bill Gates", 200000),
				new Employee(3, "Mark Zuckerberg", 300000) };
		EmployeePayrollService empService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		empService.writeData(EmployeePayrollService.IOService.FILE_IO);
		long result = empService.countEntries(EmployeePayrollService.IOService.FILE_IO);
		assertEquals(3, result);

	}
	/**
	 * Printing the data in the file
	 */
	@Test
	public void given3Employee_WhenWrittenToFile_ShouldPrintEmployeeEntries() {
		Employee[] arrayOfEmps = { new Employee(1, "Jeff Bezos", 100000), new Employee(2, "Bill Gates", 200000),
				new Employee(3, "Mark Zuckerberg", 300000) };
		EmployeePayrollService empService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		empService.writeData(EmployeePayrollService.IOService.FILE_IO);
		empService.printData(EmployeePayrollService.IOService.FILE_IO);
		long result = empService.countEntries(EmployeePayrollService.IOService.FILE_IO);
		assertEquals(3, result);

	}
	
	/**
	 * Returning the Employee entries in the "payroll.txt" file
	 */
	@Test
	public void given3Employee_WhenWrittenToFile_ShouldReturnEmployeeEntries() {
		Employee[] arrayOfEmps = { new Employee(1, "Jeff Bezos", 100000), new Employee(2, "Bill Gates", 200000),
				new Employee(3, "Mark Zuckerberg", 300000) };
		EmployeePayrollService empService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		empService.writeData(EmployeePayrollService.IOService.FILE_IO);
		empService.printData(EmployeePayrollService.IOService.FILE_IO);
		long result = empService.countEntries(EmployeePayrollService.IOService.FILE_IO);
		assertEquals(3, result);

	}
	

}
