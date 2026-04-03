package fr.dawan.formationspring.repositories;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import fr.dawan.formationspring.entities.User;

@Repository
public class FakeUserRepository {
    
    private static Map<Long,User> dataDb=new HashMap<>();
    
    private long nextId=4L; 
    
    static {      
        User u=new User("John","Doe",LocalDate.of(1993, 10, 10),"jdoe@dawan.com","azerty");
        u.setId(1L);
        dataDb.put(1L, u);
        u=new User("Jo","Dalton",LocalDate.of(1988, 9, 1),"jdalton@dawan.com","azerty");
        u.setId(2L);
        dataDb.put(2L, u);
        u=new User("Yves","Roulo",LocalDate.of(1965, 3, 4),"yroulo@dawan.com","azerty");
        u.setId(3L);
        dataDb.put(3L, u);
    }
    
    public User save(User a) {
        if(a.getId()==0) {
            a.setId(nextId);
            dataDb.put(nextId, a);
            return dataDb.get(nextId++);
        }else {
            dataDb.put(a.getId(), a);
            return dataDb.get(a.getId());
        }
    }
    
    public void remove(long id) throws Exception {
        if(!dataDb.containsKey(id)) {
            throw new Exception();
        }
        dataDb.remove(id);
    }

    public void remove(User a) {
        dataDb.remove(a.getId());
    }
    
    public User findById(long id) throws Exception {
        User a=dataDb.get(id);
        if(a==null) {
            throw new Exception();
        }
        return a;
    }
    
    public List<User> findAll(){
        return dataDb.values().stream().toList();
    }

}

