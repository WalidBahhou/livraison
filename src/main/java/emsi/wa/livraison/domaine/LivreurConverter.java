package emsi.wa.livraison.domaine;

import emsi.wa.livraison.service.modele.Livreur;

import java.util.ArrayList;
import java.util.List;

public class LivreurConverter {
    public static LivreurVO toVo(Livreur bo) {
        if (bo == null || bo.getLivreurID() ==null)
            return null;
        LivreurVO vo = new LivreurVO();
        vo.setLivreurID(bo.getLivreurID());
        vo.setFirstName(bo.getFirstName());
        vo.setLastName(bo.getLastName());
        vo.setPhoneNumber(bo.getPhoneNumber());
        return vo;
    }
    public static Livreur toBo(LivreurVO vo) {
        Livreur bo = new Livreur();
        vo.setLivreurID(bo.getLivreurID());
        vo.setFirstName(bo.getFirstName());
        vo.setLastName(bo.getLastName());
        vo.setPhoneNumber(bo.getPhoneNumber());
        return bo;
    }
    public static List<LivreurVO> toListVo(List<Livreur> listBo) {
        List<LivreurVO> listVo = new ArrayList<>();
        for (Livreur Livreur : listBo) {
            listVo.add(toVo(Livreur));
        }
        return listVo;
    }
}

