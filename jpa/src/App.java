import java.util.Date;

import domain.Users.Users;
import repository.UserRepository;

public class App {
    public static void main(String[] args) throws Exception {
      
        UserRepository repo = new UserRepository();
        Users createdUser = repo.create("exemplo kdoaksodkaoskdakso skdos ", new Date());

        Users user = repo.findUserByUuid(createdUser.getUuid());

        if(user == null){
            System.out.println("Find by uuid not works!");
        }else{
            System.out.println("Find by uuid works!");
            System.out.println(user.getName());
            System.out.println(user.getUuid());
            System.out.println(user.getBirthday());
            System.out.println(user.getCreatedAt());
            System.out.println(user.getId());
        }

    }
}
