package code.bussinesslayer;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import code.datalayer.Serializator;

import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

@SuppressWarnings( "deprecation" )
public class DeliveryService extends Observable implements IDeliveryServiceProcessing {

    Serializator s = new Serializator();
    HashMap<Order, Set<MenuItem>> hashMap;
    static int n = 0;

    public DeliveryService(){
        if(s.deserializeOrders() == null){
            hashMap = new HashMap<>();
        }else{
            hashMap = s.deserializeOrders();
        }
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public boolean isWellFormed(){
        if(Serializator.deserializeUsers() == null){
            return false;
        }
        return true;
    }

    /**
     * @pre give a valid csv file
     * @post serialize items from csv
     */
    @Override
    public void csvProducts() {
        Set<MenuItem> items = s.deserialize();

        assert !items.isEmpty();

        Set<MenuItem> uniqueItems ;

        String filePath = "C:\\Users\\aocta\\Desktop\\FoodDelivery\\src\\resources\\products.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> r = reader.readAll();
            r.remove(0);
           r.forEach(x -> items.add(new BaseProduct(Arrays.toString(x))));

        } catch (IOException e) {
            e.printStackTrace();
        }
        uniqueItems = items.stream()
                .filter(distinctByKey(item -> item.getTitle()))
                .collect(Collectors.toSet());

        s.serialize(uniqueItems);
        assert !uniqueItems.isEmpty();
        assert isWellFormed();
    }

    /**
     * @param mi item to be inserted
     * @pre give a valid item
     * @post serialize it
     */
    @Override
    public void insertMenuItem(MenuItem mi){
        Set<MenuItem> menuItems = s.deserialize();
        assert !(searchMenuItem(mi.getTitle(), -1,-1, -1, -1, -1, -1).size() >0);
        menuItems.add(mi);
        s.serialize(menuItems);
        assert !(searchMenuItem(mi.getTitle(), -1,-1, -1, -1, -1, -1).size() == 1);
        assert isWellFormed();
    }

    /**
     * @param mi item to be deleted
     * @pre give a valid item
     * @post remove it from list
     */
    @Override
    public void deleteMenuItem(String mi) {
        Set<MenuItem> menuItems = s.deserialize();
        assert !(searchMenuItem(mi, -1,-1, -1, -1, -1, -1).size() == 1);
        for (MenuItem i : menuItems) {
            if (i.getTitle().equals(mi)) {
                 System.out.println(i.getTitle());
                menuItems.remove(i);
                break;
            }
        }
        s.serialize(menuItems);
        assert !(searchMenuItem(mi, -1,-1, -1, -1, -1, -1).size() >0);
        assert isWellFormed();
    }

    /**
     * @param title the title of the actual product
     * @param newTitle new title for the modified product
     * @param rating new rating for the modified product
     * @param calories new calories for the modified product
     * @param proteins new proteins for the modified product
     * @param fats new fats for the modified product
     * @param sodium  new sodium for the modified prouct
     * @param price new price for the modified product
     * @pre given a valid title to found the product
     * @post serialize the modified product
     */
    @Override
    public void modifyMenuItem(String title, String newTitle, double rating, int calories, int proteins, int fats, int sodium, int price){
        Set<MenuItem> menuItems = s.deserialize();
        assert !(searchMenuItem(title, -1,-1, -1, -1, -1, -1).size() == 1);
        int ok = 0;
        for(MenuItem i : menuItems){
            if ((i.getTitle().equals(title))) {
                for (MenuItem j : menuItems) {
                    if(j.getTitle().equals(newTitle)) {
                        break;
                    }
                    ok = 1;
                    i.setTitle(newTitle);
                    i.setRating(rating);
                    i.setCalories(calories);
                    i.setFats(fats);
                    i.setPrice(price);
                    i.setSodium(sodium);
                    i.setProteins(proteins);
                }
            }
        }
        if(ok == 0) {
            System.out.println("The product doesn't exist");
            return;
        }
        s.serialize(menuItems);
        assert !(searchMenuItem(newTitle, -1,-1, -1, -1, -1, -1).size() == 1);
        assert isWellFormed();
    }

    public Serializator getS() {
        return s;
    }

