/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tevas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tevas.objects.Base;
import tevas.objects.Routes;

/**
 *
 * @author manambar
 */
public interface BaseDAO extends JpaRepository<Base, Integer>{
    
}
