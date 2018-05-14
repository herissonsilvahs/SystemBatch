package com.herissonsilva.dev.dao.customer_account;

import com.herissonsilva.dev.customer_account.CustomerAccount;

import java.util.List;

public interface CustomerAccountDao
{
    boolean insert(CustomerAccount customerAccount);

    boolean update(CustomerAccount customerAccount);

    boolean delete(CustomerAccount customerAccount);

    List<CustomerAccount> all();

    List<CustomerAccount> search(String field, String value);

    List<CustomerAccount> select(String colunm, String conditions);

    CustomerAccount getByID(int id);

    CustomerAccount getLastRegistry();
}
