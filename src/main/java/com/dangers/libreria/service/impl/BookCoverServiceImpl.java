package com.dangers.libreria.service.impl;

import com.dangers.libreria.dto.BookCoverDTO;
import com.dangers.libreria.entities.BookCoverEntity;
import com.dangers.libreria.mapper.IBookCoverMapper;
import com.dangers.libreria.repositories.IBookCoverRepository;
import com.dangers.libreria.service.BookCoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCoverServiceImpl implements BookCoverService {
    @Autowired
    IBookCoverRepository iBookCoverRepository;

    @Autowired
    IBookCoverMapper iBookCoverMapper;

    @Override
    public BookCoverDTO save(BookCoverEntity dataBookCover)throws Exception{
        try{
            return this.iBookCoverMapper.bookCoverToDTO(this.iBookCoverRepository.save(dataBookCover));
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public BookCoverDTO seachById(Integer id)throws Exception{
        Optional<BookCoverEntity> bookCoverEntityOptional = this.iBookCoverRepository.findById(id);
        if (bookCoverEntityOptional.isPresent()){
            return this.iBookCoverMapper.bookCoverToDTO(bookCoverEntityOptional.get());
        }else {
            throw new Exception("bookCover not found with the given ID" + id);
        }
    }
    @Override
    public List<BookCoverDTO> seachAll()throws Exception{
        try {
            return this.iBookCoverMapper.toDTOList(iBookCoverRepository.findAll());
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public BookCoverDTO modify(Integer id, BookCoverEntity bookCover)throws Exception{
        try {
            if (this.iBookCoverRepository.findById(id).isPresent()) {
                BookCoverEntity objectFound = this.iBookCoverRepository.findById(id).get();
                objectFound.setId_book_cover(objectFound.getId_book_cover());
                objectFound.setBookEntity(objectFound.getBookEntity());
                objectFound.setCoverImage(objectFound.getCoverImage());

                return this.iBookCoverMapper.bookCoverToDTO(iBookCoverRepository.save(objectFound));
            }else {
                throw new Exception("Book Cover no found");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public Boolean delete(Integer id){
        Optional<BookCoverEntity> delete = iBookCoverRepository.findById(id);

        if (delete.isEmpty())
            return false;

        iBookCoverRepository.deleteById(id);

        return true;
    }
}

