package com.kodilla.hibernate.invoice;

import com.kodilla.hibernate.invoice.dao.InvoiceDao;
import com.kodilla.hibernate.invoice.dao.InvoiceEntryDao;
import com.kodilla.hibernate.invoice.dao.ProductDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    InvoiceEntryDao invoiceEntryDao;
    @Autowired
    ProductDao productDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");
        Product product3 = new Product("Product 3");

        Invoice invoice = new Invoice("1/06/2018");

        InvoiceEntry entry1 = new InvoiceEntry(invoice, product1, new BigDecimal(100), 4);
        InvoiceEntry entry2 = new InvoiceEntry(invoice, product2, new BigDecimal(200), 5);
        InvoiceEntry entry3 = new InvoiceEntry(invoice, product3, new BigDecimal(300), 6);

        invoice.getEntries().add(entry1);
        invoice.getEntries().add(entry2);
        invoice.getEntries().add(entry3);

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();
        int product1Id = product1.getId();
        int product2Id = product2.getId();
        int product3Id = product3.getId();
        int entry1Id = entry1.getId();
        int entry2Id = entry2.getId();
        int entry3Id = entry3.getId();
        //Then
        Assert.assertNotEquals(0, invoiceId);
        Assert.assertNotEquals(0, entry1Id);
        Assert.assertNotEquals(0, entry2Id);
        Assert.assertNotEquals(0, entry3Id);
        Assert.assertNotEquals(0, product1Id);
        Assert.assertNotEquals(0, product2Id);
        Assert.assertNotEquals(0, product3Id);
        //CleanUp
        try {
            invoiceDao.delete(invoiceId);
            productDao.delete(product1);
            productDao.delete(product2);
            productDao.delete(product3);
            invoiceEntryDao.delete(entry1);
            invoiceEntryDao.delete(entry2);
            invoiceEntryDao.delete(entry3);
        }
        catch (Exception e) {}
    }

}