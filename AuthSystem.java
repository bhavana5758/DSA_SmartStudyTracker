import java.util.*;
import java.util.regex.*;

public class AuthSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<User> users = new ArrayList<>();

    static Pattern passwordPattern =
            Pattern.compile("^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,}$");

    static User login(){

        while(true){

            System.out.println("=== Login / Sign Up ===");

            System.out.print("Enter username: ");
            String uname = sc.nextLine();

            System.out.print("Enter password: ");
            String pass = sc.nextLine();

            for(User u: users){

                if(u.username.equals(uname)){

                    if(u.password.equals(pass)){

                        System.out.println("Login successful! Welcome "+uname);
                        return u;

                    }

                    else{
                        System.out.println("Invalid password!");
                        continue;
                    }

                }

            }

            if(!passwordPattern.matcher(pass).matches()){

                System.out.println("Password invalid!");
                continue;

            }

            User newUser = new User(uname,pass);

            users.add(newUser);

            System.out.println("Account created! Welcome "+uname);

            return newUser;

        }

    }

}