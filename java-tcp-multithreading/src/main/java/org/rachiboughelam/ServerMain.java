package org.rachiboughelam;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public ServerMain() throws Exception{

        ServerSocket serverSocket = new ServerSocket ( 2020 );
        System.out.println("Port 2020 is now open");

        // infinite while loop: wait for new connections
        while(true){
            Socket socket = serverSocket.accept ();
            ServerThread serverThread = new ServerThread (socket, this);
            Thread thread = new Thread (serverThread);
            thread.start ();
        }
    }

    private int clientNumber = 1;

    public int getClientNumber(){
        return clientNumber++;
    }

    public static void main ( String[] args ) {

        try{
            new ServerMain ();
        } catch (Exception e){
            e.printStackTrace ();
        }
    }

}
