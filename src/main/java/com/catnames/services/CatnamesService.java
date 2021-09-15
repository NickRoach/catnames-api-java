package com.catnames.services;

import com.catnames.entities.CatnamesEntity;
import com.catnames.payloads.requests.CatCreatePayload;
import com.catnames.repositories.CatnamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Service
@Transactional
public class CatnamesService {
    @Autowired
    private CatnamesRepository repository;

    public List<CatnamesEntity> all(){
        return this.repository.findAll();
    }

    public List<CatnamesEntity> deleteById(Integer id){
        this.repository.deleteById(id);
        return repository.findAll();
    }

    public List<CatnamesEntity> post(String name) {
            CatnamesEntity catname = new CatnamesEntity();
            catname.setName(name);
            this.repository.save(catname);
            return repository.findAll();
    }

    public List<CatnamesEntity> create(@Valid CatCreatePayload data) {
        CatnamesEntity newCat = new CatnamesEntity();
        newCat.setName(data.getName());
        newCat.setOccupation(data.getOccupation());
        this.repository.save(newCat);
        return repository.findAll();
    }

    public List<CatnamesEntity> delete(@Valid CatCreatePayload data) {
        this.repository.deleteById(data.getId());
        return repository.findAll();
    }
}
