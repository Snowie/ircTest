import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Doran on 5/17/2015.
 */
public class ircMain {
    public static void main(String[] args) throws Exception {
        ircBot testBot = new ircBot("-----");
        testBot.setVerbose(false);
        testBot.connect("irc.twitch.tv", 6667, "oauth:your-oauth-here");
        testBot.joinChannel("#ChannelGoesHere");
    }
}
