/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webs.mumscrum.repository;
import com.webs.mumscrum.domain.Sprint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 984627
 */
@Repository
public interface SprintRepository  extends CrudRepository<Sprint,Long>{
    
}
