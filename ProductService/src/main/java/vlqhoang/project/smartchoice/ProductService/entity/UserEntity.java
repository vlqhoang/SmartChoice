package vlqhoang.project.smartchoice.ProductService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "USR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private String id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "name")
    private String username;

    @Column(name = "age")
    private String age;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "address")
    private String address;
}
