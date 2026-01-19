package com.br.dashProd.respository;

import com.br.dashProd.model.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MateriaRepository extends JpaRepository<MateriaEntity, Long> {

    public Optional<MateriaEntity> findByName(String name);
}
