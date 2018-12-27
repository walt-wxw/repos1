package cn.itcast.service;

import org.springframework.stereotype.Service;

@Service
public interface BookService {
    cn.itcast.domain.Book findById(int id);
    void update(int id,double price);

    void trans();

}
