package org.rachiboughelam;

import javax.xml.crypto.Data;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Receiver {

    public Receiver() throws Exception {

        DatagramSocket socket = new DatagramSocket ( 2020 );
        System.out.println ( "Receiver is running." );

        while (true) {

            byte[] buffer = new byte[1500]; //max transfert unit
            DatagramPacket packet = new DatagramPacket ( buffer , buffer.length );

            socket.receive ( packet );

            String message = new String ( buffer ).trim ( );
            System.out.println ( "Received: " + message );

            InetAddress sendersAddress = packet.getAddress ( );
            int sendersPort = packet.getPort ( );

            System.out.print ( "Enter your message: " );
            message = "Ok";
            buffer = message.getBytes ( );
            packet = new DatagramPacket ( buffer , buffer.length , sendersAddress , sendersPort );
            socket.send ( packet );

            System.out.print ( "Sent " + message );
        }
    }

    public static void main(String[] args){
        try{
            new Receiver ();

        } catch (Exception e){
            e.printStackTrace ();
        }
    }
}
