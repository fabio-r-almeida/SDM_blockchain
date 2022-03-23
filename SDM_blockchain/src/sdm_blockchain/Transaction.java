/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdm_blockchain;

import java.util.ArrayList;

/**
 *
 * @author Fabio
 */
public class Transaction {

    private int type;
    private String clientID;
    private String storeID;
    private ArrayList<String> listOfProducts;
    private float price;
    private int orderID;

    public Transaction(int type, String clientID, String storeID, ArrayList<String> listOfProducts, float price, int orderID) {
        this.type = type;
        this.clientID = clientID;
        this.storeID = storeID;
        this.listOfProducts = listOfProducts;
        this.price = price;
        this.orderID = orderID;

    }

    public int getType() {

        return type;
    }

    public String getStoreID() {
        return storeID;
    }

    public String getClientID() {
        return clientID;
    }

    public ArrayList<String> getListOfProducts() {
        return listOfProducts;
    }

    public float getPrice() {
        return price;
    }

    public int getOrderID() {
        return orderID;
    }
}
