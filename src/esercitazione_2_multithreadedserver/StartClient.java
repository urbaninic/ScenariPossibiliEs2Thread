/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercitazione_2_multithreadedserver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author nicou
 */
public class StartClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Client cli;
        try {
            cli = new Client(InetAddress.getLocalHost(),2000);
            String msgLetto = cli.leggi();
            System.out.println(msgLetto);
        } catch (UnknownHostException ex) {
            Logger.getLogger(StartClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        

}
