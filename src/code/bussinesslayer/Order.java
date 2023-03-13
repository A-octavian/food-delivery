package code.bussinesslayer;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order implements Serializable {

    private static int id = 1;
    private int orderID;
    private int clientID;
    private final Date orderDate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMMM/yyyy HH:mm:s");

    public Order(int clientID) {
        this.orderID = id;
        this.clientID = clientID;
        id++;
        this.orderDate = new Date();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public int getClientID() {
        return clientID;
    }

    @Override
    public int hashCode() {
        return this.orderID;
    }

    @Override
    public String toString() {
        return "Order{" +
                ", orderDate = " + dateFormat.format(orderDate) +
                ", orderID = " + orderID +
                '}';
    }
}
