package com.tbd.bank_backend.services;

import java.util.List;

import com.tbd.bank_backend.models.Account;

/**
 * An interface for managing the business logic behavior for the
 * <code>Account</code> model.
 */
public interface AccountService {

    /**
     * Persists an instance of the <code>Account</code> class into the database.
     * 
     * @param account The instance to persist.
     * @return The result of the persistence.
     */
    public boolean create(Account account);

    /**
     * Updates the existing database instance of the <code>Account</code> (by its
     * ID) with data
     * from the given instance.
     * 
     * @param account the account details with which to update the existing
     *                instance.
     * @return the result of the update.
     */
    public boolean rename(Account account);

    /**
     * Retrieves all instances of the <code>Account</code> class that are associated
     * with the user of the given userId.
     * 
     * @param userId The ID of the user for which to retrieve accounts.
     * @return A <code>List</code> of <code>Account</code> objects.
     */
    public List<Account> getAllByUserId(int userId);

}
