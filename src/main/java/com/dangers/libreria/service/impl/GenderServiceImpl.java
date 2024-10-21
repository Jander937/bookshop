package com.dangers.libreria.service.impl;

import com.dangers.libreria.dto.GenderDTO;
import com.dangers.libreria.entities.GenderEntity;
import com.dangers.libreria.mapper.IGenderMapper;
import com.dangers.libreria.repositories.IGenderRepository;
import com.dangers.libreria.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    IGenderMapper iGenderMapper;

    @Autowired
    IGenderRepository iGenderRepository;

    @Override
    public GenderDTO save(GenderEntity dataGender)throws Exception{
        try {
            return this.iGenderMapper.genderToDTO(this.iGenderRepository.save(dataGender));
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public GenderDTO seachById(Integer id) throws Exception {
        Optional<GenderEntity> genderOptional = this.iGenderRepository.findById(id);
        if (genderOptional.isPresent()) {
            return this.iGenderMapper.genderToDTO(genderOptional.get());
        } else {
            throw new Exception("Gender not found with the given ID " + id);
        }
    }
    @Override
    public List<GenderDTO> seachAll() throws Exception{
        try{
            return this.iGenderMapper.toDTOLIst(iGenderRepository.findAll());

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public GenderDTO modify(Integer id, GenderEntity gender) throws Exception{
        try{
            if(this.iGenderRepository.findById(id).isPresent()){
                //cambielo
                GenderEntity objectFound=this.iGenderRepository.findById(id).get();
                objectFound.setId_gender(objectFound.getId_gender());
                objectFound.setName(objectFound.getName());

                return this.iGenderMapper.genderToDTO(iGenderRepository.save(objectFound));
            }else{
                //diga que no esta
                throw new Exception("Gender not found");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public Boolean deleteById(Integer id){
        Optional<GenderEntity> delete = iGenderRepository.findById(id);

        if (delete.isEmpty())
            return false;

        iGenderRepository.deleteById(id);

        return true;
    }

}
