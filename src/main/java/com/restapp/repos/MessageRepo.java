package com.restapp.repos;

import com.restapp.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource //(collectionResourceRel = "messages", path = "messages")
//public interface MessageRepo extends CrudRepository<Message, Long> {
public interface MessageRepo extends PagingAndSortingRepository<Message, Long> {
}
