package com.sankalpa.auction.service;

import com.sankalpa.auction.model.Admin;
import com.sankalpa.auction.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins(){
        List<Admin> admins = new ArrayList<>();
        adminRepository.findAll().forEach(admins::add);
        return admins;
    }

    public Admin updateAdmin(Admin updatedAdmin){
        return adminRepository.save(updatedAdmin);
    }

    public Admin addAdmin(Admin newAdmin){
        return adminRepository.save(newAdmin);
    }

    public void deleteAdmin(Long adminId){
        adminRepository.deleteById(adminId);
    }

    public Admin getAdmin(Long adminId){
        return adminRepository.findById(adminId).orElse(null);
    }
}
