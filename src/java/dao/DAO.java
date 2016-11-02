/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author Vinicius Böbel
 */
public interface DAO<T> {
    
        public void add(T domain);
        
    	public T get(T domain);
	
        public List<T> list();
        
	public void remove(T domain);

}
