package com.herissonsilva.dev.dao.customer_account;

import com.herissonsilva.dev.customer_account.CustomerAccount;
import com.herissonsilva.dev.database.Database;

import java.util.ArrayList;
import java.util.List;

public class CustomerAccountJDBC implements CustomerAccountDao
{
    private Database database;

    public CustomerAccountJDBC()
    {
        database = new Database("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/BackTest_App", "herisson", "root");
    }

    private List<CustomerAccount> executeQuery(String query)
    {
        List<CustomerAccount> customerAccounts = new ArrayList<CustomerAccount>();
        if(database.connect())
        {
            try
            {
                database.setResultSet(query);
                while (database.getResultSet().next())
                {
                    Integer idCustomer = database.getResultSet().getInt("id_customer");
                    String cpf_cnpj = database.getResultSet().getString("cpf_cnpj");
                    String nameCustomer = database.getResultSet().getString("nm_customer");
                    Integer isActive = database.getResultSet().getInt("is_active");
                    Double valorTotal = database.getResultSet().getDouble("val_total");
                    customerAccounts.add(new CustomerAccount(idCustomer, cpf_cnpj, nameCustomer, isActive, valorTotal));
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }finally
            {
                database.close(true, false, true);
            }
        }
        return customerAccounts;
    }

    private boolean execute(String query)
    {
        boolean success = false;
        if(database.connect())
        {
            if (database.executeQuery(query)>0)
            {
                success = true;
            }
            database.close(true, true, false);
        }
        return success;
    }

    public boolean insert(CustomerAccount customerAccount)
    {
        return execute("insert into tb_customer_account (cpf_cnpj, nm_customer, is_active, val_total)"+
                "values('"+customerAccount.getCpf_cnpj()+"', '"+customerAccount.getNameCustomer()+"',"+
                "'"+customerAccount.getIsActive()+"', '"+customerAccount.getValueTotal()+"')");
    }

    public boolean update(CustomerAccount customerAccount)
    {
        return execute("update tb_customer_account set cpf_cnpj='"+customerAccount.getCpf_cnpj()+"',"+
                "nm_customer='"+customerAccount.getNameCustomer()+"', is_active='"+customerAccount.getIsActive()+"',"+
                "val_total='"+customerAccount.getValueTotal()+"'");
    }

    public boolean delete(CustomerAccount customerAccount)
    {
        return execute("delete from tb_customer_account where id="+customerAccount.getIdCustomer());
    }

    public List<CustomerAccount> all()
    {
        return executeQuery("select * from tb_customer_account");
    }

    public List<CustomerAccount> search(String field, String value)
    {
        return executeQuery("select * from tb_customer_account where "+field+" like '%"+value+"%'");
    }

    public List<CustomerAccount> select(String colunm, String conditions)
    {
        return executeQuery("select "+colunm+" from tb_customer_account where "+conditions);
    }

    public CustomerAccount getByID(int id)
    {
        List<CustomerAccount> customerAccounts = executeQuery("select * from tb_customer_account where id="+id);
        if (customerAccounts.size()>0)
        {
            return customerAccounts.get(0);
        }
        return null;
    }

    public CustomerAccount getLastRegistry()
    {
        List<CustomerAccount> customerAccounts = executeQuery("select * from tb_customer_account order by id desc limit 1");
        if (customerAccounts.size()>0)
        {
            return customerAccounts.get(0);
        }
        return null;
    }
}
