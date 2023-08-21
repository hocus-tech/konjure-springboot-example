package ai.hocus.examples.sprintboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accounts")
public class Account {
    public final String name;
    public final String email;
    @Id
    public String id;

    public Account(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

