package com.tbd.bank_backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbd.bank_backend.data.entities.AccountEntity;
import com.tbd.bank_backend.data.repos.AccountRepo;
import com.tbd.bank_backend.models.Account;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo repo;

    @Override
    public boolean create(Account account) {

        // convert model to entity
        AccountEntity entity = convertModelToEntity(account);

        // save entity
        entity = repo.save(entity);

        // return the result
        return true;
    }

    @Override
    public boolean rename(Account account) {

        // convert model to entity
        AccountEntity entity = convertModelToEntity(account);

        // check if database contains entity
        AccountEntity existingEntity = repo.findById(entity.getId()).orElse(null);

        if (existingEntity == null) {
            return false;
        }

        // save entity
        entity = repo.save(entity);

        // return the result
        return true;
    }

    @Override
    public List<Account> getAllByUserId(int userId) {

        List<Account> accounts = new ArrayList<>();

        // get the list from the database
        List<AccountEntity> entities = repo.findAllByUserId(userId);

        // convert each entity in list to model
        for (AccountEntity entity : entities) {
            accounts.add(convertEntityToModel(entity));
        }

        // return list
        return accounts;

    }

    /**
     * Converts an instance of <code>AccountEntity</code> to <code>Account</code>.
     * 
     * @param entity the <code>AccountEntity</code> instance to convert.
     * @return the model conversion, <code>Account</code>.
     */
    @SuppressWarnings("unused")
    private Account convertEntityToModel(AccountEntity entity) {
        return new Account(entity.getId(), entity.getBalance(), entity.getType(), entity.getUserId());
    }

    /**
     * Converts an instance of <code>Account</code> to <code>AccountEntity</code>.
     * 
     * @param model the <code>Account</code> instance to convert.
     * @return the entity conversion, <code>AccountEntity</code>.
     */
    private AccountEntity convertModelToEntity(Account model) {
        return new AccountEntity(model.getId(), model.getBalance(), model.getType(), model.getUserId());
    }

}
