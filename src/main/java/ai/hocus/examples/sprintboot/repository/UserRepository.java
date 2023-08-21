package ai.hocus.examples.sprintboot.repository;

import ai.hocus.examples.sprintboot.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
