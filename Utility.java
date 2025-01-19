import java.util.regex.*;

public class Utility {

    //used to check name
    public static void checkName(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        if (name.length() > 15) {
            throw new IllegalArgumentException("Name cannot be longer than 15 characters!");
        }
        //regex for allowed characters
        Pattern pattern = Pattern.compile("^[a-zA-Z ,\\-]*$");
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Name can only contain alphabets, spaces, dashes (-), or commas (,).");
        }
    }

    //used to check age
    public static void checkAge(String ageStr) {
        try {
            int age = Integer.parseInt(ageStr);
            if (age < 0 || age > 100) {
                throw new IllegalArgumentException("Age must be between 0 and 100 inclusive.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Age must be a valid integer.");
        }
    }
}
