package by.psu.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "place")
public class Place {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number")
    private int number;

    @ManyToOne
    @JoinColumn(name = "row_id")
    private Row row;

    @OneToMany(mappedBy = "place")
    private Set<Ticket> orders;

    @Transient
    private int sessionStatus;

    public Place() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }

    public Set<Ticket> getOrders() {
        return orders;
    }

    public void setOrders(Set<Ticket> orders) {
        this.orders = orders;
    }

    public int getSessionStatus() {
        return sessionStatus;
    }

    public void setSessionStatus(int sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

    @Override
    public String toString() {
        return "Place [id=" + id + ", number=" + number + ", row=" + row + "]";
    }

}
