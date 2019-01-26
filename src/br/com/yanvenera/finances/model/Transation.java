package br.com.yanvenera.finances.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;


@Entity
@NamedQuery( query = "select sum(t.value) from Transation t where t.account = :pAccount " +
                     "group by day(t.date), month(t.date), year(t.date)",
            name = "SOMA_POR_DIA")
public class Transation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal value;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar date;

    @Enumerated
    private TransationType tipo;

    private String description;

    @ManyToOne
    private Account account;

    @ManyToMany
    private List<Category> categoryList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public TransationType getTipo() {
        return tipo;
    }

    public void setTipo(TransationType tipo) {
        this.tipo = tipo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
