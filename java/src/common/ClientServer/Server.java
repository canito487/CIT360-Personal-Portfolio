package common.ClientServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

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
public class Server {

    protected static Logger log = LoggerFactory.getLogger(Server.class);

    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        try {
            while (true) {
                Socket socket = listener.accept();
                log.info("Starting Server");
                try {
                    PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                    log.info(new Date().toString());

                } finally {
                    log.info("Closing Socket");
                    socket.close();
                }
            }
        } finally {
            log.info("Closing Listener");
            listener.close();
        }
    }

}
