package com.herissonsilva.dev.cli;

import com.herissonsilva.dev.customer_account.CustomerAccount;
import com.herissonsilva.dev.dao.customer_account.CustomerAccountDao;
import com.herissonsilva.dev.dao.customer_account.CustomerAccountJDBC;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class App
{
    private CustomerAccountDao customerAccountDao;

    public App()
    {
        this.customerAccountDao = new CustomerAccountJDBC();
    }

    public int numeroAleatorio(int min, int max)
    {
        return min + (int)(Math.random() * (max - min));
    }

    public void generateRegistrys(final int registryNumber)
    {

        Random random = new Random();
        /* Used for generate customer name */
        String[] firstNameList = {"Pedro", "Andre", "Carlos", "Joao", "Ana", "Lucia","Clarisse", "Julia", "Pablo", "Henrrique"};
        String[] lastNameList = {"Carvalho", "Souza", "Marques", "Martins", "Nascimento", "Guimaraes", "Junior","Ferraz"};

        int contador = 0;
        /* Generate values and insert new registry */
        while(contador < registryNumber)
        {
            int randomNumberFirstName = random.nextInt(9);
            int randomNumberLastName = random.nextInt(7);

            String customerName = firstNameList[randomNumberFirstName] + " " +lastNameList[randomNumberLastName];
            String customerCpfCnpj = String.valueOf(this.numeroAleatorio(100, 999)) + "." +
                    String.valueOf(this.numeroAleatorio(100, 999)) + "." +
                    String.valueOf(this.numeroAleatorio(100, 999)) + "." +
                    String.valueOf(this.numeroAleatorio(10, 99));

            Double valorTotal = 500 + (Math.random() * (2000 - 500));

            try {
                this.customerAccountDao.insert(new CustomerAccount(customerCpfCnpj,customerName,1,Math.ceil(valorTotal)));
            }catch(Exception ex)
            {
                System.out.println(ex.getMessage());
                System.exit(1);
            }

            contador++;
        }
    }

    public void showCustomers()
    {
        String query = "id_customer between 1500 and 2700 and val_total > 560"; // Query de acordo com algoritimo
        List<CustomerAccount> customerAccountList = this.customerAccountDao.select("*", query);
        int nRegistrys = customerAccountList.size();
        Double allValueTotalCustomers = 0.0;

        /* Ordenando customer por saldo */
        Collections.sort(customerAccountList, new Comparator<CustomerAccount>() {
            public int compare(CustomerAccount o1, CustomerAccount o2) {
                return o1.getValueTotal().compareTo(o2.getValueTotal());
            }
        });

        /* Lista Customers ordenados por saldo e soma os saldos */
        for (CustomerAccount aCustomerAccountList : customerAccountList)
        {
            System.out.println("\nCustomer ID: " + aCustomerAccountList.getIdCustomer()
                    + "\nCustomer Name: " + aCustomerAccountList.getNameCustomer()
                    + "\nCustomer Saldo: " + aCustomerAccountList.getValueTotal());

            allValueTotalCustomers = allValueTotalCustomers + aCustomerAccountList.getValueTotal();
        }

        /* Calculo media dos saldos */
        Double mediaValueTotalCustomers = allValueTotalCustomers / nRegistrys;

        System.out.println("\nMedia do Saldo dos Customers Listados: " + mediaValueTotalCustomers);

    }
}
