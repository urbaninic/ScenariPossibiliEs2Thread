/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercitazione_2_multithreadedserver;

import java.net.Socket;

/**
 *
 * @author nicou
 */

// to handle: gestire
public class ConnectionManager extends Thread{
    // classe che deve essere eseguita con thread
    
    // @overloading: varia la signatura del metodo, es. parametri, ritorni.
    
    private Socket socket;
    private Server server;
    
    public ConnectionManager(Socket socket, Server server){
        this.socket = socket;
        this.server = server;
    }
    
    @Override
    
    public void run(){
        System.out.println("Metodo run in esecuzione!");
        server.scrivi("Ciao client");
    }
}
