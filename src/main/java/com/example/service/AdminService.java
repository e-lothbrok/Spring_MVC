package com.example.service;

import com.example.dao.AdminDao;
import com.example.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public boolean save(Admin admin){
        admin.setFechaCreacion(new Timestamp(new Date().getTime()));
        return adminDao.save(admin);
    }

    public List<Admin> findAll() {
        return adminDao.findAll();
    }

    public Admin findById(int id) {
        return adminDao.findById(id);
    }

    public boolean saveOrUpdate(Admin adminForm) {
        if (adminForm.getId() == 0){
            adminForm.setFechaCreacion(new Timestamp(new Date().getTime()));
            return adminDao.save(adminForm);
        }else {
            return adminDao.update(adminForm);
        }
    }

    public boolean deleteById(int id) {
        return adminDao.delete(id);
    }
}
