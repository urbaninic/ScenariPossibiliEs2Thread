/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercitazione_2_multithreadedserver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicou
 */

public class Server {
    
    ServerSocket ss;
    Socket socket;
    
    
    public Server (int porta)
    {
        try {
            ss = new ServerSocket(porta);
            System.out.println("Il server è in ascolto");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
        Svolte seguenti righe commentate su StartServer
        // scegliere uno dei due metodi alternativi per chiamata a metodo onListen()
        // this.onListen();
        // onListen();
        */
    }
    
    public void onListen(){
        
        while(true)
        // ciclo infinito per accettazione di nuove richieste da parte dei client
        {
            try 
            {
                socket = ss.accept();
                ConnectionManager cm = new ConnectionManager(socket, this);
                cm.start(); // start() chiama il run() da me creato
            }
            catch (IOException ex) 
            {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void scrivi(String messaggio)
    {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(messaggio+"\n");
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
