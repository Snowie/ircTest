/**
 * Created by Doran on 5/17/2015.
 */
import org.jibble.pircbot.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ircBot extends PircBot  {
    public ircBot(String name){
        this.setName(name);
    }

    private void logMessage(String channel, String sender, String message){
        Date dNow = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("(yyyy-MM-dd'T'HH:mm:ssz)");

        try{
            File logFile = new File("./" + channel + ".txt");
            FileWriter chatLog = new FileWriter(logFile, true);

            chatLog.write(sdf.format(dNow) + " " + sender + ">" + message + "\n");
            chatLog.flush();

            chatLog.close();
        }
        catch (IOException e) {
            System.out.println("IOException, message not logged!");
        }
    }

    @Override
    public void onMessage(String channel, String sender, String login, String hostname, String message){
        System.out.println(channel + ": " + sender + ">" + message);
        logMessage(channel, sender, message);

        if(message.equalsIgnoreCase("ping")) {
            sendMessage(channel, sender + ": pong!");
            System.out.println(channel + ": " + this.getName() + ">" + sender + ": pong!");
            logMessage(channel, this.getName(), sender + ": pong!");
        }
    }
}
