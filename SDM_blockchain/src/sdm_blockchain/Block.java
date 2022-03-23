/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdm_blockchain;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 *
 * @author Fabio
 */
public class Block {

    private String hash;
    private String previousHash;
    private Transaction data;
    private long timeStamp;

    public Block(Transaction data, String previousHash) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();

    }

    public String calculateHash() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        DigitalFingerPrint dfp = new DigitalFingerPrint();

        String calculateHash = dfp.generateDigitalFingerPrint(previousHash + Long.toString(timeStamp) + data);
        return calculateHash;
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String setHash(String hash) {
        this.hash = hash;
        return hash;
    }

    public Transaction setData(Transaction data) {
        this.data = data;
        return data;
    }

    public Transaction getData() {
        return data;
    }
}
