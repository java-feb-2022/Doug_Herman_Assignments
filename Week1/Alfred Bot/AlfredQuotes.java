import java.text.SimpleDateFormat;
import java.util.Date;

public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        String returnString = String.format("Hello, %s. Lovely to see you.", name);
        return returnString;
    }

    public String guestGreeting() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
        int hour = Integer.parseInt(simpleDateFormat.format(new Date()));
        String dayPeriod;
        if (hour >= 0 && hour < 12)
            dayPeriod = "morning";
        else if (hour >= 12 && hour < 5)
            dayPeriod = "afternoon";
        else
            dayPeriod = "evening";
        String returnString = String.format("Good %s. Lovely to see you.", dayPeriod);
        return returnString;
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        String returnString = String.format("It is currently %tc.", date);
        return returnString;
    }
    
    public String respondBeforeAlexis(String conversation) {
        String returnString;
        if(conversation.indexOf("Alexis") >= 0)
            returnString = "Right away, sir. She certainly isn't sophisticated enough for that.";
        else if (conversation.indexOf("Alfred") >= 0)
            returnString = "At your service. As you wish, naturally.";
        else
            returnString = "Right. And with that I shall retire.";
        return returnString;
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

