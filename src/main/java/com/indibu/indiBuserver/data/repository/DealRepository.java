package com.indibu.indiBuserver.data.repository;

import com.indibu.indiBuserver.data.entity.Deal;
import com.indibu.indiBuserver.data.entity.User;
import com.indibu.indiBuserver.model.Category;
import com.indibu.indiBuserver.model.DealResponseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Set;


public interface DealRepository extends CrudRepository<Deal, Long>, PagingAndSortingRepository<Deal, Long> {

    long deleteByIdAndUserId(long id, long userId);

    Page<DealResponseModel> readAllByCategoriesIn(Set<Category> categorySet, Pageable pageable);

    Page<DealResponseModel> readAllByUser(User user, Pageable pageable);

    Deal findById(long id);
}
