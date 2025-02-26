using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

public class CustomerSearch
{
    private readonly DatabaseContext db;

    public CustomerSearch(DatabaseContext databaseContext)
    {
        db = databaseContext;
    }

    public List<Customer> SearchByCountry(string country)
    {
        return db.Customers
            .Where(customer => customer.Country.Contains(country))
            .OrderBy(customer => customer.CustomerID)
            .ToList();
    }

    public List<Customer> SearchByCompanyName(string companyName)
    {
        return db.Customers
            .Where(customer => customer.CompanyName.Contains(companyName))
            .OrderBy(customer => customer.CustomerID)
            .ToList();
    }

    public List<Customer> SearchByContactPerson(string contactPerson)
    {
        return db.Customers
            .Where(customer => customer.ContactName.Contains(contactPerson))
            .OrderBy(customer => customer.CustomerID)
            .ToList();
    }

    public string ExportCustomersToCSV(List<Customer> customers)
    {
        var csvBuilder = new StringBuilder();

        foreach (var customer in customers)
        {
            csvBuilder.AppendFormat("{0},{1},{2},{3}", customer.CustomerID, customer.CompanyName, customer.ContactName, customer.Country);
            csvBuilder.AppendLine();
        }

        return csvBuilder.ToString();
    }
}
