package tevas.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tevas.dao.BaseDAO;
import tevas.objects.Base;

@RestController
@RequestMapping(value = "rest")
public class BaseRESTController {

    @Autowired
    private BaseDAO baseDAO;
    
    
    @GetMapping(produces = "application/json")
    public List<Base> getAllIntegers() {
        System.out.println("bandau");
        return baseDAO.findAll();
    }
}
