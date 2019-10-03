/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tevas.REST;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tevas.dao.SuppliersDAO;
import tevas.objects.Suppliers;
import tevas.objects.Tikrinam;

/**
 *
 * @author manambar
 */
@RestController
@RequestMapping(value = "rest")
public class SuppliersRESTController {

    @Autowired
    private SuppliersDAO suppliersDAO;

    @GetMapping(produces = "application/json")
    //@ResponseBody
    public List<Suppliers> getAll() {
      //  System.out.println(name.toString());
        System.out.println("kvieciam metoda");
        System.out.println("o tai ir sarasas");
        System.out.println(suppliersDAO.findAll());
        return suppliersDAO.findAll();
    }

    @GetMapping(path = "1", produces = "application/json")
    public List<Suppliers> getOne() {
        System.out.println("kvieciam metoda");
        System.out.println("o tai ir sarasas");
        System.out.println(suppliersDAO.findAll());
        return suppliersDAO.findAll();
    }

//        @GetMapping(path = "/")
//    public String getAll() {
//        List<Suppliers> s = suppliersDAO.findAll();
//         ObjectMapper obj = new ObjectMapper(); 
//         String wtf="";
//        try {
//             wtf = obj.writeValueAsString(s);
//        } catch (JsonProcessingException ex) {
//            Logger.getLogger(SuppliersRESTController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(wtf);
//        System.out.println("kvieciam metoda");
//        System.out.println("o tai ir sarasas");
//        System.out.println(suppliersDAO.findAll());
//        return wtf;
//    }
//    @GetMapping(path = "/rest/person/{pId}", produces = "application/json")
//    public Person getOne(@PathVariable(name = "pId", required = true) Integer pId) {
//        return personDAO.getOne(pId);
//    }
//
//    @PostMapping(path = "/rest/person", produces = "application/json")
//    @Transactional
//    public Person addUpdatePerson(@RequestBody Person p) {
//        System.out.println(p.getFirstName());
//      
//        return personDAO.save(p);
//
//    }
//
//    @Transactional
//    @DeleteMapping(path = "/rest/person/{pId}", produces = "application/json")
//    public String delOne(@PathVariable(name = "pId", required = true) Integer pId) {
//        personDAO.deleteById(pId);
//        return "redirect:/html/newhtml.html";
//    }
}
