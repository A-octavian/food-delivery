package code.bussinesslayer;

import java.util.Set;

public interface IDeliveryServiceProcessing {

    /**
     * @pre give a valid csv file
     * @post serialize items from csv
     */
    void csvProducts();

    /**
     *
     * @param mi item to be inserted
     * @pre give a valid item
     * @post serialize it
     */
    void insertMenuItem(MenuItem mi);

    /**
     * @param mi item to be deleted
     * @pre give a valid item
     * @post remove it from list
     */
    void deleteMenuItem(String mi);

    /**
     * @param startingHours the store opens at
     * @param finishHours the store close at
     * @pre check for valid values
     * @post post the valid orders
     */
    void report1(int startingHours, int finishHours);

    /**
     * @param specifiedNumber minimum number of an ordered product
     * @pre check for valid integer
     * @post report the products ordered more then speicifiedNumber
     */
    void report2(int specifiedNumber);

    /**
     * @param specifiedNumber minimum number of clients that have ordered
     * @param amount minimum amount of the order found
     * @pre check the products from hashmap
     * @post list those who with more
     */
    void report3(int specifiedNumber, int amount);

    /**
     * @param day specified day
     * @pre check if the day is a valid one
     * @post list the orders that match the day
     */
    void report4(int day);

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
    void modifyMenuItem(String title, String newTitle, double rating, int calories, int proteins, int fats, int sodium, int price);

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
    Set<MenuItem> searchMenuItem(String title, double minRating, int maxCalories, int maxProteins, int maxFats, int maxSodium, int maxPrice);

    /**
     * @param products list of products to be ordered
     * @param clientID the id of the client that ordered
     * @pre desirialize the orders
     * @post serialize the orders
     */
    void createOrder(Set<MenuItem> products, int clientID);

}
