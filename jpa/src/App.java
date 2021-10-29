import java.util.Date;

import domain.Users.Users;
import repository.BaseRepository;
import repository.UserRepository;

public class App {
    public static void main(String[] args) throws Exception {
       /* Users user = new Users();
        user.setBirthday(new Date());
        user.setName("Uasdsapldaspldasdl");
        UserRepository repo = new UserRepository();
        repo.create(user);*/
        BaseRepository<Users> dao = new BaseRepository<>(Users.class);

        Users user = dao.getEntityByUuid("18c13c7c-0904-4590-bc75-c6a2730ed947");

        if(user == null){
            System.out.println("Its null");
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
