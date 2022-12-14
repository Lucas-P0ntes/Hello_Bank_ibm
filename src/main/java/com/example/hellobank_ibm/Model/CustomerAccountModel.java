package com.example.hellobank_ibm.Model;

import javax.persistence.*;

@Entity
@Table(name="account")
public class CustomerAccountModel {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String agencia;
    private String conta;
    private Integer saldo;
    private Integer customer;



    public CustomerAccountModel(String agencia, String conta, Integer saldo, Integer customer) {
        this.agencia = agencia;
        this.conta = conta;
        this.saldo = saldo;
        this.customer = customer;
    }

    public CustomerAccountModel() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Integer getCustumer() {
        return customer;
    }

    public void setCustumer(Integer custumer) {
        this.customer = custumer;
    }
}
