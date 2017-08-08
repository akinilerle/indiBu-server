package com.indibu.indiBuserver.data.repository;

import com.indibu.indiBuserver.data.entity.Comment;
import com.indibu.indiBuserver.model.CommentInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends CrudRepository<Comment, Long>, PagingAndSortingRepository<Comment, Long> {

    Page<CommentInformation> readAllByDealId(long dealId, Pageable pageable);

    int countCommentsByDealId(long dealId);
}
