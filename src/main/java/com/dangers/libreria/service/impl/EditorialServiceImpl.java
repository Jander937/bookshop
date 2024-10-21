package com.dangers.libreria.service.impl;

import com.dangers.libreria.dto.EditorialDTO;
import com.dangers.libreria.entities.EditorialEntity;
import com.dangers.libreria.mapper.IEditorialMapper;
import com.dangers.libreria.repositories.IEditorialRepository;
import com.dangers.libreria.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorialServiceImpl implements EditorialService {

    @Autowired
    IEditorialRepository iEditorialRepository;

    @Autowired
    IEditorialMapper iEditorialMapper;

    @Override
    public EditorialDTO add(EditorialEntity dataEditorial) throws Exception{
        try{

            return this.iEditorialMapper.editorialToDTO(this.iEditorialRepository.save(dataEditorial));


        }catch(Exception error){
            throw new Exception(error.getMessage());

        }

    }
    @Override
    public EditorialDTO seachById(Integer id) throws Exception {
        Optional<EditorialEntity> editorialOptional = this.iEditorialRepository.findById(id);
        if (editorialOptional.isPresent()){
            return this.iEditorialMapper.editorialToDTO(editorialOptional.get());
        }else {
            throw new Exception("Editorial not found with the given ID " + id);
        }
    }
    @Override
    public List<EditorialDTO> seachAll()throws Exception{
        try {
            return this.iEditorialMapper.toDTOList(iEditorialRepository.findAll());
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public EditorialDTO modify(Integer id, EditorialEntity editorial) throws Exception{
        try {
            if (this.iEditorialRepository.findById(id).isPresent()){
                EditorialEntity objectFound = this.iEditorialRepository.findById(id).get();
                objectFound.setId_editorial(objectFound.getId_editorial());
                objectFound.setName(objectFound.getName());
                objectFound.setCountry(objectFound.getCountry());
                objectFound.setWebsite(objectFound.getWebsite());
                objectFound.setFoundationYear(objectFound.getFoundationYear());

                return this.iEditorialMapper.editorialToDTO(iEditorialRepository.save(objectFound));
            }else {
                throw new Exception("Editorial not found");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public Boolean deleteById(Integer id){
        Optional<EditorialEntity> delete = iEditorialRepository.findById(id);

        if (delete.isEmpty())
            return false;
        iEditorialRepository.deleteById(id);

        return true;
    }
}
