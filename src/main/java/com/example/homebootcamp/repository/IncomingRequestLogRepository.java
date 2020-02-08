package com.example.homebootcamp.repository;


import com.example.homebootcamp.documents.IncomingRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncomingRequestLogRepository extends MongoRepository<IncomingRequest, String> {
}
