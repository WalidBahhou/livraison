package emsi.wa.livraison.controller;


import emsi.wa.livraison.domaine.LivreurVO;
import emsi.wa.livraison.service.IService;
import emsi.wa.livraison.service.modele.Livreur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LivreurController {
    @Autowired
    private IService service;

    @RequestMapping("/")
    public String showWelcomeFile(Model m) {
        return "index";
    }

    @RequestMapping("/livreurform")
    public String showform(Model m) {
        m.addAttribute("empVo", new LivreurVO());
        return "empform";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("empVo") LivreurVO livreur) {
        service.save(livreur);
        return "redirect:/viewelivreur";
    }

    @RequestMapping("/viewlivreur")
    public String viewemp(Model m) {
        List<LivreurVO> list = service.getLivreurs();
        m.addAttribute("list", list);
        return "viewemp";
    }

    @RequestMapping(value = "/editlivreur/{livreurid}")
    public String edit(@PathVariable Long livreurid, Model m) {
        LivreurVO emp = service.getLivreurById(livreurid);
        m.addAttribute("livreurVO", emp);
        return "empeditform";
    }

    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public String editsave(@ModelAttribute("livreurVO") LivreurVO livreur) {
        service.save(livreur);
        return "redirect:/viewemp";
    }

    @RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/viewemp";
    }

    @RequestMapping("/salary/{salary}")
    public String getBySalary(@PathVariable String firstname, Model m) {
        List<Livreur> list = service.findByFirstName(firstname);
        m.addAttribute("list", list);
        return "viewemp";
    }

    @RequestMapping("/pagination/{pageid}/{size}")
    public String pagination(@PathVariable int pageid, @PathVariable int size, Model m)
    {
        List<LivreurVO> list = service.findAll(pageid, size);
        m.addAttribute("list", list);
        return "viewemp";
    }

    @RequestMapping("/sort/{fieldName}")
    public String sortBy(@PathVariable String fieldName, Model m) {
        List<LivreurVO> list = service.sortBy(fieldName);
        m.addAttribute("list", list);
        return "viewemp";
    }
}
