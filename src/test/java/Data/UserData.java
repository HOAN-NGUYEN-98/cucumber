package Data;

import Models.User;

public class UserData {
    public Object getData(){
        User user=new User();
        user.setUsername("admin");
        user.setPassword("password123");
        return  user;
    }
}
