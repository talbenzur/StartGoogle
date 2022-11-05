package week1.ex1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] numbers= {1,2,3,4,5,6,7,8,9,10,11,12};
        Loops.Loop_foreach(numbers,2 );
        Loops.Loop_for(numbers,2 );
        Loops.Loop_while(numbers,2 );

        Map<String, User> users= Create_hashmap();
        String id="12";
        User user= get_user_by_id(users, id);

        System.out.println("user of id: "+id+" is: "+user);
        System.out.println("ths size of users array: " +count_users(users));
    }

    //Create a HashMap (<userId, Week1.Ex1.User>) of random users.
    public static Map<String, User> Create_hashmap(){
        Map<String, User> user_hashmap= new HashMap<>();
        int size= 5;
        List<User> users= Generator.generateUserList( size);
        for( User user:users) {
            user_hashmap.put(user.getId(), user);
        }
        return user_hashmap;
    }

    //Get a user from a List of users by id.
    public static User get_user_by_id (Map<String, User> users,String id ){
        User user=users.get(id);
        return user;
    }
    //Count how many of the users are activated.
    public static int count_users(Map<String, User> users){
        return users.size();
    }

}


