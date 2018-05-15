package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.*;

public final class Forum {

    private final List<ForumUser> listOfUsers = new ArrayList<>();

    public List<ForumUser> getUserList(){
        Random r = new Random();
        for(int i=0;i<100;i++){
            listOfUsers.add(new ForumUser(i*1000 + r.nextInt(1000),
                    "User" + i,
                    r.nextBoolean() ? 'M' : 'F',
                    LocalDate.of(1970 + r.nextInt(38), 1 + r.nextInt(12), 1 + r.nextInt(28)),
                    r.nextInt(100)));
        }
        List<ForumUser> list = listOfUsers;
        return list;
    }

}
