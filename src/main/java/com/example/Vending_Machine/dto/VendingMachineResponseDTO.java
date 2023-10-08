package com.example.Vending_Machine.dto;

public class VendingMachineResponseDTO {
    private String total;
    private Integer depositMoney;
    private String change;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Integer getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(Integer depositMoney) {
        this.depositMoney = depositMoney;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }
}
