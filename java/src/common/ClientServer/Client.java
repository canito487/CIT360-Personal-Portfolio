package common.ClientServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by alex.hernandez on 6/23/16.
 * Modified on 07/11/16
 */


/**
 * ROUND 2:
 * Instructor Feedback:
 * "This is a nice and simple example.  Continue to expand it.
 * Consider things like logging as a part of your program.  Integrate for Strongly Agree."
 *
 *
 * IMPLEMENT LOGGING

 */
public class Client {

    // Instantiate Logger
    protected static Logger log = LoggerFactory.getLogger(Client.class);

    /**
     * Runs the client as an application.  First it displays a dialog
     * box asking for the IP address or hostname of a host running
     * the date server, then connects to it and displays the date that
     * it serves.
     */
    public static void main(String[] args) throws IOException {

        log.info("Starting input dialog");

        String serverAddress = JOptionPane.showInputDialog(
                "Enter IP Address of a machine that is\n" +
                        "running the date service on port 9090:");
        //Log server address
        log.info("Server address is: " + serverAddress);
        Socket s = new Socket(serverAddress, 9090);
        BufferedReader input =
                new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer = input.readLine();
        JOptionPane.showMessageDialog(null, answer);
        log.info("Exiting System");
        System.exit(0);
    }

}
