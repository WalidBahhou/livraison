package emsi.wa.livraison.service;

import emsi.wa.livraison.dao.LivreurRepository;
import emsi.wa.livraison.domaine.LivreurConverter;
import emsi.wa.livraison.domaine.LivreurVO;
import emsi.wa.livraison.service.modele.Livreur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements IService, CommandLineRunner {
    @Autowired
    private LivreurRepository livreurRepository;
    //@Override
    public List<LivreurVO> getEmployees() {
        List<Livreur> list = livreurRepository.findAll();
        return LivreurConverter.toListVo(list);
    }

    @Override
    public List<LivreurVO> getLivreurs() {
        return null;
    }

    @Override
    public void save(LivreurVO livreur) {
        livreurRepository.save(LivreurConverter.toBo(livreur));
    }

    @Override
    public LivreurVO getLivreurById(Long id) {
        return null;
    }

    //@Override
    public LivreurVO getEmpById(Long id) {
        boolean trouve = livreurRepository.existsById(id);
        if (!trouve)
            return null;
        return LivreurConverter.toVo(livreurRepository.getOne(id));
    }
    //@Override
    public void delete(Long id) {
        livreurRepository.deleteById(id);
    }

    @Override
    public List<Livreur> findByFirstName(String firstName) {
        return null;
    }

    //@Override
    public List<LivreurVO> findBySalary(String firstName) {
        List<Livreur> list = livreurRepository.findByFirstName(firstName);
        return LivreurConverter.toListVo(list);
    }
    @Override
    public List<LivreurVO> findByLastName(String lastName) {
        List<Livreur> list = livreurRepository.findByLastName(lastName);
        return LivreurConverter.toListVo(list);
    }
    @Override
    public List<LivreurVO> findByFirstNameAndLastName(String firstName, String lastName) {
        List<Livreur> list = livreurRepository.findByFirstNameAndLastName(firstName, lastName);
        return LivreurConverter.toListVo(list);
    }
    @Override
    public List<LivreurVO> findAll(int pageId, int size) {
        Page<Livreur> result = livreurRepository.findAll(PageRequest.of(pageId, size,
                Sort.Direction.ASC, "name"));
        return LivreurConverter.toListVo(result.getContent());
    }
    @Override
    public List<LivreurVO> sortBy(String fieldName) {
        return LivreurConverter.toListVo(livreurRepository.findAll(Sort.by(fieldName)));
    }

    @Override
    public void run(String... args) throws Exception {
        livreurRepository.deleteAll();
        livreurRepository.save(new Livreur("walid", "Bahhou", "0643665085"));
        livreurRepository.save(new Livreur("ElAmine", "ElFilali", "06123456789"));
    }
}
