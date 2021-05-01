package com.bulat.jobboard.service;

import com.bulat.jobboard.model.User;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void send(User user);
}
