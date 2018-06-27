package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.InvoiceEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface InvoiceEntryDao extends CrudRepository<InvoiceEntry, Integer> {}