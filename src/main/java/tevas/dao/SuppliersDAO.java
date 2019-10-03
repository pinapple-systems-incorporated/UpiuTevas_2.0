/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tevas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tevas.objects.Suppliers;

/**
 *
 * @author manambar
 */
public interface SuppliersDAO extends JpaRepository<Suppliers, Integer>{
    
}
