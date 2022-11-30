package co.edu.icesi.store.model;

import co.edu.icesi.store.validation.CustomAnnotations;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Table(name = "`user`")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    private String name;

    private String email;

    @CustomAnnotations.PasswordValidation
    private String password;

    private String address;

    private String phoneNumber;

    @PrePersist
    public void generateId(){
        this.id = UUID.randomUUID();
    }
}