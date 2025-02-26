public class Employee
{
    private int id;
    private string name;
    private string department;
    private bool working;

    public void SaveToDatabase();
    public void TerminateEmployee();
    public bool IsWorking();
}

public interface IEmployeeReport
{
    void PrintEmployeeDetailReport();
}

public class EmployeeReportXML : IEmployeeReport
{
    public void PrintEmployeeDetailReport();
}

public class EmployeeReportCSV : IEmployeeReport
{
    public void PrintEmployeeDetailReport();
}
