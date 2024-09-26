package fit.app.repository;

import fit.app.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Login,Integer> {
    Login findByEmailAndPassword(String email, String password);
}
