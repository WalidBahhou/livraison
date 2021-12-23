package emsi.wa.livraison.dao;

import emsi.wa.livraison.service.modele.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreurRepository extends JpaRepository<Livreur, Long> {
    List<Livreur> findByFirstName(String firstName);
    List<Livreur> findByLastName(String lastName);
    List<Livreur> findByFirstNameAndLastName(String firstName, String lastName);
}
