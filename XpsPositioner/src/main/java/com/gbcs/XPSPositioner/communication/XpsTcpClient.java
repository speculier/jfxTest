package com.gbcs.XPSPositioner.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * XpsTcpClient
 * @author sp01515
 *
 */
public class XpsTcpClient {

    private static int    port;
    private static Socket socket;

    public void send(String message, int sPort)
    {
        InputStream input   = null;
   
        try
        {
            port   = sPort;
            socket = new Socket((String) null, port);

            // Open stream
            input = socket.getInputStream();

            // Show the server response
            String response = new BufferedReader(new InputStreamReader(input)).readLine();
            System.out.println("Server message: " + response);
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                input.close();
                socket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
