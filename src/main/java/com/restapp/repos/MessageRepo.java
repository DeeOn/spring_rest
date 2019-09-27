package com.restapp.repos;

import com.restapp.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource (collectionResourceRel = "messages", path = "messages", exported = false)
public interface MessageRepo extends CrudRepository<Message, Long> {
}
