package com.dangers.libreria.service.impl;

import com.dangers.libreria.dto.AuthorDTO;
import com.dangers.libreria.entities.AuthorEntity;
import com.dangers.libreria.mapper.IAuthorMapper;
import com.dangers.libreria.repositories.IAuthorRepository;
import com.dangers.libreria.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    IAuthorRepository iAuthorRepository;

    @Autowired
    IAuthorMapper iAuthorMapper;

    @Override
    public AuthorDTO save(AuthorEntity dataAuthor)throws Exception{
        try {
            return this.iAuthorMapper.authorToDTO(this.iAuthorRepository.save(dataAuthor));
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public AuthorDTO seachById(Integer id) throws Exception {
        Optional<AuthorEntity> authorEntityOptional = this.iAuthorRepository.findById(id);
        if (authorEntityOptional.isPresent()){
            return this.iAuthorMapper.authorToDTO(authorEntityOptional.get());
        }else {
            throw new Exception("Author not found with the given ID " + id);
        }
    }
    @Override
    public List<AuthorDTO> seachAll()throws Exception{
        try {
            return this.iAuthorMapper.toDTOList(iAuthorRepository.findAll());
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public AuthorDTO modify(Integer id, AuthorEntity author) throws Exception{
        try {
            if (this.iAuthorRepository.findById(id).isPresent()){
                AuthorEntity objectFound = this.iAuthorRepository.findById(id).get();
                objectFound.setId_author(objectFound.getId_author());
                objectFound.setBirthdate(objectFound.getBirthdate());
                objectFound.setNameAuthor(objectFound.getNameAuthor());
                objectFound.setNationality(objectFound.getNationality());
                objectFound.setLastName(objectFound.getLastName());

                return this.iAuthorMapper.authorToDTO(iAuthorRepository.save(objectFound));
            }else {
                throw new Exception("Author not found");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public Boolean deleteById(Integer id){
        Optional<AuthorEntity> delete = iAuthorRepository.findById(id);

        if (delete.isEmpty())
            return false;

        iAuthorRepository.deleteById(id);

        return true;
    }
}
