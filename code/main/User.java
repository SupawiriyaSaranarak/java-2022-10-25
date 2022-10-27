package main;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;



@Table(name="users")
public class User {
    @Id
    public int code;
    public String email;
    String password;
    @Column("first_name")
    public String firstName;
    @Column("last_name")
    public String lastName;
    public char gender;
    public String address;
}

@Service 
@Indexed
interface UserRepository extends CrudRepository<User,Integer> {}


