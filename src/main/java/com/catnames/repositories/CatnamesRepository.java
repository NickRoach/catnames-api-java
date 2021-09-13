package com.catnames.repositories;

import com.catnames.entities.CatnamesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatnamesRepository extends JpaRepository <CatnamesEntity, Integer> {
}
