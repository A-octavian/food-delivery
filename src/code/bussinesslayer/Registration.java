package code.bussinesslayer;


import code.datalayer.Serializator;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Registration implements Serializable{

    private String username;
    private String password;

    public Registration(){}

    public Registration(String username, String password){
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean register(String username, String password){

        Set<Registration> users = new HashSet<>();
        if(Serializator.deserializeUsers() != null){
            users = Serializator.deserializeUsers();
        }
        int ok = 0;
        for(Registration r : users){
            if(r.getUsername().equals(username)){
                ok = 1;
                break;
            }
        }
        if(ok == 0) {
            users.add(new Registration(username, password));
            Serializator.serializeUsers(users);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean login(String username, String password){
        Set<Registration> users = new HashSet<>();
        if(Serializator.deserializeUsers() != null){
            users = Serializator.deserializeUsers();
        }
        int ok = 0;
        for(Registration r : users) {
            if (r.getUsername().equals(username) && r.getPassword().equals(password)) {
                ok = 1;
                break;
            }
        }
        if(ok == 1){
            return true;
        }else{
            return false;
        }
    }

    public boolean registerMethod(String username, String password){
        File file = new File("C:\\Users\\aocta\\Desktop\\Food Delivery\\src\\resources\\log.txt");
        int ok = 0;
        try{
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                String[] check = data.split(",", 0);
                if(check[0].equals(username)){
                    ok = 1;
                }
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }

        if(ok == 1)
            return false;
        return true;
    }

    public void confirmRegistration(String username, String password){
        File file = new File("C:\\Users\\aocta\\Desktop\\Food Delivery\\src\\resources\\log.txt");
        if(registerMethod(username, password) == true){
            FileWriter fw = null;
            PrintWriter pw=null;
            try{
                fw = new FileWriter(file, true);
                pw = new PrintWriter(fw);
            } catch (IOException e){
                e.printStackTrace();
            }
            pw.println(username + "," + password);
            pw.close();
        } else {
            System.out.println("Invalid username");
        }
    }

    public boolean loginMethod(String username, String password){
        File file = new File("C:\\Users\\aocta\\Desktop\\Food Delivery\\src\\resources\\log.txt");
        int ok = 0;
        try{
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                String[] check = data.split(",", 0);
                if(check[0].equals(username) && check[1].equals(password)){
                    ok = 1;
                }
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
        if(ok == 1)
            return true;
        return false;
    }

    public boolean employeeLogin(String username, String password){
        if(username.equals("employee") && password.equals("employee")) {
            return true;
        }
        return false;
    }

    public boolean adminLogin(String username, String password){
        if(username.equals("admin") && password.equals("admin")) {
            return true;
        }
        return false;
    }
}
