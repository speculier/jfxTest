package com.gbcs.XPSPositioner.communication;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * XpsTcpServer
 * @author sp01515
 *
 */
public class XpsTcpServer {

	private static String        message = "Hello I'm your server.";
    private static int           port;
    private static ServerSocket  socket;

    /*private void doCalculate() {
        final Cursor oldCursor = scene.getCursor();
        scene.setCursor(Cursor.WAIT);
        calculateItem.setDisable(true);
        calculateButton.setDisable(true);
        final Service<Void> calculateService = new Service<Void>() {

            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {

                    @Override
                    protected Void call() throws Exception {
                        final int maxIterations = 1000000;
                        for (int iterations = 0; iterations < maxIterations; iterations ++) {
                            System.out.println(iterations);
                        }
                        return null;
                    }
                };
            }
        };
        
        calculateService.stateProperty().addListener((ObservableValue<? extends Worker.State> observableValue, Worker.State oldValue, Worker.State newValue) -> {
            switch (newValue) {
                case FAILED:
                case CANCELLED:
                case SUCCEEDED:
                    scene.setCursor(oldCursor);
                    calculateItem.setDisable(false);
                    calculateButton.setDisable(false);
                    break;
            }
        });
        calculateService.start();
    }*/
    
    /**
     * start
     * @param sPort
     */
    public static void start(int sPort)
    {
        try
        {
            port   =  sPort;
            socket = new ServerSocket(port);

            System.out.println("TCP server is running on " + port + "...");

            while (true)
            {
                // Accept new TCP client
                Socket client = socket.accept();
                // Open output stream
                OutputStream output = client.getOutputStream();

                System.out.println("New client, address " + client.getInetAddress() + " on " + client.getPort() + ".");

                // Write the message and close the connection
                output.write(message.getBytes());
                client.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                socket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}

