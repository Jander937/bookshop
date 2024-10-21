package com.dangers.libreria.service.impl;

import com.dangers.libreria.dto.BookDTO;
import com.dangers.libreria.entities.BookEntity;
import com.dangers.libreria.mapper.IBookMapper;
import com.dangers.libreria.repositories.IBookRepository;
import com.dangers.libreria.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    IBookMapper iBookMapper;

    @Autowired
    IBookRepository iBookRepository;

    @Override
    public BookDTO save(BookEntity dataBook) throws Exception{
        try {
            return this.iBookMapper.bookToDTO(this.iBookRepository.save(dataBook));
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public BookDTO seachById(Integer id) throws Exception{
        Optional<BookEntity> bookEntityOptional = this.iBookRepository.findById(id);
        if (bookEntityOptional.isPresent()){
            return this.iBookMapper.bookToDTO(bookEntityOptional.get());
        }else {
            throw new Exception("book not found with the given ID" + id);
        }
    }
    @Override
    public List<BookDTO> seachAllBooks()throws Exception{
        try {
            return this.iBookMapper.toDTOList(iBookRepository.findAll());
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public BookDTO modifyBook(Integer id, BookEntity book) throws Exception{
        try {
            Optional<BookEntity> optionalBook = iBookRepository.findById(id);
            if (optionalBook.isPresent()){
                BookEntity existingBook = optionalBook.get();
                existingBook.setTitle(book.getTitle());
                // Aquí establece los demás atributos que deseas modificar

                return iBookMapper.bookToDTO(iBookRepository.save(existingBook));
            } else {
                throw new Exception("Book not found with ID: " + id);
            }
        } catch (Exception error){
            throw new Exception("Failed to modify book: " + error.getMessage());
        }
    }
    @Override
    public Boolean deleteBook(Integer id){
        Optional<BookEntity> deleteBook = iBookRepository.findById(id);

        if (deleteBook.isEmpty())
            return false;
        iBookRepository.deleteById(id);

        return true;
    }
}
