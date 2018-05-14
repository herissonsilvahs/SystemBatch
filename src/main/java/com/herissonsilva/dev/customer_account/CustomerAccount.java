package com.herissonsilva.dev.customer_account;

public class CustomerAccount
{
    private Integer idCustomer;
    private String cpf_cnpj;
    private String nameCustomer;
    private Integer isActive;
    private Double valueTotal;

    public CustomerAccount(final Integer idCustomer,
                           final String cpf_cnpj,
                           final String nameCustomer,
                           final Integer isActive,
                           final Double valueTotal)
    {
        this.idCustomer = idCustomer;
        this.cpf_cnpj = cpf_cnpj;
        this.nameCustomer = nameCustomer;
        this.isActive = isActive;
        this.valueTotal = valueTotal;
    }

    public CustomerAccount(final String cpf_cnpj,
                           final String nameCustomer,
                           final Integer isActive,
                           final Double valueTotal)
    {
        this.cpf_cnpj = cpf_cnpj;
        this.nameCustomer = nameCustomer;
        this.isActive = isActive;
        this.valueTotal = valueTotal;
    }

    public Integer getIdCustomer()
    {
        return idCustomer;
    }

    public String getCpf_cnpj()
    {
        return cpf_cnpj;
    }

    public String getNameCustomer()
    {
        return nameCustomer;
    }

    public Integer getIsActive()
    {
        return isActive;
    }

    public Double getValueTotal()
    {
        return valueTotal;
    }
}
