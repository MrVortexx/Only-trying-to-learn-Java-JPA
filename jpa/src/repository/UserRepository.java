package repository;

import java.util.Date;

import domain.Users.Users;

public class UserRepository{
    private BaseRepository<Users> dao;

    UserRepository(){
        dao = new BaseRepository<>(Users.class);
    }

   Users findUserByUuid(String uuid){
       return dao.getEntityByUuid(uuid);
   }


   Users create(String name, Date birthday){
       Users user = new Users();

       user.setBirthday(birthday);
       user.setName(name);

        return dao.create(user);
   }

}