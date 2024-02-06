package com.example.esd_demo.dao.impl;

import com.example.esd_demo.bean.Bill;
import com.example.esd_demo.bean.Receipt;
import com.example.esd_demo.dao.BillDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //this class serves as repository
@Transactional
public class BillDAOImpl implements BillDAO {
    @PersistenceContext
    private EntityManager entityManager; //for interacting with database

    @Override
    public List<Bill> getBills(Integer studentId) {
        return entityManager.createQuery(
                        "SELECT b FROM Bill b WHERE b.student.studentId = :studentId", Bill.class)
                .setParameter("studentId", studentId)
                .getResultList();
    }

    @Override
    public List<Bill> getBillById(Integer billId) {
        return entityManager.createQuery("SELECT b FROM Bill b WHERE b.billId = :billId", Bill.class)
                .setParameter("billId", billId)
                .getResultList();
    }

    @Override
    public void updateBill(Bill bill) {
        entityManager.merge(bill);
    }

    @Override
    public void createReceipt(Receipt receipt) {
        entityManager.persist(receipt);
    }
}