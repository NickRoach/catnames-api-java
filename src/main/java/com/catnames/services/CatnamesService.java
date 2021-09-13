package com.catnames.services;

import com.catnames.entities.CatnamesEntity;
import com.catnames.repositories.CatnamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Transactional
public class CatnamesService {
    @Autowired
    private CatnamesRepository repository;
    private final AtomicLong IDCounter = new AtomicLong();

    public List<CatnamesEntity> all(){
        return this.repository.findAll();
    }

    public List<CatnamesEntity> deleteById(Integer id){
        this.repository.deleteById(id);
        return repository.findAll();
    }

    public List<CatnamesEntity> post(String name) {
            CatnamesEntity catname = new CatnamesEntity();
            catname.setId((int)IDCounter.incrementAndGet());
            catname.setName(name);
            this.repository.save(catname);
            return repository.findAll();
    }
}
