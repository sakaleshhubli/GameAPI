package com.sakalesh.game_app_sdp.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sakalesh.game_app_sdp.modal.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByMemberId(String memberId);
    List<Transaction> findByGameId(String gameId);
}


