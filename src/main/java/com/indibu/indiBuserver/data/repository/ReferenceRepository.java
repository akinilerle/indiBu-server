package com.indibu.indiBuserver.data.repository;


import com.indibu.indiBuserver.data.entity.Reference;
import com.indibu.indiBuserver.data.entity.User;
import com.indibu.indiBuserver.model.ReferenceResponseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ReferenceRepository extends CrudRepository<Reference, Long>, PagingAndSortingRepository<Reference, Long> {

    Page<ReferenceResponseModel> readAllByUser(User user, Pageable pageable);

}
