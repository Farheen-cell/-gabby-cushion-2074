package com.Shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Shopping.Model.ProductDTO;

@Repository
public interface ProductDTORepo extends JpaRepository<ProductDTO, Integer>{

}