    /**
     * @param title of the product to be searched
     * @param minRating minimum rating to be search
     * @param maxCalories maximum calories to be searched
     * @param maxProteins maximum proteins to be searched
     * @param maxFats maximum fats to be searched
     * @param maxSodium maximum sodium to be searched
     * @param maxPrice maximum price to be searched
     * @return the set of MenuItems with all the products that match the description given by user
     * @pre valid data input
     * @post set of MenuItems
     */
    @Override
    public Set<MenuItem> searchMenuItem(String title, double minRating, int maxCalories, int maxProteins, int maxFats, int maxSodium, int maxPrice) {
        assert !(!title.isEmpty()  || maxCalories >= 0 || maxProteins >= 0 || maxFats >= 0 || maxSodium >= 0 || maxPrice >= 0);

        Set<MenuItem> mi = s.deserialize();
        mi = mi.stream()
                .filter(menuItem -> menuItem.getRating() >= minRating)
                .filter(menuItem -> menuItem.getTitle().contains(title))
                .filter(menuItem -> menuItem.getProteins() <= maxProteins)
                .filter(menuItem -> menuItem.getCalories() <= maxCalories)
                .filter(menuItem -> menuItem.getSodium() <= maxSodium)
                .filter(menuItem -> menuItem.getFats() <= maxFats)
                .filter(menuItem -> menuItem.getPrice() <= maxPrice)
                .collect(Collectors.toCollection((HashSet::new)));
        assert !mi.isEmpty();
        assert isWellFormed();
        return mi;
    }

