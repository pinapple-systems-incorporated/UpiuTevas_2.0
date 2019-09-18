package tevas.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tevas.objects.Base;


public interface BaseDAO extends JpaRepository<Base, Integer>{
    
//    @Query("select b from Base b")
//    public List<Base> getAll();
    
}
