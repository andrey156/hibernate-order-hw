package mate.academy.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "orders")
public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    @JoinTable (name = "order_ticket",
                joinColumns = @JoinColumn (name = "order_id"),
                inverseJoinColumns = @JoinColumn (name = "ticket_id"))
    private List<Ticket> tickets;
    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;
    private LocalDateTime orderDate;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
