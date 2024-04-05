import java.util.Scanner;

public class UserInfo {
    private String name;
    private String userID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean checkNameContainsSpace() {
        return name.contains(" ");
    }

    public String generateUserID() {
        if (checkNameContainsSpace()) {
            String[] nameLong = name.split(" ");
            userID = nameLong[0].substring(0, 1) + nameLong[nameLong.length - 1];
            return userID;
        } else {
            return "guest";
        }
    }

    public void promptForName() {
        Scanner scanner = new Scanner(System.in);
        boolean isValidName = false;

        do {
            System.out.print("Enter the user name: ");
            String fullName = scanner.nextLine();

            if (fullName.isEmpty()) {
                System.out.println("Please enter your name!");
            } else {
                // Split the full name into individual words and check each one for letters only
                String[] nameWords = fullName.split(" ");
                boolean allWordsAreValid = true;
                for (String word : nameWords) {
                    if (!word.matches("[a-zA-Z]+")) {
                        allWordsAreValid = false;
                        System.out.printf("Invalid name! '%s' contains non-letter characters.%n", word);
                        break;
                    }
                }

                // If all words are valid, set the name and exit the loop
                if (allWordsAreValid) {
                    isValidName = true;
                    setName(fullName);
                }
            }
        } while (!isValidName);
    }

}
