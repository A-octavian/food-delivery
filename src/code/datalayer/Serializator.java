package code.datalayer;

import code.bussinesslayer.MenuItem;
import code.bussinesslayer.Order;
import code.bussinesslayer.Registration;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Serializator {

    public Serializator(){
        Set<MenuItem> s = new HashSet<>();
        serialize(s);
    }

    public void serialize(Set<MenuItem> o) {
        FileOutputStream file = null;
        try {
            file = new FileOutputStream("src/resources/SerializedProducts.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(o);
            out.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void serializeUsers(Set<Registration> o) {
        FileOutputStream file = null;
        try {
            file = new FileOutputStream("src/resources/log.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(o);
            out.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serializeOrders(HashMap<Order, Set<MenuItem>> o) {
        FileOutputStream file = null;
        try {
            file = new FileOutputStream("src/resources/SerializedOrders.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(o);
            out.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<MenuItem> deserialize() {
        Set<MenuItem> itemsSet = new HashSet<>();
        FileInputStream file = null;
        try {
            file = new FileInputStream("src/resources/SerializedProducts.txt");
            ObjectInputStream in = new ObjectInputStream(file);
            itemsSet = (Set<MenuItem>) in.readObject();
            in.close();
            file.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return itemsSet;
    }

    public static Set<Registration> deserializeUsers() {
        Set<Registration> itemsSet = new HashSet<>();
        FileInputStream file = null;
        try {
            file = new FileInputStream("src/resources/log.txt");
            ObjectInputStream in = new ObjectInputStream(file);
            itemsSet = (Set<Registration>) in.readObject();
            in.close();
            file.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return itemsSet;
    }

    public HashMap<Order, Set<MenuItem>> deserializeOrders() {
        HashMap<Order, Set<MenuItem>> itemsSet = new HashMap<>();
        FileInputStream file = null;
        try {
            file = new FileInputStream("src/resources/SerializedOrders.txt");
            ObjectInputStream in = new ObjectInputStream(file);
            itemsSet = (HashMap<Order, Set<MenuItem>>) in.readObject();
            in.close();
            file.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
            return itemsSet;
    }

}
