package emsi.wa.livraison.service;

import emsi.wa.livraison.domaine.LivreurVO;
import emsi.wa.livraison.service.modele.Livreur;

import java.util.List;

public interface IService {
    List<LivreurVO> getLivreurs();
    void save(LivreurVO livreur);
    LivreurVO getLivreurById(Long id);
    void delete(Long id);
    List<Livreur> findByFirstName(String firstName);
    List<LivreurVO> findByLastName(String lastName);
    List<LivreurVO> findByFirstNameAndLastName(String firstName, String lastName);
    //Pour la pagination
    List<LivreurVO> findAll(int pageId, int size);
    //pour le tri
    List<LivreurVO> sortBy(String fieldName);
}
