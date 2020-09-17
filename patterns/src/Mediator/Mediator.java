package Mediator;

import java.util.Date;

public class Mediator {
        public static void main(String[] args) {
            User robert = new User("Вася");
            User john = new User("Петя");

            robert.sendMessage("Сообщение 1");
            john.sendMessage("Сообщение 2");

        }
    }

//mediator
    class ChatRoom {
        public static void showMessage(User user, String message){
            System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
        }
    }

    class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public User(String name){
            this.name  = name;
        }

        public void sendMessage(String message){
            ChatRoom.showMessage(this,message);
        }
    }