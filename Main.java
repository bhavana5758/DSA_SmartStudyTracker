public class Main {

    public static void main(String[] args){

        System.out.println("Welcome to Smart Student Study Tracker");

        User u = AuthSystem.login();

        Dashboard.start();

    }

}