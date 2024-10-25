package io.NinjaCipherr.mailSender.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.NinjaCipherr.mailSender.entity.Email;

public interface EmailRepository extends JpaRepository<Email,Long> {
}
