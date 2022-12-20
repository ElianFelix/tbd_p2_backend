package com.tbd.bank_backend.data.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tbd.bank_backend.data.entities.AccountEntity;

/**
 * A repository interface for the {@link AccountEntity}.
 */
public interface AccountRepo extends CrudRepository<AccountEntity, Integer> {

    /**
     * Finds all instances of AccountEntity in the database with the user_id of the
     * given integer.
     * 
     * @param userId the ID associated with the account's user.
     * @return a list of account entities.
     */
    public List<AccountEntity> findAllByUserId(int userId);

}
