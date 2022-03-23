/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sdm_blockchain;

import com.google.gson.GsonBuilder;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Fabio
 */
public class SDM_blockchain {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // TODO code application logic here
        /*Block genesisBlock = new Block("Hi! Im the first block, My name is Genesis :)", "0");
        System.out.println("Hash for block 1: " + genesisBlock.getHash());

        Block secondBlock = new Block("Hi! Im the second block", genesisBlock.getHash());
        System.out.println("Hash for block 2: " + secondBlock.getHash());

        Block thirdBlock = new Block("Hi! Im the last block", secondBlock.getHash());
        System.out.println("Hash for block 3: " + thirdBlock.getHash());*/

 /*blockchain.add(new Block("Hi! Im the first block, My name is Genesis :)", "0"));
        blockchain.add(new Block("Hi! Im the second block", blockchain.get(blockchain.size() - 1).getHash()));
        blockchain.add(new Block("Hi! Im the last block", blockchain.get(blockchain.size() - 1).getHash()));


        
        changeChainHash();
        changeChainData();
        isChainValid();
        
        
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);*/
        blockchain.add(new Block(new Transaction(0, "", "", new ArrayList<String>(), 0, 0), "0"));

        //First Transaction
        ArrayList<String> order1 = new ArrayList<>();
        order1.add("medium ham");
        order1.add("light coke");
        Transaction transaction1 = new Transaction(1, "123", "Capatica", order1, 12, 123);
        blockchain.add(new Block(transaction1, blockchain.get(blockchain.size() - 1).getHash()));

        //Second Transaction
        ArrayList<String> order2 = new ArrayList<>();
        order2.add("familiar peperoni");
        order2.add("soda 1.5lt");
        Transaction transaction2 = new Transaction(2, "456", "Almada", order2, 20, 321);
        blockchain.add(new Block(transaction2, blockchain.get(blockchain.size() - 1).getHash()));

        //Third Transaction
        Transaction transaction3 = new Transaction(3, "3213", "Almada", order1, 12, 123);
        blockchain.add(new Block(transaction3, blockchain.get(blockchain.size() - 1).getHash()));

        //Forth Transaction       
        Transaction transaction4 = new Transaction(4, "324", "Capatica", order2, 20, 321);
        blockchain.add(new Block(transaction4, blockchain.get(blockchain.size() - 1).getHash()));

        //Fifth Transaction
        Transaction transaction5 = new Transaction(5, "123", "Almada", order1, 12, 124);
        blockchain.add(new Block(transaction5, blockchain.get(blockchain.size() - 1).getHash()));

        System.out.println(isChainValid());
        changeChainData();
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
        System.out.println(isChainValid());

        // System.out.println("\nBlocks associated with order 123:\n"
        //       + new GsonBuilder().setPrettyPrinting().create().toJson(blocksForOrder(123)));
        // System.out.println("\nBlocks associated with order 321:\n"
        //       + new GsonBuilder().setPrettyPrinting().create().toJson(blocksForOrder(321)));
    }

    public static Boolean isChainValid() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Block currentBlock = null;
        Block previousBlock = null;

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("Chain is NOT valid!");
                return false;
            }
            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                System.out.println("Chain is NOT valid!");
                return false;
            }
        }
        System.out.println("Chain is valid!");
        return true;
    }

    public static void changeChainHash() {
        Iterator<Block> iterator = blockchain.iterator();
        iterator.next();
        Block secondBlock = iterator.next();
        secondBlock.setHash("000000000000000000000000000000000000000");
    }

    public static void changeChainData() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Iterator<Block> iterator = blockchain.iterator();
        iterator.next();

        Block secondBlock = iterator.next();

        ArrayList<String> corrupted_data = new ArrayList<>();
        corrupted_data.add("sdjqhdjkhas");
        corrupted_data.add("kjsahdjkashjdkj");
        Transaction corrupted_transaction = new Transaction(2, "00", "0000", corrupted_data, 20, 321);

        secondBlock.setData(corrupted_transaction);
        secondBlock.setHash(secondBlock.calculateHash());
    }

    public static ArrayList<Block> blocksForOrder(int orderID) {
        ArrayList<Block> blocksForOrder = new ArrayList<>();
        for (Iterator<Block> iterator = blockchain.iterator(); iterator.hasNext();) {
            Block nextBlock = iterator.next();

            if (nextBlock.getData().getOrderID() == orderID) {
                blocksForOrder.add(nextBlock);
            }
        }
        return blocksForOrder;
    }

}