    public void createBill(Order o){
        FileWriter fw = null;
        try{
            fw = new FileWriter("src/resources/bill" + n + ".txt");
        }catch(IOException e){
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        n++;
        ArrayList<MenuItem> prod = new ArrayList<>();
        prod.addAll(this.hashMap.get(o));
        pw.println(o);
        for(MenuItem mi : prod){
            pw.println(mi);
        }
        pw.close();
    }

    /**
     * @param products list of products to be ordered
     * @param clientID the id of the client that ordered
     * @pre desirialize the orders
     * @post serialize the orders
     */

    @Override
    public void createOrder (Set < MenuItem > products,int clientID){
        assert !products.isEmpty() || clientID > 0;
        if(s.deserializeOrders() != null){
            this.hashMap = s.deserializeOrders();
        }
        Order o = new Order(clientID);
        this.hashMap.put(o, products);
        createBill(o);
        s.serializeOrders(hashMap);
        setChanged();
        notifyObservers(o.toString());
        assert !this.hashMap.containsKey(o);
        assert isWellFormed();
    }

    public String[][] populateTable(){
        int size = s.deserialize().size();
        String[][] table = new String[size][7];
        ArrayList<MenuItem> products = new ArrayList<>();
        products.addAll(s.deserialize());
        int k = 0;
        for(MenuItem mi : products){
            table[k][0] = mi.getTitle();
            table[k][1] = String.valueOf(mi.getRating());
            table[k][2] = String.valueOf(mi.getCalories());
            table[k][3] = String.valueOf(mi.getProteins());
            table[k][4] = String.valueOf(mi.getFats());
            table[k][5] = String.valueOf(mi.getSodium());
            table[k][6] = String.valueOf(mi.getPrice());
            k++;

        }
        System.out.println(products.size());
        return table;
    }

    public String[][] populateTableAfterSearch(String title, double minRating, int maxCalories, int maxProteins, int maxFats, int maxSodium, int maxPrice){
        int size = searchMenuItem(title, minRating, maxCalories, maxProteins, maxFats, maxSodium, maxPrice).size();
        Set<MenuItem> menuSet = searchMenuItem(title, minRating, maxCalories, maxProteins, maxFats, maxSodium, maxPrice);
        String[][] table = new String[size][7];
        ArrayList<MenuItem> products = new ArrayList<>();
        products.addAll(menuSet);
        int k = 0;
        for(MenuItem mi : products){
            table[k][0] = mi.getTitle();
            table[k][1] = String.valueOf(mi.getRating());
            table[k][2] = String.valueOf(mi.getCalories());
            table[k][3] = String.valueOf(mi.getProteins());
            table[k][4] = String.valueOf(mi.getFats());
            table[k][5] = String.valueOf(mi.getSodium());
            table[k][6] = String.valueOf(mi.getPrice());
            k++;
        }
        System.out.println(products.size());
        return table;
    }



    /**
     * @param startingHours the store opens at
     * @param finishHours the store close at
     * @pre check for valid values
     * @post post the valid orders
     */
    @Override
    public void report1(int startingHours, int finishHours){
        assert !(startingHours > 0 || finishHours > 0);
        Set<Order> orders = hashMap.keySet();
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src/resources/FirstReport.txt", true);
            fileWriter = new FileWriter("src/resources/FirstReport.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);

        orders = orders.stream()
                .filter(order -> order.getOrderDate().getHours() >= startingHours && order.getOrderDate().getHours() < finishHours)
                .collect(Collectors.toCollection((HashSet::new)));
        orders.stream().forEach(System.out::println);
        orders.stream().forEach(printWriter::println);

        assert orders.isEmpty();
        assert isWellFormed();
        printWriter.close();
    }

    public HashMap<Order, Set<MenuItem>> getHashMap() {
        return hashMap;
    }

    /**
     * @param specifiedNumber minimum number of an ordered product
     * @pre check for valid integer
     * @post report the products ordered more then speicifiedNumber
     */
    @Override
    public void report2(int specifiedNumber){
        assert specifiedNumber < 0;

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src/resources/SecondReport.txt", true);
            fileWriter = new FileWriter("src/resources/SecondReport.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);

        Collection<Set<MenuItem>> set = hashMap.values();
        ArrayList<String> products = new ArrayList<>();
        set.stream().forEach(s ->{
            s.stream().forEach(ss -> {
                products.add(ss.getTitle());
            });
        });
        products.stream()
                .filter(prod -> Collections.frequency(products, prod) >= specifiedNumber)
               .collect(Collectors.toSet()).forEach(printWriter::println);
        assert products.isEmpty();
        assert isWellFormed();
        printWriter.close();
    }

    /**
     * @param specifiedNumber minimum number of clients that have ordered
     * @param amount minimum amount of the order found
     * @pre check the products from hashmap
     * @post list those who with more
     */
    @Override
    public void report3(int specifiedNumber, int amount){
        assert !(specifiedNumber > 0 || amount > 0);

        File file = new File("src/resources/ThirdReport.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);

        Set<Order> orders = hashMap.keySet();
        ArrayList<Order> ord = new ArrayList<>();
        ord.addAll(orders);
        ArrayList<Integer> clientsID = new ArrayList<>();
        Set<Integer> id;
        orders.stream().forEach(o -> {
            clientsID.add(o.getClientID());
        });
        id = clientsID.stream()
                .filter(c -> Collections.frequency(clientsID, c) >= specifiedNumber)
                .collect(Collectors.toSet());
        id.forEach(System.out::println);
        id.stream()
                .forEach(c -> {
                    for (Order o : orders) {
                        int sum = 0;
                        if (o.getClientID() == c) {
                            Set<MenuItem> oo = hashMap.get(o);
                            for (MenuItem k : oo) {
                                sum = sum + k.computePrice();
                            }
                            if (sum >= amount) {
                                System.out.println("Client " + o.getClientID() + " price " + sum);
                                printWriter.println("Client " + o.getClientID() + " price " + sum);
                                printWriter.close();
                            }
                        }
                    }
                });
        assert clientsID.isEmpty();
        assert isWellFormed();
    }


    /**
     * @param day specified day
     * @pre check if the day is a valid one
     * @post list the orders that match the day
     */
    @Override
    public void report4(int day){
        assert day > 0;

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src/resources/FourthReport.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);

        Set<Order> orders = hashMap.keySet();
        ArrayList<String> products = new ArrayList<>();
        orders = orders.stream()
                .filter(order -> order.getOrderDate().getDate() == day)
                .collect(Collectors.toSet());
        orders.stream().forEach(o -> {
            hashMap.get(o).forEach(oo -> {
                products.add(oo.getTitle());
            });
        });
        products.stream()
                .distinct()
                .forEach(prod -> printWriter.println(Collections.frequency(products, prod) + " " + prod));
        printWriter.close();
        assert !products.isEmpty();
        assert isWellFormed();
    }

}
